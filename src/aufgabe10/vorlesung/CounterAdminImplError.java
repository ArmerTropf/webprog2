package aufgabe10.vorlesung;

public class CounterAdminImplError implements CounterAdminInterface {
	public static CounterAdminImplError getInstance(String parameter) {
		return new CounterAdminImplError();
	}

	@Override
	public int restoreCounter() throws CounterAdminException {
		throw new CounterAdminException("Test restore");
	}

	@Override
	public void saveCounter(int counter) throws CounterAdminException {
		throw new CounterAdminException("Test save");
	}
}
