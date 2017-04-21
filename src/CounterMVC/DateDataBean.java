package CounterMVC;

public class DateDataBean {
	
	private final String df, tf;
	
	public DateDataBean(String df, String tf){
		this.df = df;
		this.tf  = tf;		
	}
	
	public String getDate(){
		return this.df;
	}
		
	public String getTime(){
		return this.tf;
	}
}
