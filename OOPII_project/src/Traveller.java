
public abstract class Traveller {

	private int[] termsVectorRepresentations = new int[10];
	private int[] geodesicVectorRepresentations = new int[2];
	
	// constructors
	public Traveller(int[] termsVectorRepresentations , int[] geodesicVectorRepresentations) {
		this.termsVectorRepresentations = termsVectorRepresentations;
		this.geodesicVectorRepresentations = geodesicVectorRepresentations;
	}
	
	// setters 	
	public void setTermsVectorRepresentations(int[] termsVectorRepresentations) {
		this.termsVectorRepresentations = termsVectorRepresentations;
	}
	
	public void setGeodesicVectorRepresentations(int[] geodesicVectorRepresentations) {
		this.geodesicVectorRepresentations = geodesicVectorRepresentations;
	}
	
	// getters 	
	public int[] getTermsVectorRepresentations() {
		return termsVectorRepresentations;
	}
	
	public int[] getGeodesicVectorRepresentations() {
		return geodesicVectorRepresentations;
	}
	
	public abstract int calculateSimilarity(City x);

}
