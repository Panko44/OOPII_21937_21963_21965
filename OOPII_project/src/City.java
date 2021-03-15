
public class City {

	private int[] termsVector = new int[10];
	private int[] geodesicVector = new int[2];

    //constructor
	public City(int[] termsVector, int[] geodesicVector) {
		this.termsVector = termsVector;
		this.geodesicVector = geodesicVector;
	}

    //setters
	public void setTerms_vector(int[] termsVector) {
		this.terms_vector = terms_vector;
	}

	public void setGeodesicVector(int[] geodesicVector) {
		this.geodesicVector = geodesicVector;
	}

    //getters
	public int[] getGeodesicVector() {
		return geodesicVector;
	}
	
	public int[] getTermsVector() {
		return termsVector;
	}
		
}
