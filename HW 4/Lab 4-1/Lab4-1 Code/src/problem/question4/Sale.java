package problem.question4;

import java.util.ArrayList;

public class Sale {

	private ArrayList<SalesLineItem> lineItems;
	
	
	public float getTotal() {
		float t = 0;
		
		for (int i = 0; i < lineItems.size(); i++) {
			t += lineItems.get(i).getSubtotal();
		}
		
		return t;
	}
}
