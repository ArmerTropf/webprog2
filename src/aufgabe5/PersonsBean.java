package aufgabe5;

import java.util.List;

public class PersonsBean {

	private IDataTier<Person> dt;

	public PersonsBean(IDataTier<Person> dt) {
		this.dt = dt;
	}
	
	public Person getPerson(int id){
		return dt.get(id);
	}
	
	public List<Person> getAllPersons(){
		return dt.getAllItems();
	}

}
