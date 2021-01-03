package entity;

//import java.util.List;

public class CongTrinh {

	private String maCongTrinh;
	private String tenCongTrinh;
	private String diaDiem;
	private String loaiHinh;
	private int giayPhepSo;
	private String ngayCapPhep;
	private String ngayKhoiCong;
	private String ngayHoanThanh;
	private boolean trangThai;

	public CongTrinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CongTrinh(String maCongTrinh) {
		super();
		this.maCongTrinh = maCongTrinh;
	}

	public CongTrinh(String maCongTrinh, String tenCongTrinh, String diaDiem, String loaiHinh, int giayPhepSo,
			String ngayCapPhep, String ngayKhoiCong, String ngayHoanThanh, boolean trangThai) {
		super();
		this.maCongTrinh = maCongTrinh;
		this.tenCongTrinh = tenCongTrinh;
		this.diaDiem = diaDiem;
		this.loaiHinh = loaiHinh;
		this.giayPhepSo = giayPhepSo;
		this.ngayCapPhep = ngayCapPhep;
		this.ngayKhoiCong = ngayKhoiCong;
		this.ngayHoanThanh = ngayHoanThanh;
		this.trangThai = trangThai;
	}

	public String getMaCongTrinh() {
		return maCongTrinh;
	}

	public void setMaCongTrinh(String maCongTrinh) {
		this.maCongTrinh = maCongTrinh;
	}

	public String getTenCongTrinh() {
		return tenCongTrinh;
	}

	public void setTenCongTrinh(String tenCongTrinh) {
		this.tenCongTrinh = tenCongTrinh;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public String getLoaiHinh() {
		return loaiHinh;
	}

	public void setLoaiHinh(String loaiHinh) {
		this.loaiHinh = loaiHinh;
	}

	public int getGiayPhepSo() {
		return giayPhepSo;
	}

	public void setGiayPhepSo(int giayPhepSo) {
		this.giayPhepSo = giayPhepSo;
	}

	public String getNgayCapPhep() {
		return ngayCapPhep;
	}

	public void setNgayCapPhep(String ngayCapPhep) {
		this.ngayCapPhep = ngayCapPhep;
	}

	public String getNgayKhoiCong() {
		return ngayKhoiCong;
	}

	public void setNgayKhoiCong(String ngayKhoiCong) {
		this.ngayKhoiCong = ngayKhoiCong;
	}

	public String getNgayHoanThanh() {
		return ngayHoanThanh;
	}

	public void setNgayHoanThanh(String ngayHoanThanh) {
		this.ngayHoanThanh = ngayHoanThanh;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

}
