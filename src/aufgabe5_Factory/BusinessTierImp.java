package aufgabe5_Factory;

public class BusinessTierImp implements BusinessTier {

	
	PersonsBean PBean = new PersonsBean();
	
	public BusinessTierImp() {
		PBean = new PersonsBean();
	}
	
	BusinessTierImp(String param) {
		PBean = new PersonsBean(param);
	}
	
	@Override
	public PersonsBean getBean() {	
		return PBean;
	}
	
	public void setData(String param) {
		PBean = new PersonsBean(param);
	}
	
}
