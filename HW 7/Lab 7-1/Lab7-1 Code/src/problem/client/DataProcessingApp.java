package problem.client;

import problem.framework.DataGenerator;
import problem.framework.IHandler;

public class DataProcessingApp {

	public static void main(String[] args) {
		IHandler handler = new PrimeHandler();
		DataGenerator generator = new DataGenerator(1, 20, handler);
		generator.process();
	}
}
