# Data Structures and Algorithms Final Project

## How to run

Utilize the Algs4 Library which can be located at https://algs4.cs.princeton.edu/code/

## Purpose

To compress a text file. A full description of the programming assignment can be located at https://www.cs.princeton.edu/courses/archive/fall21/cos226/assignments/burrows/specification.php

## MoveToFront

This method applies the MoveToFront conversion. By representing charachters which appear in succession with smaller integers, it allows Huffman Compression to better take place. 

The typical run-time is n + R  

## CircularSuffixArray

Convert a String into a CircularSuffixArray, which is a sorted representation in which all possible orderings of the string using MSD sort. 

The typical run-time is n * log_R (n)

## BurrowsWheeler

Either transform or inverse transform a given string, using its CircularSuffixArray representation, to increases the likelihood of charachters occuring in close succesion to each other

The typical run-time for transformation is n * log_R (n) and for inverse transformation is n + R
