**Name:H V Suchitra Reddy

-----------------------------------------------------------------------

1)Each Replica System needs to be represented as a tree, wherein each node of the tree corresponds to a Student Record.
2)Each Tree needs to be given a unique ID (0, 1, 2, for example). Use a final int in each Tree to save this id. Write a utility class with a static method to return this unique id to be returned whenever it is called.
3)Create a class called StudentRecord to serve as nodes for the tree. A student record consists of the following:
        a)	a bNumber (4 digit positive integer),
        b)	a String for "firstName",
        c)	a String for "lastName",
        d)	a double value for "gpa",
        e)	a String for "major",
        f)	and a set of Strings for skills. The max number of skills that will be listed in the input file will be 10.
1.	Write code for a tree that has the features to insert and search Student Records. You need to write code for the tree by yourself. However, you are allowed to get help from a book or online source (for example the source code for BST, AVL, 2-3, 2-3-4, etc.) If you do so, cite the URL both in your source code and also README. It will be considered CHEATING if you do not cite the source of any code on tree that you use/adapt.
2.	The three trees (replica_0, replica_1, and replica_2) should be separate instances of the same Tree. Note that you should appropriately use Camel case (as per Java naming convention)) instead of the names I have listed here.
3.	Each Node of the tree should implement both the SubjectI and the ObserverI interface.
4.	As you need to modify the code to implement the Observer pattern, you can't use the in-built Observer pattern in Java.
5.	Populate the tree using the data from an input file provided with the -Dinput commandline option. A line in the input file has the following format:
6.		<B_NUMBER>:<FIRST_NAME>,<LAST_NAME>,<GPA>,<MAJOR>,[<SKILL>,[<SKILL>, ...]]

Example is shown below.
	1234:John,Doe,3.9,ComputerScience,Skill3,Skill1,Skill2,Skill5,Skill4,
	2345:John,Doe,3.9,Chemistry,Skill0,Skill7,Skill8,Skill5,Skill3,Skill4,Skill3,Skill9
	1124:Jane,Doe,3.9,Chemistry,Skill9,Skill8,Skill7,Skill6,Skill2,Skill3,Skill4
	...
	
1.	The input lines may have bNumbers that are repeated. If a node already exists, change the data member values in the Node with the new values from the latest input line. Note that by using a set for the skills, only unique Strings can be added.
2.	Your TreeHelper should be such that when you create a node (replica_Node_0), you should clone it twice to get two Nodes (let's say replica_Node_1 and replica_Node_2). Setup these three nodes to be replicas of each other. The TreeHelper is a helper that helps build the tree recrusively.
        a)	So, replica_Node_1 and replica_Node_2 should be observers of replica_Node_0. As replica_Node_0 is the subject in this case, you should store the references of replica_Node_1 and replica_Node_2 in a data structure for listeners (array list of references, for example).
                    1.	replica_Node_0 should be inserted in replica_tree_0.
                    2.	replica_Node_1 should be inserted in replica_tree_1.
                    3.	replica_Node_2 should be inserted in replica_tree_2.
        b)	replica_Node_0 and replica_Node_1 should be observers of replica_Node_2. Continue with steps corresponding to the ones listed in the 1st bullet.
        c)	replica_Node_0 and replica_Node_2 should be observers of replica_Node_1. Continue with steps corresponding to the ones listed in the 1st bullet.
3.	You do NOT need to write code to delete nodes, as the input and modification files should not require deletion of any node.
4.	The Replica trees should NOT be setup a observers or subjects. The replicas should be setup at only the Node level.
5.	Process one line at a time from the modification file provided using the -Dmodify commandline option. The file has the following format (first entry corresponds to the replica number, the 2nd to the bNumber, and 3rd to the value that needs to be searched and replaced/modified).
6.		<REPLICA_ID>,<B_NUMBER>,<ORIG_VALUE>:<NEW_VALUE>
	
An example is shown below.
	0,1234,John:John7
	1,2345,Chemistry:MathematicalSciences
	2,1234,Skill1:Skill9
	...
	
7.	The modification file will not have any request to change the GPA.
8.	If the request for modified value is empty (for example, "Mathematical Sciences:"), print a meaningful message to error file and proceed to the next line.
9.	Search for the node with the bNumber in the line from the modification file, and then modify the corresponding attribute value in that Node. If that attribute value does not exist to modify, then ignore and move to the next line. Once the change to the specified replica_Node_X is done, then the change should be sent to both the observer nodes. Note that the updates should be sent before the next line is processed.
10.	The update(...) call should do the following:
              a)	determine if the call on the observer is for INSERT or MODIFY.
              b)	search for the appropriate node using the bNumber.
              c)	If it is an INSERT based update call, then use the latest values. Note that for skills, insert should only add to the existing set, and not        delete any existing skill.
              d)	If it is a MODIFY based update call, then every occurrence of the origValue should be replaced with the provided modifiedValue.
11.	From the command line accept the following args:
              a)	Input file path with the -Dinput commandline option.
              b)	Modification path file with the -Dmodify commandline option.
              c)	Output file path for tree 1 with the -Dout1 commandline option.
              d)	Output file path for tree 2 with the -Dout2 commandline option.
              e)	Output file path for tree 3 with the -Dout3 commandline option.
              f)	Error file path with the -Derror commandline option.
              g)	Debug value with the -Ddebug commandline option.
12.	Do not hardcode the file names in your code. Use the file names provided via command line.
13.	Add a method to your tree, printNodes(Results r, ...), that stores in Results the list of skills for each student, sorted by the bNumber in ascending order.
14.	Your driver code should do the following:
              a)	Read command line arguments.
              b)	Build the three trees, based on the input file and the observer pattern. It is recommended that you use a TreeHelper to build each tree recursively. The TreeHelper can hold references to the roots of the 3 trees that are being built, and have helper methods to insert, printNodes(...), etc. It is also ok to build your trees in other ways as long as the design will work if the number of replicas is increased/decreased.
              c)	Apply updates according to modification file.
              d)	Create a new Results instance and call printNodes(...) on each of the three trees to store the bNumber and list of skills to store in Results. So, each of the three trees will use a different instance of Results.
              e)	Call a method in Results, via the method in FileDisplayInterface, to write the data stored in Results to three output files, for the three trees. You can run a "diff" on the three output files to make sure your Observer pattern worked correctly.
15.	When you read in an input file, you should insert the skill into the main tree and in that tree update the node corresponding to the bNumber. If a node with the bNumber exists, you should update that node in the main tree, notifyAll(...) to the two corresponding listener nodes. If no such node with that bNumber exists in the main tree, then do the following:
                a)	create a new Node (lets call it new node)
                b)	clone this new node twice, and setup all the listeners and subjects.
                c)	insert the nodes in their respective trees, recursive insert from the root.
16.	Note that notifyAll(...) could be used for processing modification file and also input file (for example, when you need to add a skill to an existing bNumber from the input file). So, add enum as a parameter to the notifyAll(...) call in the SubjectI, also to update(...) in ObserverI, to indicate whether the notifyAll(...) call, which calls update(...) on the observer nodes, is for INSERT or MODIFY.
17.	Calls made to notifyAll(...) should be propagated to the observers. However, calls to update(...) on a node should not be propagated any further to prevent a cycle (infinite loop).
18.	briefly describe how the observer pattern has been implemented, and the URLs from where you borrowed ideas/code for the tree implementation.

-----------------------------------------------------------------------------------------------

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



