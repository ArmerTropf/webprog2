package aufgabe9;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Path("mimes")
public class VorlesungRestXml {

	public String var1 = "Text1";
	public int var2 = 10;

	public VorlesungRestXml() {
	}

	public VorlesungRestXml(String go1, int go2) {
		this();
		this.var1 = go1;
		this.var2 = go2;
	}

	@GET
	@Path("/xmlWithoutVar")
	@Produces("text/xml")
	public VorlesungRestXml getXML() {
		VorlesungRestXml tester = new VorlesungRestXml();

		return tester;
	}

	@GET
	@Path("/xmlWithVar/{go1}/{go2}")
	@Produces("text/xml")
	public VorlesungRestXml getXML(@PathParam("go1") String go1, @PathParam("go2") int go2) {
		VorlesungRestXml tester = new VorlesungRestXml(go1, go2);

		return tester;
	}

	@GET
	@Path("/error")
	public Response getError() {
		javax.ws.rs.core.Response.ResponseBuilder rb = Response.serverError();
		rb.header("Cache-Control", "no-cache");
		return rb.build();
	}

	@GET
	@Path("/request")
	@Produces("text/plain")
	public Response doIndex(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		// use request and response ...
		ResponseBuilder rb = Response.ok("ok");
		return rb.build();
	}

	@GET
	@Path("/cookies")
	@Produces("text/plain")
	public Response doCookie(@CookieParam("myCookie") String oldCookieValue) {
		int maxAge = 3;
		javax.ws.rs.core.Cookie tempCookie = new Cookie("myCookie", "gogogo");
		javax.ws.rs.core.NewCookie newCookie = new NewCookie(tempCookie, "comment", maxAge, false);
		ResponseBuilder rb = Response.ok("ok").cookie(newCookie);
		return rb.build();
	}
}
