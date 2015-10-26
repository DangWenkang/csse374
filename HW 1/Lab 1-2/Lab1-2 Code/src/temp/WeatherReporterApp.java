package temp;

public class WeatherReporterApp {

	public static void main(String[] args) {
		IWeatherReporter reporter = new WeatherReporter();
		
		ISubscriber tDisplay = new TemperatureDisplay();
		ISubscriber pDisplay = new PressureDisplay();
		
		reporter.addSubscriber(tDisplay);
		reporter.addSubscriber(pDisplay);
		
		IWeatherData firstData = new WeatherData(10,10,10);
		reporter.setData(firstData);
		
		IWeatherData secondData = new WeatherData(20,20,20);
		reporter.setData(secondData);
		
		reporter.removeSubscriber(pDisplay);
		
		IWeatherData thirdData = new WeatherData(30,30,30);
		reporter.setData(thirdData);
	}

}
