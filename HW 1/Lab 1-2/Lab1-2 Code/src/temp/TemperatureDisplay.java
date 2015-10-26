package temp;

public class TemperatureDisplay implements ISubscriber {

	@Override
	public void handleDataChange(IWeatherData d) {
		System.out.format("Temperature: %.2f\n", d.getTemperature());
	}

}
