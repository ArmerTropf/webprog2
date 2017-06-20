package aufgabe10;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sun.jersey.spi.resource.Singleton;

import aufgabe10.businessTier.PersonsBean;
import aufgabe10.businessTier.PersonsFactory;
import aufgabe10.model.Person;

@Path("/10")
@Singleton
public class Aufgabe10 {
	
	public PersonsBean persons;
	
	public Aufgabe10() {

	}
	
	@PostConstruct
	public void init() {
		System.out.println("schreibe Neu     ");
		persons = PersonsFactory.getNewXMLPersonsBean();		
	}
	
	@GET
	@Path("/persons")
	@Produces({"text/xml","application/json"})
	public List<Person> getXml() {
		
		return persons.getAllPersons();
	}
	
	@GET
	@Path("/persons/firstname/{firstname}")
	@Produces({"text/xml","application/json"})
	public List<Person> getPersonByFirstName(@PathParam("firstname") String firstname) {
		Person person1 = null;
		person1 = persons.getPersonByFirstName(firstname);
		
		List<Person> go = new ArrayList<Person>();
		go.add(person1);
		
		return go;
	}
	
	@DELETE
	@Path("/persons/firstname/{firstname}")
	@Produces({"text/xml","application/json"})
	public List<Person> deletePersonByName(@PathParam("firstname") String firstname) {
		persons.removeByName(firstname);
		return persons.getAllPersons();
	}
	
	
	@GET
	@Path("/persons/lastname/{lastname}")
	@Produces({"text/xml","application/json"})
	public List<Person> getPersonByLastname(@PathParam("lastname") String lastname) {
		Person person1 = null;
		person1 = persons.getPersonByLastName(lastname);
		
		List<Person> go = new ArrayList<Person>();
		go.add(person1);
		
		return go;
	}
	
	@GET
	@Path("/persons/residence/{residence}")
	@Produces({"text/xml","application/json"})
	public List<Person> getPersonByResidence(@PathParam("residence") String residence) {
		Person person1 = null;
		person1 = persons.getPersonByResidence(residence);
		
		List<Person> go = new ArrayList<Person>();
		go.add(person1);
		
		return go;
	}
	
	@DELETE
	@Path("/persons/{id}")
	@Produces({"text/xml","application/json"})
	public List<Person> deletePerson(@PathParam("id") int id) {
		persons.removeById(id);
		return persons.getAllPersons();
	}
	
	@PUT
	@Path("/persons/{firstname}/{lastname}/{residence}")
	@Produces({"text/xml","application/json"})
	public List<Person> addPerson(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname, @PathParam("residence") String residence) {
		persons.addPersonToList(firstname, lastname, residence);
		return persons.getAllPersons();
	}
	
}
