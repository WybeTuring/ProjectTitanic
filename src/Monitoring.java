import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;

/**
 * this class holds information about all
 * observatories and has methods that returns the average, largest color and list 
 * of all observatories.
 * 
 * @author Hephzibah Emereole
 *
 */
	public class Monitoring {
		ArrayList <Observatory> observatoryList = new ArrayList<Observatory>();
		//ArrayList <Observatory> galamseyList = new ArrayList<Observatory>;
		
		
		/**
		 * default constructor
		 */
		public Monitoring() {
			
		}
		/**
		 * This is an overloaded constructor		
		 * @param Observe
		 */
		public Monitoring(ArrayList<Observatory>  Observe) {
			 this.observatoryList= Observe;
		}
		
		/**
		 * This is a method that identifies the largeAverage color value of the Observatory objects	
		 * @returns the largest average value newObserv
		 */
		
		public Observatory largestAverage() {
			Observatory newObserv = null;
			double averageCol = 0;
			for (int i=0; i< observatoryList.size(); i++) {
				if (averageCol < observatoryList.get(i).averageGalamColourValue()) {
					averageCol = observatoryList.get(i).averageGalamColourValue();
					newObserv = observatoryList.get(i);
				}
			}
			return newObserv;
			}
				
				
	    /**
	     * this method loops through the array list of galamsey values and return the largest color value of 
	     * the galamsey object
	     * @return the largest  color value
	     */
		
	    public int largeColValue() {
			int colVal =0;
			for(Observatory e:observatoryList) {
				for(Galamsey g:e.getListGalamObserv()) {
					if(colVal < g.getColourValue()) {
						colVal = g.getColourValue();
					}
				}
			}
			return colVal;
		}
		
		
		
		/**
		 * This is a method that loops through the list of observatory, galamsey objects and compares 
		 * the color value of each galamsey object with an arbitrary number. It adds the 
		 * @param number, which is an arbitrary
		 * @returns the list of galamsey objects. 
		 */
		
		public ArrayList<Galamsey> getGalamseyObjects (int number){
			ArrayList<Galamsey> allObserv = new ArrayList<Galamsey>();
			for (Observatory e: this.observatoryList) {
				for (Galamsey g: e.getListGalamObserv()) {
					if (g.getColourValue() > number)
						allObserv.add(g);	
					}
				}	
			return allObserv;
			}
		
		
}