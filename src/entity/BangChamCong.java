package entity;

public class BangChamCong {

	private CongTrinh congTrinh;
	private NhanVien nhanVien;
	private String tenNhanVien;
	private String chucVu;
	private float soNgayCong;

	public BangChamCong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BangChamCong(CongTrinh congTrinh, NhanVien nhanVien, String tenNhanVien, String chucVu, float soNgayCong) {
		super();
		this.congTrinh = congTrinh;
		this.nhanVien = nhanVien;
		this.tenNhanVien = tenNhanVien;
		this.chucVu = chucVu;
		this.soNgayCong = soNgayCong;
	}

	public CongTrinh getCongTrinh() {
		return congTrinh;
	}

	public void setCongTrinh(CongTrinh congTrinh) {
		this.congTrinh = congTrinh;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public float getSoNgayCong() {
		return soNgayCong;
	}

	public void setSoNgayCong(float soNgayCong) {
		this.soNgayCong = soNgayCong;
	}

}
