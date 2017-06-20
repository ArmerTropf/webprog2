package aufgabe10.dataTier;

import aufgabe10.model.Person;

public class PersonDummyDataTier extends CacheDataTier<Person> {
	
	public PersonDummyDataTier(){
		Person person = new Person();
		
		person.setVorname("hans");
		person.setNachname("wurst");
		person.setWohnort("milchsstra�e");
		add(person);
	}
}
