package aufgabe10.vorlesung;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CounterAdminImplFile implements CounterAdminInterface {

	private final File file;

	/** Factory method */
	public static CounterAdminImplFile getInstance(String fileName) throws CounterAdminException {
		return new CounterAdminImplFile(fileName);
	}

	/** None public constructor for this class */
	protected CounterAdminImplFile(String fileName) throws CounterAdminException {
		try {
			this.file = new File(fileName);
			if (!file.exists()) {
				throw new CounterAdminException("Counter file does not exist");
			}
		} catch (Exception e) {
			throw new CounterAdminException(e.getMessage());
		}
	}

	@Override
	public int restoreCounter() throws CounterAdminException {
		try {
			return new Scanner(file).nextInt();
		} catch (Exception e) {
			// throw ...
		}
		return 0;
	}

	@Override
	public void saveCounter(int counter) throws CounterAdminException {
		try {
			PrintWriter out = new PrintWriter(file);
			out.println(counter);
			out.close();
		} catch (Exception e) { 
			// throw ...
		}
	}

}
