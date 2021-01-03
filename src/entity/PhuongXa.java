package entity;

public class PhuongXa {
	private String idPX;
	private String id_QH;
	private String name;
	
	public PhuongXa() {
		// TODO Auto-generated constructor stub
	}

	public PhuongXa(String idPX, String id_QH, String name) {
		super();
		this.idPX = idPX;
		this.id_QH = id_QH;
		this.name = name;
	}

	public String getIdPX() {
		return idPX;
	}

	public void setIdPX(String idPX) {
		this.idPX = idPX;
	}

	public String getId_QH() {
		return id_QH;
	}

	public void setId_QH(String id_QH) {
		this.id_QH = id_QH;
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
