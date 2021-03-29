# CSX42: Assignment 3
**Name:H V Suchitra Reddy

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in [studentskills/src](./studentskills/src/) folder.

## Instruction to clean:

commandline:
ant -buildfile studentskills/src/build.xml clean


Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

commandline:

ant -buildfile studentskills/src/build.xml all

The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

commandline:

ant -buildfile studentskills/src/build.xml run -Dinput="input.txt" -Dmodify="modify.txt" -Dout1="output1.txt" -Dout2="output2.txt" -Dout3="output3.txt" -Derror="error.txt" -Ddebug="debug.txt"



Note: Arguments accept the absolute path of the files.


## Description:
->Used One day of Slack Day for this assignment.


Implimented tree using binary Search trees as it is more efficeient for sorting and seach operartions.
RunTime: O(log n).

reference:https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/




## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [11-JULY-2020]


