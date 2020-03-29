package Main;

public class Coche{
	
	protected String _id;
	protected String _modelo;
	protected int _stock;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_modelo() {
		return _modelo;
	}
	public void set_modelo(String _modelo) {
		this._modelo = _modelo;
	}
	public int get_stock() {
		return _stock;
	}
	public void set_stock(int _stock) {
		this._stock = _stock;
	}
	
	
	public Coche() {};
	
	public Coche(String _id, String _modelo, int _stock) {			
		this._id = _id;
		this._modelo = _modelo;
		this._stock = _stock;
	}

	
	
}