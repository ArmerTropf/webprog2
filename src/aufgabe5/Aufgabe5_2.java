package aufgabe5;

import aufgabe5.PersonsDataBean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CounterMVC.InfoDataBean;
import CounterMVC.ListDataBean;

/**
 * Servlet implementation class Aufgabe5_2
 */
@WebServlet("/Aufgabe5_2")
public class Aufgabe5_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonsBean persons;
	private static final String ACTION = "ACTION";
	private static final int SHOW_SYSTEM = 1;
	private static final int SHOW_RANDOM = 2;
	private String jsp;
	int mode = 0;


	public Aufgabe5_2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {

		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");	

		System.out.println(action);

		DataTierImp myData = new DataTierImp();
		BusinessTierImp myBusiness = new BusinessTierImp();
		
		if (action == null) {
			//persons = new PersonsBean();
			myBusiness = new BusinessTierImp();
			jsp = "./aufgabe5/Listenausgabe.jspx";
			
		} else {
			//persons = new PersonsBean(action);
			myBusiness = new BusinessTierImp(action);
			jsp = "./aufgabe5/Detailausgabe.jspx";
			
		}
		
		PersonsDataBean personsData = new PersonsDataBean(myData.getNames(myBusiness.getBean())); 

		request.setAttribute("personsData", personsData);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
