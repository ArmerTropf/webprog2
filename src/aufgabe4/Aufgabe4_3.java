package aufgabe4;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Aufgabe4_3 {

	private String XML = "C:/Users/ich/Documents/GitHub/webprog2/WebContent/aufgabe4/persons.xml";
	private Map<String, String> names = new HashMap<String, String>();

	public Aufgabe4_3() {
		try {

			File fXmlFile = new File(XML);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("person");

			String vorname = "";
			String nachname = "";

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					vorname = eElement.getElementsByTagName("firstname").item(0).getTextContent();
					if (eElement.getElementsByTagName("lastname").item(0) != null) {
						nachname = eElement.getElementsByTagName("lastname").item(0).getTextContent();
					} else
						nachname = "*";

				}
				names.put(vorname, nachname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

}
