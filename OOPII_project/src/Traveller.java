
public abstract class Traveller {

	private int[] termsVectorRepresentations = new int[10];
	private double[] geodesicVectorRepresentations = new double[2];
	
	// constructors
	public Traveller(int[] termsVectorRepresentations ,double[] geodesicVectorRepresentations) {
		this.termsVectorRepresentations = termsVectorRepresentations;
		this.geodesicVectorRepresentations = geodesicVectorRepresentations;
	}
	
	// setters 	
	public void setTermsVectorRepresentations(int[] termsVectorRepresentations) {
		this.termsVectorRepresentations = termsVectorRepresentations;
	}
	
	public void setGeodesicVectorRepresentations(double[] geodesicVectorRepresentations) {
		this.geodesicVectorRepresentations = geodesicVectorRepresentations;
	}
	
	// getters 	
	public int[] getTermsVectorRepresentations() {
		return termsVectorRepresentations;
	}
	
	public double[] getGeodesicVectorRepresentations() {
		return geodesicVectorRepresentations;
	}
	
	public abstract double calculateSimilarity(City x);

}
