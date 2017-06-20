package aufgabe10.vorlesung;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.Path;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/counterInit")
public class CounterInit01 extends Counter {

	private static final String COUNTER_FILE = "/.../foo";
	private CounterAdminInterface counterAdmin01 = CounterAdminImplFile.getInstance(COUNTER_FILE);

	/** Getter to access the CounterAdmin */
	protected CounterAdminInterface getCounterAdmin() {
		return counterAdmin01;
	}

	@PostConstruct
	public void init() {
		int n = 0;
		try {
			n = getCounterAdmin().restoreCounter();
		} catch (CounterAdminException e) {
		} finally {
			setCounter(n);
		}
	}

	@PreDestroy
	public void destroy() {
		try {
			getCounterAdmin().saveCounter(getCounter());
		} catch (CounterAdminException e) {
		}
	}
}