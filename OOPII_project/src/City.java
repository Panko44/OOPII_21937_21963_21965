
public class City {

	private int[] cityTermsVector = new int[10];
	private int[] cityGeodesicVector = new int[2];

    //constructor
	public City(int[] cityTermsVector, int[] cityGeodesicVector) {
		this.cityTermsVector = cityTermsVector;
		this.cityGeodesicVector = cityGeodesicVector;
	}

    //setters
	public void setCityTermsVector(int[] cityTermsVector) {
		this.cityTermsVector = cityTermsVector;
	}

	public void setCityGeodesicVector(int[] cityGeodesicVector) {
		this.cityGeodesicVector = cityGeodesicVector;
	}

    //getters
	public int[] getCityTermsVector() {
		return cityTermsVector;
	}
	
	public int[] getCityGeodesicVector() {
		return cityGeodesicVector;
	}
		
}
