package CounterMVC;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

public class InfoBean {
	protected final Map<String, String> map1 = new TreeMap<>();

	public InfoBean() {

		Enumeration myEnum = System.getProperties().propertyNames();
		while (myEnum.hasMoreElements()) {
			String key = (String) myEnum.nextElement();
			String value = System.getProperty(key);
			map1.put(key, value);
		}
	}

	public Map<String, String> getSystemInfo() {
		return this.map1;
	}

}
