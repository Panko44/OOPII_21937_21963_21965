
public abstract class Traveller {

	private int[] vectorRepresentations = new int[10];
	private int[] GeodesicVectorRepresentations = new int[10];
	
	// constructors
	
	public Traveller(int[] vectorRepresentations , int[] GeodesicVectorRepresentations) {
		this.GeodesicVectorRepresentations = GeodesicVectorRepresentations;
		this.vectorRepresentations = vectorRepresentations;
	}
	
	// setters 
	
	public void setVectorRepresentations(int[] vectorRepresentations) {
		this.vectorRepresentations = vectorRepresentations;
	}
	
	public void setGeodesicVectorRepresentations(int[] geodesicVectorRepresentations) {
		GeodesicVectorRepresentations = geodesicVectorRepresentations;
	}
	
	// getters 
	
	public int[] getVectorRepresentations() {
		return vectorRepresentations;
	}
	
	public int[] getGeodesicVectorRepresentations() {
		return GeodesicVectorRepresentations;
	}
	
	public abstract int calculate_similarity(City x);
	

}
