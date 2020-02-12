import java.util.*;
/**
 * 
 * @author Percy George Brown
 *
 */
public class MonitoringIO {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Menu();		
		System.out.println("Enter menu choice now: ");
		int menu_choice = input.nextInt();
		while(menu_choice >=1 && menu_choice <=3) {
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
	 * 
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
	 * 
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
	 * 
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
	 * 
	 */
	public static void Exit() {
		System.exit(0);
	}
	
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
	
		
			
			
			
	
			
	
	

		
	
}
