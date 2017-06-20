package aufgabe10.vorlesung;

public class CounterInit02 extends CounterInit01 {
	/* Value injected by Context Listener */
	private static String COUNTER_FILE_02 = "null";

	/** Method to set file name from outside */
	public static void setFileName(String fileName) {
		COUNTER_FILE_02 = fileName;
	}

	private CounterAdminInterface counterAdmin02 = CounterAdminImplFile.getInstance(COUNTER_FILE_02);

}
