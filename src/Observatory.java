/**
 * Creation of Observatory class
 * @version: 1.0.1
 * @author: Kweku Andoh Yamoah(71712022)
 */

import java.util.Arrays;

/**
 * Observatory class with fields, methods and constructor to store and retrieve
 * the name of the observatory, the name of the country in which it is located, the year in which
 * “galamsey” observations started, the area covered by the observatory (in square kilometers) and a list of
 * “galamsey” events that it has recorded.
 *
 * It also returns;
 * The largest “galamsey” colour value recorded by the observatory.
 * The average “galamsey” colour value recorded at the observatory.
 * A list of all “galamsey” recorded at the observatory with a colour value greater than a
 * given/arbitrary number.
 */
public class Observatory {
    String nameofObservatory, nameofCountryObserv, yearSiteGalam;
    Galamsey[] listGalamObserv = new Galamsey[2000000000]; //The system will run out of ram before this size is reached

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
    public Observatory(String nameofObservatory, String nameofCountryObserv, String yearSiteGalam, Galamsey[] listGalamObserv) {
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
    public Galamsey[] getListGalamObserv() {
        return listGalamObserv;
    }

    /**
     *
     * @param listGalamObserv
     * @return
     */
    public Observatory setListGalamObserv(Galamsey[] listGalamObserv) {
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
                nameofCountryObserv.equals (that.nameofCountryObserv) &&
                yearSiteGalam.equals (that.yearSiteGalam) &&
                Arrays.equals (listGalamObserv, that.listGalamObserv);
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
                ", listGalamObserv=" + Arrays.toString (listGalamObserv) +
                '}';
    }

    /**
     *Helper method
     * @param value
     * @return
     */
    private int returnCount(int value){
        int count = 0;
        for(int i = 0; i < listGalamObserv.length-1; i++){
            if(listGalamObserv[i].getColourValue () == value){ count ++ ;}
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
     *Returns the largest
     * @return
     */
    public int largestGalamValueRec(){
        return Math.max (countofGalamGreen (),Math.max (this.countofGalamYellow (),this.countofGalamBrown ()));
    }
}
