package CounterMVC;

import java.util.Enumeration;
import java.util.Vector;

public class ListBean {
	
	public int[] getArray() {
		int[] data = { 1, 5, 4, 3, 6567, -34, 5, 88 };
		return data;
	}

	public Enumeration getEnumeration() {
		Vector data = new Vector();
		for (int i = 0; i < 15; i++)
			data.add(new Integer((int) (Math.random() * 100)));
		return data.elements();
	}
}
