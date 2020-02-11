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
		if(menu_choice == 1) {
			getObservatories();
			System.out.println("Choose another option: ");
			Menu();
		}
		else if(menu_choice == 2){
			getGalamseydetals();
			System.out.println("Choose another option: ");
			Menu();
		}
		else if(menu_choice == 3) {
			//soon
			System.out.println("Choose another option: ");
			Menu();
		}
		else {
			Exit();
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
				+ "Exit");
	
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
		System.out.println("Enter galamsey events recorded: ");
		String galamsey = input.nextLine();
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
	//method for averge color value ....soon
		
			
			
			
	
			
	
	

		
	
}
