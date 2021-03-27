
public class City {

	private int[] cityTermsVector = new int[10];
	private double[] cityGeodesicVector = new double[2];

    //constructor
	public City(int[] cityTermsVector, double[] cityGeodesicVector) {
		this.cityTermsVector = cityTermsVector;
		this.cityGeodesicVector = cityGeodesicVector;
	}
	
	public City() {
	
	}

    //setters
	public void setCityTermsVector(int[] cityTermsVector) {
		this.cityTermsVector = cityTermsVector;
	}

	public void setCityGeodesicVector(double[] cityGeodesicVector) {
		this.cityGeodesicVector = cityGeodesicVector;
	}

    //getters
	public int[] getCityTermsVector() {
		return cityTermsVector;
	}
	
	public double[] getCityGeodesicVector() {
		return cityGeodesicVector;
	}
	
}