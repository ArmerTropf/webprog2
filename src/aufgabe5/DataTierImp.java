package aufgabe5;

import java.util.Map;

public class DataTierImp implements DataTier {

	PersonsDataBean myPDBean = new PersonsDataBean();	
	
	@Override
	public Map<String, String> getNames(PersonsBean myPBean) {
		return myPBean.getNames();
	}
	

}
