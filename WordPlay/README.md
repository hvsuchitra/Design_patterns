## Name: H V Suchitra Reddy

-----------------------------------------------------------------------
-----------------------------------------------------------------------

**Project Discription:**
Develop a program, using Java, to process an input file containing sentences and also to calculate certain metrics.!
•	An input file contains sentences, one per line. Each sentence contains words delimited by <space> character. Each sentence terminates with a period.
•	Each sentence is made up of alphanumeric words (characters in the set [a-zA-Z0-9]).
•	The program  process the input file word by word.
•	The program does the following.
  
->	Rotate each word in a sentence to the right by x places where x is the index of the word in the sentence.

Note: Indexing starts from 1. So first word is rotated by 1 place, second by 2 places and so on.
Note: Only the characters of a word should be rotated. The order of words in the sentence should remain as is.
Note: The rotation should be case senstitive. An upper case character in the input should remain in upper case in the output and lower case character should remain in lower case.
Note: Period characters remain unchanged.

For example, 
consider the sentence "Welcome to the course.". As it is mentioned that indices start from 1, the index of "Welcome" is 1, "to" is 2, "the" is 3 and "course" is 4.
We therefore need to rotate "Welcome" by 1 position, "to" by 2 positions, "the" by 3 positons and "course" by 4 positions to the right.
After performing rotation, the sentence would now read "eWelcom to the urseco.". This rotated sentence is to be written to the output file.


->	Calculates the following metrics and write them to the metrics file (one metric per line).
=>	AVG_NUM_WORDS_PER_SENTENCE - Average number of words per sentence. Round to 2 decimal places. Format: AVG_NUM_WORDS_PER_SENTENCE = <value>
=>	AVG_WORD_LENGTH - Average length (number of characters) of a word in the input file. Round to 2 decimal places. Format: AVG_WORD_LENGTH = <value>
  
  
  
**INPUT**

Your program should accept three files from the commandline - input file, output file and metrics file. These file names/paths will be provided using the following command-line options. 


        •	-Dinput: Input file path.
        •	-Doutput: Path to the output file to which the sentences with the sorted words are written.
        •	-Dmetrics: Path to the metrics file to which the metrics are written (one per line) in their respective formats.
        
        
        
**EXAMPLES**


INPUT


Welcome to design patterns summer 2020.
Start working on this assignment quickly.


OUTPUT


eWelcom to igndes ernspatt ummers 2020.
tStar ngworki no this nmentassig uicklyq.

**metrics**

AVG_NUM_WORDS_PER_SENTENCE - 6.0
AVG_WORD_LENGTH - 5.67


-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
Refered override of toString():
https://www.geeksforgeeks.org/overriding-tostring-method-in-java/

complexity for my program is O(n).



Date: [5-JUN-2020]



