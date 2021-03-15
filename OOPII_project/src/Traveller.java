
public abstract class Traveller {

	private int[] vectorRepresentations = new int[10];
	private int[] geodesicVectorRepresentations = new int[10];
	
	// constructors
	
	public Traveller(int[] vectorRepresentations , int[] geodesicVectorRepresentations) {
		this.geodesicVectorRepresentations = geodesicVectorRepresentations;
		this.vectorRepresentations = vectorRepresentations;
	}
	
	// setters 
	
	public void setVectorRepresentations(int[] vectorRepresentations) {
		this.vectorRepresentations = vectorRepresentations;
	}
	
	public void setGeodesicVectorRepresentations(int[] geodesicVectorRepresentations) {
		geodesicVectorRepresentations = geodesicVectorRepresentations;
	}
	
	// getters 
	
	public int[] getVectorRepresentations() {
		return vectorRepresentations;
	}
	
	public int[] getGeodesicVectorRepresentations() {
		return geodesicVectorRepresentations;
	}
	
	public abstract int calculate_similarity(City x);
	

}
