package aufgabe4;

import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

public class Aufgabe4_2 {
	protected final Map<String, String> map1 = new TreeMap<>();

	public Aufgabe4_2() {

		Enumeration myEnum = System.getProperties().propertyNames();
		while (myEnum.hasMoreElements()) {
			String key = (String) myEnum.nextElement();
			String value = System.getProperty(key);
			map1.put(key, value);
		}
	}

	public Map<String, String> getMyProperties() {
		return this.map1;
	}

}
