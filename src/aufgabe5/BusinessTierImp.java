package aufgabe5;

public class BusinessTierImp implements BusinessTier {

	
	PersonsBean PBean = new PersonsBean();
	
	BusinessTierImp() {
		
	}
	
	BusinessTierImp(String param) {
		PBean = new PersonsBean(param);
	}
	
	@Override
	public PersonsBean getBean() {	
		return PBean;
	}
	
}
