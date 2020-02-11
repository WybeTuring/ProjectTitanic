/**
 * Creation of Observatory class
 * @version: 1.0.1
 * @author: Kweku Andoh Yamoah(71712022)
 */

import java.util.ArrayList;
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
    Galamsey[] listGalamObserv = new ArrayList[2000000000];

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

    public String getNameofObservatory() {
        return nameofObservatory;
    }

    public Observatory setNameofObservatory(String nameofObservatory) {
        this.nameofObservatory = nameofObservatory;
        return this;
    }

    public String getNameofCountryObserv() {
        return nameofCountryObserv;
    }

    public Observatory setNameofCountryObserv(String nameofCountryObserv) {
        this.nameofCountryObserv = nameofCountryObserv;
        return this;
    }

    public String getYearSiteGalam() {
        return yearSiteGalam;
    }

    public Observatory setYearSiteGalam(String yearSiteGalam) {
        this.yearSiteGalam = yearSiteGalam;
        return this;
    }

    public Galamsey[] getListGalamObserv() {
        return listGalamObserv;
    }

    public Observatory setListGalamObserv(Galamsey[] listGalamObserv) {
        this.listGalamObserv = listGalamObserv;
        return this;
    }


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

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "Observatory{" +
                "nameofObservatory='" + nameofObservatory + '\'' +
                ", nameofCountryObserv='" + nameofCountryObserv + '\'' +
                ", yearSiteGalam='" + yearSiteGalam + '\'' +
                ", listGalamObserv=" + Arrays.toString (listGalamObserv) +
                '}';
    }

    public int  largeGalamValRecorded(){

    }
}
