package aufgabe10.vorlesung;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public class CounterInit02a extends CounterInit01 {
	private CounterAdminInterface counterAdmin02a;
	@Context
	private ServletContext context;

	@Override
	@PostConstruct
	public void init() {
		String fileName = context.getInitParameter("counterFileName02");
		counterAdmin02a = CounterAdminImplFile.getInstance(fileName);
		super.init();
	}
}
