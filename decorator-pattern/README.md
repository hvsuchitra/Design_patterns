CSX42: Assignment 4
**Name:H V Suchitra Reddy

Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in arrayvisitors/src folder.

Instruction to clean:
commandline: ant -buildfile textdecorators/src/build.xml clean

Description: It cleans up all the .class files that were generated when you compiled your code.

Instructions to compile:
commandline:

ant -buildfile textdecorators/src/build.xml all

The above command compiles your code and generates .class files inside the BUILD folder.

Instructions to run:
commandline:

ant -buildfile textdecorators/src/build.xml run -Dinput="input.txt" -Dmisspelled="misspelled.txt" -Dkeywords="keywords.txt" -Doutput="output.txt" -Ddebug="2"


Note: Arguments accept the absolute path of the files.

I have used my 4 days of my slack day for this assignment

Description:
For storing the words from the input files and I have implemented using ArraysLists.

Time Complexity for accesing an element from an arrayList and for insert operation is O(1) and O(n) Respectively.


References: 
https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
https://stackoverflow.com/questions/505928/how-to-count-the-number-of-occurrences-of-an-element-in-a-list

Academic Honesty statement:
"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken. "

Date: [20-Jul-2020]
