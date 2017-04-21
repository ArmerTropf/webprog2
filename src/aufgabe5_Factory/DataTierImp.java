package aufgabe5_Factory;

import java.util.Map;

public class DataTierImp implements DataTier {

	@Override
	public Map<String, String> getNames(PersonsBean go) {
		return go.getNames();
	}

}
