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
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Menu();		
		System.out.println("Enter menu choice now: ");
		int menu_choice = input.nextInt();
		while(menu_choice >=1 && menu_choice <=4) {
			if(menu_choice == 1) {
				getObservatories();
				System.out.println("Choose another option: ");
				Menu();
				System.out.println("new choice: ");
				menu_choice = input.nextInt();
			}
			else if(menu_choice == 2){
				getGalamseydetals();
				System.out.println("Choose another option: ");
				Menu();
				System.out.println("new choice: ");
				menu_choice = input.nextInt();
			}
			
			else if(menu_choice == 3) {
				Statistics();
			}
			else {
				Exit();
			}
		}
	}
	/**
	 * This method prints the features as menu to the user
	 */
	public static void Menu() {
		System.out.println("Kindly choose from the following options\n"
				+ "Enter 1 to enter observatory data\n"
				+ "Enter 2 to enter 'galamsey' data\n"
				+ "Enter 3 to provide monitory statistics on largest average 'galamsey', largest galamsey ever,\n"
				+ "and all 'galamsey' with color value greater than a given number\n"
				+ "Enter 4 to Exit");
	}
	/**
	 * This method allows the user to enter observatory data
	 */
	public static void getObservatories() {
		System.out.println("Enter observatory details including: name of observatory,country, year,area covered,galamsey events recorded");
		System.out.println("Enter name of observatory: ");
		String name = input.nextLine();
		System.out.println("Enter country: ");
		String country = input.nextLine();
		System.out.println("Enter year: ");
		String year = input.nextLine();
		System.out.println("Enter area covered in square kms: ");
		String area = input.nextLine();
		System.out.println("Now, how many galamsey events are you recording: ");
		int number = input.nextInt();
		String[] galamseyevents = new String[number];
		for(int i = 0; i < number; i++) {
			System.out.println("Enter events: ");
			galamseyevents[i] = input.nextLine();
		}
	}
	/**
	 * This method allows the user to enter galamsey data
	 */
	public static void getGalamseydetals() {
		System.out.println("Enter vegetation colour: ");
		String vegetationcolor = input.nextLine();
		System.out.println("color value: ");
		int color = input.nextInt();
		System.out.println("Enter longitude: ");
		double longitude = input.nextDouble();
		System.out.println("Enter latitude: ");
		double latitude = input.nextDouble();
		System.out.println("Enter year: ");
		String year = input.nextLine();
		
	}
	/**
	 * This method allows the user provides the largest galamsey, largest average glamsey
	 * and allows the user to enter an arbitary number
	 * All galamsey records with colour value greater than the number provided are displayed.
	 */
	public static void Statistics() {
		System.out.println("Largest 'galamsey' recorded: " + new Observatory().largestGalamValueRec());
		//System.out.println("Largest 'average' galamsey recorded: " + )--waiting for Zibah
		System.out.println("Give an arbitary number: ");
		int colourValue = input.nextInt();
		if(colourValue > 0 && colourValue <3) {
			System.out.println("List of galamsey events with colour values greater than " + colourValue + ": ");
			for(int i = 3; i > colourValue; i--) {
				if(new Galamsey().getColourValue() == i) {
					System.out.println(Arrays.toString (new Observatory().getListGalamObserv()));
				}
			}
		}
		
	}
	/**
	 * This method allows the user to exit the program
	 */
	public static void Exit() {
		System.exit(0);
	}
	

}
