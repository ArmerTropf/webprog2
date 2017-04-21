package CounterMVC;

public class CounterDataBean {
	private final int value;

	// nicht leerer Konstruktor
	public CounterDataBean(int value) {
		this.value = value;
	}

	// Zugriff auf die Property "value"
	public int getValue() {
		return value;
	}
}
