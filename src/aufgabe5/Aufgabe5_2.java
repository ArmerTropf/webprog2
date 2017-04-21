package aufgabe5;

import aufgabe5_Factory.BusinessTier;
import aufgabe5_Factory.BusinessTierImp;
import aufgabe5_Factory.DataTier;
import aufgabe5_Factory.DataTierImp;
import aufgabe5_Factory.PersonsDataBean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Aufgabe5_2
 */
@WebServlet("/Aufgabe5_2")
public class Aufgabe5_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BusinessTier businessTier;
	private DataTier dataTier;
	private String jsp;

	public Aufgabe5_2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		businessTier = new BusinessTierImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");	

		System.out.println(action);

			
		if (action == null) {
			jsp = "./aufgabe5/Listenausgabe.jspx";
			
		} else {
			businessTier.setData(action);
			jsp = "./aufgabe5/Detailausgabe.jspx";
		}
		
		dataTier = new DataTierImp();
		
		PersonsDataBean personData = new PersonsDataBean(dataTier.getNames(businessTier.getBean()));
		request.setAttribute("personsData", personData );
	
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
