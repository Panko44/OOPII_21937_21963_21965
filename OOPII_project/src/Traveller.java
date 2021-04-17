import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.text.html.HTMLDocument.Iterator;

public abstract class Traveller implements Comparable<Traveller>  {

	private String name;
	private int age;
	private long timestamp;
	private String visit;
	private int[] travellerTermsVector = new int[10];
	private double[] travellerGeodesicVector = new double[2];
	private ArrayList<City> citiesToCompare = new ArrayList<City>();
	
	//constructor
	public Traveller(String name, int age, long timestamp, int[] travellerTermsVector, double[] travellerGeodesicVector) {
		this.name = name;
		this.age = age;
		this.timestamp = timestamp;
		this.travellerTermsVector = travellerTermsVector;
		this.travellerGeodesicVector = travellerGeodesicVector;
	}

	public Traveller() {
		
	}

	//setters
	
	public void setVisit(String visit) {
		this.visit = visit;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setTravellerTermsVector(int[] travellerTermsVector) {
		this.travellerTermsVector = travellerTermsVector;
	}

	public void setTravellerGeodesicVector(double[] travellerGeodesicVector) {
		this.travellerGeodesicVector = travellerGeodesicVector;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
		
	//getters
	
	public String getVisit() {
		return visit;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public int[] getTravellerTermsVector() {
		return travellerTermsVector;
	}

	public double[] getTravellerGeodesicVector() {
		return travellerGeodesicVector;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
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
	
	public ArrayList<City> compareCities(ArrayList<City> citiesToCompare, int returnNum) {
		
		Collections.sort(citiesToCompare);
		ArrayList<City> comparedCities = new ArrayList<City>(returnNum);
		for(int i = 0; i < returnNum; i++) {
			comparedCities.add(citiesToCompare.get(i));
		}
		return comparedCities;
	}
	
//	public void sortTravellers(ArrayList<Traveller> travellerList) {
//		// Hashtable<String,Traveller> travellerHashtable = new Hashtable<>();
//		Collections.sort(travellerList);
//		
//		Iterator i = (Iterator) travellerList.iterator();
//		
//		for(Traveller traveller: travellerList) {
//			
//			if(i.equals(traveller)) {
//				System.out.println("12");
//			}
//			
//		}
//		
//	}
	
	public void sortTravellers(ArrayList<Traveller> travellerList) {
		Hashtable<String,Traveller> travellerHashtable = new Hashtable<>();
		Collections.reverse(travellerList);
		
		for(Traveller traveller : travellerList) {
			travellerHashtable.put(traveller.getName(), traveller);
		}
		
		for(String name: travellerHashtable.keySet()) {
			String key = name.toString();
			String value = travellerHashtable.get(name).toString();
		    System.out.println(key + " " + value);
		}
	}
	
	public boolean equals(Traveller t) {
	    if(this.getName().equals(t.getName())) {
	    	return true;
	    }
	    return false;
	}
	
	@Override
	public int compareTo(Traveller arg0) {
		if(this.timestamp < arg0.timestamp) {
			return -1;
		} else if(this.timestamp > arg0.timestamp) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Traveller: name=" + getName() + ", age=" + getAge();
	}
	
}