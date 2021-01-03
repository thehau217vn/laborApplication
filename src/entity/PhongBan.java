package entity;

public class PhongBan {
	private String maPhongBan;
	private String tenPhongBan;
	private String hotLine;
	private String moTa;
	public PhongBan() {
		super();
	}

	public PhongBan(String maPhongBan) {
		super();
		this.maPhongBan = maPhongBan;
	}

	public PhongBan(String maPhongBan, String tenPhongBan, String hotLine, String moTa) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.hotLine = hotLine;
		this.moTa = moTa;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public String getHotLine() {
		return hotLine;
	}

	public void setHotLine(String hotLine) {
		this.hotLine = hotLine;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	
}
