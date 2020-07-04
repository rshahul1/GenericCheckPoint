# CSX42: Assignment 5
## Name:Reshma Barvin Shahul Hameed Amanullah 

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in genericCheckpointing/src folder.
input.txt is in the genericCheckpointing folder

-----------------------------------------------------------------------
## Instruction to clean:


Go till the src folder
command: ant clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

Go till the src folder
command: ant all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

Command: ant run -Darg0="deserser" -Darg1="input.txt" -Darg2="output.txt" -Darg3="2"
arg3 is the debug value, here 2 is passed, however 0>=arg3<=2 can be passed. 
Debug value:
debugLevel 2 = DebugLevel.STRATEGY; break;
debugLevel 1 = DebugLevel.FILE_GENERATE; break;
debugLevel 0 = DebugLevel.FILE_PROCESSOR; break;

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## References:
1.https://www.geeksforgeeks.org/java-string-indexof/
2.https://stackoverflow.com/questions/8491687/write-newline-into-a-file
3.https://examples.javacodegeeks.com/core-java/io/filewriter/java-filewriter-example/

-----------------------------------------------------------------------
## Data Structure and algorithm:
1.Xml file is read line by line and parsed instead of storing of storing the entire file in a data structure. 
2.The objects after the deserialisation is stored in the Arraylist for easy  addition and retrieval of objects.
3.Serialisation and Deserialisation is implemented using Strategy Pattern.
4.Dynamic Proxy and Reflection are implemented.
5.Parsing of the XML file is done in XMLParser Class and building the output file again from the object is done in XMLMerger. 

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [12/9/2019]


