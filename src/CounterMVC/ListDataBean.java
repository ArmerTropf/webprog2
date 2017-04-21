package CounterMVC;

import java.util.Enumeration;
import java.util.Vector;

public class ListDataBean {
	
	private Enumeration data;
	
	public ListDataBean(Enumeration data){
		
		this.data = data;
	}
	
	public Enumeration getData(){
		return this.data;
	}
}
