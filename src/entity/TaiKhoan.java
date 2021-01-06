package entity;

public class TaiKhoan {
	private String maNhanVien;
	private NhanVien nhanVien;
	private String tenTaiKhoan;
	private String matKhau;

	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(String maNhanVien, String tenTaiKhoan, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}

	public TaiKhoan(String maNhanVien, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.matKhau = matKhau;
	}
	
	
	public TaiKhoan(NhanVien nhanVien, String matKhau) {
		super();
		this.nhanVien = nhanVien;
		this.matKhau = matKhau;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = nhanVien.getMaNhanVien();
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

}