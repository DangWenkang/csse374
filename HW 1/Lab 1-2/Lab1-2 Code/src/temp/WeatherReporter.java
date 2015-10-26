package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeatherReporter implements IWeatherReporter {
	
	private List<ISubscriber> subscribers;
	private IWeatherData data;
	
	public WeatherReporter() {
		this.subscribers = Collections.synchronizedList(new ArrayList<ISubscriber>());
		this.data = null;
	}
	
	@Override
	public void addSubscriber(ISubscriber s) {
		this.subscribers.add(s);
	}

	@Override
	public void removeSubscriber(ISubscriber s) {
		this.subscribers.remove(s);
	}

	@Override
	public void setData(IWeatherData d) {
		this.data = d;
		this.notifySubscribers();
	}

	@Override
	public IWeatherData getData() {
		return this.data;
	}
	
	protected void notifySubscribers() {
		for(ISubscriber s : this.subscribers) {
			s.handleDataChange(this.data);
		}
	}

}
