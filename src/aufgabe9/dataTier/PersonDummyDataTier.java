package aufgabe9.dataTier;

import aufgabe9.model.Person;

public class PersonDummyDataTier extends CacheDataTier<Person> {
	
	public PersonDummyDataTier(){
		Person person = new Person();
		
		person.setVorname("hans");
		person.setNachname("wurst");
		person.setWohnort("milchsstra�e");
		add(person);
	}
}
