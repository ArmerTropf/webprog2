package aufgabe9;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import aufgabe9.Person;

@XmlRootElement(name="persons")
@Path("/aufgabe9")
public class PersonBean {

	private String XML = "C:/Users/Andre Schriever/Documents/GitHub/webprog2/WebContent/aufgabe5/persons.xml";

	private List<Person> persons = new ArrayList<Person>();

	@PostConstruct
	public void init() {

		System.out.println("in init");
//		getdataFromXmlFile();
	}
	

	@XmlElement(name="person")
	public List<Person> getPersons(){
//		this.persons.add(new Person("hans", "wurst", "bremerhaven"));
		
		getdataFromXmlFile();
		
		return this.persons;
	}	

	@GET
	@Path("/xml")
	@Produces("text/xml")
	public PersonBean getXML() {
		return new PersonBean();
	}

	@GET
	@Path("/json")
	@Produces("application/json")
	public PersonBean getJson() {
		return new PersonBean();
	}
	
//	@GET
//	@Path("/getAllPersonsXml")
//	@Produces("text/xml")
//	public PersonBean getAllPersonsXML() {
//		getdataFromXmlFile();
//		return new PersonBean();
//	}
//	
//	@GET
//	@Path("/getAllPersonsJson")
//	@Produces("application/json")
//	public PersonBean getAllPersonsJson() {
//		getdataFromXmlFile();
//		return new PersonBean();
//	}
	
		
	private void getdataFromXmlFile(){
		try {

			File fXmlFile = new File(XML);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("person");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				
				Person person = new Person();
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String vorname = eElement.getElementsByTagName("firstname").item(0).getTextContent();

					person.setVorname(vorname);
					
//					System.out.println(vorname);
					
					if (eElement.getElementsByTagName("lastname").item(0) != null) {
						String nachname = eElement.getElementsByTagName("lastname").item(0).getTextContent();
						person.setNachname(nachname);
					} else
						person.setNachname("*");

				}
				this.persons.add(person);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
