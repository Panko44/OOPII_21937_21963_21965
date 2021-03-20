
public class MiddleTraveller extends Traveller {

	private double p = 0.5;
	private int maxdist = 15317; // Distance from Athens to Sydney
	
	public MiddleTraveller(int[] termsVectorRepresentations, double[] geodesicVectorRepresentations) {
		super(termsVectorRepresentations, geodesicVectorRepresentations);
		// TODO Auto-generated constructor stub
	}

	private double calculateSimilarityTermsVector(int[] travellerTermsVector, int[] cityTermsVector) {
		double sum = 0;
		double sumA = 0;
		double sumB = 0;
		for(int i = 0; i <= travellerTermsVector.length; i++) {
			sum += travellerTermsVector[i] * cityTermsVector[i];
			sumA += Math.pow(travellerTermsVector[i], 2);
			sumB += Math.pow(cityTermsVector[i], 2);
		}
		
		if(sumA == 0 || sumB == 0) {
			return 0;
		}
		
		return sum / (Math.sqrt(sumA) * Math.sqrt(sumB));
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
	
	@Override
	public double calculateSimilarity(City x) {
		return p * calculateSimilarityTermsVector(getTermsVectorRepresentations(), x.getCityTermsVector()) + (1-p) * similarity_geodesic_vector(getGeodesicVectorRepresentations(),x.getCityGeodesicVector());
	}

}
