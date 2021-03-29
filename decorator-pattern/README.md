
**Name:H V Suchitra Reddy

**Text Decorators **

1.	Design a program that accepts the following inputs.
          a.	-Dinput - Input file containing the text to process. The valid characters in the input file are [a-zA-Z0-9\.,\s] where
                    i.	a-z - Lowercase alphabets.
                    ii.	A-Z - Uppercase alphabets.
                    iii.	\. - Period character.
                    iv.	, - Comma.
                    v.	\s - Any whitespace character. Matches [\r\n\t\f\v].
          b.	-Dmisspelled - Misspelled words file containing words, one per line, that are misspelled.
          c.	-Dkeywords - Keywords file containing keywords, one per line.
          d.	-Doutput - Output file to which the processed input is persisted.
          e.	-Ddebug - Debug value.
2.	Design a class InputDetails that has datastructure(s) to store, retrieve and update sentences.
3.	Words in the input file are delimited by one or more spaces.
4.	Design the following decorators.
          a.	Design a SentenceDecorator. Each sentence is separated by a "." (period) character. The SentenceDecorator prefixes the sentence with BEGIN_SENTENCE__ and suffixes the sentence with __END_SENTENCE .Note that the period character is not considered a part of the sentence.
          b.	Design a SpellCheckDecorator. This decorator checks whether any of the words is a misspelled word. A word is misspelled if it is present in the file provided with the commandline option -Dmisspelled. Misspelled words are prefixed with SPELLCHECK_ and suffixed with _SPELLCHECK. Note: The algorithm should be case insensitive.
          c.	Design a MostFrequentDecorator. This decorator adds the prefix MOST_FREQUENT_ and suffix _MOST_FREQUENT to all the occurrences of the most frequently occurring word in the entire input file. Note: The algorithm should be case insensitive. Note: Think of what data structure can be used here to facilitate efficient search of the most frequently occurring word..
          d.	Design a KeywordDecorator. This decorator checks whether any of the words is a keyword. A word is a keyword if it is present in the file provided with the commandline option -Dkeywords. Keywords are prefixed with KEYWORD_ and suffixed with _KEYWORD. Note: The algorithm should be case insensitive.
          e.	Note: All decorators update the contents in-place. Hint: In SpellCheckDecorator and KeywordDecorator You can use String#indexOf(...) to search for words to make the program more robust.
         
5.	Assume that the input file is well formatted.
6.	Use loggers and debug values as used in the previous assignments. Each decorator will have its own debug value, that when set will result in that decorator writing the transformations made to a log.txt file. When writing the transformations to log.txt, prefix and suffix the log entry with the name of the decorator. Note that this is in addition to updating InputDetails in-place.
7.	Decorators are all derived types of AbstractTextDecorator (the name of the type should give enough information regarding its blueprint). AbstractTextDecorator declares a method called processInputDetails() that has no return type and no arguments.
8.	Decorators are instantiated by passing the decorator to wrap around and the InputDetails reference (the one to process) to the constructor.
9.	After processing input and applying all the decorators, the updated text in InputDetails should be persisted to the output file, the name of which will be provided via the commandline option -Doutput.

**Input/Output**

An example input, along with the corresponding output is given below. 
**Input**

The Electors shall meet in their respective States and vote by Ballot for two Persons of whom one at least shall not be an Inhabitant of the same State with themselvs. And they shall make a List of all the Persons voted for and of the Number of Votes for each 3 which List they shall sign and sertify and transmit sealed to the Seat of the Government of the United States 3 directed to the President of the Senate .

**Keywords:**
government
persons
states

**Misspelled Words:**
themselvs
sertify

**Output:**

BEGIN_SENTENCE__MOST_FREQUENT_The_MOST_FREQUENT Electors shall meet in their respective KEYWORD_States_KEYWORD and vote by Ballot for two KEYWORD_Persons_KEYWORD of whom one at least shall not be an Inhabitant of MOST_FREQUENT_the_MOST_FREQUENT same State with SPELLCHECK_themselvs_SPELLCHECK__END_SENTENCE.BEGIN_SENTENCE__ And they shall make a List of all MOST_FREQUENT_the_MOST_FREQUENT KEYWORD_Persons_KEYWORD voted for and of MOST_FREQUENT_the_MOST_FREQUENT Number of Votes for each 3 which List they shall sign and SPELLCHECK_sertify_SPELLCHECK and transmit sealed to MOST_FREQUENT_the_MOST_FREQUENT Seat of MOST_FREQUENT_the_MOST_FREQUENT KEYWORD_Government_KEYWORD of MOST_FREQUENT_the_MOST_FREQUENT United KEYWORD_States_KEYWORD 3 directed to MOST_FREQUENT_the_MOST_FREQUENT President of MOST_FREQUENT_the_MOST_FREQUENT Senate __END_SENTENCE.


--------------------------------------------------------------------------
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
