
public class City implements Comparable<City> {

	private int[] cityTermsVector = new int[10];
	private double[] cityGeodesicVector = new double[2];
	private double similarity;

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
	
	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}

    //getters
	public int[] getCityTermsVector() {
		return cityTermsVector;
	}
	
	public double[] getCityGeodesicVector() {
		return cityGeodesicVector;
	}
	
    public double getSimilarity() {
		return similarity;
	}

	@Override
	public int compareTo(City arg0) {
		if(this.similarity > arg0.similarity) {
			return -1;
		} else if(this.similarity < arg0.similarity) {
			return 1;
		} else {
			return 0;
		}
	}
    
}