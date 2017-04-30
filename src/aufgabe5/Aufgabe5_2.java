package aufgabe5;

import aufgabe5_Factory.BusinessTier;
import aufgabe5_Factory.BusinessTierImp;
import aufgabe5_Factory.DataTier;
import aufgabe5_Factory.DataTierImp;
import aufgabe5_Factory.PersonsDataBean;

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

	public void init() throws ServletException {

		persons = new PersonsBean(new PersonDummyDataTier());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsp = "./aufgabe5/start.jspx";

		try {

			String action = request.getParameter("action");

			System.out.println(action);

			switch (action) {
			case "start":

				break;
			case "liste":

				PersonsDataBean personsData = new PersonsDataBean(persons.getAllPersons());
				request.setAttribute("personsData", personsData);
				jsp = "./aufgabe5/Listenausgabe.jspx";
				break;

			case "detail":
				int id = Integer.parseInt(request.getParameter("id"));
				Person person = persons.getPerson(id);
				if (person == null)
					break;
				PersonDataBean personData = new PersonDataBean(person);
				request.setAttribute("personData", personData);
				jsp = "./aufgabe5/Detailausgabe.jspx";
				break;

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
