
public class YoungTraveller extends Traveller {

	private double p = 0.8;
	private int maxdist = 15317; // Distance from Athens to Sydney
	
	public YoungTraveller(int[] termsVectorRepresentations, double[] geodesicVectorRepresentations) {
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
	
	private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}
	
	private double  similarity_geodesic_vector(double[] travellerGeodesicVector,double[] cityGeodesicVector) {
		log2(2 /2-(distance(travellerGeodesicVector[0],travellerGeodesicVector[1],cityGeodesicVector[0],cityGeodesicVector[1],"k")/maxdist));
		return 0;
				
	}
	public static double log2(double N) {
		double result = (Math.log(N) / Math.log(2));
		return result;
	}
	
	
	public double calculateSimilarity(City x) {
		return p * similarity_terms_vector(x) + (1-p) * similarity_geodesic_vector(getGeodesicVectorRepresentations(),x.getCityGeodesicVector());
	}

}
