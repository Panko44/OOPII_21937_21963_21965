
public class ElderTraveller extends Traveller {

	private double p = 0.20;
	private int maxDist = 15317; // Distance from Athens to Sydney
	
	//constructor
	public ElderTraveller(int[] travellerTermsVector, double[] travellerGeodesicVector) {
		super(travellerTermsVector, travellerGeodesicVector);
		// TODO Auto-generated constructor stub
	}

	//calculates traveller & city terms vectors similarity
	private double similarityTermsVector(int[] travellerTermsVector, int[] cityTermsVector) {
		double sumIntersection = 0;
		double sumUnion = 0;
		for(int i = 0; i < travellerTermsVector.length; i++) {
			if(travellerTermsVector[i] >= 1 && cityTermsVector[i] >= 1) {
				sumIntersection += 1;
			}
			if(travellerTermsVector[i] >= 1 || cityTermsVector[i] >= 1) {
				sumUnion += 1;
			}
		}
		
		if(sumUnion == 0) {
			return 0;
		}
		
		return sumIntersection / sumUnion;
	}
	
	//calculates traveller & city geodesic vectors similarity
	private double similarityGeodesicVector(double[] travellerGeodesicVector,double[] cityGeodesicVector) {
		log2(2 / 2-(distance(travellerGeodesicVector[0],travellerGeodesicVector[1],cityGeodesicVector[0],cityGeodesicVector[1],"k") / maxDist));
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