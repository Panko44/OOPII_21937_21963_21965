import java.util.ArrayList;

public class Ticket {

	public Traveller freeTicket(City bestCity,ArrayList<Traveller> user) {
		double max = 0;
		double tmp;
		Traveller t = null;
		for(Traveller pr1: user) {
			if( (tmp = pr1.calculateSimilarity(bestCity) )>= max) {
				max = tmp;
				t = pr1;
				
			}
		}
		return t;
	}
	
}