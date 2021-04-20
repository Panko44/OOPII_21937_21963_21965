import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {
	 private void writeJSON(Traveller traveller) throws JsonGenerationException, JsonMappingException, IOException{
	      ObjectMapper mapper = new ObjectMapper();	
	      mapper.writeValue(new File("traveller.json"), traveller);
	   }

	   private Traveller readJSON() throws JsonParseException, JsonMappingException, IOException{
	      ObjectMapper mapper = new ObjectMapper();
	      Traveller traveller = mapper.readValue(new File("traveller.json"), Traveller.class);
	      return traveller;
	   }
}
