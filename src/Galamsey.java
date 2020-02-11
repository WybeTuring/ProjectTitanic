
/**
 * This class stores information about identified cases of galamsey.
 * It uses the Position to define a position in which the Galamsey was identified.
 * @author wybeturing
 *
 */

public class Galamsey {
	private String vegetationColour;
	private int colourValue;
	private Position position;
	private int year;
	
	public Galamsey(String vegcol, int col, Position pos, int year) {
		this.vegetationColour = vegcol;
		this.colourValue = col;
		this.position = pos;
		this.year = year;
	}

	public String getVegetationColour() {
		return vegetationColour;
	}

	public void setVegetationColour(String vegetationColour) {
		this.vegetationColour = vegetationColour;
	}

	public int getColourValue() {
		return colourValue;
	}

	public void setColourValue(int colourValue) {
		this.colourValue = colourValue;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean equals(Galamsey x) {
		return ((this.colourValue == x.getColourValue()) && (this.vegetationColour.equals(x.getVegetationColour()))
				&& (this.position.equals(x.getPosition())) && (this.year == x.getYear()));
	}
	
	public String toString() {
		return ("The Galamsey case specifications are; Vegetation colour: " + this.vegetationColour + "  Colour Value: "
				+ this.colourValue + "  Position|| (Latitude: " + this.position.getLatitude() + "  Longitude: " + this.position.getLongitude()
				+ " In the Year: " + this.year);
	}
	
}
