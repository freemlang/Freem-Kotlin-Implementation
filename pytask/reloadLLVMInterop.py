print("python task for gradle")
print("abcefg")
print()
print("a")

import os

print(os.getcwd())

"""
task("reloadLLVMInterop") {
        nativeTarget.compilations.getByName("main") {
            cinterops {
                val path = "src/nativeInterop/cinterop/llvm/def"
                for (def in File(path).walkTopDown().filter { it.toString().endsWith(".def") }) {
                    create(def.name).defFile(project.file(def))
                }
            }
        }
        ""\"
            package = {package}
            compilerOpts = -Isrc/nativeInterop/cinterop/llvm/llvm16.0.6/include
            linkerOpts = -Lsrc/nativeInterop/cinterop/llvm/llvm16.0.6/lib
            headerFilter = {filepath.split("/", 1)[0]}/*
            headers = {filepath}
        ""\".trimIndent()
    }
"""