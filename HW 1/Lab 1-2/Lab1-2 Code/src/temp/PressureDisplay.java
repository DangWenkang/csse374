package temp;

public class PressureDisplay implements ISubscriber {

	@Override
	public void handleDataChange(IWeatherData d) {
		System.out.format("Pressure: %.2f\n", d.getPressure());
	}

}
