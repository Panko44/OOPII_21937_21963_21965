import java.util.ArrayList;
import java.util.Arrays;

public abstract class Traveller {

	private int[] travellerTermsVector = new int[10];
	private double[] travellerGeodesicVector = new double[2];
	
	private ArrayList<City> citiesToCompare= new ArrayList<>();
	
	//constructor
	public Traveller(int[] travellerTermsVector, double[] travellerGeodesicVector) {
		this.travellerTermsVector = travellerTermsVector;
		this.travellerGeodesicVector = travellerGeodesicVector;
	}

	//setters
	public void setTravellerTermsVector(int[] travellerTermsVector) {
		this.travellerTermsVector = travellerTermsVector;
	}

	public void setTravellerGeodesicVector(double[] travellerGeodesicVector) {
		this.travellerGeodesicVector = travellerGeodesicVector;
	}

	
	//getters
	public int[] getTravellerTermsVector() {
		return travellerTermsVector;
	}

	public double[] getTravellerGeodesicVector() {
		return travellerGeodesicVector;
	}

	public abstract double calculateSimilarity(City city);

	//calculates the distance between two points(using their latitude & longitude)
	protected static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		} else {
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
	
	public City compareCities(ArrayList<City> citiesToCompare) {
		
		double maxSimilarity = -1;
		City maxSimilarityCity = new City();
		for(City city: citiesToCompare) {
			 if(calculateSimilarity(city) >= maxSimilarity) {
				 maxSimilarity = calculateSimilarity(city);
				 maxSimilarityCity = city;
			 }
		}
		return maxSimilarityCity;
	}
	
	public City compareCities(ArrayList<City> citiesToCompare, int number) {
//		double maxSimilarity = -1;
//		City maxSimilarityCity = new City();
//		for(City city: citiesToCompare) {
//			 if(calculateSimilarity(city) >= maxSimilarity) {
//				 maxSimilarity = calculateSimilarity(city);
//				 maxSimilarityCity = city;
//			 }
//		}
//		return maxSimilarityCity;
	}
	
}