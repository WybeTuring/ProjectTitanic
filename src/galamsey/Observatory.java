package galamsey;
/**
 * Creation of Observatory class
 * @version: 1.0.1
 * @author: Kweku Andoh Yamoah(71712022)
 */

import java.util.ArrayList;
import java.util.Comparator;


import com.sun.istack.internal.NotNull;

/**
 * Observatory class with fields, methods and constructor to store and retrieve
 * the name of the observatory, the name of the country in which it is located, the year in which
 * galamsey observations started, the area covered by the observatory (in square kilometers) and a list of
 * galamsey events that it has recorded.
 *
 * It also returns;
 * The largest galamsey colour value recorded by the observatory.
 * The average galamsey colour value recorded at the observatory.
 * A list of all galamsey recorded at the observatory with a colour value greater than a
 * given/arbitrary number.
 */
public class Observatory {
    private String nameofObservatory;
    private String countryName;
    private int startingYear;
    private double areaCovered;
    ArrayList<Galamsey> listGalamObserv = new ArrayList<> ();

    /**
     * Default Constructor
     */
    public Observatory() {
    }

    /**
     * Overloaded Constructor
     * @param nameofObservatory, String
     * @param countryName, String
     * @param yearSiteGalam, String
     * @param listGalamObserv, Galamsey[]
     */
    public Observatory(String nameofObservatory, String countryName, int yearSiteGalam, double area, ArrayList<Galamsey> listGalamObserv) {
        this.nameofObservatory = nameofObservatory;
        this.countryName = countryName;
        this.startingYear = yearSiteGalam;
        this.areaCovered = area;
        this.listGalamObserv = listGalamObserv;
    }

    public Observatory(String nameofObservatory, String countryName, int yearSiteGalam, double area) {
        this.nameofObservatory = nameofObservatory;
        this.countryName = countryName;
        this.startingYear = yearSiteGalam;
        this.areaCovered = area;
    }
    
    public Observatory(String nameofObservatory) {
    	this.nameofObservatory = nameofObservatory;
        this.countryName = "LOREM IPSUM";
        this.startingYear = 1791;
        this.areaCovered = 0.0;
    }
    
    /**
	 * @return the nameofObservatory
	 */
	public String getNameofObservatory() {
		return nameofObservatory;
	}

	/**
	 * @param nameofObservatory the nameofObservatory to set
	 */
	public void setNameofObservatory(String nameofObservatory) {
		this.nameofObservatory = nameofObservatory;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the startingYear
	 */
	public int getStartingYear() {
		return startingYear;
	}

	/**
	 * @param startingYear the startingYear to set
	 */
	public void setStartingYear(int startingYear) {
		this.startingYear = startingYear;
	}

	/**
	 * @return the areaCovered
	 */
	public double getAreaCovered() {
		return areaCovered;
	}

	/**
	 * @param areaCovered the areaCovered to set
	 */
	public void setAreaCovered(double areaCovered) {
		this.areaCovered = areaCovered;
	}

	/**
	 * @return the listGalamObserv
	 */
	public ArrayList<Galamsey> getListGalamObserv() {
		return listGalamObserv;
	}

	/**
	 * @param listGalamObserv the listGalamObserv to set
	 */
	public void setListGalamObserv(ArrayList<Galamsey> listGalamObserv) {
		this.listGalamObserv = listGalamObserv;
	}

	/**
     *
     * @param o
     * @return
     */
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(areaCovered);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((listGalamObserv == null) ? 0 : listGalamObserv.hashCode());
		result = prime * result + ((nameofObservatory == null) ? 0 : nameofObservatory.hashCode());
		result = prime * result + startingYear;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Observatory other = (Observatory) obj;
		if (Double.doubleToLongBits(areaCovered) != Double.doubleToLongBits(other.areaCovered))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (listGalamObserv == null) {
			if (other.listGalamObserv != null)
				return false;
		} else if (!listGalamObserv.equals(other.listGalamObserv))
			return false;
		if (nameofObservatory == null) {
			if (other.nameofObservatory != null)
				return false;
		} else if (!nameofObservatory.equals(other.nameofObservatory))
			return false;
		if (startingYear != other.startingYear)
			return false;
		return true;
	}
   
    
    @Override
    public String toString() {
        return "Observatory{" +
                "nameofObservatory='" + nameofObservatory + '\'' +
                ", countryName='" + countryName + '\'' +
                ", yearSiteGalam='" + startingYear + '\'' +
                ", listGalamObserv=" + listGalamObserv +
                '}';
    }
    

	/**
     *Helper method
     * @param value
     * @return
     */
    private int returnCount(int value){
        int count = 0;
        for (Galamsey galamsey : listGalamObserv) {
            if (galamsey.getColourValue () == value) {
                count++;
            }
        }

        return count;
    }

    /**
     *
     * @return
     */
    public int countofGalamGreen(){
        return  returnCount (1);

    }

    /**
     *
     * @return
     */
    public int countofGalamYellow(){
        return  returnCount (2);

    }

    /**
     *
     * @return
     */
    public int countofGalamBrown(){
        return  returnCount (3);
    }

    /**
     * A personal Comparator to return the maximum colour value
     * between two galamsey objects.
     */
    public class MyComparator implements Comparator<Galamsey> {
        public int compare(@NotNull Galamsey o1, @NotNull Galamsey o2){
            return Math.max (o1.getColourValue (),o2.getColourValue ());
        }
    }

    /**
     *Returns the largest
     * @return
     */
    public int largestGalamValueRec(){
        listGalamObserv.sort (new MyComparator ());
        return listGalamObserv.get (0).getColourValue ();
    }

    /**
     * 
     * @return
     */
    public double averageGalamColourValue() {
        double sum = 0;
        int count = 0;
        for (Galamsey galamsey : listGalamObserv) {
            count++;
            sum += galamsey.getColourValue ();
        }
        return  sum / count;
    }

    /**
     * 
     * @param arbitraryNumber
     * @return
     */
    public ArrayList<Galamsey> eventsGreaterThanNo(int arbitraryNumber ) {
        ArrayList<Galamsey> listofEvents = new ArrayList<> ();
        if (arbitraryNumber <= 0) {
            return this.listGalamObserv;
        	} 
        else {
            int i = 0;
            while (i < listofEvents.size()) {
                if (listGalamObserv.get (i).getColourValue () > arbitraryNumber) {
                    listofEvents.add (listGalamObserv.get (i));
                }
                i++;
            }
        }
        return listofEvents;
    }
    
    /**
     * 
     * @param obs
     * @return
     */
    public boolean addGalamseyEvent(Galamsey obs) {
    	
    	if(listGalamObserv != null) {
    	for(Galamsey g:listGalamObserv) {
    		if(g.equals(obs)) {
    			return false;
    		}
    	}
    	this.listGalamObserv.add(obs);
    	return true;
    	}
    	else {
    		listGalamObserv.add(obs);
        	return true;
    	}
    }

}
