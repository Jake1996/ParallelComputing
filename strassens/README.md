# Parallel Strassens Matrix Multiplication

## Link to original serial code
https://github.com/MartinThoma/matrix-multiplication/blob/master/C%2B%2B/strassen-algorithm.cpp

## Run instructions
For generating the input files :
```
javac scint.java
java scing size_of_matrix > size_of_matrix.txt
```
Replace size_of_matrix with a 2^n integer , this will generate out input files

For serial run :
```
g++ strassen-algorithm.cpp
./a.out < size_of_matrix.txt 
```
For parallel run :
```
g++ -fopenmp strassen-algorithm.cpp
./a.out < size_of_matrix.txt
```
This will output the time taken to run the code for that input.

## Changes made to serial code to parallelize

Line 43 : single layer of parallelization on the bruteforce ijkalgorithm
Line 91-146 : initialize aResult and bResult and parallelize calculation of p1 to p7
Line 148-174 : initialize aResult and bResult when required and parallelize calculation of the four parts of the resulting array