import os
from pathlib import Path

header_dir = './llvm16.0.6/include/llvm-c'

defs_path = 'def/defs'
if os.path.isfile(defs_path):
    defs = open(defs_path, 'r')
    lines = defs.readlines()
    defs.close()
    for line in lines:
        file = line[:-1]
        if (os.path.isfile(file)):
            os.remove(file)


os.makedirs(os.path.dirname(defs_path), exist_ok=True)

defs = open(defs_path, 'w')

for root, dirs, files in os.walk(header_dir):
    for file in files:
        if file.endswith('.h'):
            filepath = os.path.relpath(os.path.join(root, file), Path(header_dir).parent.absolute()).replace('\\', '/')
            filepathname = os.path.splitext(filepath)[0]
            package = filepathname.replace('/', '.').replace('-', '_').lower()
            defpath = os.path.join('def', f'{package}.def')
            
            defs.write(f'{defpath}\n')

            file = open(defpath, 'w')
            file.write(f'package = {package}\n')
            file.write(f'compilerOpts = -Isrc/nativeInterop/cinterop/llvm/llvm16.0.6/include\n')
            file.write(f'linkerOpts = -Lsrc/nativeInterop/cinterop/llvm/llvm16.0.6/lib\n')
            file.write(f'headerFilter = {filepath.split("/", 1)[0]}/*\n')
            file.write(f'headers = {filepath}')
            file.close()

defs.close()