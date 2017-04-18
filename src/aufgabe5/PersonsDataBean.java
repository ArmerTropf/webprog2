package aufgabe5;

import java.util.Map;

public class PersonsDataBean {

	private Map<String,String> names;
	
	private String test = "bums";
	
	public PersonsDataBean(Map<String, String> names){
		this.names = names;
	}
	
	public Map<String, String> getNames() {
		return names;
	}
	
	public String getTest(){
		return test;
	}
}
