package aufgabe10.vorlesung;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/counter")
public class Counter {
	private int counter = -999;

	protected synchronized int getCounter() {
		return counter;
	}

	protected synchronized void incrCounter() {
		counter++;
	}

	protected synchronized void setCounter(int i) {
		counter = i;
	}

	protected synchronized int resetCounter() {
		int tmp = getCounter();
		setCounter(0);
		return tmp;
	}

	@GET
	@Path("/read")
	@Produces("text/plain")
	public String doRead() {
		incrCounter();
		return String.format("%d\n", getCounter());
	}

	@GET
	@Path("/reset")
	@Produces("text/plain")
	public String doReset() {
		final int tmp = resetCounter();
		return String.format("%d\n", tmp);
	}

	@GET
	@Path("/set/{zahl}")
	@Produces("text/plain")
	public String doSet(@PathParam("zahl") Integer zahl) {
		if (zahl >= 0) {
			setCounter(zahl);
		}
		return String.format("%d\n", getCounter());
	}

	@PostConstruct
	public void init() {
		resetCounter();
	}
}
