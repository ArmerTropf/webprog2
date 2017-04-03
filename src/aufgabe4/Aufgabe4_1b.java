package aufgabe4;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Aufgabe4_1b {

	private HttpServletRequest request;

	public int getGo() {
		return 5;
	}


	public Aufgabe4_1b() {

	}

	public Map<String, String> getHeaderNames() {

		Map<String, String> map = new HashMap<String, String>();

		Enumeration<String> myHeaderNames = request.getHeaderNames() ;

		while (myHeaderNames.hasMoreElements()) {
			String name = (String) myHeaderNames.nextElement();
			String value = request.getHeader(name);
			map.put(name, value);
		}

		return map;

	}
}
