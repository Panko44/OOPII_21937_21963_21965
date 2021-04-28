import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Random;
import exception.WikipediaNoArcticleException;
import exception.WikipediaNoCityException;

public class App {

	public static void main(String[] args) throws IOException, WikipediaNoArcticleException, WikipediaNoCityException, InterruptedException, SQLException {
		ArrayList<Traveller> travellerList = new ArrayList<Traveller>();
		HashMap<String, City> cityHashMap = new HashMap<String, City>();
		App runApp = new App();

		String appid = "116427f6e7a5e1872aa0d6ac10c3e2d8";

		JacksonFile json = new JacksonFile();

		// travellers
		try {

			travellerList = json.readJSON();

//			runApp.createTravellers(travellerList);
			int[] travellerTermsVector1 = { 0, 5, 7, 3, 1, 0, 9, 10, 4, 7 };
			double[] travellerGeodesicVector1 = { 37.955894, 23.702099 };
			Date date1 = new Date();
			YoungTraveller traveller1 = new YoungTraveller("Aris", 20, date1.getTime(), travellerTermsVector1,
					travellerGeodesicVector1);
			travellerList.add(traveller1);

			int[] travellerTermsVector2 = { 10, 2, 6, 3, 1, 8, 3, 7, 0, 10 };
			double[] travellerGeodesicVector2 = { 40.629269, 22.947412 };
			Date date2 = new Date();
			MiddleTraveller traveller2 = new MiddleTraveller("George", 35, date2.getTime(), travellerTermsVector2,
					travellerGeodesicVector2);
			travellerList.add(traveller2);

			Thread.sleep(1000);

			int[] travellerTermsVector3 = { 9, 8, 4, 6, 3, 2, 1, 10, 5, 7 };
			double[] travellerGeodesicVector3 = { 40.629269, 22.947412 };
			Date date3 = new Date();
			ElderTraveller traveller3 = new ElderTraveller("Michail", 80, date3.getTime(), travellerTermsVector3,
					travellerGeodesicVector3);
			travellerList.add(traveller3);

			Thread.sleep(1003);

			int[] travellerTermsVector4 = { 9, 8, 4, 10, 3, 2, 1, 1, 5, 7 };
			double[] travellerGeodesicVector4 = { 40.629269, 22.947412 };
			Date date4 = new Date();
			ElderTraveller traveller4 = new ElderTraveller("Nikos", 70, date4.getTime(), travellerTermsVector4,
					travellerGeodesicVector4);
			travellerList.add(traveller4);

			Thread.sleep(2000);

			int[] travellerTermsVector5 = { 10, 5, 8, 3, 1, 7, 9, 0, 4, 7 };
			double[] travellerGeodesicVector5 = { 37.955894, 23.702099 };
			Date date5 = new Date();
			YoungTraveller traveller5 = new YoungTraveller("Kostas", 19, date5.getTime(), travellerTermsVector5,
					travellerGeodesicVector5);
			travellerList.add(traveller5);

			Thread.sleep(1002);

			int[] travellerTermsVector6 = { 10, 2, 6, 3, 1, 8, 3, 7, 0, 10 };
			double[] travellerGeodesicVector6 = { 40.629269, 22.947412 };
			Date date6 = new Date();
			MiddleTraveller traveller6 = new MiddleTraveller("George", 40, date6.getTime(), travellerTermsVector6,
					travellerGeodesicVector6);
			travellerList.add(traveller6);

			traveller6.sortTravellers(travellerList);

			json.writeJSON(travellerList);
			
			json.writeJSON(travellerList);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(travellerList.toString());

		// cities
		cityHashMap = runApp.createCities(cityHashMap);
		
		for(Traveller traveller: travellerList) {
			for (String name : cityHashMap.keySet()) {
				String key = name.toString();
				traveller.calculateSimilarity(cityHashMap.get(key));
			}
		}
		
		for (String name : cityHashMap.keySet()) {
			String key = name.toString();
			String value = cityHashMap.get(name).toString();
			System.out.println("Name: " + key + " Data: " + value);
		}
		
//		for(Traveller traveller: ) {
//			
//		}

//		// free ticket
//		Ticket ticket = new Ticket();
//		ticket.freeTicket(city2, travellerList);

	}
	
	public void createTravellers(ArrayList<Traveller> travellerList) throws InterruptedException, JsonGenerationException, JsonMappingException, IOException {
		String[] travellersNamesArray = new String[] { "George", "Nikos", "Petros", "Christos", "Aris", "Panos",
				"Maria", "Dimitra", "Sofia", "Andreas", "Pavlos", "Katerina", "Tasos", "Eleni", "Anna" }; // 15 names
		double maxLatitude = 90.00;
		double minLatitude = -90.00;
		double maxLongitude = 180.00;
		double minLongitude = -180.00;
		int namesArrayPointer = 0;
		for (int i = 20; i < 25; i++) {
			int[] tmpTermsVector = new int[10];
			double[] tmpGeodesicVector = new double[2];
			YoungTraveller traveller = new YoungTraveller();
			traveller.setAge(i - 5);
			traveller.setName(travellersNamesArray[namesArrayPointer]);
			Date date = new Date();
			traveller.setTimestamp(date.getTime());
			for (int k = 0; k < 10; k++) {
				Random rand = new Random();
				tmpTermsVector[k] = rand.nextInt(11);
			}
			traveller.setTravellerTermsVector(tmpTermsVector);
			tmpGeodesicVector[0] = Math.random() * (maxLatitude - minLatitude) + minLatitude;
			tmpGeodesicVector[1] = Math.random() * (maxLongitude - minLongitude) + minLongitude;
			traveller.setTravellerGeodesicVector(tmpGeodesicVector);
			travellerList.add(traveller);
			Thread.sleep(i);

			int[] tmpTermsVector2 = new int[10];
			double[] tmpGeodesicVector2 = new double[2];
			MiddleTraveller traveller2 = new MiddleTraveller();
			traveller2.setAge(i + 20);
			traveller2.setName(travellersNamesArray[namesArrayPointer + 1]);
			Date date2 = new Date();
			traveller2.setTimestamp(date2.getTime());
			for (int k = 0; k < 10; k++) {
				Random rand = new Random();
				tmpTermsVector2[k] = rand.nextInt(11);
			}
			traveller2.setTravellerTermsVector(tmpTermsVector2);
			tmpGeodesicVector2[0] = Math.random() * (maxLatitude - minLatitude) + minLatitude;
			tmpGeodesicVector2[1] = Math.random() * (maxLongitude - minLongitude) + minLongitude;
			traveller2.setTravellerGeodesicVector(tmpGeodesicVector2);
			travellerList.add(traveller2);
			Thread.sleep(i);

			int[] tmpTermsVector3 = new int[10];
			double[] tmpGeodesicVector3 = new double[2];
			ElderTraveller traveller3 = new ElderTraveller();
			traveller3.setAge(i + 40);
			traveller3.setName(travellersNamesArray[namesArrayPointer + 2]);
			Date date3 = new Date();
			traveller3.setTimestamp(date3.getTime());
			for (int k = 0; k < 10; k++) {
				Random rand = new Random();
				tmpTermsVector3[k] = rand.nextInt(11);
			}
			traveller3.setTravellerTermsVector(tmpTermsVector3);
			tmpGeodesicVector3[0] = Math.random() * (maxLatitude - minLatitude) + minLatitude;
			tmpGeodesicVector3[1] = Math.random() * (maxLongitude - minLongitude) + minLongitude;
			traveller3.setTravellerGeodesicVector(tmpGeodesicVector3);
			travellerList.add(traveller3);
			Thread.sleep(i);

			namesArrayPointer += 3;
		}

		// Same traveller enters 2nd time
		int[] tmpTermsVector4 = new int[10];
		double[] tmpGeodesicVector4 = new double[2];
		MiddleTraveller traveller4 = new MiddleTraveller();
		traveller4.setName("Nikos");
		traveller4.setAge(40);
		Date date4 = new Date();
		traveller4.setTimestamp(date4.getTime());
		for (int k = 0; k < 10; k++) {
			Random rand = new Random();
			tmpTermsVector4[k] = rand.nextInt(11);
		}
		traveller4.setTravellerTermsVector(tmpTermsVector4);
		tmpGeodesicVector4[0] = Math.random() * (maxLatitude - minLatitude) + minLatitude;
		tmpGeodesicVector4[1] = Math.random() * (maxLongitude - minLongitude) + minLongitude;
		traveller4.setTravellerGeodesicVector(tmpGeodesicVector4);
		travellerList.add(traveller4);

	}
	
	public HashMap<String, City> createCities(HashMap<String, City> cityHashMap) throws SQLException, JsonParseException, JsonMappingException, IOException, WikipediaNoCityException {
		// oracleDB connection
		OracleDBService dbObject = new OracleDBService();
		dbObject.makeJDBCConnection();
		
		cityHashMap = dbObject.ReadData();
		
//		for (String name : cityHashMap.keySet()) {
//			String key = name.toString();
//			String value = cityHashMap.get(name).toString();
//			System.out.println("1. Name: " + key + " Data: " + value);
//		}
		
		String[] citiesNamesArray = new String[] {"Paris", "London", "Athens", "Moscow", "Corfu", "Berlin", "Naples"};
		String[] countryNamesArray = new String[] {"fr", "uk", "gr", "ru", "gr", "de", "it"};
		String appid = "116427f6e7a5e1872aa0d6ac10c3e2d8";
		for(int i = 0; i < citiesNamesArray.length; i++) {
			try {
				City city = new City();
				if (city.searchCity(citiesNamesArray[i], cityHashMap) == false) {
					city.setCityValues(citiesNamesArray[i], countryNamesArray[i], appid);
					cityHashMap.put(city.getName(), city);
					dbObject.addDataToDB(city.getName(), city.getCityTermsVector(), city.getCityGeodesicVector());
				}

			} catch (WikipediaNoArcticleException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return cityHashMap;
	}

}
