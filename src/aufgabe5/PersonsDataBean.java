package aufgabe5;

import java.util.Map;

public class PersonsDataBean  {

	private Map<String,String> names;
	
	public PersonsDataBean(Map<String, String> names){
		this.names = names;
	}
	public PersonsDataBean(){
		
	}
	
	public Map<String, String> getNames() {
		return names;
	}
}
