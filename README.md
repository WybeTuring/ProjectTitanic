# ProjectTitanic
## Overall Design
**The javadocs for this project can be read from [Read Javadocs](https://wybeturing.github.io/ProjectTitanic/galamsey/package-summary.html)**


**The javadocs for the entire project can be read comfortable from [Read Javadocs](https://wybeturing.github.io/ProjectTitanic/galamsey/package-summary.html)**

This aim of this project is to design and build a software that enables policy makers and regulators to tract illegal mining (Hereafter referred to as Galamsey) across the world. The program is designed using object oriented design principles, and makes use of five primary classes, which include;
- A Position class that holds the longitude and latitude of positions.
- A Galamsey class that holds records of Galamsey events.
- A Observatory class that holds information about a given observatory and a list of observed Galamsey events.
- A Monitoring class that holds information about several observatories.
- A MonitoringIO class that employs all the classes and contains a main method. 

## Achieving Data Persistence

To achieve persistence, we read and write to files. Two files, observatories.txt and galamsey.txt are being used, and are described as follows;

- galamsey.txt holds records of observed Galamsey events in the format 
	observatory name, colour value, colour name, latitude, longitude, year of observation.
	The observatory name refers to the name of the observatory that is recording the galamsey event.
	
- observatories.txt holds information about the registered observatories, in the format, 
	Name of observatory, county, year of commencement, square area observed
	
	
The program can be said to run in the following sequence;

1. A monitoring class is created that will hold all all the information for a session
2. The observatories are read from the observatories.txt file, and the information obtained used to form Observatory objects.
3. The Observatory objects are added to the list of observatories in the Monitoring class. 
4. The recorded instances of Galamsey events are read from the galamsey.txt file and the information obtained used to create Galamsey objects. 
5. Based on the observatory that recorded the information, the Galamsey objects are added to the list of  observed Galamsey events for various observatory classes. 


The program then interacts with the user, taking input where necessary and adding that data to the Monitoring object appropriately. 

When the program is exited using option 4, the following sequence is followed;

1. The Observatories are read from the Observatory list in the Monitoring object and written to the observatories.txt file in the format specified above.
2. For every observatory in the Monitoring object, the recorded galamsey events are saved into the galamsey.txt file in the format specified above. 



# Running the program. 

To run the version 1 of this project, the following steps should be followed. 

1. Clone the repository into a desired directory
2. Navigate to the ProjectTitan/src/galamsey directory
3. In the above directory, run the following command in the specified order
4. >javac Position.java Galamsey.java Observatory.java Monitoring.java MonitoringIO.java
5. Navigate upwards to the directory ProjectTitan/src
6. Run the following command;
7. > java galamsey.MonitoringIO

NB. jdk8 has been used for development throughout this project. 
