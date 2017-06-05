package aufgabe9.businessTier;

import aufgabe9.dataTier.PersonDummyDataTier;
import aufgabe9.dataTier.PersonXMLDataTier;

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
