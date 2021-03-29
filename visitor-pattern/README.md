# CSX42: Assignment 4
**Name:H V Suchitra Reddy

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [arrayvisitors/src](./arrayvisitors/src/) folder.

## Instruction to clean:

commandline:
ant -buildfile arrayvisitors/src/build.xml clean


Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

commandline:

ant -buildfile arrayvisitors/src/build.xml all

The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

commandline:

ant -buildfile arrayvisitors/src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dcommonintout="commanintout.txt" -Dmissingintout="missingintout.txt" -Ddebug="2"




Note: Arguments accept the absolute path of the files.


## Description:
For storing the integer values from the input files and I have implemented using Arrays and LinkedList.

Time Complexity for accesing an element from an array and for insert operation is O(1) and O(n) Respectively.

Time Complexity for getting a value from an LinkedList and for insert operations is O(n) and O(1) Respectively.

References:
https://www.geeksforgeeks.org/singleton-class-java/
https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/





## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [20-Jul-2020]


