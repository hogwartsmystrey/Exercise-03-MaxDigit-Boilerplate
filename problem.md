## Problem Statement: Longest span of the number in an array##

**Given an integer array, the longest span of number needs to be found. If 
a number is repeated multiple times in an array, span is the number of elements between 
the first occurrence and the last occurrence of the number, inclusive of the numbers. 

**This exercise contains a class named LongestSpan with the following static method:**

      findLongestSpan(int[]):String  
  
     - Method should take integer array as input and return a String with the number and longest span of a number separated by colon(:).
     - If two numbers have the same longest span, the larger number and its span should be returned
     - A single value has a span of 1.
     
    *Note: If the input array is null or empty, method should return "-1"* 

**Do the following in the main method of LongestSpan class**

1. Accept inputs from the console
2. The first input is integer(n) denoting the count of integers, followed by  'n' integers
3. The integers should be stored in an array and passed to the method
4. The output should be displayed as per the format given in example section 
5. Main method should display **Empty Array**, if the input array to the method is empty

## Example
    Sample Input:
    5 1 2 1 2 1       // The max elements between 1's is 5 inclusive of 1. Longest span is 5 
    
    Expected Output:
    1:5
--------------------------------------------------------
    Sample Input:
    7 3 4 5 3 1 3 4   // The max elements between 3 is 6 and 4 is 6. Longest span is 6 and larger number is 4
    
    Expected Output:
    4:6

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding