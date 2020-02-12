
/**
 * This class stores information about identified cases of galamsey.
 * It uses the Position to define a position in which the Galamsey was identified.
 * @author wybeturing
 * @version 1.0
 *
 */

public class Galamsey {
	private String vegetationColour;
	private int colourValue;
	private Position position;
	private int year;
	
	public Galamsey() {
		
	}
	/**
	 * Creates a Galamsey object. Note that there is only one constructor, as it is extremely important for all information to be available
	 * when creating a Galamsey object. 
	 * @param vegcol Specifies the colour of the vegetation. Can be green, yellow or brown. 
	 * @param col Specifies the colour value of the vegetation, colour values are pre-fixed. 
	 * @param pos Specifies the position at which the galamsey was identified. 
	 * @param year
	 */
	public Galamsey(String vegcol, int col, Position pos, int year) {
		this.vegetationColour = vegcol;
		this.colourValue = col;
		this.position = pos;
		this.year = year;
	}

	/**
	 * Gets the colour of the vegetation
	 * @return A string representing the vegetation colour; can either be green, brown or yellow. 
	 */
	public String getVegetationColour() {
		return vegetationColour;
	}

	/**
	 * Sets the vegetation colour to a desired colour. 
	 * @param vegetationColour The colour of the vegetation. 
	 */
	public void setVegetationColour(String vegetationColour) {
		this.vegetationColour = vegetationColour;
	}

	/**
	 * Gets the colour value of the vegetation; these values are pre-fixed and can either be 1, 2 or 3. 
	 * @return An integer value representing the colour. 
	 */
	public int getColourValue() {
		return colourValue;
	}

	/**
	 * Sets the colour value to a particular value. 
	 * @param colourValue The desired colour value number (1, 2, or 3)
	 */
	public void setColourValue(int colourValue) {
		this.colourValue = colourValue;
	}
	
	/**
	 * Gets the position at which an act of Galamsey was identified. 
	 * @return An object of type Position. 
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Sets the position of the Galamsey observation to a desired position. 
	 * @param position The new position we are setting the identified act to
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Gets the year during which the Galamsey act was observed. 
	 * @return An integer representing the year in which the Galamsey was observed. 
	 */
	public int getYear() {
		return year;
	}

	/**
	 * This sets the year to a new required year. 
	 * @param year The new year in which we want to register the Galamsey object. 
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Tests for equality amongst Galamsey objects. 
	 * @param x The galamsey object with which we want to test for equality. 
	 * @return Returns a boolean indicating whether or not the objects are equal. 
	 */
	public boolean equals(Galamsey x) {
		return ((this.colourValue == x.getColourValue()) && (this.vegetationColour.equals(x.getVegetationColour()))
				&& (this.position.equals(x.getPosition())) && (this.year == x.getYear()));
	}
	
	/**
	 * This method returns a string that can be printed on the screen to represent a Galamsey object.
	 * @return Returns a string that will often be printed to the console. 
	 */
	public String toString() {
		return ("The Galamsey case specifications are; Vegetation colour: " + this.vegetationColour + "  Colour Value: "
				+ this.colourValue + "  Position|| (Latitude: " + this.position.getLatitude() + "  Longitude: " + this.position.getLongitude()
				+ " In the Year: " + this.year);
	}
	
}
