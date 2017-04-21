package CounterMVC;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateBean {
	private final DateFormat df, tf;

	public DateBean() {
		df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.GERMAN);
		tf = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.GERMAN);
	}

	public String getDate() {
		return df.format(new Date());
	}

	public String getTime() {
		return tf.format(new Date());
	}
}
