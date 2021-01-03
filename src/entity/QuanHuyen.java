package entity;

public class QuanHuyen {
	private String idQH;
	private String id_TP;
	private String name;
	
	public QuanHuyen(String idQH, String id_TP, String name) {
		super();
		this.idQH = idQH;
		this.id_TP = id_TP;
		this.name = name;
	}
	public String getIdQH() {
		return idQH;
	}
	public void setIdQH(String idQH) {
		this.idQH = idQH;
	}
	public String getId_TP() {
		return id_TP;
	}
	public void setId_TP(String id_TP) {
		this.id_TP = id_TP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
	
	
	
}
