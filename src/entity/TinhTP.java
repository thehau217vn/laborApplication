package entity;

public class TinhTP {
	private String idTP;
	private String name;

	public TinhTP(String idTP, String name) {
		super();
		this.idTP = idTP;
		this.name = name;
	}

	public String getIdTP() {
		return idTP;
	}

	public void setIdTP(String idTP) {
		this.idTP = idTP;
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
