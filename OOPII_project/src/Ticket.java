import java.util.ArrayList;

public class Ticket {

	public void freeTicket(City bestCity, ArrayList<Traveller> users) {
		double max = 0;
		double tmp = -1;
		Traveller t = null;
		for(Traveller pr1: users) {
			tmp = pr1.calculateSimilarity(bestCity);
			if(tmp >= max) {
				max = tmp;
				t = pr1;
			}
		}
		System.out.println(t);
	}
	
}