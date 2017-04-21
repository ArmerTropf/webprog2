package CounterMVC;

public class CounterBean {
	private int counter = -999;

	public CounterBean() {
		setCounter(0);
	}

	public synchronized int getCounter() {
		return ++counter;

	}

	public synchronized void setCounter(int value) {
		counter = value;
	}
}
