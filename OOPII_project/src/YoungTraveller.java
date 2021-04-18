import java.lang.Math;

public class YoungTraveller extends Traveller {

	private double p = 0.80;
	private int maxDist = 15317; // Distance from Athens to Sydney
	
	//constructor
	public YoungTraveller(String name, int age, long timestamp, int[] travellerTermsVector, double[] travellerGeodesicVector) {
		super(name, age, timestamp, travellerTermsVector, travellerGeodesicVector);
	}

	//calculates traveller & city terms vectors similarity
	private double similarityTermsVector(City x) {
		double sum = 0;
		int[] user = getTravellerTermsVector();
		int[] city = x.getCityTermsVector();
		for(int i = 0; i < 10; i++) {
			sum += Math.pow((user[i] - city[i]), 2);
		}
		return 1 / (1 + Math.sqrt(sum));
	}
	
	//calculates traveller & city geodesic vectors similarity
	private double similarityGeodesicVector(double[] travellerGeodesicVector,double[] cityGeodesicVector) {
		return log2(2 / 2-(distance(travellerGeodesicVector[0],travellerGeodesicVector[1],cityGeodesicVector[0],cityGeodesicVector[1],"K") / maxDist));
				
	}
	
	//calculates the log base 2 of a number
	private static double log2(double N) {
		double result = (Math.log(N) / Math.log(2));
		return result;
	}
	
	@Override
	public double calculateSimilarity(City city) {
		double similarity = p * similarityTermsVector(city) + (1-p) * similarityGeodesicVector(getTravellerGeodesicVector(), city.getCityGeodesicVector());
		city.setSimilarity(similarity);
		return similarity;
	}

}