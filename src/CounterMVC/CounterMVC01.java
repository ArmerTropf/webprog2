package CounterMVC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterMVC01
 */
@WebServlet("/CounterMVC01")
public class CounterMVC01 extends HttpServlet {
	// ein paar Konstanten
	private static final String ACTION = "ACTION";
	private static final int SHOW_SYSTEM = 1;
	private static final int SHOW_RANDOM = 2;
	// Model-Klassen (Business-Objekte)
	private CounterBean counter;
	private DateBean date;
	private InfoBean info;
	private ListBean list;

	public void init() throws ServletException {
		// Business-Objekte erzeugen
		counter = new CounterBean();
		date = new DateBean();
		info = new InfoBean();
		list = new ListBean();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Daten, die immer ben¨otigt werden
		CounterDataBean counterData = new CounterDataBean(counter.getCounter());
		request.setAttribute("counterData", counterData);
		DateDataBean dateData = new DateDataBean(date.getDate(), date.getTime());
		request.setAttribute("dateData", dateData);
		// Ausgabeseite ermitteln
		String jsp = "../html/mvc/counter02.jsp";
		String action = request.getParameter("action");
		System.out.println(action);
		try

		{
			switch (Integer.parseInt(action)) {
			case SHOW_SYSTEM:
				System.out.println("in Show_System");
				jsp = "../html/mvc/showSystem.jsp";
				InfoDataBean infoData = new InfoDataBean(info.getSystemInfo());
				request.setAttribute("infoData", infoData);
				break;
			case SHOW_RANDOM:
				System.out.println("in Show_Random");
				jsp = "../html/mvc/showRandom.jsp";
				ListDataBean listData = new ListDataBean(list.getEnumeration());
				request.setAttribute("listData", listData);
				break;
			}
		} catch (Exception e) {
			/* ... */
		}

		// zur Ausgabe weiterleiten
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

	}
}