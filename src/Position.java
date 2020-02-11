/**
 * The position class helps to register a position by latitude and longitude
 * @author wybeturing
 * @version Version 1.0
 *
 */
public class Position {
	private double latitude;
	private double longitude;
	
	/**
	 * Constructs a Position object with a latitude and longitude
	 * @param lat The latitude of the position, a double.
	 * @param longit The longitude of the position, a double. 
	 */
	public Position(double lat, double longit) {
		this.latitude = lat;
		this.longitude = longit;
	}

	/**
	 * Gets the latitude attribute
	 * @return The value of the position latitude, a double. 
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude value to a given value
	 * @param latitude The latitude which is a double
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude of the position
	 * @return The position's longitude which is a longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude of the position to a desired value.
	 * @param longitude The longitude which is a double.
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * This method compares two positions for equality by checking if their latitudes and longitudes are the same. 
	 * @param x An object of type Position.
	 * @return A boolean that indicates whether or not the two objects are equal. 
	 */
	
	public boolean equals(Position x) {
		return ((this.latitude == x.getLatitude()) && (this.longitude == x.getLongitude()));
	}
	
	/**
	 * This method returns a string that can be printed on the screen to represent a position object.
	 * @return Returns a string that will often be printed to the console. 
	 */
	public String toString() {
		return ("Position is Latitude: " + this.latitude + "  Longitude: " + this.longitude);
	}
	
}
