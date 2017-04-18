package Counter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterForward01
 */
@WebServlet("/CounterForward01")
public class CounterForward01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Realisierung des Z¨ahlers
	private int counter = -999;

	private synchronized int getCounter() {
		return ++counter;
	}

	private synchronized void resetCounter() {
		counter = 0;
	}

	public void init() throws ServletException {
		resetCounter();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DataBean erzeugen
		CounterDataBean bean = new CounterDataBean(getCounter());
		request.setAttribute("counterData", bean);
		System.out.println(bean.getValue());
//		System.out.println(this.getClass().);
		String jsp = "./Counter/counter.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}
}
