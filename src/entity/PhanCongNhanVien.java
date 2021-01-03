package entity;

public class PhanCongNhanVien {
	private NhanVien nhanVien;
	private String tenNhanVien;
	private CongViec congViec;
	private CongTrinh congTrinh;
	private String ngayBatDau;
	private String ngayKetThuc;

	public PhanCongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhanCongNhanVien(NhanVien nhanVien, String tenNhanVien, CongViec congViec, CongTrinh congTrinh,
			String ngayBatDau, String ngayKetThuc) {
		super();
		this.nhanVien = nhanVien;
		this.tenNhanVien = tenNhanVien;
		this.congViec = congViec;
		this.congTrinh = congTrinh;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
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

	public CongViec getCongViec() {
		return congViec;
	}

	public void setCongViec(CongViec congViec) {
		this.congViec = congViec;
	}

	public CongTrinh getCongTrinh() {
		return congTrinh;
	}

	public void setCongTrinh(CongTrinh congTrinh) {
		this.congTrinh = congTrinh;
	}

	public String getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

}
