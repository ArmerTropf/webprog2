package aufgabe9.dataTier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aufgabe9.model.Model;

public class CacheDataTier<T extends Model> implements IDataTier<T> {

	private Map<Integer, T> map = new HashMap<Integer, T>();
	private int counter = 0;
	
	@Override
	public List<T> getAllItems() {
		return  new ArrayList<T>(map.values());
	}

	@Override
	public T get(int id) {
		return map.get(id);
	}

	@Override
	public void add(T obj) {
		obj.setId(counter);
		map.put(counter++, obj);
	}

	@Override
	public void remove(int id) {
		map.remove(id);
	}

	@Override
	public T get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
