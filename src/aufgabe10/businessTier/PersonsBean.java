package aufgabe10.businessTier;

import java.util.List;

import aufgabe10.dataTier.IDataTier;
import aufgabe10.model.Person;


public class PersonsBean {

	private IDataTier<Person> dt;

	public PersonsBean(IDataTier<Person> dt) {
		this.dt = dt;
	}
	
	public Person getPerson(int id){
		return dt.get(id);
	}
	
	public Person getPersonByFirstName(String firstname){

		List<Person> allPersons = dt.getAllItems();
		Person foundPerson = null;
		
		for (Person person : allPersons) {
			if (person.getVorname().equals(firstname)) {
				foundPerson =  person;
			}
				
		}
		
		return foundPerson;
	}
	
	public Person getPersonByLastName(String lastname){

		List<Person> allPersons = dt.getAllItems();
		Person foundPerson = null;
		
		for (Person person : allPersons) {
			if (person.getNachname().equals(lastname)) {
				foundPerson =  person;
			}
				
		}
		
		return foundPerson;
	}
	
	public Person getPersonByResidence(String residence){

		List<Person> allPersons = dt.getAllItems();
		Person foundPerson = null;
		
		for (Person person : allPersons) {
			if (person.getWohnort().equals(residence)) {
				foundPerson =  person;
			}
				
		}
		
		return foundPerson;
	}
	
	public void removeById(int id) {
		dt.remove(id);
	}
	
	public void removeByName(String firstname) {
		Person person = getPersonByFirstName(firstname);
		if (person != null) {
			dt.remove(person.getId());
		}
		
	}
	
	public void addPersonToList(String firstname, String lastname, String residence) {
		Person person = new Person();
		person.setVorname(firstname);
		person.setNachname(lastname);
		person.setWohnort(residence);
		
		dt.add(person);
	}
		
	public List<Person> getAllPersons(){
		return dt.getAllItems();
	}

}
