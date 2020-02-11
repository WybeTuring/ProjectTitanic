/**
 * The position class helps to register a position by latitude and longitude
 * @author wybeturing
 *
 */
public class Position {
	private double latitude;
	private double longitude;
	
	/**
	 * Constructs a Position object with a latitude and longitude
	 * @param lat The latitude of the position
	 * @param longit The longitude of the position
	 */
	public Position(double lat, double longit) {
		this.latitude = lat;
		this.longitude = longit;
	}

	/**
	 * 
	 * @return
	 */
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public boolean equals(Position x) {
		return ((this.latitude == x.getLatitude()) && (this.longitude == x.getLongitude()));
	}
	
	public String toString() {
		return ("Position is Latitude: " + this.latitude + "  Longitude: " + this.longitude);
	}
	
}
