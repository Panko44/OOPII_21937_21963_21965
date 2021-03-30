import java.util.ArrayList;

public class Ticket {

	public double freeTicket(City bestCity,ArrayList<Traveller> user) {
		double max = 0;
		double tmp;
		for(Traveller pr1: user) {
			if( (tmp = pr1.calculateSimilarity(bestCity) )>= max) {
				max = tmp;
			}
		}
		return max;
	}
	
}