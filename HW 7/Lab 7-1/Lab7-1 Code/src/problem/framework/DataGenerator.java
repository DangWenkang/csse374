package problem.framework;

import problem.model.Data;
import problem.model.IData;

public class DataGenerator {
	private int low;
	private int high;
	private IHandler handler;
	
	public DataGenerator(int low, int high, IHandler handler) {
		this.low = low;
		this.high = high;
		this.handler = handler;
	}
	
	private IData createData(int i) {
		return new Data(i, "Data - " + i);
	}
	
	public void process() {
		for(int i = low; i < high; ++i) {
			IData d = createData(i);
			if(handler.canHandle(d)) {
				this.handler.handle(d);
			}
		}
	}
}
