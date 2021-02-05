import java.util.Properties;

public class Configuration {
	public int interval;
	public int duration;
	public int departure;

	public int checkInterval(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("interval");

		if (valueString == null) {
			throw new ConfigurationException("interval");
		}
		int value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("interval > 0");
		}
			return value;
	}

	public int checkDuration(Properties props) throws ConfigurationException {
		String valueString = props.getProperty("duration");

		if (valueString == null) {
			throw new ConfigurationException("duration");
		}
		int value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("duration > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
		return value;
	}

	public int checkDeparture(Properties props) throws ConfigurationException{
		String valueString = props.getProperty("departure");

		if (valueString == null) {
			throw new ConfigurationException("departure offset");
		}
		int value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("departure > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("departure % interval");
		}
		return value;
	}

	public void load(Properties props) throws ConfigurationException{
		interval = checkInterval(props);
		duration = checkDuration(props);
		departure = checkDeparture(props);
	}
}
