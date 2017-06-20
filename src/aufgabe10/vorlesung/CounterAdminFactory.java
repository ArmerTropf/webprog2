package aufgabe10.vorlesung;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CounterAdminFactory {
	/* Class name injected by Context Listener */
	private static String className = null;

	public static void setClassName(String str) {
		className = str;
	}

	/* Parameter injected by Context Listener */
	private static String parameter = null;

	public static void setParameter(String str) {
		parameter = str;
	}

	/** Factory method to get an instance */
	public static final CounterAdminInterface getInstance() {
		CounterAdminInterface inst = null;
		try {
			Class<CounterAdminInterface> cl = (Class<CounterAdminInterface>) Class.forName(className);
			Method getInstance = cl.getMethod("getInstance", parameter.getClass());
			inst = (CounterAdminInterface) getInstance.invoke(cl, parameter);
		} catch (ClassNotFoundException | ClassCastException | IllegalAccessException | NoSuchMethodException
				| InvocationTargetException e) {
			// gogogo
		}
		return inst;
	}
}