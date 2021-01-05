package entity;

public class PhanCongNhanVien {
	private NhanVien nhanVien;
	private String tenNhanVien;
	private String ngaySinh;
	private boolean gioiTinh;
	private String soCMND;
	private String diaChi;
	private String soDT;
	private String tenChucVu;
	private String diaDiem;
	private String tenCongTrinh;
	private String congViec;
	private CongTrinh congTrinh;
	private String ngayBatDau;
	private String ngayKetThuc;

	public PhanCongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhanCongNhanVien(NhanVien nhanVien, String tenNhanVien, String congViec, CongTrinh congTrinh,
			String ngayBatDau, String ngayKetThuc) {
		super();
		this.nhanVien = nhanVien;
		this.tenNhanVien = tenNhanVien;
		this.congViec = congViec;
		this.congTrinh = congTrinh;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public PhanCongNhanVien(NhanVien nhanVien, String tenNhanVien, String ngaySinh, boolean gioiTinh, String soCMND,
			String diaChi, String soDT, String tenChucVu) {
		super();
		this.nhanVien = nhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.tenChucVu = tenChucVu;
	}

	public PhanCongNhanVien(CongTrinh congTrinh, String tenCongTrinh, String diaDiem, String congViec,
			String ngayBatDau, String ngayKetThuc) {
		super();
		this.congTrinh = congTrinh;
		this.tenCongTrinh = tenCongTrinh;
		this.diaDiem = diaDiem;
		this.congViec = congViec;
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

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(CongViec congViec) {
		this.congViec = congViec.getTenCongViec();
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

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = nhanVien.getNgaySinh();
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = nhanVien.isGioiTinh();
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = nhanVien.getDiaChi();
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = nhanVien.getSoDT();
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = nhanVien.getChucVu();
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = nhanVien.getSoCMND();
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = congTrinh.getDiaDiem();
	}

	public String getTenCongTrinh() {
		return tenCongTrinh;
	}

	public void setTenCongTrinh(String tenCongTrinh) {
		this.tenCongTrinh = congTrinh.getTenCongTrinh();
	}

}
