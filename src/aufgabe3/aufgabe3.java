package aufgabe3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aufgabe3
 */
@WebServlet("/aufgabe3")
public class aufgabe3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/* 1. doGet ¨uberschreiben */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* Cookie erzeugen */
		Cookie myCookie = new Cookie("myCookie", "sdsd");
		myCookie.setMaxAge(60);
		response.addCookie(myCookie);
		
		response.setContentType("text/html");
		/* 3. Ausgabekanal besorgen */
		PrintWriter out = response.getWriter();
		// alternativ:
		// ServletOutputStream out = response.getOutputStream();
		/* 4. Auszugebende Daten erzeugen (z. B. Html-Code) */
		String html = "<html><body>cookie hinzugefuegt</body></html>";
		/* 5. Ausgabe zum Client senden */
		out.println(html);
		out.close(); /* optional */
	}

}
