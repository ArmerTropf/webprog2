package aufgabe9.dataBeans;

import aufgabe9.model.Model;

public abstract class DataBean<T extends Model> {
	
	protected T model;
	
	public int getId() {
		return model.getId();
	}
}

