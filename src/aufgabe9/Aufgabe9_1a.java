package aufgabe9;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import aufgabe9.businessTier.PersonsBean;
import aufgabe9.businessTier.PersonsFactory;
import aufgabe9.model.*;

@Path("/9_1")
@XmlRootElement
public class Aufgabe9_1a {
	
	public PersonsBean persons;
	List<Person> personList = new ArrayList<Person>();  
	
	public Aufgabe9_1a() {
		persons = PersonsFactory.getNewXMLPersonsBean();
		personList = persons.getAllPersons();
		
	}
	
	
	@GET
	@Path("/getPersonsXml")
	@Produces("text/xml")
	public List<Person> getXml() {
			
		return personList;
	}
	
	@GET
	@Path("/getPersonsJSON")
	@Produces("text/json")
	public List<Person> getJSON() {
			
		return personList;
	}
	
	
}
