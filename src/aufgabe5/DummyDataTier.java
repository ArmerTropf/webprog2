package aufgabe5;

import java.util.HashMap;
import java.util.Map;

public class DummyDataTier implements DataTier {

//	Map<String, String> myDummyMap = new HashMap<>()
	
	
	@Override
	public Map<String, String> getNames(PersonsBean go) {
		// TODO Auto-generated method stub
		return go.getNames();
	}
	

}
