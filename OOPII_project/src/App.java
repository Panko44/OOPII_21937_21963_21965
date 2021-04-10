import java.io.IOException;
import java.util.ArrayList;

import exception.WikipediaNoArcticleException;
import exception.WikipediaNoCityException;

public class App {
	
	public static void main(String[] args) throws IOException, WikipediaNoArcticleException, WikipediaNoCityException {
		ArrayList<Traveller> travellerList = new ArrayList<Traveller>();
		ArrayList<City> cityList = new ArrayList<City>();
		
		String appid = "113cbc692911b95ae581a5ae7ab261c6";
		
		try {
		City city1 = new City();
		city1.setCityValues("Adfgdtn", "gr", appid);
		cityList.add(city1);
		} catch(WikipediaNoArcticleException e) {
			System.out.println(e.getMessage());		
		}

		
		City city2 = new City();
		city2.setCityValues("Berlin","de",appid);
		cityList.add(city2);
		
		City city3 = new City();
		city3.setCityValues("Naples","it",appid);
		cityList.add(city3);
		
		int[] travellerTermsVector1 = {0, 5, 7, 3, 1, 0, 9, 10, 4, 7};
		double[] travellerGeodesicVector1 = {37.955894, 23.702099};
		
		YoungTraveller traveller1 = new YoungTraveller("George", 20, travellerTermsVector1, travellerGeodesicVector1);
		travellerList.add(traveller1);
		
		int[] travellerTermsVector2 = {10, 2, 6, 3, 1, 8, 3, 7, 0, 10};
		double[] travellerGeodesicVector2 = {40.629269, 22.947412};
		MiddleTraveller traveller2 = new MiddleTraveller("Maria", 35, travellerTermsVector2, travellerGeodesicVector2);
		travellerList.add(traveller2);
		
		int[] travellerTermsVector3 = {9, 8, 4, 6, 3, 2, 1, 10, 5, 7};
		double[] travellerGeodesicVector3 = {40.629269, 22.947412};
		ElderTraveller traveller3 = new ElderTraveller("Michail", 80, travellerTermsVector2, travellerGeodesicVector2);
		travellerList.add(traveller3);
	
		
		Ticket ticket = new Ticket();
		ticket.freeTicket(city2, travellerList);
	}

}
