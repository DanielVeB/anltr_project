Repository contains c files compiled with clang to llvm. 

## How to compile 

Use clang to compile c file to llvm ir
```
$ clang -S -emit-llvm -O3 <file_name>.c
```

<blockquote> -O3 ensures we discard any unnecessary instructions. </blockquote>

This creates a file <file-name>.ll
To run llvm file, use lli 

```
lli <file_name>.ll 
```