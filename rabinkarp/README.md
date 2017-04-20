# Parallel Rabinkarp

## Link to original serial code 
https://github.com/saru95/DSA/blob/master/RabinKarp.cpp

## Run Instructions
```
g++ RabinKarpSerial.cpp
./a.out < strmatch_dna_ip2.txt 
./a.out < strmatch_binary_ip2.txt 
```
For the Parallel code :
``` 
g++ -fopenmp RabinKarp.cpp
./a.out < strmatch_dna_ip2.txt 
./a.out < strmatch_binary_ip2.txt 
```
use the time command to get the real runtime of the program.

## Changes made to serial code to parallelize
Line 51 : removed calculation of initial text hash

Lines 54-56 : calculation of how to split the strings across cores

Line 57-61 : calculation the start and end of each part of the string and parallelizing parts of string with a new for loop

Line 63-67 : calculation of initial hash for each part of the string 