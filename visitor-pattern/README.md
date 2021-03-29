**Name:H V Suchitra Reddy

-----------------------------------------------------------------------
**PROJECT DISCRIPTION**

Program with visitors to determine features in two input files that have integers. 

1.	The input for the program consists of two separate input files, both with a positive 2 digit integer in each line. Assume that the input may contain duplicates in the individual files.
2.	Create an interface MyArrayI that defines an API for an Abstract Data Type (ADT) representing an array. In addition, MyArrayI is an Element.
3.	Define an ADT, MyArray, that implements MyArrayI and stores an internal array of integers. The internal array should be created with an initial capacity of 10 and increased by 50% in capacity each time an integer has to be added beyond the current capacity.
4.	Each MyArray object will store the integers from a single input file.
5.	Design a visitor, PopulateMyArrayVisitor, that reads from a file and populates MyArray one integer at a time. The visitor should use an instance of the FileProcessor to read from the input file one line at a time (one integer at a time). Check for the boundary condition that the input file does not exist or is empty. Throw an exception and exit if a string from the file cannot be converted to an integer. Other than that, assume the input file is well formed and no other exceptions need to be handled.
6.	The PopulateMyArrayVisitor can take the name of the input file in its constructor or have a setX(..) method for it. You need to apply this visitor once for each of the two input files to get two instances of MyArray that are populated with integers.
7.	Create an interface MyArrayListI that defines an API for a ADT representing an arraylist. In addition, MyArrayListI is an Element.
8.	Define an ADT, MyArrayList, that implements MyArrayListI and maintains an internal array of the MyArray objects.
9.	Design a visitor, CommonIntsVisitor, that determines the integers that are common in the two ADTs stored in MyArrayList, and stores those integers (without duplicates) in an appropriate data structure in Results.
10.	Design a visitor, MissingIntsVisitor that determines the 2 digit integers (between 00 and 99) that are missing in MyArray and stores them in an appropriate data structure in Results.
11.	The output files should contain a single integer per line.
12.	Use a singleton Logger and design your own debugging scheme.
14.	The driver should accept the input file names, output file names, and debug value, via the command line.

              a.	-Dinput1 - First input file containing 2 digits integers per line.
              b.	-Dinput2 - Second input file containing 2 digits integers per line.
              c.	-Dcommonintsout - Output file to store results of applying CommonIntsVisitor.
              d.	-Dmissingintsout - Output file to store results of applying MissingIntsVisitor.
                          i.	Recommended for this assignment - upload to the same output file. Include headings to indicate which MyArray or input file the output corresponds to.
                          ii.	Also acceptable - upload to missing integers for each MyArray object to a different output file.
              e.	-Ddebug - Debug value.
              
              
14.	The driver should do the following:

          a.	Create required instances of Results.
          b.	Create instance of FileProcessor.
          c.	Create instances of the visitors.
          d.	Create two instances of MyArray.
          e.	Use the PopulateMyArrayVisitor to populate two instances of MyArray.
          f.	Apply CommonIntsVisitor to determine common ints in ADTs stored in MyArrayList.
          g.	Apply MissingIntsVisitor separately to each of the MyArray instances.
          h.	Call appropriate methods in Result instances to print the output of each of the visitors.
          
15.	Helpers:

          a.	There is only a single visitor interface.
          b.	Unlike the traditional viistor pattern where there is just a single visit(...) method in the Visitor interface, you will need to overload the method here for each of the two visitors.
          c.	When calling methods on the ADTs/Elements make sure to cast to the appropriate interface and then call the method. For example, ADT methods should be called by casting to the interface that defines the API for the ADT.
          d.	No business logic should be written in the driver code.
          e.	ADT design
                  i.	Empty constructor.
                  ii.	Explicit value constructor.
                  iii.	Getters and Setters.
                  iv.	Override toString.
                  v.	Empty finalize method.
                  vi.	Override Clone.
          f.	Driver code
                  i.	Driver code should not include business logic.
                  ii.	Simple and concise.


--------------------------------------------------------------------------------
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

