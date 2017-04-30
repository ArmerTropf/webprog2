package aufgabe5;

public class PersonDummyDataTier extends DummyDataTier<Person> {
	
	public PersonDummyDataTier(){
		Person person = new Person();
		
		person.setVorname("hans");
		person.setNachname("wurst");
		person.setWohnort("milchsstraﬂe");
		add(person);
	}
}
