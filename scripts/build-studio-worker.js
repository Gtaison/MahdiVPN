#!/usr/bin/env node
'use strict';

// Rebuild (or verify) the byte-identical Config Studio Worker from its ordered source fragments.
const fs = require('node:fs');
const path = require('node:path');

const root = path.resolve(__dirname, '..');
const manifestPath = path.join(root, 'worker-src', 'studio', 'manifest.json');
const manifest = JSON.parse(fs.readFileSync(manifestPath, 'utf8'));
if (!Array.isArray(manifest.parts) || !manifest.output) {
  throw new Error('worker-src/studio/manifest.json must define output and ordered parts');
}

const sourceDir = path.join(root, 'worker-src', 'studio');
const parts = manifest.parts.map((part) => {
  if (!part || typeof part.file !== 'string') throw new Error('Invalid worker fragment entry');
  return fs.readFileSync(path.join(sourceDir, part.file));
});
const expected = Buffer.concat(parts);
const outputPath = path.join(root, manifest.output);

if (process.argv.includes('--check')) {
  if (!fs.existsSync(outputPath)) {
    console.error('Config Studio Worker asset is missing:', manifest.output);
    process.exit(1);
  }
  const actual = fs.readFileSync(outputPath);
  if (!actual.equals(expected)) {
    let offset = 0;
    const max = Math.min(actual.length, expected.length);
    while (offset < max && actual[offset] === expected[offset]) offset++;
    console.error(
      'Config Studio Worker asset has drifted from its fragments. ' +
      'Run: node scripts/build-studio-worker.js\n' +
      `first differing byte: ${offset}; asset bytes: ${actual.length}; source bytes: ${expected.length}`,
    );
    process.exit(1);
  }
  console.log(`studio worker asset: ${manifest.parts.length} fragments, ${expected.length} bytes, byte-identical`);
} else {
  fs.mkdirSync(path.dirname(outputPath), { recursive: true });
  fs.writeFileSync(outputPath, expected);
  console.log(`built ${manifest.output} from ${manifest.parts.length} fragments (${expected.length} bytes)`);
}
