#!/usr/bin/env python3
"""Repackage stock GoMobile output to the JNI runtime names used by MLMVPN 1.2.51.

The transformation is intentionally narrow and same-length: JVM constant-pool UTF8
entries and ELF dynamic string-table entries can be changed in place without shifting
offsets. All expected old names and all resulting new names are checked.
"""
from __future__ import annotations

import io
import pathlib
import struct
import sys
import zipfile

ABIS = {
    "arm64-v8a": 183,   # EM_AARCH64
    "armeabi-v7a": 40,  # EM_ARM
}
CLASS_RENAMES = (
    (b"go/", b"ar/"),
    (b"gojni", b"arjni"),
)
ELF_RENAMES = (
    (b"Java_go_", b"Java_ar_"),
)
AAR_LIBS = {f"jni/{abi}/libgojni.so": f"jni/{abi}/libarjni.so" for abi in ABIS}


def replace_required(data: bytes, pairs: tuple[tuple[bytes, bytes], ...], label: str) -> bytes:
    for old, new in pairs:
        if len(old) != len(new):
            raise SystemExit(f"{label}: unsafe length-changing remap {old!r} -> {new!r}")
        if old not in data:
            raise SystemExit(f"{label}: expected source marker not found: {old!r}")
        data = data.replace(old, new)
    for old, _ in pairs:
        if old in data:
            raise SystemExit(f"{label}: old marker remains after remap: {old!r}")
    return data


def rewrite_classes_jar(raw: bytes) -> bytes:
    source = zipfile.ZipFile(io.BytesIO(raw))
    out = io.BytesIO()
    with source, zipfile.ZipFile(out, "w") as target:
        names = set(source.namelist())
        if "mobile/Mobile.class" not in names:
            raise SystemExit("GoMobile AAR does not contain mobile/Mobile.class")
        if not {"go/Seq.class", "go/Universe.class", "go/error.class"} <= names:
            raise SystemExit("GoMobile AAR does not contain the expected GoMobile runtime classes")
        for info in source.infolist():
            name = info.filename
            payload = source.read(info)
            if name.endswith(".class"):
                for old_marker, new_marker in CLASS_RENAMES:
                    payload = payload.replace(old_marker, new_marker)
            if name.startswith("go/"):
                name = "ar/" + name[len("go/"):]
            new_info = zipfile.ZipInfo(name, info.date_time)
            new_info.compress_type = info.compress_type
            new_info.comment = info.comment
            new_info.extra = info.extra
            new_info.external_attr = info.external_attr
            new_info.create_system = info.create_system
            target.writestr(new_info, payload)
    rewritten = out.getvalue()
    with zipfile.ZipFile(io.BytesIO(rewritten)) as check:
        names = set(check.namelist())
        required = {"mobile/Mobile.class", "ar/Seq.class", "ar/Universe.class", "ar/error.class"}
        missing = required - names
        if missing:
            raise SystemExit(f"repacked classes.jar missing: {sorted(missing)}")
        if any(n.startswith("go/") for n in names):
            raise SystemExit("repacked classes.jar still contains the go runtime package")
        for name in names:
            if name.endswith(".class"):
                payload = check.read(name)
                for old_marker, _ in CLASS_RENAMES:
                    if old_marker in payload:
                        raise SystemExit(f"repacked class still contains {old_marker!r}: {name}")
    return rewritten


def main() -> None:
    if len(sys.argv) != 3:
        raise SystemExit("usage: repackage-argo-gomobile-aar.py input.aar output.aar")
    source, destination = map(pathlib.Path, sys.argv[1:])
    with zipfile.ZipFile(source) as src:
        entries: dict[str, bytes] = {}
        for info in src.infolist():
            name = info.filename
            data = src.read(info)
            if name == "classes.jar":
                data = rewrite_classes_jar(data)
            elif name in AAR_LIBS:
                abi = name.split("/")[1]
                data = replace_required(data, ELF_RENAMES, name)
                # JNI registration tables may carry package descriptors too. Remap them when present.
                data = data.replace(b"go/", b"ar/")
                if b"Java_go_" in data or b"go/" in data:
                    raise SystemExit(f"{name}: old GoMobile runtime namespace remains")
                if data[:4] != b"\x7fELF":
                    raise SystemExit(f"{name}: output is not ELF")
                if data[4] != (2 if abi == "arm64-v8a" else 1):
                    raise SystemExit(f"{name}: ELF class does not match {abi}")
                machine = struct.unpack_from("<H", data, 18)[0]
                if machine != ABIS[abi]:
                    raise SystemExit(f"{name}: ELF machine {machine} does not match {abi}")
                name = AAR_LIBS[name]
            elif name == "proguard.txt":
                data = data.replace(b"go.", b"ar.")
            elif name == "AndroidManifest.xml":
                data = data.replace(b"gojni", b"arjni")
            entries[name] = data

    required = {"classes.jar", *AAR_LIBS.values()}
    missing = required - entries.keys()
    if missing:
        raise SystemExit(f"GoMobile AAR missing required entries: {sorted(missing)}")
    destination.parent.mkdir(parents=True, exist_ok=True)
    with zipfile.ZipFile(destination, "w", compression=zipfile.ZIP_DEFLATED) as out:
        for name, data in entries.items():
            out.writestr(name, data)
    print(f"Repackaged {source} -> {destination}")
    for abi in ABIS:
        print(f"  {abi}: {AAR_LIBS[f'jni/{abi}/libgojni.so']}")


if __name__ == "__main__":
    main()
