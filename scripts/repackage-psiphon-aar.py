#!/usr/bin/env python3
"""Repackage the Psiphon gomobile AAR so it can coexist with libv2ray.

Both libraries contain the gomobile runtime under Java package `go` and use
`libgojni.so`. The app ships two different Go runtimes, so Psiphon's runtime
is relocated to package `pg` and the JNI library renamed to `libpgjni.so`.
The names have equal byte lengths; class-file constant-pool references can
therefore be rewritten without changing class-file offsets or lengths.
"""

from __future__ import annotations

import argparse
import io
import sys
import zipfile
from pathlib import Path

REPLACEMENTS = ((b"go/", b"pg/"), (b"go.", b"pg."), (b"libgojni.so", b"libpgjni.so"))


def rewrite_bytes(data: bytes) -> bytes:
    for old, new in REPLACEMENTS:
        data = data.replace(old, new)
    return data


def is_signature(name: str) -> bool:
    upper = name.upper()
    return upper.startswith("META-INF/") and upper.endswith((".SF", ".RSA", ".DSA", ".EC"))


def rewrite_jar(source: bytes) -> tuple[bytes, int]:
    output = io.BytesIO()
    renamed_classes = 0
    with zipfile.ZipFile(io.BytesIO(source), "r") as src, zipfile.ZipFile(output, "w") as dst:
        for info in src.infolist():
            if is_signature(info.filename):
                continue
            old_name = info.filename
            new_name = old_name
            if new_name.startswith("go/"):
                new_name = "pg/" + new_name[len("go/"):]
            if new_name.endswith(".class") and (old_name.startswith("go/") or b"go/" in src.read(old_name)):
                renamed_classes += 1
            data = rewrite_bytes(src.read(info))
            clone = zipfile.ZipInfo(new_name, date_time=info.date_time)
            clone.compress_type = info.compress_type
            clone.comment = info.comment
            clone.extra = info.extra
            clone.create_system = info.create_system
            clone.external_attr = info.external_attr
            clone.internal_attr = info.internal_attr
            clone.flag_bits = info.flag_bits
            dst.writestr(clone, data)
    return output.getvalue(), renamed_classes


def repackage(source: Path, destination: Path) -> None:
    if not source.is_file():
        raise FileNotFoundError(f"Psiphon AAR not found: {source}")

    output = io.BytesIO()
    found_classes = False
    found_go_runtime = False
    renamed_native = 0
    rewritten_classes = 0

    with zipfile.ZipFile(source, "r") as src, zipfile.ZipFile(output, "w") as dst:
        for info in src.infolist():
            name = info.filename
            data = src.read(info)
            if name == "classes.jar":
                data, count = rewrite_jar(data)
                rewritten_classes += count
                found_classes = True
                found_go_runtime = True
            new_name = name
            if new_name.endswith("/libgojni.so") or new_name == "libgojni.so":
                new_name = new_name[: -len("libgojni.so")] + "libpgjni.so"
                renamed_native += 1
            data = rewrite_bytes(data) if name != "classes.jar" else data

            clone = zipfile.ZipInfo(new_name, date_time=info.date_time)
            clone.compress_type = info.compress_type
            clone.comment = info.comment
            clone.extra = info.extra
            clone.create_system = info.create_system
            clone.external_attr = info.external_attr
            clone.internal_attr = info.internal_attr
            clone.flag_bits = info.flag_bits
            dst.writestr(clone, data)

    if not found_classes:
        raise ValueError("AAR has no classes.jar")
    if renamed_native < 2:
        raise ValueError(f"Expected Psiphon JNI libraries for both ABIs; found {renamed_native}")
    if rewritten_classes == 0:
        raise ValueError("No gomobile go/ runtime classes were found in classes.jar")

    # Verify the final archive rather than trusting the transformation.
    final_bytes = output.getvalue()
    with zipfile.ZipFile(io.BytesIO(final_bytes), "r") as aar:
        names = aar.namelist()
        if any(n.endswith("/libgojni.so") or n == "libgojni.so" for n in names):
            raise ValueError("Unrenamed libgojni.so remains in the AAR")
        if not any(n.endswith("/libpgjni.so") for n in names):
            raise ValueError("Renamed libpgjni.so is missing from the AAR")
        with zipfile.ZipFile(io.BytesIO(aar.read("classes.jar")), "r") as jar:
            if any(n.startswith("go/") for n in jar.namelist()):
                raise ValueError("Unrenamed go/ package remains in classes.jar")
            if not any(n.startswith("pg/") for n in jar.namelist()):
                raise ValueError("Relocated pg/ runtime package is missing")

    destination.parent.mkdir(parents=True, exist_ok=True)
    destination.write_bytes(final_bytes)
    print(f"Repackaged {source} -> {destination}")
    print(f"Relocated {rewritten_classes} runtime classes; renamed {renamed_native} JNI libraries.")


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("source", type=Path, help="official psiphontunnel AAR")
    parser.add_argument("destination", type=Path, help="output -ns AAR")
    args = parser.parse_args()
    try:
        repackage(args.source, args.destination)
    except (OSError, ValueError, zipfile.BadZipFile) as exc:
        print(f"ERROR: {exc}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
