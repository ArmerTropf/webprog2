package aufgabe5;

import java.util.Collection;
import java.util.List;

public interface IDataTier<T extends Model> {
	
	public List<T> getAllItems();
	
	public T get(int id);
	
	public void add(T obj);
	
	public void remove(T obj);
	
}
