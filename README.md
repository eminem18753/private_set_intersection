## Java 8 is needed to run the code. Make sure you have Java 8.

	Cybersecurity incidents are an ever-growing problem for companies.  Recently, the President of the United States called for steps to improve cybersecurity, including new legislation that would limit liabilities of companies that report incidents that had happened to them.I study how companies can share cybersecurity incidents with each other without revealing unnecessary information about the incidents.
  
	Each one represents a company that has experienced 10 standard cybersecurity incidents. This code can be used to learn whether other companies have experienced similar incidents, but without having to share the set of all incidents.

## Running the PSI protocol

	Suppose a Client wants to find if another Server has experienced the same incidents as it has experienced.

##### Both the Client and the Server need to perform the following steps initially without sharing any information with each other at this stage:

1. Extract the code from the provided archive.
2. Compile the code using
  * Unix/Linux/Mac: "javac -cp .:flanagan.jar *.java"
 * Windows: "javac -cp “.;flanagan.jar” *.java"
3. Select 10 unique cybersecurity incidents from the list in file "incident_list.txt".
4. Create another text file say "inputs.txt" and put the labels of the 10 incidents you selected in step 2 and separate the labels by new lines. See example "example_inputs.txt" to understand the format. Do not use the example "example_inputs.txt" file. A group using "example_inputs.txt" as "inputs.txt" will get zero.

###### The Client needs to perform the following steps:

1. Run the following program: 
  * Unix/Linux/Mac: "java -cp .:flanagan.jar ClientPhase1 <cl-inputs.txt>  <netid>"
  * Windows:  "java -cp “.:flanagan.jar” ClientPhase1 <cl-inputs.txt>  <netid>"
  * Use netid of one of the group member.
2. This will generate two files with filename being "netid" and "ClientPK.out". 
3. Email both of these files to the Server.
4. Wait for the server to run its program and send you the file "netid.out".
5. After you receive the file from Server named netid.out, put it in the same directory as the code and run the following program: 
 * Unix/Linux/Mac: "java -cp .:flanagan.jar ClientPhase2 <cl-inputs.txt>  <netid.out>"
 * Windows: "java -cp “.;flanagan.jar” ClientPhase2 <cl-inputs.txt>  <netid.out>"
6. The program will output the common incidents.

###### The server perform the following steps:

Note: Before you can perform the steps below you must implement the server PSI sub-protocol (see Task 1).

1. Put the files ("ClientPK.out" and "netid") received from the Client in the same directory as the code.
2. Run the following program:
  * Unix/Linux/Mac: "java -cp .:flanagan.jar Server <sr-inputs.txt>	<netid>"
  * Windows:  "java -cp “.:flanagan.jar” Server <sr-inputs.txt> <netid>"
3. This will generate a file with the filename "netid.out". Email this file back to the Client.
