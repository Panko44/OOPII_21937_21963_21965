import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import exception.WikipediaNoArcticleException;
import exception.WikipediaNoCityException;

public class App {
	
	public static void main(String[] args) throws IOException, WikipediaNoArcticleException, WikipediaNoCityException, InterruptedException {
		ArrayList<Traveller> travellerList = new ArrayList<Traveller>();
		HashMap<String,City> cityHashMap = new HashMap<String,City>();
		
		String appid = "116427f6e7a5e1872aa0d6ac10c3e2d8";
		
		int[] travellerTermsVector1 = {0, 5, 7, 3, 1, 0, 9, 10, 4, 7};
		double[] travellerGeodesicVector1 = {37.955894, 23.702099};
		Date date1 = new Date();
		YoungTraveller traveller1 = new YoungTraveller("George", 20, date1.getTime(), travellerTermsVector1, travellerGeodesicVector1);
		travellerList.add(traveller1);
		
		int[] travellerTermsVector2 = {10, 2, 6, 3, 1, 8, 3, 7, 0, 10};
		double[] travellerGeodesicVector2 = {40.629269, 22.947412};
		Date date2 = new Date();
		MiddleTraveller traveller2 = new MiddleTraveller("Maria", 35, date2.getTime(), travellerTermsVector2, travellerGeodesicVector2);
		travellerList.add(traveller2);
		
		
		int[] travellerTermsVector3 = {9, 8, 4, 6, 3, 2, 1, 10, 5, 7};
		double[] travellerGeodesicVector3 = {40.629269, 22.947412};
		Date date3 = new Date();
		ElderTraveller traveller3 = new ElderTraveller("Michail", 80, date3.getTime(), travellerTermsVector3, travellerGeodesicVector3);
		travellerList.add(traveller3);
		
		try {
		City city1 = new City();
		city1.setCityValues("Adfgdtn", "gr", appid);
		cityHashMap.put(city1.getName(),city1);
		} catch(WikipediaNoArcticleException e) {
			System.out.println(e.getMessage());		
		}

		
		City city2 = new City();
		city2.setCityValues("Berlin","de",appid);
		cityHashMap.put("Berlin",city2);
		
		City city3 = new City();
		city3.setCityValues("Naples","it",appid);
		cityHashMap.put("Naples",city3);
		
		for(String name: cityHashMap.keySet()) {
			String key = name.toString();
			String value = cityHashMap.get(name).toString();
		    System.out.println(key + " " + value);
		}
		
		City city4 = new City();
		if(city4.searchCity("Berlin", cityHashMap) == false) {
			city4.setCityValues("Berlin","de",appid);
			cityHashMap.put(city4.getName(),city4);
			System.out.println("1");
		}
		
		
		Ticket ticket = new Ticket();
		ticket.freeTicket(city2, travellerList);
	}

}
