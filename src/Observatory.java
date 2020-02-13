/**
 * Creation of Observatory class
 * @version: 1.0.1
 * @author: Kweku Andoh Yamoah(71712022)
 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

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
    String nameofObservatory, nameofCountryObserv, yearSiteGalam;
    ArrayList<Galamsey> listGalamObserv = new ArrayList<> (); //The system will run out of ram before this size is reached

    /**
     * Default Constructor
     */
    public Observatory() {
    }

    /**
     * Overloaded Constructor
     * @param nameofObservatory, String
     * @param nameofCountryObserv, String
     * @param yearSiteGalam, String
     * @param listGalamObserv, Galamsey[]
     */
    public Observatory(String nameofObservatory, String nameofCountryObserv, String yearSiteGalam, ArrayList<Galamsey> listGalamObserv) {
        this.nameofObservatory = nameofObservatory;
        this.nameofCountryObserv = nameofCountryObserv;
        this.yearSiteGalam = yearSiteGalam;
        this.listGalamObserv = listGalamObserv;
    }

    /**
     *
     * @return
     */
    public String getNameofObservatory() {
        return nameofObservatory;
    }

    /**
     *
     * @param nameofObservatory
     * @return
     */
    public Observatory setNameofObservatory(String nameofObservatory) {
        this.nameofObservatory = nameofObservatory;
        return this;
    }

    /**
     *
     * @return
     */
    public String getNameofCountryObserv() {
        return nameofCountryObserv;
    }

    /**
     *
     * @param nameofCountryObserv
     * @return
     */
    public Observatory setNameofCountryObserv(String nameofCountryObserv) {
        this.nameofCountryObserv = nameofCountryObserv;
        return this;
    }

    /**
     *
     * @return
     */
    public String getYearSiteGalam() {
        return yearSiteGalam;
    }

    /**
     *
     * @param yearSiteGalam
     * @return
     */
    public Observatory setYearSiteGalam(String yearSiteGalam) {
        this.yearSiteGalam = yearSiteGalam;
        return this;
    }

    /**
     *
     * @return
     */
    public ArrayList<Galamsey> getListGalamObserv() {
        return listGalamObserv;
    }

    /**
     *
     * @param listGalamObserv
     * @return
     */
    public Observatory setListGalamObserv(ArrayList<Galamsey> listGalamObserv) {
        this.listGalamObserv = listGalamObserv;
        return this;
    }
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Observatory)) return false;
        Observatory that = (Observatory) o;
        return nameofObservatory.equals (that.nameofObservatory) &&
                Objects.equals (nameofCountryObserv, that.nameofCountryObserv) &&
                yearSiteGalam.equals (that.yearSiteGalam) &&
                listGalamObserv.equals (that.listGalamObserv);
    }
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Observatory{" +
                "nameofObservatory='" + nameofObservatory + '\'' +
                ", nameofCountryObserv='" + nameofCountryObserv + '\'' +
                ", yearSiteGalam='" + yearSiteGalam + '\'' +
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
     * A personal Comparator to return the minimum colour value
     * between two galamsey objects.
     */
    public class MyComparator implements Comparator<Galamsey> {
        public int compare(@NotNull Galamsey o1, @NotNull Galamsey o2){
            return Math.min (o1.getColourValue (),o2.getColourValue ());
        }
    }

    /**
     *Returns the largest
     * @return
     */
    public int largestGalamValueRec(){
        listGalamObserv.sort (new MyComparator ());
        return listGalamObserv.get (-1).getColourValue ();
    }

    public double averageGalamColourValue() {
        double sum = 0;
        int count = 0;
        for (Galamsey galamsey : listGalamObserv) {
            count++;
            sum += galamsey.getColourValue ();
        }
        return  sum / count;
    }

    public ArrayList<Galamsey> eventsGreaterThanNo(int arbitraryNumber ) {
        ArrayList<Galamsey> listofEvents = new ArrayList<> ();
        if (arbitraryNumber <= 3) {
            System.out.println ("IllegalArgumentException :The colour values currently defined are from 1-3,please enter a number from 0 to" +
                                        " this range.");
            eventsGreaterThanNo (arbitraryNumber);
        } else {
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

}
