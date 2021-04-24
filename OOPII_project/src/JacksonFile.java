import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonFile {
	
	 public void writeJSON(ArrayList<Traveller> inTravellerList) throws JsonGenerationException, JsonMappingException, IOException{
	      ObjectMapper mapper = new ObjectMapper();	
	      mapper.writeValue(new File("travellerList.json"), inTravellerList);
	 }

	 //@SuppressWarnings("unchecked")
	 public ArrayList<Traveller> readJSON() throws JsonParseException, JsonMappingException, IOException{
		 
		 ObjectMapper mapper = new ObjectMapper();
		 ArrayList<Traveller> outTravellerList = mapper.readValue(new File("travellerList.json"), mapper.getTypeFactory().constructCollectionType(List.class, Traveller.class));
		 return outTravellerList;
	 }
}
