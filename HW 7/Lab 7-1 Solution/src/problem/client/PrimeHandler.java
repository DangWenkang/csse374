package problem.client;

import problem.framework.IHandler;
import problem.model.IData;

public class PrimeHandler implements IHandler {

	public PrimeHandler() {}

	@Override
	public boolean canHandle(IData d) {
		int num = d.getId();
		if (num % 2 == 0) return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) return false;
		return true;
	}

	@Override
	public void handle(IData d) {
		System.out.format("[%d] %s%n", d.getId(), d.getContent());
	}
}
