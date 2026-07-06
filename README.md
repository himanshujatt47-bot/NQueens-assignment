# N-Queens Problem Solution

## Description
This project solves the N-Queens problem using the Backtracking algorithm in Java.

## Language
- Java

## Algorithm
- Backtracking

## Features
- Finds all possible solutions.
- Prints the total number of solutions.
- Works for values of n from 1 to 9.

## Regular Expression Matching

### Problem Statement 2
This program implements a simple Regular Expression Matching system where the symbol `+` means **one or more occurrences** of the preceding character.

---

### Rules
- `A+` means one or more A's (A, AA, AAA, etc.)
- Pattern must match the entire string
- Invalid patterns:
  - starts with `+`
  - ends with `+`
  - contains `++`

---

### Example 1
Input:
P = AAAB  
Q = A+B  

Output:
True  

Explanation:  
A+ matches AAA and B matches B

---

### Example 2
Input:
P = AAB  
Q = A+B  

Output:
True  

---

### Example 3
Input:
P = BA  
Q = A+B  

Output:
False  

Explanation:  
Pattern expects A first but text starts with B

---

### Approach Used
- Two pointer technique
- Greedy matching for `A+`
- Validate each character sequentially
- Ensure full string and pattern match

---

### File
- RegularExpressionMatching.java
