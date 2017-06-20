package aufgabe10.dataBeans;

import aufgabe10.model.Model;

public abstract class DataBean<T extends Model> {
	
	protected T model;
	
	public int getId() {
		return model.getId();
	}
}

