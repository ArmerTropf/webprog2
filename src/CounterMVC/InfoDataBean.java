package CounterMVC;

import java.util.Map;

public class InfoDataBean {
	
	private Map<String, String> props;
	
	public InfoDataBean(Map<String, String> props){
		this.props = props;
	}
	
	public Map<String,String> getProps()
	{
		return this.props;
	}

}
