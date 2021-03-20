
public class YoungTraveller extends Traveller {

	private double p = 0.8;
	private int maxdist = 15317; // Distance from Athens to Sydney
	
	public YoungTraveller(int[] termsVectorRepresentations, int[] geodesicVectorRepresentations) {
		super(termsVectorRepresentations, geodesicVectorRepresentations);
		// TODO Auto-generated constructor stub
	}

	private double similarity_terms_vector(City x) {
		int sum = 0;
		int[] user = getTermsVectorRepresentations();
		int[] city = x.getCityTermsVector();
		for(int i = 0; i < 10; i++) {
			sum += (user[i] - city[i])^2;
		}
		return 1 / (1 + Math.sqrt(sum));
	}
	
	private int similarity_geodesic_vector() {
		return 0;
	}
	
	public double calculateSimilarity(City x) {
		return p * similarity_terms_vector(x) + (1-p) * similarity_geodesic_vector();
	}

}
