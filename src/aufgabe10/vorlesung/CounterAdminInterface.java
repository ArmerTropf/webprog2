package aufgabe10.vorlesung;

public interface CounterAdminInterface {
	public int restoreCounter() throws CounterAdminException;

	public void saveCounter(int counter) throws CounterAdminException;
}
