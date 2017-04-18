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

/**
 * Servlet implementation class Aufgabe5_2
 */
@WebServlet("/Aufgabe5_2")
public class Aufgabe5_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private PersonsBean persons;
   
    public Aufgabe5_2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException{
    	persons = new PersonsBean();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DataBean erzeugen
		PersonsDataBean personsData = new PersonsDataBean(persons.getNames());
		
		request.setAttribute("personsData", personsData);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("personsData", personsData);
		
//		getServletContext.setAttribute("personsData", personsData);
		
		String jsp = "./aufgabe5/aufgabe5_2.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
