package aufgabe10.dataTier;

import java.util.List;

import aufgabe10.model.Model;

public interface IDataTier<T extends Model> {
	
	public List<T> getAllItems();
	
	public T get(int id);
	
	public T get(String name);
	
	public void add(T obj);
	
	public void remove(int id);
	
}
