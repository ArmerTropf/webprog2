package aufgabe10.businessTier;

import aufgabe10.dataTier.PersonDummyDataTier;
import aufgabe10.dataTier.PersonXMLDataTier;

public class PersonsFactory {

	
	private PersonsFactory() {
		
	}
	
	public static PersonsBean getNewDummyPersonsBean() {
				
		return new PersonsBean(new PersonDummyDataTier());
		
	}
	
	public static PersonsBean getNewXMLPersonsBean() {
		return new PersonsBean(new PersonXMLDataTier());	
	}
	
	
}
