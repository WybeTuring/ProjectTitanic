package galamsey;
import java.util.ArrayList;

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
		 * @return the observatoryList
		 */
		public ArrayList<Observatory> getObservatoryList() {
			return observatoryList;
		}
		/**
		 * @param observatoryList the observatoryList to set
		 */
		public void setObservatoryList(ArrayList<Observatory> observatoryList) {
			this.observatoryList = observatoryList;
		}
		/**
		 * This is a method that identifies the largeAverage color value of the Observatory objects	
		 * @returns the largest average value newObserv
		 */
		
		public Observatory largestAverageObservatory() {
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
		
		public ArrayList<Galamsey> allGalamseyObjectsGreaterThan(double number){
			ArrayList<Galamsey> allObserv = new ArrayList<Galamsey>();
			for (Observatory e: this.observatoryList) {
				for (Galamsey g: e.getListGalamObserv()) {
					if (g.getColourValue() > number)
						allObserv.add(g);	
					}
				}	
			return allObserv;
			}
		
		/***
		 * Adds a new observatory to an already existing list of observatories. 
		 * @param newObservatory
		 * @return
		 */
		public boolean addNewObservatory(Observatory newObservatory) {
			for(Observatory o:observatoryList) {
				if(o.equals(newObservatory)) {
					return false;
				}
			}
			observatoryList.add(newObservatory);
			return true;
		}
		
}