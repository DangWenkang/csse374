package temp;

public class WeatherData implements IWeatherData {
	
	private double temperature;
	private double humidity;
	private double pressure;

	public WeatherData(double temperature, double humidity, double pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	@Override
	public double getTemperature() {
		return this.temperature;
	}

	@Override
	public double getHumidity() {
		return this.humidity;
	}

	@Override
	public double getPressure() {
		return this.pressure;
	}

}
