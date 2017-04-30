package aufgabe5;

public abstract class DataBean<T extends Model> {
	
	protected T model;
	
	public int getId() {
		return model.getId();
	}
}

