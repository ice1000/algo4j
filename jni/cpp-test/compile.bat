
@echo off

g++ discretization.cpp -o discretization.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3
g++ bubble_sort_test.cpp -o bubble_sort_test.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3
g++ merge_sort_test.cpp -o merge_sort_test.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3
g++ insertion_sort_test.cpp -o insertion_sort_test.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3
g++ pair_test.cpp -o pair_test.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3
g++ quick_sort_test.cpp -o quick_sort_test.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3
g++ prime.cpp -o prime.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3
g++ beep.cpp -o beep.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3
g++ memory.cpp -o memory.exe -m32 -std=gnu++11 -static-libgcc -m32 -g3

pause
