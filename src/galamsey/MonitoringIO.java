package galamsey;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
/**
 * This is the main method to test all other classes for the program
 * Presents the user with menu options to choose from
 * After executing one of the features, the user is allowed to enter another option
 * Allows the user to input, via the console, the details of observatories and galamsey
 * @author Percy George Brown
 * version 1.0
 */
public class MonitoringIO {
	

	public static void main(String[] args) throws IOException {
		Monitoring CentralObservatory = new Monitoring();
		MonitoringIO current = new MonitoringIO();
		
		// Reading information from files and initialising CentralObservatory. 
		ArrayList<Observatory> currentObservatories = current.loadObservatories("observatories.txt");
		CentralObservatory.setObservatoryList(currentObservatories);
		ArrayList<String[]> currentGalamseyEvents = current.loadGalamseyEvents("galamsey.txt");
		
		// Adding the Galamsey events to their various observatories
		for(String[] s:currentGalamseyEvents) {
			boolean added = false;
			for(Observatory e:CentralObservatory.getObservatoryList()) {
				if(s[0].trim().toLowerCase().equals(e.getNameofObservatory())) {
					int colourValue = Integer.parseInt(s[1].trim());
					String vegetationColour = s[2].trim();
					Position pos = new Position(Double.parseDouble(s[3].trim()),Double.parseDouble(s[4].trim()));
					int year = Integer.parseInt(s[5].trim());
					Galamsey galamsey = new Galamsey(vegetationColour, colourValue, pos, year);
					e.addGalamseyEvent(galamsey);
					added = true;
					break;
				}	
			}
			if(!added) {
				Observatory tempOb = new Observatory(s[0].trim().toLowerCase());
				int colourValue = Integer.parseInt(s[1].trim());
				String vegetationColour = s[2].trim();
				Position pos = new Position(Double.parseDouble(s[3].trim()),Double.parseDouble(s[4].trim()));
				int year = Integer.parseInt(s[5].trim());
				Galamsey galamsey = new Galamsey(vegetationColour, colourValue, pos, year);
				tempOb.addGalamseyEvent(galamsey);
				CentralObservatory.addNewObservatory(tempOb);
			}
		}
		
		
		// Interacting with the user.
		
		int menu_choice = -50;
		while(menu_choice < 1 || menu_choice > 4) {
			System.out.println("Please only enter integers between one and four.");
			current.Menu();
			Scanner input = new Scanner(System.in);
			menu_choice = Integer.parseInt(input.nextLine());
		}
		while(menu_choice >=1 && menu_choice <=4) {
			Scanner input = new Scanner(System.in);
			if(menu_choice == 1) {
				Observatory newOb = current.obtainObservatoriesData();
				CentralObservatory.addNewObservatory(newOb);
				current.Menu();
				menu_choice = input.nextInt();
			}
			else if(menu_choice == 2){
				String[] s = current.obtainGalamseyData(); // s holds the data required to add the galamsey object.
				boolean added = false;
				for(Observatory e:CentralObservatory.getObservatoryList()) {
					if(s[0].trim().toLowerCase().equals(e.getNameofObservatory().toLowerCase())) {
						int colourValue = Integer.parseInt(s[1].trim());
						String vegetationColour = s[2].trim();
						Position pos = new Position(Double.parseDouble(s[3].trim()),Double.parseDouble(s[4].trim()));
						int year = Integer.parseInt(s[5].trim());
						Galamsey galamsey = new Galamsey(vegetationColour, colourValue, pos, year);
						e.addGalamseyEvent(galamsey);
						added = true;
						break;
					}	
				}
				if(!added) {
					Observatory tempOb = new Observatory(s[0].trim().toLowerCase());
					int colourValue = Integer.parseInt(s[1].trim());
					String vegetationColour = s[2].trim();
					Position pos = new Position(Double.parseDouble(s[3].trim()),Double.parseDouble(s[4].trim()));
					int year = Integer.parseInt(s[5].trim());
					Galamsey galamsey = new Galamsey(vegetationColour, colourValue, pos, year);
					tempOb.addGalamseyEvent(galamsey);
					CentralObservatory.addNewObservatory(tempOb);
				}
				
				current.Menu();
				menu_choice = input.nextInt();
			}
			
			else if(menu_choice == 3) {
				System.out.println("Enter an arbirary number: ");
				double arbitraryValue = input.nextDouble();
				current.Statistics(CentralObservatory,arbitraryValue);
				current.Menu();
				menu_choice = input.nextInt();
			}
			else if (menu_choice == 4){
				// Writing the information to a file when the program is shutting
				current.saveCentralObservatoryData(CentralObservatory, "observatories.txt", "galamsey.txt");
				System.out.println("Thank you Benjamin and Dr Ebo :)");
				System.exit(0);
			}
			;
		}

}
	
	/**
	 * This function helps us to read the information about observatories from the text file and create observatory objects.
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
		
	public ArrayList<Observatory> loadObservatories(String fileName) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(fileName));
    	ArrayList<Observatory> observatoryList = new ArrayList<Observatory>();
    	try {
    		String line;
    		while((line = br.readLine()) != null) {
    			line = line.trim();
	    		String[] tempInfo = line.split(",");
				String observatoryName = tempInfo[0].trim().toLowerCase();
				String countryName = tempInfo[1].trim().toLowerCase();
				int startYear = Integer.parseInt(tempInfo[2].trim());
				double areaCovered = Double.parseDouble(tempInfo[3].trim());
				Observatory tempObservatory = new Observatory(observatoryName, countryName, startYear, areaCovered);
				observatoryList.add(tempObservatory);
    		}
    	} finally {
    		br.close();
    	}
    	
    	return observatoryList;
	}
	
	
	/**
	 * This method reads the galamsey events and returns an arraylist of string arrays holding the information. 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String[]> loadGalamseyEvents(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
    	ArrayList<String[]> galamseyEventList = new ArrayList<String[]>();
    	try {
    		String line;
    		while((line = br.readLine()) != null) {
    			line = line.trim();
	    		String[] tempInfo = line.split(",");
				galamseyEventList.add(tempInfo);
    		}
    	} finally {
    		br.close();
    	}
    	
    	return galamseyEventList;
	}
	
	/**
	 * 
	 * @param centralMonitor
	 * @param observatoryFileName
	 * @param galamseyFileName
	 */
    public void saveCentralObservatoryData(Monitoring centralMonitor, String observatoryFileName, String galamseyFileName) {
	    
    	// Writing the observatory details to the observatory file
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileOutputStream(observatoryFileName));
		}catch(FileNotFoundException fnfe) {
			fnfe.getMessage();
		}
		for(Observatory e:centralMonitor.getObservatoryList()) {
		    printWriter.printf(e.getNameofObservatory().toLowerCase() + "," + e.getCountryName() + "," + e.getStartingYear() + "," + e.getAreaCovered());
		    printWriter.println();
		}  
		printWriter.close();
		
		// Writing the galamsey details to the Galamsey file
		PrintWriter printWriter1 = null;
		
		try {
			printWriter1 = new PrintWriter(new FileOutputStream(galamseyFileName));
		}catch(FileNotFoundException fnfe) {
			fnfe.getMessage();
		}
		for(Observatory e:centralMonitor.getObservatoryList()) {
			for(Galamsey g:e.getListGalamObserv()) {
			    printWriter1.printf(e.getNameofObservatory().toLowerCase() + "," + g.getColourValue() + "," + 
			    					g.getVegetationColour() + "," + g.getPosition().getLatitude() + 
			    					"," + g.getPosition().getLongitude() + "," + g.getYear());
			    printWriter1.println();
			}
		}  
		printWriter1.close();
		
		
	}
	

    /**
	 * This method prints the features as menu to the user
	 */
	public void Menu() {
		System.out.println("\n\nKindly choose from amongst the following options\n"
				+ "Enter 1 to enter observatory data\n"
				+ "Enter 2 to enter 'galamsey' data\n"
				+ "Enter 3 to provide monitory statistics on largest average 'galamsey', largest galamsey ever,\n\t"
				+ "and all 'galamsey' with color value greater than a given number\n"
				+ "Enter 4 to Exit");
	}
	
	/**
	 * This method allows the user to enter observatory data
	 */
	public Observatory obtainObservatoriesData() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter observatory details including: Name of observatory,Country, Year,Area covered");
		System.out.println("Enter name of observatory: ");
		String name = input.nextLine();
		System.out.println("Enter country: ");
		String country = input.nextLine();
		System.out.println("Enter year: ");
		int year = Integer.parseInt(input.nextLine());
		System.out.println("Enter area covered in square kms: ");
		double area = input.nextDouble();
		Observatory details = new Observatory(name, country, year, area);
		;
		return details;
	}
	
	/**
	 * This method allows the user to enter Galamsey data
	 */
	public String[] obtainGalamseyData() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the name of the observatory that identified the galamsey: ");
		String observatoryName = input.nextLine();
		
		System.out.println("Enter vegetation colour: ");
		String vegetationColour = input.nextLine();
		
		System.out.println("Colour value: ");
		int colourValue = input.nextInt();
		
		System.out.println("Enter longitude: ");
		double longitude = input.nextDouble();
		
		System.out.println("Enter latitude: ");
		double latitude = input.nextDouble();
		
		System.out.println("Enter year: ");
		int year = input.nextInt();
		
		String[] toReturn = {observatoryName, String.valueOf(colourValue), vegetationColour, String.valueOf(latitude), String.valueOf(longitude),String.valueOf(year) };
		;
		
		return toReturn;	
		
	}
	
	/**
	 * This method allows the user provides the largest galamsey, largest average glamsey
	 * and allows the user to enter an arbitary number
	 * All galamsey records with colour value greater than the number provided are displayed.
	 */
	public void Statistics(Monitoring centralMonitor, double arbitraryValue) {
		
		
		System.out.println("Largest average 'galamsey' recorded by an observatory: "
								+ centralMonitor.largestAverageObservatory().averageGalamColourValue()
								+ "\nThis value was recorder by " + centralMonitor.largestAverageObservatory().getNameofObservatory());
		
		System.out.println("Largest ever galamsey value recorded: " + centralMonitor.largeColValue());
		
		ArrayList<Galamsey> toReturn = centralMonitor.allGalamseyObjectsGreaterThan(arbitraryValue);
		
		for(Galamsey g:toReturn) {
			System.out.println(g.toString());
		}
		
		
	}
}