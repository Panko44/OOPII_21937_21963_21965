
public class MiddleTraveller extends Traveller {

	private double p = 0.50;
	private int maxDist = 15317; // Distance from Athens to Sydney
	
	//constructor
	public MiddleTraveller(int[] travellerTermsVector, double[] travellerGeodesicVector) {
		super(travellerTermsVector, travellerGeodesicVector);
		// TODO Auto-generated constructor stub
	}

	//calculates traveller & city terms vectors similarity
	private double similarityTermsVector(int[] travellerTermsVector, int[] cityTermsVector) {
		double sum = 0;
		double sumA = 0;
		double sumB = 0;
		for(int i = 0; i < travellerTermsVector.length; i++) {
			sum += travellerTermsVector[i] * cityTermsVector[i];
			sumA += Math.pow(travellerTermsVector[i], 2);
			sumB += Math.pow(cityTermsVector[i], 2);
		}
		
		if(sumA == 0 || sumB == 0) {
			return 0;
		}
		
		return sum / (Math.sqrt(sumA) * Math.sqrt(sumB));
	}
	
	//calculates traveller & city geodesic vectors similarity
	private double  similarityGeodesicVector(double[] travellerGeodesicVector,double[] cityGeodesicVector) {
		log2(2 /2-(distance(travellerGeodesicVector[0],travellerGeodesicVector[1],cityGeodesicVector[0],cityGeodesicVector[1],"K") / maxDist));
		return 0;
				
	}
	
	//calculates the log base 2 of a number
	private static double log2(double N) {
		double result = (Math.log(N) / Math.log(2));
		return result;
	}
	
	@Override
	public double calculateSimilarity(City city) {
		return p * similarityTermsVector(getTravellerTermsVector(), city.getCityTermsVector()) + (1-p) * similarityGeodesicVector(getTravellerGeodesicVector(), city.getCityGeodesicVector());
	}

}
