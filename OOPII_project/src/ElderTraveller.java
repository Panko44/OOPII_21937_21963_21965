
public class ElderTraveller extends Traveller {

	private double p = 0.2;
	
	public ElderTraveller(int[] termsVectorRepresentations, int[] geodesicVectorRepresentations) {
		super(termsVectorRepresentations, geodesicVectorRepresentations);
		// TODO Auto-generated constructor stub
	}

	private int similarity_terms_vector() {
		
	}
	
	private int similarity_geodesic_vector() {
		
	}
	
	@Override
	public int calculateSimilarity(City x) {
		return p * similarity_terms_vector() + (1-p) * similarity_geodesic_vector();
	}

}
