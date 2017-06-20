package aufgabe10.vorlesung;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CounterAdminContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		ServletContext context = contextEvent.getServletContext();
		/* handling context parameters for CounterInit02 */
		String counterFileName02 = context.getInitParameter("counterFileName02");
		CounterInit02.setFileName(counterFileName02);
	}

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) { 
		// not used here

	}
}
