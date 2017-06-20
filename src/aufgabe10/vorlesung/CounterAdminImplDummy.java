package aufgabe10.vorlesung;

public class CounterAdminImplDummy implements CounterAdminInterface {
	public static CounterAdminImplDummy getInstance() {
		return getInstance(null);
	}

	public static CounterAdminImplDummy getInstance(String parameter) {
		return new CounterAdminImplDummy();
	}

	@Override
	public int restoreCounter() throws CounterAdminException {
		return 41;
	}

	@Override
	public void saveCounter(int counter) throws CounterAdminException {
	}
}
