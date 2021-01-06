package ui;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.ChucVu_DAO;
import dao.CongTrinh_DAO;
import dao.CongViec_DAO;
import dao.NhanVien_DAO;
import dao.PhanCongNhanVien_DAO;
import dao.PhongBan_DAO;
import dao.TaiKhoan_DAO;
import entity.ChucVu;
import entity.CongTrinh;
import entity.CongViec;
import entity.NhanVien;
import entity.PhanCongNhanVien;
import entity.PhongBan;
import entity.PhuongXa;
import entity.TinhTP;
import entity.QuanHuyen;
import entity.TaiKhoan;

/**
 *
 * @author WIN10
 */
public class QLLD_Application extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelNV;
	private DefaultTableModel modelCT;
	private DefaultTableModel modelCM;
	private DefaultTableModel modelPB;
	private DefaultTableModel modelCV;
	private DefaultTableModel modelChV;
	private DefaultTableModel modelTKNV;
	private DefaultTableModel modelTKCT;
	private DefaultTableModel modelBCCNV;
	private DefaultTableModel modelBCCCT;
	private DefaultTableModel modelPCNVCT;
	private DefaultTableModel modelPCNVNV;
	private DefaultTableModel modelPCNVJCT;
	private DefaultTableModel modelTTCN;

	private CongTrinh_DAO congTrinh_DAO = new CongTrinh_DAO();
	private PhongBan_DAO phongBan_DAO = new PhongBan_DAO();
	private CongViec_DAO congViec_DAO = new CongViec_DAO();
	private ChucVu_DAO chucVu_DAO = new ChucVu_DAO();
	private TaiKhoan_DAO taiKhoan_DAO = new TaiKhoan_DAO();
	private PhanCongNhanVien_DAO phanCong_DAO = new PhanCongNhanVien_DAO();
	private NhanVien_DAO nhanVien_DAO = new NhanVien_DAO();
	private String maTaiKhoan;

	public QLLD_Application(String account) throws SQLException, ParseException {
		this.maTaiKhoan = account;
		initComponents();
		setSize(1366, 768);
		setLocationRelativeTo(null);
		setTitle("PHẦN MỀM QUẢN LÝ LAO ĐỘNG");
	}

	PhanCong phanCong = new PhanCong();
	DoiMatKhau doiMatKhau = new DoiMatKhau();
	DangNhap dangNhap = new DangNhap();
	ThongTinPhanMem thongTin = new ThongTinPhanMem();
	private JComboBox<String> cbbCongViec_LaoDong;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCongViec_laoDong;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCongViec_baoVe;
	private JComboBox<String> cbbCongViec_BaoVe;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCongViec_kTrucSu;
	private JComboBox<String> cbbCongViec_kTrucSu;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCongViec_KSXD;
	private JComboBox<String> cbbCongViec_KSXD;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCongViec_QLCT;
	private JComboBox<String> cbbCongViec_QLCT;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelCongViec_KSD;
	private JComboBox<String> cbbCongViec_KSD;
	private JComboBox<String> cbb_SLNgayNghi;
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modelSLNgayNghi;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	class JDateChooserEditor extends DefaultCellEditor {

		private static final long serialVersionUID = 1L;

		public JDateChooserEditor(JCheckBox checkBox) {
			super(checkBox);

		}

		JDateChooser date;

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {

			date = new JDateChooser();
			date.setDateFormatString("yyyy-MM-dd");
			return date;
		}

		public Object getCellEditorValue() {
			return new String(((JTextField) date.getDateEditor().getUiComponent()).getText());
		}

		public boolean stopCellEditing() {
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}

	@SuppressWarnings("unchecked")
	private void initComponents() throws SQLException, ParseException {

		jToolBar1 = new javax.swing.JToolBar();
		JTB_QLLD = new javax.swing.JTabbedPane();
		pn_TrangChu = new javax.swing.JPanel();
		pn_Header = new javax.swing.JPanel();
		lbl_logo = new javax.swing.JLabel();
		lbl_TenPM2 = new javax.swing.JLabel();
		lbl_TenPM = new javax.swing.JLabel();
		btn_ThongTin = new javax.swing.JButton();
		lbl_Background = new javax.swing.JLabel();
		pn_NguoiQuanLy = new javax.swing.JPanel();
		pn_QuanLy = new javax.swing.JTabbedPane();
		pn_QLNhanVien = new javax.swing.JPanel();
		pn_DsNhanVien = new javax.swing.JPanel();
		scroll_QLNV = new javax.swing.JScrollPane();
		tbl_QLNV = new javax.swing.JTable();
		lbl_TimPB = new javax.swing.JLabel();
		lbl_TimTenNV = new javax.swing.JLabel();
		txt_nvTimTenNV = new javax.swing.JTextField();
		lbl_TimMaNV = new javax.swing.JLabel();
		txt_nvTimMaNV = new javax.swing.JTextField();
		lblTimNV = new javax.swing.JLabel();
		cbb_nvTimPB = new javax.swing.JComboBox<>();
		lbl_TimChucVu = new javax.swing.JLabel();
		cbb_nvTimChucVu = new javax.swing.JComboBox<>();
		btn_nvTimNV = new javax.swing.JButton();
		pn_nvThemNV = new javax.swing.JPanel();
		lbl_PB = new javax.swing.JLabel();
		cbb_nvChonPB = new javax.swing.JComboBox<>();
		lbl_MaNV = new javax.swing.JLabel();
		txt_nvMaNV = new javax.swing.JTextField();
		txt_nvMaNV.setEditable(false);
		lbl_TenNV = new javax.swing.JLabel();
		txt_nvTenNV = new javax.swing.JTextField();
		lbl_CMND = new javax.swing.JLabel();
		txt_nvCMND = new javax.swing.JTextField();
		lbl_GT = new javax.swing.JLabel();
		Rbtn_Nam = new javax.swing.JRadioButton();
		Rbtn_Nu = new javax.swing.JRadioButton();
		DateChooser_NamSinh = new com.toedter.calendar.JDateChooser();
		cbb_nvChonChV = new javax.swing.JComboBox<>();
		lbl_ChVu = new javax.swing.JLabel();
		lbl_Tuoi = new javax.swing.JLabel();
		lbl_SDT = new javax.swing.JLabel();
		lbl_DiaChi = new javax.swing.JLabel();
		txt_nvSDT = new javax.swing.JTextField();
		txt_nvDiaChiNV = new javax.swing.JTextField();
		lbl_ThemNV = new javax.swing.JLabel();
		btn_XoaNV = new javax.swing.JButton();
		btn_LuuNV = new javax.swing.JButton();
		btn_CapNhatNV = new javax.swing.JButton();
		btn_XoaTrangNV = new javax.swing.JButton();
		lbl_DiaChi2 = new javax.swing.JLabel();
		lbl_DiaChi3 = new javax.swing.JLabel();
		lbl_DiaChi4 = new javax.swing.JLabel();
		cbb_nvThanhPho = new javax.swing.JComboBox<>();
		cbb_nvQuanHuyen = new javax.swing.JComboBox<>();
		cbb_nvPhuongXa = new javax.swing.JComboBox<>();
		pn_QLChuyenMon = new javax.swing.JPanel();
		pn_QuanLyCM = new javax.swing.JPanel();
		lbl_ChuyenMon = new javax.swing.JLabel();
		scroll_QLCM = new javax.swing.JScrollPane();
		tbl_ChuyenMon = new javax.swing.JTable();
		cbb_TimCM = new javax.swing.JComboBox<>();
		pn_QLPhongBan = new javax.swing.JPanel();
		pn_ThemPB = new javax.swing.JPanel();
		lbl_ThemPB = new javax.swing.JLabel();
		lbl_MaPB = new javax.swing.JLabel();
		lbl_TenPB = new javax.swing.JLabel();
		lbl_Hotline = new javax.swing.JLabel();
		txt_pbMaPB = new javax.swing.JTextField();
		txt_pbMaPB.setEditable(false);
		txt_pbTenPB = new javax.swing.JTextField();
		txt_pbHotline = new javax.swing.JTextField();
		lbl_GhiChu = new javax.swing.JLabel();
		scroll_GhiChu = new javax.swing.JScrollPane();
		txt_pbMoTa = new javax.swing.JTextArea();
		btn_XoaPB = new javax.swing.JButton();
		btn_LuuPB = new javax.swing.JButton();
		btn_CapNhatPB = new javax.swing.JButton();
		btn_XoaTrangPB = new javax.swing.JButton();
		pn_DsPhongBan = new javax.swing.JPanel();
		scroll_QLPB = new javax.swing.JScrollPane();
		tbl_QLPB = new javax.swing.JTable();
		lbl_TKPB = new javax.swing.JLabel();
		lbl_TimMaPB = new javax.swing.JLabel();
		lbl_TimTenPB = new javax.swing.JLabel();
		txt_pbTimTenPB = new javax.swing.JTextField();
		btn_pbTimPB = new javax.swing.JButton();
		txt_pbTimMaPB = new javax.swing.JTextField();
		pn_QLCongTrinh = new javax.swing.JPanel();
		pn_ThemCT = new javax.swing.JPanel();
		lbl_ThemCT = new javax.swing.JLabel();
		lbl_MaCT = new javax.swing.JLabel();
		lbl_TenCT = new javax.swing.JLabel();
		lbl_DiaChiCT = new javax.swing.JLabel();
		txt_ctTenCT = new javax.swing.JTextField();
		txt_ctMaCT = new javax.swing.JTextField();
		lbl_NgayHT = new javax.swing.JLabel();
		lbl_NgayKC = new javax.swing.JLabel();
		lbl_NgayCP = new javax.swing.JLabel();
		btn_LuuCT = new javax.swing.JButton();
		btn_XoaCT = new javax.swing.JButton();
		btn_XoaTrangCT = new javax.swing.JButton();
		btn_CapNhatCT = new javax.swing.JButton();
		lbl_TrangThai = new javax.swing.JLabel();
		DateChooser_ctNgayCP = new com.toedter.calendar.JDateChooser();
		DateChooser_ctNgayKC = new com.toedter.calendar.JDateChooser();
		DateChooser_ctNgayHT = new com.toedter.calendar.JDateChooser();
		Rbtn_TrangThaiDHT = new javax.swing.JRadioButton();
		Rbtn_TrangThaiCHT = new javax.swing.JRadioButton();
		cbb_ctQuan = new javax.swing.JComboBox<>();
		cbb_ctPhuong = new javax.swing.JComboBox<>();
		lbl_DiaChi5 = new javax.swing.JLabel();
		txt_ctDiaChiCT = new javax.swing.JTextField();
		lbl_GiayPhepSo = new javax.swing.JLabel();
		txt_ctSoGiayPhep = new javax.swing.JTextField();
		lbl_LoaiHinh = new javax.swing.JLabel();
		cbb_ctLoaiHinhCT = new javax.swing.JComboBox<>();
		pn_DsCongTrinh = new javax.swing.JPanel();
		scroll_QLCT = new javax.swing.JScrollPane();
		tbl_QLCT = new javax.swing.JTable();
		lbl_TKCT = new javax.swing.JLabel();
		lbl_TimMaCT = new javax.swing.JLabel();
		lbl_TimTenCT = new javax.swing.JLabel();
		txt_ctTimTenCT = new javax.swing.JTextField();
		btn_ctTimCT = new javax.swing.JButton();
		txt_ctTimMaCT = new javax.swing.JTextField();
		pn_QLChucVuCongViec = new javax.swing.JPanel();
		pn_CongViec = new javax.swing.JPanel();
		pn_ThemCongViec = new javax.swing.JPanel();
		lbl_cvThemCongViec = new javax.swing.JLabel();
		lbl_MaCongViec = new javax.swing.JLabel();
		lbl_TenCongViec = new javax.swing.JLabel();
		txt_cvTenCV = new javax.swing.JTextField();
		txt_cvMaCV = new javax.swing.JTextField();
		txt_cvMaCV.setEditable(false);
		btn_LuuCV = new javax.swing.JButton();
		btn_XoaCV = new javax.swing.JButton();
		btn_XoaTrangCV = new javax.swing.JButton();
		btn_CapNhatCV = new javax.swing.JButton();
		scroll_MoTaCongViec = new javax.swing.JScrollPane();
		txt_cvMoTaCV = new javax.swing.JTextArea();
		lbl_MoTaCV = new javax.swing.JLabel();
		pn_dsCongViec = new javax.swing.JPanel();
		scroll_QLCV = new javax.swing.JScrollPane();
		tbl_QLCV = new javax.swing.JTable();
		pn_ChucVu = new javax.swing.JPanel();
		pn_ThemChucVu = new javax.swing.JPanel();
		lbl_cvThemChucVu = new javax.swing.JLabel();
		lbl_MaChucVu = new javax.swing.JLabel();
		txt_cvMaChV = new javax.swing.JTextField();
		txt_cvMaChV.setEditable(false);
		lbl_TenChucVu = new javax.swing.JLabel();
		txt_cvTenChV = new javax.swing.JTextField();
		lbl_MoTaChucVu = new javax.swing.JLabel();
		scroll_MoTaCongViec1 = new javax.swing.JScrollPane();
		txt_cvMoTaChV = new javax.swing.JTextArea();
		btn_LuuChV = new javax.swing.JButton();
		btn_XoaChV = new javax.swing.JButton();
		btn_XoaTrangChV = new javax.swing.JButton();
		btn_CapNhatChV = new javax.swing.JButton();
		pn_dsChucVu = new javax.swing.JPanel();
		scroll_QLCV1 = new javax.swing.JScrollPane();
		tbl_QLChV = new javax.swing.JTable();
		pn_QLTaiKhoan = new javax.swing.JPanel();
		lbl_tkTimPB = new javax.swing.JLabel();
		lbl_tkTimTenNV = new javax.swing.JLabel();
		txt_tkTimTenNV = new javax.swing.JTextField();
		lbl_tkTimMaNV = new javax.swing.JLabel();
		txt_tkTimMaNV = new javax.swing.JTextField();
		lbl_TimNV = new javax.swing.JLabel();
		cbb_tkTimPB = new javax.swing.JComboBox<>();
		btn_tkTimNV = new javax.swing.JButton();
		pn_ThemTK = new javax.swing.JPanel();
		lbl_ThemTK = new javax.swing.JLabel();
		lbl_tkMaNV = new javax.swing.JLabel();
		lbl_tkTenNV = new javax.swing.JLabel();
		txt_tkTenNV = new javax.swing.JTextField();
		txt_tkMaNV = new javax.swing.JTextField();
		lbl_tkMatKhau = new javax.swing.JLabel();
		txt_tkMatKhau = new javax.swing.JTextField();
		lbl_tkNLMatKhau = new javax.swing.JLabel();
		txt_tkNLMatKhau = new javax.swing.JTextField();
		btn_LuuTK = new javax.swing.JButton();
		btn_XoaTK = new javax.swing.JButton();
		btn_XoaTrangTK = new javax.swing.JButton();
		btn_CapNhatTK = new javax.swing.JButton();
		pn_DsTaiKhoan = new javax.swing.JPanel();
		scroll_QLTK = new javax.swing.JScrollPane();
		tbl_QLTK = new javax.swing.JTable();
		pn_PhanCongCV = new javax.swing.JPanel();
		pn_PhanCong = new javax.swing.JPanel();
		pn_ThongTinCT = new javax.swing.JPanel();
		lbl_pcMaCT = new javax.swing.JLabel();
		txt_pcMaCT = new javax.swing.JTextField();
		lbl_pcTenCT = new javax.swing.JLabel();
		txt_pcTenCT = new javax.swing.JTextField();
		lbl_pcNgayCP = new javax.swing.JLabel();
		lbl_pcNgayHT = new javax.swing.JLabel();
		lbl_pcNgayKC = new javax.swing.JLabel();
		lbl_pcDiaChiCT = new javax.swing.JLabel();
		txt_pcDiaChiCT = new javax.swing.JTextField();
		DateChooser_pcNgayCP = new com.toedter.calendar.JDateChooser();
		DateChooser_pcNgayKC = new com.toedter.calendar.JDateChooser();
		DateChooser_pcNgayHT = new com.toedter.calendar.JDateChooser();
		lbl_TrangThai1 = new javax.swing.JLabel();
		Rbtn_pcTrangThaiDHT = new javax.swing.JRadioButton();
		Rbtn_pcTrangThaiCHT = new javax.swing.JRadioButton();
		lbl_GiayPhepSo1 = new javax.swing.JLabel();
		txt_ctSoGiayPhep1 = new javax.swing.JTextField();
		pn_pcQLCongTrinh = new javax.swing.JPanel();
		lbl_LocCT = new javax.swing.JLabel();
		cbb_LocCT = new javax.swing.JComboBox<>();
		lbl_TimTenCongTrinh = new javax.swing.JLabel();
		txt_pcTimTenCT = new javax.swing.JTextField();
		btn_pcTimCT = new javax.swing.JButton();
		pn_pcDsCongTrinh = new javax.swing.JPanel();
		scroll_DSCongTrinh = new javax.swing.JScrollPane();
		tbl_pcQLCT = new javax.swing.JTable();
		btn_OKCongViec = new javax.swing.JButton();
		pn_LocNV = new javax.swing.JPanel();
		btn_IN = new javax.swing.JButton();
		btn_OUT = new javax.swing.JButton();
		pn_pcDsNhanVien = new javax.swing.JPanel();
		scroll_DSNhanVien = new javax.swing.JScrollPane();
		tbl_pcDanhSachNV = new javax.swing.JTable();
		pn_DsNhanVienTGCT = new javax.swing.JPanel();
		scroll_PhanCongNV = new javax.swing.JScrollPane();
		tbl_pcNVThamGia = new javax.swing.JTable();
		pn_ChamCong = new javax.swing.JPanel();
		pn_BangChamCongNV = new javax.swing.JPanel();
		pn_bccTTNV = new javax.swing.JPanel();
		lbl_PB1 = new javax.swing.JLabel();
		cbb_nvChonPB1 = new javax.swing.JComboBox<>();
		cbb_nvChonChVu1 = new javax.swing.JComboBox<>();
		lbl_ChVu1 = new javax.swing.JLabel();
		lbl_MaNV1 = new javax.swing.JLabel();
		txt_bccMaNV = new javax.swing.JTextField();
		lbl_TenNV1 = new javax.swing.JLabel();
		txt_bccnvTenNV = new javax.swing.JTextField();
		lbl_Tuoi1 = new javax.swing.JLabel();
		DateChooser_bccNamSinh = new com.toedter.calendar.JDateChooser();
		lbl_GT1 = new javax.swing.JLabel();
		Rbtn_bccNam = new javax.swing.JRadioButton();
		Rbtn_bccNu = new javax.swing.JRadioButton();
		lbl_CMND1 = new javax.swing.JLabel();
		lbl_SDT1 = new javax.swing.JLabel();
		txt_bccSDT = new javax.swing.JTextField();
		txt_bccCMND = new javax.swing.JTextField();
		lbl_DiaChi1 = new javax.swing.JLabel();
		txt_bccDiaChi = new javax.swing.JTextField();
		pn_bccDSNV = new javax.swing.JPanel();
		jScrollPane_DSNV = new javax.swing.JScrollPane();
		tbl_bccDSNV = new javax.swing.JTable();
		pn_BangChamCong = new javax.swing.JPanel();
		jScrollPane_BangChamCong = new javax.swing.JScrollPane();
		tbl_bccBangChamCong = new javax.swing.JTable();
		pn_ThongKe = new javax.swing.JPanel();
		pn_ThongKeCongTrinh = new javax.swing.JPanel();
		lbl_TieuChi = new javax.swing.JLabel();
		lbl_SoLuong = new javax.swing.JLabel();
		lbl_NamXD = new javax.swing.JLabel();
		txt_NamXD = new javax.swing.JTextField();
		cbb_TieuChi = new javax.swing.JComboBox<>();
		txt_SoLuong = new javax.swing.JTextField();
		btn_XacNhanThongKe = new javax.swing.JButton();
		scroll_QLCT1 = new javax.swing.JScrollPane();
		tbl_Thongke = new javax.swing.JTable();
		pn_TTCN = new javax.swing.JPanel();
		TTCN = new javax.swing.JPanel();
		lbl_ttcnPB = new javax.swing.JLabel();
		lbl_ttcnMaNV = new javax.swing.JLabel();
		lbl_ttcnTenNV = new javax.swing.JLabel();
		lbl_ttcnGT = new javax.swing.JLabel();
		Rbtn_ttcnNam = new javax.swing.JRadioButton();
		Rbtn_ttcnNu = new javax.swing.JRadioButton();
		lbl_ttcnDiaChi = new javax.swing.JLabel();
		lbl_ttcnSDT = new javax.swing.JLabel();
		lbl_ttcnTuoi = new javax.swing.JLabel();
		lbl_ttcnCMND = new javax.swing.JLabel();
		txt_ttcnCMND = new javax.swing.JTextField();
		txt_ttcnSDT = new javax.swing.JTextField();
		txt_ttcnDiaChi = new javax.swing.JTextField();
		btn_HoanTat = new javax.swing.JButton();
		txt_ttcnTenNV = new javax.swing.JTextField();
		txt_ttcnMaNV = new javax.swing.JTextField();
		txt_ttcnPhongBan = new javax.swing.JTextField();
		lbl_Profile = new javax.swing.JLabel();
		btn_DangXuat = new javax.swing.JButton();
		btn_DoiMK = new javax.swing.JButton();
		btn_TroGiup = new javax.swing.JButton();
		DateChooser_ttcnNamSinh = new com.toedter.calendar.JDateChooser();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		modelCongViec_laoDong = new DefaultComboBoxModel<>();
		modelCongViec_laoDong.addElement("Thợ Hồ");
		modelCongViec_laoDong.addElement("Làm Móng");
		modelCongViec_laoDong.addElement("Làm Nền");
		modelCongViec_laoDong.addElement("Chuyển Giàn Giáo");
		modelCongViec_laoDong.addElement("Tô Tường");
		modelCongViec_laoDong.addElement("Thợ Chính");
		modelCongViec_laoDong.addElement("Sơn Tường");
		modelCongViec_laoDong.addElement("Ốp Gạch");
		modelCongViec_laoDong.addElement("Làm Trần");
		modelCongViec_laoDong.addElement("Uốn Cắt Thép");
		modelCongViec_laoDong.addElement("Làm Vòm");
		modelCongViec_laoDong.addElement("Xây Cầu Thang");
		modelCongViec_laoDong.addElement("Bốc Vác");
		modelCongViec_laoDong.addElement("Lắp Đặt Hệ Thống Cửa");
		cbbCongViec_LaoDong = new JComboBox<String>(modelCongViec_laoDong);

		modelCongViec_baoVe = new DefaultComboBoxModel<>();
		modelCongViec_baoVe.addElement("Kiểm Kê Vật Liệu");
		modelCongViec_baoVe.addElement("Trông Coi Công Trình");
		cbbCongViec_BaoVe = new JComboBox<String>(modelCongViec_baoVe);

		modelCongViec_kTrucSu = new DefaultComboBoxModel<>();
		modelCongViec_kTrucSu.addElement("Thiết Kế Quy Hoạch");
		modelCongViec_kTrucSu.addElement("Thiết Kế Nội Thất");
		cbbCongViec_kTrucSu = new JComboBox<String>(modelCongViec_kTrucSu);

		modelCongViec_KSXD = new DefaultComboBoxModel<>();
		modelCongViec_KSXD.addElement("Giám Sát Thiết Kế");
		modelCongViec_KSXD.addElement("Giám Sát Công Trình");
		cbbCongViec_KSXD = new JComboBox<String>(modelCongViec_KSXD);

		modelCongViec_QLCT = new DefaultComboBoxModel<>();
		modelCongViec_QLCT.addElement("Giám Sát Công Trình");
		modelCongViec_QLCT.addElement("Chỉ Huy CT");
		cbbCongViec_QLCT = new JComboBox<String>(modelCongViec_QLCT);

		modelCongViec_KSD = new DefaultComboBoxModel<>();
		modelCongViec_KSD.addElement("Thiết Kế Hệ Thống Điện");
		modelCongViec_KSD.addElement("Lắp Đặt Dây Điện");
		cbbCongViec_KSD = new JComboBox<String>(modelCongViec_KSD);

		jToolBar1.setRollover(true);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JTB_QLLD.setFont(new java.awt.Font("Tahoma", 1, 18));

		pn_TrangChu.setLayout(null);

		pn_Header.setBackground(new java.awt.Color(255, 212, 121));

		lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rsz_1hnv.png")));
		lbl_logo.setToolTipText("Trang chủ");

		lbl_TenPM2.setFont(new java.awt.Font("Tahoma", 1, 40));
		lbl_TenPM2.setText("PHẦN MỀM QUẢN LÝ LAO ĐỘNG");

		lbl_TenPM.setFont(new java.awt.Font("Tahoma", 1, 40));
		lbl_TenPM.setText("HNV VIỆT NAM");

		btn_ThongTin.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_ThongTin.setText("Thông Tin");
		btn_ThongTin.setToolTipText("Thông tin phần mềm");
		btn_ThongTin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/information.png")));
		btn_ThongTin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_ThongTinActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pn_HeaderLayout = new javax.swing.GroupLayout(pn_Header);
		pn_Header.setLayout(pn_HeaderLayout);
		pn_HeaderLayout
				.setHorizontalGroup(pn_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_HeaderLayout.createSequentialGroup().addGap(55, 55, 55).addComponent(lbl_logo)
								.addGap(48, 48, 48)
								.addGroup(pn_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(pn_HeaderLayout.createSequentialGroup().addGap(137, 137, 137)
												.addComponent(lbl_TenPM, javax.swing.GroupLayout.PREFERRED_SIZE, 420,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap(474, Short.MAX_VALUE))
										.addGroup(pn_HeaderLayout.createSequentialGroup().addComponent(lbl_TenPM2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btn_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 142,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(34, 34, 34)))));
		pn_HeaderLayout.setVerticalGroup(pn_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_HeaderLayout.createSequentialGroup()
						.addComponent(btn_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(pn_HeaderLayout.createSequentialGroup().addGap(15, 15, 15)
						.addGroup(pn_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addGroup(pn_HeaderLayout.createSequentialGroup().addComponent(lbl_TenPM2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lbl_TenPM)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pn_TrangChu.add(pn_Header);
		pn_Header.setBounds(0, 0, 1380, 135);

		lbl_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/B1.jpg")));
		pn_TrangChu.add(lbl_Background);
		lbl_Background.setBounds(0, 150, 1380, 540);

		JTB_QLLD.addTab("TRANG CHỦ", new javax.swing.ImageIcon(getClass().getResource("/images/bluehome.png")),
				pn_TrangChu, "TRANG CHỦ");

		pn_QuanLy.setBackground(new java.awt.Color(164, 211, 238));
		pn_QuanLy.setFont(new java.awt.Font("Tahoma", 1, 14));

		pn_DsNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH NHÂN VIÊN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		tbl_QLNV.setFont(new java.awt.Font("Tahoma", 0, 12));

//=====================================================QuanLyNhanVien================================================================		
		String[] headerNV = ("STT;Mã Nhân Viên;Tên Nhân Viên;Ngày Sinh;Giới Tính;Số CMND;Địa Chỉ;Số Điện Thoại;Chức Vụ;Phòng Ban")
				.split(";");
		modelNV = new DefaultTableModel(headerNV, 0);
		tbl_QLNV.setModel(modelNV);
		tbl_QLNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scroll_QLNV.setViewportView(tbl_QLNV);
		if (tbl_QLNV.getColumnModel().getColumnCount() > 0) {
			tbl_QLNV.getColumnModel().getColumn(0).setMinWidth(40);
			tbl_QLNV.getColumnModel().getColumn(0).setMaxWidth(40);
			tbl_QLNV.getColumnModel().getColumn(1).setMinWidth(100);
			tbl_QLNV.getColumnModel().getColumn(1).setMaxWidth(100);
			tbl_QLNV.getColumnModel().getColumn(2).setMinWidth(150);
			tbl_QLNV.getColumnModel().getColumn(2).setMaxWidth(150);
			tbl_QLNV.getColumnModel().getColumn(3).setMinWidth(80);
			tbl_QLNV.getColumnModel().getColumn(3).setMaxWidth(80);
			tbl_QLNV.getColumnModel().getColumn(4).setMinWidth(80);
			tbl_QLNV.getColumnModel().getColumn(4).setMaxWidth(80);
			tbl_QLNV.getColumnModel().getColumn(5).setMinWidth(85);
			tbl_QLNV.getColumnModel().getColumn(5).setMaxWidth(85);
			tbl_QLNV.getColumnModel().getColumn(6).setMinWidth(100);
			tbl_QLNV.getColumnModel().getColumn(6).setMaxWidth(100);
			tbl_QLNV.getColumnModel().getColumn(7).setMinWidth(100);
			tbl_QLNV.getColumnModel().getColumn(7).setMaxWidth(100);
			tbl_QLNV.getColumnModel().getColumn(8).setMinWidth(100);
			tbl_QLNV.getColumnModel().getColumn(8).setMaxWidth(100);
			tbl_QLNV.getColumnModel().getColumn(9).setMinWidth(100);
			tbl_QLNV.getColumnModel().getColumn(9).setMaxWidth(100);
		}

		tbl_QLNV.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int row = tbl_QLNV.getSelectedRow();
				String[] diaChi = modelNV.getValueAt(row, 6).toString().split(",");
				txt_nvMaNV.setText(modelNV.getValueAt(row, 1).toString());
				txt_nvTenNV.setText(modelNV.getValueAt(row, 2).toString());
				txt_nvCMND.setText(modelNV.getValueAt(row, 5).toString());
				txt_nvDiaChiNV.setText(diaChi[0]);
				cbb_nvPhuongXa.setSelectedItem(diaChi[1]);
				cbb_nvQuanHuyen.setSelectedItem(diaChi[2]);
				cbb_nvThanhPho.setSelectedItem(diaChi[3]);
				txt_nvSDT.setText(modelNV.getValueAt(row, 7).toString());
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelNV.getValueAt(row, 3));
					DateChooser_NamSinh.setDate(date);
				} catch (ParseException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				String gioiTinh = modelNV.getValueAt(row, 4).toString();
				if (gioiTinh.equalsIgnoreCase("Nam")) {
					Rbtn_Nam.setSelected(true);
				} else {
					Rbtn_Nu.setSelected(true);
				}
				cbb_nvChonChV.setSelectedItem(modelNV.getValueAt(row, 8).toString());
				cbb_nvChonPB.setSelectedItem(modelNV.getValueAt(row, 9).toString());

			}
		});

		javax.swing.GroupLayout pn_DsNhanVienLayout = new javax.swing.GroupLayout(pn_DsNhanVien);
		pn_DsNhanVien.setLayout(pn_DsNhanVienLayout);
		pn_DsNhanVienLayout
				.setHorizontalGroup(pn_DsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLNV, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE));
		pn_DsNhanVienLayout
				.setVerticalGroup(pn_DsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		lbl_TimPB.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimPB.setText("Phòng Ban:");

		lbl_TimTenNV.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimTenNV.setText("Tên Nhân Viên:");

		lbl_TimMaNV.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimMaNV.setText("Mã Nhân Viên:");

		lblTimNV.setFont(new java.awt.Font("Tahoma", 1, 36));
		lblTimNV.setText("TÌM KIẾM NHÂN VIÊN");

		cbb_nvTimPB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng Ban" }));
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT maPhongBan + '-' + tenPhongBan FROM tbl_PhongBan";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cbb_nvTimPB.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		AutoCompleteDecorator.decorate(cbb_nvTimPB);
		cbb_nvTimPB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					cbb_nvTimPBActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		lbl_TimChucVu.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimChucVu.setText("Chức Vụ:");

		cbb_nvTimChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chức Vụ" }));
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT tenChucVu FROM tbl_ChucVu";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cbb_nvTimChucVu.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		AutoCompleteDecorator.decorate(cbb_nvTimChucVu);
		cbb_nvTimChucVu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					cbb_nvTimChucVuActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_nvTimNV.setFont(new java.awt.Font("Tahoma", 0, 14));
		btn_nvTimNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loupe.png")));
		btn_nvTimNV.setText("TÌM KIẾM");
		btn_nvTimNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_nvTimNVActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		pn_nvThemNV.setBackground(new java.awt.Color(255, 255, 255));
		pn_nvThemNV.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "THÔNG TIN NHÂN VIÊN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_PB.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_PB.setText("Phòng Ban:");

		cbb_nvChonPB.setBackground(new java.awt.Color(198, 226, 255));
		cbb_nvChonPB.setFont(new java.awt.Font("Tahoma", 0, 12));
		cbb_nvChonPB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng Ban" }));
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT maPhongBan FROM tbl_PhongBan";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cbb_nvChonPB.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		AutoCompleteDecorator.decorate(cbb_nvChonPB);

		lbl_MaNV.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_MaNV.setText("Mã Nhân Viên:");

		lbl_TenNV.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_TenNV.setText("Họ Và Tên:");

		lbl_CMND.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_CMND.setText("Số CMND:");

		lbl_GT.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_GT.setText("Giới Tính:");

		Rbtn_Nam.setText("Nam");
		Rbtn_Nam.setToolTipText("");

		Rbtn_Nu.setText("Nữ");
		Rbtn_Nu.setToolTipText("");

		cbb_nvThanhPho.setBackground(new java.awt.Color(198, 226, 255));
		cbb_nvThanhPho.setFont(new java.awt.Font("Tahoma", 0, 12));
		cbb_nvThanhPho.setModel(new javax.swing.DefaultComboBoxModel<>());

		this.loadCBB_TP("SELECT * FROM TinhTP");

		AutoCompleteDecorator.decorate(cbb_nvThanhPho);
		cbb_nvThanhPho.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbb_nvThanhPhoActionPerformed(evt);
			}
		});

		String TP_ID = ((TinhTP) (Object) this.cbb_nvThanhPho.getSelectedItem()).getIdTP();

		cbb_nvQuanHuyen.setBackground(new java.awt.Color(198, 226, 255));
		cbb_nvQuanHuyen.setFont(new java.awt.Font("Tahoma", 0, 12));
		cbb_nvQuanHuyen.setModel(new javax.swing.DefaultComboBoxModel<>());
		this.loadCBB_QH("SELECT * FROM QUANHUYEN WHERE idTP = '" + TP_ID + "'");
		AutoCompleteDecorator.decorate(cbb_nvQuanHuyen);
		cbb_nvQuanHuyen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbb_nvQuanHuyenActionPerformed(evt);
			}
		});

		String QH_ID = ((QuanHuyen) (Object) this.cbb_nvQuanHuyen.getSelectedItem()).getIdQH();

		cbb_nvPhuongXa.setBackground(new java.awt.Color(198, 226, 255));
		cbb_nvPhuongXa.setFont(new java.awt.Font("Tahoma", 0, 12));
		cbb_nvPhuongXa.setModel(new javax.swing.DefaultComboBoxModel<>());
		this.loadCBB_PX("SELECT * FROM PHUONGXA WHERE idQH = '" + QH_ID + "'");
		AutoCompleteDecorator.decorate(cbb_nvPhuongXa);

//==============================================ButtonGroup1================================================================
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(Rbtn_Nam);
		buttonGroup1.add(Rbtn_Nu);

		cbb_nvChonChV.setBackground(new java.awt.Color(198, 226, 255));
		cbb_nvChonChV.setFont(new java.awt.Font("Tahoma", 0, 12));
		cbb_nvChonChV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chức Vụ" }));
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT tenChucVu FROM tbl_ChucVu";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cbb_nvChonChV.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		AutoCompleteDecorator.decorate(cbb_nvChonChV);

		cbb_nvChonChV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbb_nvChonChVActionPerformed(evt);
			}

			private void cbb_nvChonChVActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub

			}
		});

		lbl_ChVu.setFont(new java.awt.Font("Tahoma", 0, 12));
		lbl_ChVu.setText("Chức Vụ:");

		lbl_Tuoi.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_Tuoi.setText("Năm Sinh:");

		lbl_SDT.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_SDT.setText("Số Điện Thoại:");

		lbl_DiaChi.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_DiaChi.setText("Số nhà, tên đường:");

		lbl_ThemNV.setBackground(new java.awt.Color(204, 204, 255));
		lbl_ThemNV.setFont(new java.awt.Font("Tahoma", 1, 24));
		lbl_ThemNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee1.png")));
		lbl_ThemNV.setText("THÊM NHÂN VIÊN");

		btn_XoaNV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png")));
		btn_XoaNV.setText("Xóa");
		btn_XoaNV.setToolTipText("Xóa thông tin");
		btn_XoaNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_XoaNVActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_LuuNV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_LuuNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png")));
		btn_LuuNV.setText("Lưu");
		btn_LuuNV.setToolTipText("Lưu thông tin");
		btn_LuuNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_LuuNVActionPerformed(evt);
				} catch (HeadlessException | SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_CapNhatNV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_CapNhatNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png")));
		btn_CapNhatNV.setText("Cập Nhật");
		btn_CapNhatNV.setToolTipText("Cập nhật thông tin");
		btn_CapNhatNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_CapNhatNVActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_XoaTrangNV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaTrangNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh1.png")));
		btn_XoaTrangNV.setText("Xóa Trắng");
		btn_XoaTrangNV.setToolTipText("Xóa trắng");
		btn_XoaTrangNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaTrangNVActionPerformed(evt);
			}
		});

		lbl_DiaChi2.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_DiaChi2.setText("Tỉnh/Thành phố:");

		lbl_DiaChi3.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_DiaChi3.setText("Quận/Huyện:");

		lbl_DiaChi4.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_DiaChi4.setText("Phường/Xã:");

		javax.swing.GroupLayout pn_nvThemNVLayout = new javax.swing.GroupLayout(pn_nvThemNV);
		pn_nvThemNV.setLayout(pn_nvThemNVLayout);
		pn_nvThemNVLayout.setHorizontalGroup(pn_nvThemNVLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_nvThemNVLayout.createSequentialGroup().addContainerGap().addGroup(pn_nvThemNVLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_nvThemNVLayout.createSequentialGroup()
								.addGroup(
										pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_CMND).addComponent(lbl_TenNV).addComponent(lbl_MaNV))
								.addGap(48, 48, 48)
								.addGroup(pn_nvThemNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txt_nvTenNV, javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(pn_nvThemNVLayout.createSequentialGroup().addComponent(Rbtn_Nam)
												.addGap(32, 32, 32).addComponent(Rbtn_Nu).addGap(0, 0, Short.MAX_VALUE))
										.addComponent(DateChooser_NamSinh, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txt_nvMaNV)
										.addComponent(txt_nvCMND, javax.swing.GroupLayout.Alignment.TRAILING)))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_nvThemNVLayout
								.createSequentialGroup()
								.addGroup(pn_nvThemNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btn_LuuNV, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
												Short.MAX_VALUE)
										.addComponent(btn_XoaNV, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pn_nvThemNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btn_CapNhatNV, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btn_XoaTrangNV, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
												Short.MAX_VALUE)))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								pn_nvThemNVLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(
										lbl_ThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 309,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(pn_nvThemNVLayout.createSequentialGroup().addComponent(lbl_PB)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38,
										Short.MAX_VALUE)
								.addComponent(cbb_nvChonPB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(lbl_ChVu)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(cbb_nvChonChV, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(pn_nvThemNVLayout.createSequentialGroup().addGroup(pn_nvThemNVLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lbl_DiaChi)
								.addComponent(lbl_SDT).addComponent(lbl_GT).addComponent(lbl_Tuoi)
								.addComponent(lbl_DiaChi3).addComponent(lbl_DiaChi4).addComponent(lbl_DiaChi2))
								.addGap(14, 14, 14)
								.addGroup(pn_nvThemNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txt_nvDiaChiNV)
										.addComponent(cbb_nvThanhPho, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(txt_nvSDT)
										.addComponent(cbb_nvQuanHuyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(cbb_nvPhuongXa, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))))
						.addContainerGap()));
		pn_nvThemNVLayout.setVerticalGroup(pn_nvThemNVLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_nvThemNVLayout.createSequentialGroup()
						.addComponent(lbl_ThemNV).addGap(8, 8, 8)
						.addGroup(pn_nvThemNVLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
										javax.swing.GroupLayout.Alignment.TRAILING,
										pn_nvThemNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(cbb_nvChonPB, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lbl_ChVu, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cbb_nvChonChV, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_PB, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_MaNV).addComponent(txt_nvMaNV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_TenNV).addComponent(txt_nvTenNV,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_Tuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(DateChooser_NamSinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(Rbtn_Nam).addComponent(Rbtn_Nu).addComponent(lbl_GT))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_CMND).addComponent(txt_nvCMND, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_SDT).addComponent(txt_nvSDT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_DiaChi2).addComponent(cbb_nvThanhPho,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_DiaChi3)
								.addComponent(cbb_nvQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_DiaChi4).addComponent(cbb_nvPhuongXa,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_DiaChi).addComponent(txt_nvDiaChiNV,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
						.addGroup(pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_LuuNV, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_CapNhatNV, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								pn_nvThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btn_XoaTrangNV, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btn_XoaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		javax.swing.GroupLayout pn_QLNhanVienLayout = new javax.swing.GroupLayout(pn_QLNhanVien);
		pn_QLNhanVien.setLayout(pn_QLNhanVienLayout);
		pn_QLNhanVienLayout.setHorizontalGroup(pn_QLNhanVienLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_QLNhanVienLayout.createSequentialGroup()
						.addComponent(pn_nvThemNV, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(pn_QLNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_QLNhanVienLayout.createSequentialGroup().addGap(37, 37, 37)
										.addGroup(pn_QLNhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_TimTenNV).addComponent(lbl_TimMaNV)
												.addComponent(lbl_TimPB))
										.addGap(18, 18, 18)
										.addGroup(pn_QLNhanVienLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(pn_QLNhanVienLayout.createSequentialGroup()
														.addComponent(cbb_nvTimPB,
																javax.swing.GroupLayout.PREFERRED_SIZE, 151,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(47, 47, 47).addComponent(lbl_TimChucVu)
														.addGap(18, 18, 18).addComponent(cbb_nvTimChucVu, 0,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addComponent(txt_nvTimMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 426,
														Short.MAX_VALUE)
												.addComponent(txt_nvTimTenNV))
										.addGap(38, 38, 38).addComponent(btn_nvTimNV,
												javax.swing.GroupLayout.PREFERRED_SIZE, 151,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(pn_QLNhanVienLayout.createSequentialGroup().addGap(289, 289, 289)
										.addComponent(lblTimNV))
								.addGroup(pn_QLNhanVienLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(
										pn_DsNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(92, Short.MAX_VALUE)));
		pn_QLNhanVienLayout.setVerticalGroup(pn_QLNhanVienLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_QLNhanVienLayout.createSequentialGroup().addGroup(pn_QLNhanVienLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(pn_QLNhanVienLayout.createSequentialGroup().addContainerGap().addComponent(lblTimNV)
								.addGroup(pn_QLNhanVienLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(pn_QLNhanVienLayout.createSequentialGroup()
												.addGroup(pn_QLNhanVienLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(pn_QLNhanVienLayout.createSequentialGroup()
																.addGap(1, 1, 1).addComponent(lbl_TimPB,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 19,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(pn_QLNhanVienLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(cbb_nvTimPB,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(lbl_TimChucVu,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 19,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(cbb_nvTimChucVu,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(8, 8, 8)
												.addGroup(pn_QLNhanVienLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_TimMaNV,
																javax.swing.GroupLayout.PREFERRED_SIZE, 28,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txt_nvTimMaNV,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(pn_QLNhanVienLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_TimTenNV,
																javax.swing.GroupLayout.PREFERRED_SIZE, 16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txt_nvTimTenNV,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(btn_nvTimNV, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 63,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pn_DsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(pn_nvThemNV, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 0, Short.MAX_VALUE)));

		pn_QuanLy.addTab("NHÂN VIÊN", pn_QLNhanVien);

		pn_QuanLyCM.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "QUẢN LÝ CHUYÊN MÔN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_ChuyenMon.setFont(new java.awt.Font("Tahoma", 0, 20));
		lbl_ChuyenMon.setText("Chuyên Môn:");

//==============================================================QuanLyChuyenMon============================================================		
		String[] headerCM = ("STT;Mã Nhân Viên;Tên Nhân Viên;Ngày Sinh;Giới Tính;Số CMND;Địa Chỉ;Số Điện Thoại;Chuyên Môn;Chức Vụ;Phòng Ban")
				.split(";");
		modelCM = new DefaultTableModel(headerCM, 0);
		tbl_ChuyenMon.setModel(modelCM);
		tbl_ChuyenMon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scroll_QLCM.setViewportView(tbl_ChuyenMon);
		if (tbl_ChuyenMon.getColumnModel().getColumnCount() > 0) {
			tbl_ChuyenMon.getColumnModel().getColumn(0).setMinWidth(40);
			tbl_ChuyenMon.getColumnModel().getColumn(0).setMaxWidth(40);
			tbl_ChuyenMon.getColumnModel().getColumn(1).setMinWidth(100);
			tbl_ChuyenMon.getColumnModel().getColumn(1).setMaxWidth(100);
			tbl_ChuyenMon.getColumnModel().getColumn(2).setMinWidth(150);
			tbl_ChuyenMon.getColumnModel().getColumn(2).setMaxWidth(150);
			tbl_ChuyenMon.getColumnModel().getColumn(3).setMinWidth(100);
			tbl_ChuyenMon.getColumnModel().getColumn(3).setMaxWidth(100);
			tbl_ChuyenMon.getColumnModel().getColumn(4).setMinWidth(80);
			tbl_ChuyenMon.getColumnModel().getColumn(4).setMaxWidth(80);
			tbl_ChuyenMon.getColumnModel().getColumn(5).setMinWidth(100);
			tbl_ChuyenMon.getColumnModel().getColumn(5).setMaxWidth(100);
			tbl_ChuyenMon.getColumnModel().getColumn(6).setMinWidth(250);
			tbl_ChuyenMon.getColumnModel().getColumn(6).setMaxWidth(250);
			tbl_ChuyenMon.getColumnModel().getColumn(7).setMinWidth(150);
			tbl_ChuyenMon.getColumnModel().getColumn(7).setMaxWidth(150);
			tbl_ChuyenMon.getColumnModel().getColumn(8).setMinWidth(130);
			tbl_ChuyenMon.getColumnModel().getColumn(8).setMaxWidth(130);
			tbl_ChuyenMon.getColumnModel().getColumn(9).setMinWidth(150);
			tbl_ChuyenMon.getColumnModel().getColumn(9).setMaxWidth(150);
			tbl_ChuyenMon.getColumnModel().getColumn(10).setMinWidth(100);
			tbl_ChuyenMon.getColumnModel().getColumn(10).setMaxWidth(100);
		}

		cbb_TimCM.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Chọn Chuyên Môn", "Kỹ Sư", "Quản Lý", "Kinh Tế", "Công Nhân" }));
		cbb_TimCM.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					cbb_TimCMActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout pn_QuanLyCMLayout = new javax.swing.GroupLayout(pn_QuanLyCM);
		pn_QuanLyCM.setLayout(pn_QuanLyCMLayout);
		pn_QuanLyCMLayout
				.setHorizontalGroup(
						pn_QuanLyCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(scroll_QLCM)
								.addGroup(pn_QuanLyCMLayout.createSequentialGroup().addGap(347, 347, 347)
										.addComponent(lbl_ChuyenMon).addGap(18, 18, 18)
										.addComponent(cbb_TimCM, javax.swing.GroupLayout.PREFERRED_SIZE, 309,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(539, Short.MAX_VALUE)));
		pn_QuanLyCMLayout.setVerticalGroup(pn_QuanLyCMLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_QuanLyCMLayout.createSequentialGroup()
						.addGap(21, 21, 21)
						.addGroup(pn_QuanLyCMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_ChuyenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbb_TimCM, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(34, 34, 34).addComponent(scroll_QLCM, javax.swing.GroupLayout.PREFERRED_SIZE, 513,
								javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout pn_QLChuyenMonLayout = new javax.swing.GroupLayout(pn_QLChuyenMon);
		pn_QLChuyenMon.setLayout(pn_QLChuyenMonLayout);
		pn_QLChuyenMonLayout
				.setHorizontalGroup(pn_QLChuyenMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_QLChuyenMonLayout.createSequentialGroup()
								.addComponent(pn_QuanLyCM, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 74, Short.MAX_VALUE)));
		pn_QLChuyenMonLayout
				.setVerticalGroup(pn_QLChuyenMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_QLChuyenMonLayout.createSequentialGroup().addComponent(pn_QuanLyCM,
								javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)));

		pn_QuanLy.addTab("CHUYÊN MÔN", pn_QLChuyenMon);

		pn_ThemPB.setBackground(new java.awt.Color(255, 255, 255));
		pn_ThemPB.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "THÔNG TIN PHÒNG BAN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_ThemPB.setFont(new java.awt.Font("Tahoma", 1, 24));
		lbl_ThemPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/meeting-room.png")));
		lbl_ThemPB.setText(" THÊM PHÒNG BAN");

		lbl_MaPB.setFont(new java.awt.Font("Tahoma", 1, 15));
		lbl_MaPB.setText("Mã Phòng Ban:");

		lbl_TenPB.setFont(new java.awt.Font("Tahoma", 1, 15));
		lbl_TenPB.setText("Tên Phòng Ban:");

		lbl_Hotline.setFont(new java.awt.Font("Tahoma", 1, 15));
		lbl_Hotline.setText("Hotline:");

		lbl_GhiChu.setFont(new java.awt.Font("Tahoma", 1, 15));
		lbl_GhiChu.setText("Mô Tả:");

		txt_pbMoTa.setColumns(20);
		txt_pbMoTa.setRows(5);
		scroll_GhiChu.setViewportView(txt_pbMoTa);

		btn_XoaPB.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png")));
		btn_XoaPB.setText("Xóa");
		btn_XoaPB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_XoaPBActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_LuuPB.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_LuuPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png")));
		btn_LuuPB.setText("Lưu");
		btn_LuuPB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_LuuPBActionPerformed(evt);
				} catch (HeadlessException | SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_CapNhatPB.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_CapNhatPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png")));
		btn_CapNhatPB.setText("Cập Nhật");
		btn_CapNhatPB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_CapNhatPBActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_XoaTrangPB.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaTrangPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh1.png")));
		btn_XoaTrangPB.setText("Xóa Trắng");
		btn_XoaTrangPB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaTrangPBActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pn_ThemPBLayout = new javax.swing.GroupLayout(pn_ThemPB);
		pn_ThemPB.setLayout(pn_ThemPBLayout);
		pn_ThemPBLayout.setHorizontalGroup(
				pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pn_ThemPBLayout
						.createSequentialGroup().addGroup(pn_ThemPBLayout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(pn_ThemPBLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(
										pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addGroup(pn_ThemPBLayout.createSequentialGroup().addComponent(lbl_MaPB)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(txt_pbMaPB,
																javax.swing.GroupLayout.PREFERRED_SIZE, 215,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(pn_ThemPBLayout
														.createSequentialGroup().addComponent(lbl_TenPB).addGap(6, 6, 6)
														.addComponent(txt_pbTenPB,
																javax.swing.GroupLayout.PREFERRED_SIZE, 214,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(pn_ThemPBLayout.createSequentialGroup()
														.addGroup(pn_ThemPBLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(lbl_Hotline).addComponent(lbl_GhiChu))
														.addGroup(pn_ThemPBLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(pn_ThemPBLayout.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(scroll_GhiChu,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				213,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(pn_ThemPBLayout.createSequentialGroup()
																		.addGap(61, 61, 61)
																		.addComponent(txt_pbHotline)))))
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(pn_ThemPBLayout.createSequentialGroup().addContainerGap()
										.addGroup(pn_ThemPBLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btn_LuuPB, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btn_XoaPB, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40,
												Short.MAX_VALUE)
										.addGroup(pn_ThemPBLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btn_XoaTrangPB, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
														Short.MAX_VALUE)
												.addComponent(btn_CapNhatPB, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap())
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThemPBLayout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE).addComponent(lbl_ThemPB).addGap(36, 36, 36)));
		pn_ThemPBLayout.setVerticalGroup(pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThemPBLayout.createSequentialGroup()
						.addGap(23, 23, 23).addComponent(lbl_ThemPB).addGap(44, 44, 44)
						.addGroup(pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_MaPB).addComponent(txt_pbMaPB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(36, 36, 36)
						.addGroup(pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_TenPB)
								.addComponent(txt_pbTenPB, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(34, 34, 34)
						.addGroup(pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_Hotline)
								.addComponent(txt_pbHotline, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(34, 34, 34)
						.addGroup(pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_GhiChu)
								.addComponent(scroll_GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(31, 31, 31)
						.addGroup(pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btn_CapNhatPB, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
								.addComponent(btn_LuuPB, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 26, Short.MAX_VALUE)
						.addGroup(pn_ThemPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btn_XoaTrangPB, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
								.addComponent(btn_XoaPB, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(32, 32, 32)));

		pn_DsPhongBan.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH PHÒNG BAN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
//===============================================QuanLyPhongBan=================================================================
		String[] headerPB = ("STT;Mã Phòng Ban;Tên Phòng Ban;Hotline;Mô Tả").split(";");
		modelPB = new DefaultTableModel(headerPB, 0);
		tbl_QLPB.setModel(modelPB);
		scroll_QLPB.setViewportView(tbl_QLPB);
		if (tbl_QLPB.getColumnModel().getColumnCount() > 0) {
			tbl_QLPB.getColumnModel().getColumn(0).setMinWidth(50);
			tbl_QLPB.getColumnModel().getColumn(0).setMaxWidth(50);
			tbl_QLPB.getColumnModel().getColumn(1).setResizable(false);
			tbl_QLPB.getColumnModel().getColumn(4).setResizable(false);
		}
		tbl_QLPB.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tbl_QLPB.getSelectedRow();
				txt_pbMaPB.setText(modelPB.getValueAt(row, 1).toString());
				txt_pbTenPB.setText(modelPB.getValueAt(row, 2).toString());
				txt_pbHotline.setText(modelPB.getValueAt(row, 3).toString());
				txt_pbMoTa.setText(modelPB.getValueAt(row, 4).toString());

			}
		});

		javax.swing.GroupLayout pn_DsPhongBanLayout = new javax.swing.GroupLayout(pn_DsPhongBan);
		pn_DsPhongBan.setLayout(pn_DsPhongBanLayout);
		pn_DsPhongBanLayout
				.setHorizontalGroup(pn_DsPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLPB, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE));
		pn_DsPhongBanLayout
				.setVerticalGroup(pn_DsPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLPB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		lbl_TKPB.setFont(new java.awt.Font("Tahoma", 1, 36));
		lbl_TKPB.setText("TÌM KIẾM PHÒNG BAN");

		lbl_TimMaPB.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimMaPB.setText("Mã Phòng Ban:");

		lbl_TimTenPB.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimTenPB.setText("Tên Phòng Ban:");

		btn_pbTimPB.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_pbTimPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loupe.png")));
		btn_pbTimPB.setText("TÌM KIẾM");
		btn_pbTimPB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_pbTimPBActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

//		txt_pbTimMaPB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Phòng Ban" }));
//		try {
//			Connection con = ConnectDB.getConnect();
//			String sql = "SELECT maPhongBan FROM tbl_PhongBan";
//			Statement statement = con.createStatement();
//			ResultSet resultSet = statement.executeQuery(sql);
//			while (resultSet.next()) {
//				txt_pbTimMaPB.addItem(resultSet.getString(1));
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		AutoCompleteDecorator.decorate(txt_pbTimMaPB);
		txt_pbTimMaPB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txt_pbTimMaPBActionPerformed(evt);
			}

			private void txt_pbTimMaPBActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub

			}
		});

		javax.swing.GroupLayout pn_QLPhongBanLayout = new javax.swing.GroupLayout(pn_QLPhongBan);
		pn_QLPhongBan.setLayout(pn_QLPhongBanLayout);
		pn_QLPhongBanLayout.setHorizontalGroup(pn_QLPhongBanLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_QLPhongBanLayout.createSequentialGroup()
						.addComponent(pn_ThemPB, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(pn_QLPhongBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_QLPhongBanLayout.createSequentialGroup().addGap(10, 10, 10)
										.addGroup(pn_QLPhongBanLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_TimMaPB).addComponent(lbl_TimTenPB))
										.addGap(27, 27, 27)
										.addGroup(pn_QLPhongBanLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txt_pbTimTenPB, javax.swing.GroupLayout.PREFERRED_SIZE,
														426, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_pbTimMaPB, javax.swing.GroupLayout.PREFERRED_SIZE,
														426, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18).addComponent(btn_pbTimPB,
												javax.swing.GroupLayout.PREFERRED_SIZE, 150,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(pn_QLPhongBanLayout.createSequentialGroup().addGap(292, 292, 292)
										.addComponent(lbl_TKPB))
								.addGroup(pn_QLPhongBanLayout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pn_DsPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pn_QLPhongBanLayout.setVerticalGroup(pn_QLPhongBanLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_QLPhongBanLayout.createSequentialGroup().addGroup(pn_QLPhongBanLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(pn_QLPhongBanLayout.createSequentialGroup().addContainerGap().addComponent(lbl_TKPB)
								.addGap(57, 57, 57)
								.addGroup(pn_QLPhongBanLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_QLPhongBanLayout
												.createSequentialGroup()
												.addGroup(pn_QLPhongBanLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_TimMaPB).addComponent(txt_pbTimMaPB,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18)
												.addGroup(pn_QLPhongBanLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(txt_pbTimTenPB,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(lbl_TimTenPB,
																javax.swing.GroupLayout.PREFERRED_SIZE, 16,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(btn_pbTimPB, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 66,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18).addComponent(pn_DsPhongBan, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(pn_ThemPB, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 0, Short.MAX_VALUE)));

		pn_QuanLy.addTab("PHÒNG BAN", pn_QLPhongBan);

		pn_ThemCT.setBackground(new java.awt.Color(255, 255, 255));
		pn_ThemCT.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "THÔNG TIN CÔNG TRÌNH",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_ThemCT.setFont(new java.awt.Font("Tahoma", 1, 24));
		lbl_ThemCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sketch.png")));
		lbl_ThemCT.setText(" THÊM CÔNG TRÌNH");

		lbl_MaCT.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_MaCT.setText("Mã Công Trình:");

		lbl_TenCT.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_TenCT.setText("Tên Công Trình:");

		lbl_DiaChiCT.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_DiaChiCT.setText("Địa Chỉ:");

		lbl_NgayHT.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_NgayHT.setText("Ngày Hoàn Thành:");

		lbl_NgayKC.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_NgayKC.setText("Ngày Khởi Công:");

		lbl_NgayCP.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_NgayCP.setText("Ngày Cấp Phép:");

		btn_LuuCT.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_LuuCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png")));
		btn_LuuCT.setText("Lưu");
		btn_LuuCT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_LuuCTActionPerformed(evt);
				} catch (HeadlessException | SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_XoaCT.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png")));
		btn_XoaCT.setText("Xóa");
		btn_XoaCT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_XoaCTActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_XoaTrangCT.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaTrangCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh1.png")));
		btn_XoaTrangCT.setText("Xóa Trắng");
		btn_XoaTrangCT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaTrangCTActionPerformed(evt);
			}
		});

		btn_CapNhatCT.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_CapNhatCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png")));
		btn_CapNhatCT.setText("Cập Nhật");
		btn_CapNhatCT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_CapNhatCTActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		lbl_TrangThai.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_TrangThai.setText("Trạng Thái:");

		Rbtn_TrangThaiDHT.setFont(new java.awt.Font("Tahoma", 0, 12));
		Rbtn_TrangThaiDHT.setText("Đã Hoàn Thành");
		Rbtn_TrangThaiDHT.setToolTipText("");
		Rbtn_TrangThaiDHT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Rbtn_TrangThaiDHTActionPerformed(evt);
			}
		});

		Rbtn_TrangThaiCHT.setFont(new java.awt.Font("Tahoma", 0, 12));
		Rbtn_TrangThaiCHT.setText("Chưa Hoàn Thành");
		Rbtn_TrangThaiCHT.setToolTipText("");

//=========================================ButtonGroup2===========================================================
		ButtonGroup buttonGroup2 = new ButtonGroup();
		buttonGroup2.add(Rbtn_TrangThaiDHT);
		buttonGroup2.add(Rbtn_TrangThaiCHT);

		cbb_ctQuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
		this.loadCBB_QHFCT("SELECT * FROM QuanHuyen WHERE idTP = '79'");
		cbb_ctQuan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbb_ctQuanActionPerformed(evt);
			}
		});
		AutoCompleteDecorator.decorate(cbb_ctQuan);
		cbb_ctPhuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
		AutoCompleteDecorator.decorate(cbb_ctPhuong);
		lbl_DiaChi5.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_DiaChi5.setText("Số nhà, tên đường:");

		lbl_GiayPhepSo.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_GiayPhepSo.setText("Giấy Phép Số:");

		lbl_LoaiHinh.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_LoaiHinh.setText("Loại hình:");

		cbb_ctLoaiHinhCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dân Dụng", "Công Nghiệp" }));

		AutoCompleteDecorator.decorate(cbb_ctLoaiHinhCT);
		javax.swing.GroupLayout pn_ThemCTLayout = new javax.swing.GroupLayout(pn_ThemCT);
		pn_ThemCT.setLayout(pn_ThemCTLayout);
		pn_ThemCTLayout.setHorizontalGroup(pn_ThemCTLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						pn_ThemCTLayout.createSequentialGroup().addContainerGap(41, Short.MAX_VALUE)
								.addComponent(lbl_ThemCT).addGap(28, 28, 28))
				.addGroup(pn_ThemCTLayout.createSequentialGroup().addContainerGap()
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_ThemCTLayout.createSequentialGroup()
										.addGroup(pn_ThemCTLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btn_LuuCT, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btn_XoaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(pn_ThemCTLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btn_CapNhatCT, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btn_XoaTrangCT, javax.swing.GroupLayout.PREFERRED_SIZE,
														150, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(16, 16, 16))
								.addComponent(lbl_TenCT).addComponent(lbl_MaCT)
								.addGroup(pn_ThemCTLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												pn_ThemCTLayout.createSequentialGroup().addComponent(lbl_GiayPhepSo)
														.addGap(42, 42, 42).addComponent(txt_ctSoGiayPhep))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
												pn_ThemCTLayout.createSequentialGroup().addComponent(lbl_LoaiHinh)
														.addGap(70, 70, 70).addComponent(cbb_ctLoaiHinhCT,
																javax.swing.GroupLayout.PREFERRED_SIZE, 199,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(pn_ThemCTLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
										.addGroup(pn_ThemCTLayout.createSequentialGroup().addComponent(lbl_TrangThai)
												.addGap(15, 15, 15).addComponent(Rbtn_TrangThaiDHT)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(Rbtn_TrangThaiCHT))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_ThemCTLayout
												.createSequentialGroup()
												.addGroup(pn_ThemCTLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lbl_NgayKC).addComponent(lbl_NgayHT))
												.addGap(7, 7, 7)
												.addGroup(pn_ThemCTLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(DateChooser_ctNgayKC,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(
																DateChooser_ctNgayHT,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_ThemCTLayout
												.createSequentialGroup()
												.addGroup(pn_ThemCTLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																lbl_NgayCP)
														.addComponent(lbl_DiaChiCT).addComponent(lbl_DiaChi5,
																javax.swing.GroupLayout.PREFERRED_SIZE, 123,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(pn_ThemCTLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(pn_ThemCTLayout.createSequentialGroup()
																.addGap(14, 14, 14)
																.addGroup(pn_ThemCTLayout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(DateChooser_ctNgayCP,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(pn_ThemCTLayout
																				.createSequentialGroup()
																				.addGroup(pn_ThemCTLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(pn_ThemCTLayout
																								.createSequentialGroup()
																								.addComponent(
																										cbb_ctQuan,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										92,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addGap(18, 18, 18)
																								.addComponent(
																										cbb_ctPhuong,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										90,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(txt_ctTenCT,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								199,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(txt_ctMaCT,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								199,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGap(0, 1, Short.MAX_VALUE))))
														.addGroup(pn_ThemCTLayout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(txt_ctDiaChiCT,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 201,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, Short.MAX_VALUE))))))
						.addGap(1, 1, 1)));
		pn_ThemCTLayout.setVerticalGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThemCTLayout.createSequentialGroup()
						.addComponent(lbl_ThemCT).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_MaCT).addComponent(txt_ctMaCT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_TenCT)
								.addComponent(txt_ctTenCT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cbb_ctQuan, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbb_ctPhuong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_DiaChiCT))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_DiaChi5)
								.addComponent(txt_ctDiaChiCT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_LoaiHinh).addComponent(cbb_ctLoaiHinhCT,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_GiayPhepSo).addComponent(txt_ctSoGiayPhep,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(DateChooser_ctNgayCP, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_NgayCP))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_NgayKC)
								.addComponent(DateChooser_ctNgayKC, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_NgayHT).addComponent(DateChooser_ctNgayHT,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_ThemCTLayout.createSequentialGroup().addGap(23, 23, 23)
										.addComponent(lbl_TrangThai))
								.addGroup(pn_ThemCTLayout.createSequentialGroup().addGap(18, 18, 18)
										.addGroup(pn_ThemCTLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(Rbtn_TrangThaiDHT, javax.swing.GroupLayout.PREFERRED_SIZE,
														25, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(Rbtn_TrangThaiCHT, javax.swing.GroupLayout.PREFERRED_SIZE,
														25, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_LuuCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_CapNhatCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_XoaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_XoaTrangCT, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		pn_DsCongTrinh.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH CÔNG TRÌNH",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

//================================================QuanLyCongTrinh====================================================================
		String[] headerCT = ("STT;Mã Công Trình;Tên Công Trình;Địa Chỉ;Loại Hình;Giấy Phép Số;Ngày Cấp Phép;Ngày Khởi Công;Ngày Hoàn Thành;Trạng Thái")
				.split(";");
		modelCT = new DefaultTableModel(headerCT, 0);
		tbl_QLCT.setModel(modelCT);
		tbl_QLCT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scroll_QLCT.setViewportView(tbl_QLCT);
		if (tbl_QLCT.getColumnModel().getColumnCount() > 0) {
			tbl_QLCT.getColumnModel().getColumn(0).setMinWidth(40);
			tbl_QLCT.getColumnModel().getColumn(0).setMaxWidth(40);
			tbl_QLCT.getColumnModel().getColumn(1).setMinWidth(100);
			tbl_QLCT.getColumnModel().getColumn(1).setMaxWidth(100);
			tbl_QLCT.getColumnModel().getColumn(2).setMinWidth(150);
			tbl_QLCT.getColumnModel().getColumn(2).setMaxWidth(150);
			tbl_QLCT.getColumnModel().getColumn(3).setMinWidth(160);
			tbl_QLCT.getColumnModel().getColumn(3).setMaxWidth(160);
			tbl_QLCT.getColumnModel().getColumn(4).setMinWidth(120);
			tbl_QLCT.getColumnModel().getColumn(4).setMaxWidth(120);
			tbl_QLCT.getColumnModel().getColumn(5).setMinWidth(120);
			tbl_QLCT.getColumnModel().getColumn(5).setMaxWidth(120);
			tbl_QLCT.getColumnModel().getColumn(6).setMinWidth(120);
			tbl_QLCT.getColumnModel().getColumn(6).setMaxWidth(120);
			tbl_QLCT.getColumnModel().getColumn(7).setMinWidth(130);
			tbl_QLCT.getColumnModel().getColumn(7).setMaxWidth(130);
			tbl_QLCT.getColumnModel().getColumn(8).setMinWidth(130);
			tbl_QLCT.getColumnModel().getColumn(8).setMaxWidth(130);
			tbl_QLCT.getColumnModel().getColumn(9).setMinWidth(150);
			tbl_QLCT.getColumnModel().getColumn(9).setMaxWidth(150);
		}
		tbl_QLCT.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				int row = tbl_QLCT.getSelectedRow();
				String[] diaChi = modelCT.getValueAt(row, 3).toString().split(",");
				txt_ctMaCT.setText(modelCT.getValueAt(row, 1).toString());
				txt_ctTenCT.setText(modelCT.getValueAt(row, 2).toString());
				txt_ctDiaChiCT.setText(diaChi[0]);
				cbb_ctQuan.setSelectedItem(diaChi[2]);
				cbb_ctPhuong.setSelectedItem(diaChi[1]);
				txt_ctSoGiayPhep.setText(modelCT.getValueAt(row, 5).toString());
				cbb_ctLoaiHinhCT.setSelectedItem(modelCT.getValueAt(row, 4).toString());
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelCT.getValueAt(row, 6));
					DateChooser_ctNgayCP.setDate(date);
				} catch (ParseException e1) {

					e1.printStackTrace();
				}

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelCT.getValueAt(row, 7));
					DateChooser_ctNgayKC.setDate(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelCT.getValueAt(row, 8));
					DateChooser_ctNgayHT.setDate(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String trangThai = modelCT.getValueAt(row, 9).toString();
				if (trangThai.equalsIgnoreCase("Đã Hoàn Thành")) {
					Rbtn_TrangThaiDHT.setSelected(true);
				} else {
					Rbtn_TrangThaiCHT.setSelected(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

//				int row = tbl_QLCT.getSelectedRow();
//				txt_ctMaCT.setText(modelCT.getValueAt(row, 1).toString());
//				txt_ctTenCT.setText(modelCT.getValueAt(row, 2).toString());
//				String[] diaChi = modelCT.getValueAt(row, 3).toString().split(",");
//				txt_ctDiaChiCT.setText(diaChi[0]);
//				cbb_ctQuan.setSelectedItem(diaChi[2]);
//				cbb_ctPhuong.setSelectedItem(diaChi[1]);
//				txt_ctSoGiayPhep.setText(modelCT.getValueAt(row, 5).toString());
//				cbb_ctLoaiHinhCT.setSelectedItem(modelCT.getValueAt(row, 4).toString());
//				try {
//					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelCT.getValueAt(row, 6));
//					DateChooser_ctNgayCP.setDate(date);
//				} catch (ParseException e1) {
//
//					e1.printStackTrace();
//				}
//
//				try {
//					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelCT.getValueAt(row, 7));
//					DateChooser_ctNgayKC.setDate(date);
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//				}
//
//				try {
//					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelCT.getValueAt(row, 8));
//					DateChooser_ctNgayHT.setDate(date);
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//				}
//				String trangThai = modelCT.getValueAt(row, 9).toString();
//				if (trangThai.equalsIgnoreCase("Đã Hoàn Thành")) {
//					Rbtn_TrangThaiDHT.setSelected(true);
//				} else {
//					Rbtn_TrangThaiCHT.setSelected(true);
//				}

			}
		});

		javax.swing.GroupLayout pn_DsCongTrinhLayout = new javax.swing.GroupLayout(pn_DsCongTrinh);
		pn_DsCongTrinh.setLayout(pn_DsCongTrinhLayout);
		pn_DsCongTrinhLayout
				.setHorizontalGroup(pn_DsCongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLCT, javax.swing.GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE));
		pn_DsCongTrinhLayout.setVerticalGroup(pn_DsCongTrinhLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(scroll_QLCT));

		lbl_TKCT.setFont(new java.awt.Font("Tahoma", 1, 36));
		lbl_TKCT.setText("TÌM KIẾM CÔNG TRÌNH");

		lbl_TimMaCT.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimMaCT.setText("Mã Công Trình:");

		lbl_TimTenCT.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimTenCT.setText("Tên Công Trình:");

		btn_ctTimCT.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_ctTimCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loupe.png")));
		btn_ctTimCT.setText("TÌM KIẾM");
		btn_ctTimCT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_ctTimCTActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		cbb_ctLoaiHinhCT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					cbb_ctLoaiHinhCTActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});
		javax.swing.GroupLayout pn_QLCongTrinhLayout = new javax.swing.GroupLayout(pn_QLCongTrinh);
		pn_QLCongTrinh.setLayout(pn_QLCongTrinhLayout);
		pn_QLCongTrinhLayout.setHorizontalGroup(pn_QLCongTrinhLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_QLCongTrinhLayout.createSequentialGroup()
						.addComponent(pn_ThemCT, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_QLCongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_QLCongTrinhLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(pn_DsCongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(pn_QLCongTrinhLayout.createSequentialGroup()
												.addGroup(pn_QLCongTrinhLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lbl_TimTenCT,
																javax.swing.GroupLayout.DEFAULT_SIZE, 145,
																Short.MAX_VALUE)
														.addGroup(pn_QLCongTrinhLayout.createSequentialGroup()
																.addComponent(lbl_TimMaCT,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 118,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, Short.MAX_VALUE)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(pn_QLCongTrinhLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txt_ctTimTenCT,
																javax.swing.GroupLayout.PREFERRED_SIZE, 335,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txt_ctTimMaCT,
																javax.swing.GroupLayout.PREFERRED_SIZE, 335,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(461, 461, 461)))
								.addGroup(pn_QLCongTrinhLayout.createSequentialGroup().addGap(240, 240, 240)
										.addGroup(pn_QLCongTrinhLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(btn_ctTimCT, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lbl_TKCT))))
						.addContainerGap(6, Short.MAX_VALUE)));
		pn_QLCongTrinhLayout.setVerticalGroup(pn_QLCongTrinhLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_QLCongTrinhLayout.createSequentialGroup().addGroup(pn_QLCongTrinhLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addGroup(pn_QLCongTrinhLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(lbl_TKCT)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(pn_QLCongTrinhLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(pn_QLCongTrinhLayout.createSequentialGroup()
												.addGroup(pn_QLCongTrinhLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_TimMaCT,
																javax.swing.GroupLayout.PREFERRED_SIZE, 16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txt_ctTimMaCT,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addGroup(pn_QLCongTrinhLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_TimTenCT,
																javax.swing.GroupLayout.PREFERRED_SIZE, 19,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txt_ctTimTenCT,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(23, 23, 23))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_QLCongTrinhLayout
												.createSequentialGroup()
												.addComponent(btn_ctTimCT, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)))
								.addComponent(pn_DsCongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(pn_ThemCT, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(0, 60, Short.MAX_VALUE)));

		pn_QuanLy.addTab("CÔNG TRÌNH", pn_QLCongTrinh);

		pn_CongViec.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "CÔNG VIỆC",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		pn_ThemCongViec.setBackground(new java.awt.Color(255, 255, 255));
		pn_ThemCongViec.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "THÔNG TIN CÔNG VIỆC",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_cvThemCongViec.setFont(new java.awt.Font("Tahoma", 1, 24));
		lbl_cvThemCongViec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/job-search.png")));
		lbl_cvThemCongViec.setText(" THÊM CÔNG VIỆC");

		lbl_MaCongViec.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_MaCongViec.setText("Mã Công Việc:");

		lbl_TenCongViec.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_TenCongViec.setText("Tên Công Việc:");

		btn_LuuCV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_LuuCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png")));
		btn_LuuCV.setText("Lưu");
		btn_LuuCV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_LuuCVActionPerformed(evt);
				} catch (HeadlessException | SQLException e) {
					e.printStackTrace();
				}
			}
		});

		btn_XoaCV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png")));
		btn_XoaCV.setText("Xóa");
		btn_XoaCV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_XoaCVActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		btn_XoaTrangCV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaTrangCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh1.png")));
		btn_XoaTrangCV.setText("Xóa Trắng");
		btn_XoaTrangCV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaTrangCVActionPerformed(evt);
			}
		});

		btn_CapNhatCV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_CapNhatCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png")));
		btn_CapNhatCV.setText("Cập Nhật");
		btn_CapNhatCV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_CapNhatCVActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		txt_cvMoTaCV.setColumns(20);
		txt_cvMoTaCV.setRows(5);
		scroll_MoTaCongViec.setViewportView(txt_cvMoTaCV);

		lbl_MoTaCV.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_MoTaCV.setText("Mô Tả:");

		javax.swing.GroupLayout pn_ThemCongViecLayout = new javax.swing.GroupLayout(pn_ThemCongViec);
		pn_ThemCongViec.setLayout(pn_ThemCongViecLayout);
		pn_ThemCongViecLayout.setHorizontalGroup(pn_ThemCongViecLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_ThemCongViecLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pn_ThemCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(pn_ThemCongViecLayout.createSequentialGroup()
										.addGroup(pn_ThemCongViecLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(btn_LuuCV, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(btn_XoaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(34, 34, 34)
										.addGroup(pn_ThemCongViecLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btn_CapNhatCV, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btn_XoaTrangCV)))
								.addGroup(pn_ThemCongViecLayout.createSequentialGroup().addComponent(lbl_cvThemCongViec)
										.addGap(32, 32, 32))
								.addGroup(pn_ThemCongViecLayout.createSequentialGroup()
										.addGroup(pn_ThemCongViecLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_TenCongViec).addComponent(lbl_MaCongViec)
												.addComponent(lbl_MoTaCV))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(pn_ThemCongViecLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(scroll_MoTaCongViec,
														javax.swing.GroupLayout.PREFERRED_SIZE, 224,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_cvTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, 224,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_cvMaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 224,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pn_ThemCongViecLayout.setVerticalGroup(pn_ThemCongViecLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThemCongViecLayout.createSequentialGroup()
						.addComponent(lbl_cvThemCongViec)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_ThemCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_MaCongViec).addComponent(txt_cvMaCV,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThemCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_TenCongViec).addComponent(txt_cvTenCV,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThemCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_MoTaCV).addComponent(scroll_MoTaCongViec,
										javax.swing.GroupLayout.PREFERRED_SIZE, 82,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemCongViecLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btn_LuuCV, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_CapNhatCV, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_XoaCV, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_XoaTrangCV, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(18, Short.MAX_VALUE)));

		pn_dsCongViec.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH CÔNG VIỆC ",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

//===============================================QuanLyCongViec=================================================================		
		String[] headerCV = ("STT;Mã Công Việc;Tên Công Việc;Mô Tả").split(";");
		modelCV = new DefaultTableModel(headerCV, 0);
		tbl_QLCV.setModel(modelCV);

		scroll_QLCV.setViewportView(tbl_QLCV);
		if (tbl_QLCV.getColumnModel().getColumnCount() > 0) {
			tbl_QLCV.getColumnModel().getColumn(0).setMinWidth(50);
			tbl_QLCV.getColumnModel().getColumn(0).setMaxWidth(50);
		}
		tbl_QLCV.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

				int row = tbl_QLCV.getSelectedRow();
				txt_cvMaCV.setText(modelCV.getValueAt(row, 1).toString());
				txt_cvTenCV.setText(modelCV.getValueAt(row, 2).toString());
				txt_cvMoTaCV.setText(modelCV.getValueAt(row, 3).toString());

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		javax.swing.GroupLayout pn_dsCongViecLayout = new javax.swing.GroupLayout(pn_dsCongViec);
		pn_dsCongViec.setLayout(pn_dsCongViecLayout);
		pn_dsCongViecLayout
				.setHorizontalGroup(pn_dsCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLCV, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE));
		pn_dsCongViecLayout
				.setVerticalGroup(pn_dsCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLCV, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		javax.swing.GroupLayout pn_CongViecLayout = new javax.swing.GroupLayout(pn_CongViec);
		pn_CongViec.setLayout(pn_CongViecLayout);
		pn_CongViecLayout.setHorizontalGroup(pn_CongViecLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_CongViecLayout.createSequentialGroup().addGap(6, 6, 6)
						.addGroup(pn_CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pn_ThemCongViec, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pn_dsCongViec, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		pn_CongViecLayout
				.setVerticalGroup(pn_CongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_CongViecLayout.createSequentialGroup()
								.addComponent(pn_ThemCongViec, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pn_dsCongViec, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pn_ChucVu.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Chức Vụ",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		pn_ThemChucVu.setBackground(new java.awt.Color(255, 255, 255));
		pn_ThemChucVu.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "THÔNG TIN CHỨC VỤ",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_cvThemChucVu.setFont(new java.awt.Font("Tahoma", 1, 24));
		lbl_cvThemChucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/career-promotion.png")));
		lbl_cvThemChucVu.setText(" THÊM CHỨC VỤ");

		lbl_MaChucVu.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_MaChucVu.setText("Mã Chức Vụ:");

		lbl_TenChucVu.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_TenChucVu.setText("Tên Chức Vụ:");

		lbl_MoTaChucVu.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_MoTaChucVu.setText("Mô Tả:");

		txt_cvMoTaChV.setColumns(20);
		txt_cvMoTaChV.setRows(5);
		scroll_MoTaCongViec1.setViewportView(txt_cvMoTaChV);

		btn_LuuChV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_LuuChV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png")));
		btn_LuuChV.setText("Lưu");
		btn_LuuChV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_LuuChVActionPerformed(evt);
				} catch (HeadlessException | SQLException e) {

					e.printStackTrace();
				}
			}
		});

		btn_XoaChV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaChV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png")));
		btn_XoaChV.setText("Xóa");
		btn_XoaChV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_XoaChVActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		btn_XoaTrangChV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaTrangChV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh1.png")));
		btn_XoaTrangChV.setText("Xóa Trắng");
		btn_XoaTrangChV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaTrangChVActionPerformed(evt);
			}
		});

		btn_CapNhatChV.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_CapNhatChV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png")));
		btn_CapNhatChV.setText("Cập Nhật");
		btn_CapNhatChV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_CapNhatChVActionPerformed(evt);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout pn_ThemChucVuLayout = new javax.swing.GroupLayout(pn_ThemChucVu);
		pn_ThemChucVu.setLayout(pn_ThemChucVuLayout);
		pn_ThemChucVuLayout.setHorizontalGroup(pn_ThemChucVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_ThemChucVuLayout.createSequentialGroup().addGap(90, 90, 90).addGroup(pn_ThemChucVuLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(pn_ThemChucVuLayout.createSequentialGroup().addGap(0, 156, Short.MAX_VALUE)
								.addGroup(pn_ThemChucVuLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(pn_ThemChucVuLayout.createSequentialGroup()
												.addGroup(pn_ThemChucVuLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(btn_LuuChV,
																javax.swing.GroupLayout.PREFERRED_SIZE, 115,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(btn_XoaChV,
																javax.swing.GroupLayout.PREFERRED_SIZE, 115,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(34, 34, 34)
												.addGroup(pn_ThemChucVuLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(btn_CapNhatChV,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btn_XoaTrangChV)))
										.addGroup(pn_ThemChucVuLayout.createSequentialGroup()
												.addComponent(lbl_cvThemChucVu).addGap(33, 33, 33))))
						.addGroup(pn_ThemChucVuLayout.createSequentialGroup().addGroup(pn_ThemChucVuLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_TenChucVu).addComponent(lbl_MaChucVu).addComponent(lbl_MoTaChucVu))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(pn_ThemChucVuLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(scroll_MoTaCongViec1, javax.swing.GroupLayout.DEFAULT_SIZE, 224,
												Short.MAX_VALUE)
										.addComponent(txt_cvTenChV).addComponent(txt_cvMaChV))))
						.addGap(126, 126, 126)));
		pn_ThemChucVuLayout.setVerticalGroup(pn_ThemChucVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThemChucVuLayout.createSequentialGroup()
						.addComponent(lbl_cvThemChucVu)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_ThemChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(pn_ThemChucVuLayout.createSequentialGroup()
										.addComponent(txt_cvMaChV, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txt_cvTenChV, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(pn_ThemChucVuLayout.createSequentialGroup().addComponent(lbl_MaChucVu)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lbl_TenChucVu)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_ThemChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_MoTaChucVu).addComponent(scroll_MoTaCongViec1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 82,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemChucVuLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btn_LuuChV, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_CapNhatChV, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_XoaChV, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_XoaTrangChV, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pn_dsChucVu.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH CHỨC VỤ",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

//==========================================QuanLyChucVu==================================================================
		String[] headerChV = ("STT;Mã Chức Vụ;Tên Chức Vụ;Mô Tả").split(";");
		modelChV = new DefaultTableModel(headerChV, 0);
		tbl_QLChV.setModel(modelChV);
		scroll_QLCV1.setViewportView(tbl_QLChV);
		if (tbl_QLChV.getColumnModel().getColumnCount() > 0) {
			tbl_QLChV.getColumnModel().getColumn(0).setMinWidth(50);
			tbl_QLChV.getColumnModel().getColumn(0).setMaxWidth(50);
		}
		tbl_QLChV.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

				int row = tbl_QLChV.getSelectedRow();
				txt_cvMaChV.setText(modelChV.getValueAt(row, 1).toString());
				txt_cvTenChV.setText(modelChV.getValueAt(row, 2).toString());
				txt_cvMoTaChV.setText(modelChV.getValueAt(row, 3).toString());

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		javax.swing.GroupLayout pn_dsChucVuLayout = new javax.swing.GroupLayout(pn_dsChucVu);
		pn_dsChucVu.setLayout(pn_dsChucVuLayout);
		pn_dsChucVuLayout.setHorizontalGroup(pn_dsChucVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(scroll_QLCV1));
		pn_dsChucVuLayout
				.setVerticalGroup(pn_dsChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLCV1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE));

		javax.swing.GroupLayout pn_ChucVuLayout = new javax.swing.GroupLayout(pn_ChucVu);
		pn_ChucVu.setLayout(pn_ChucVuLayout);
		pn_ChucVuLayout.setHorizontalGroup(pn_ChucVuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pn_dsChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pn_ThemChucVu, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pn_ChucVuLayout.setVerticalGroup(pn_ChucVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_ChucVuLayout.createSequentialGroup()
						.addComponent(pn_ThemChucVu, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
						.addComponent(pn_dsChucVu, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout pn_QLChucVuCongViecLayout = new javax.swing.GroupLayout(pn_QLChucVuCongViec);
		pn_QLChucVuCongViec.setLayout(pn_QLChucVuCongViecLayout);
		pn_QLChucVuCongViecLayout.setHorizontalGroup(
				pn_QLChucVuCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_QLChucVuCongViecLayout.createSequentialGroup().addContainerGap()
								.addComponent(pn_CongViec, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(pn_ChucVu, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(52, 52, 52)));
		pn_QLChucVuCongViecLayout.setVerticalGroup(
				pn_QLChucVuCongViecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_QLChucVuCongViecLayout.createSequentialGroup()
								.addGroup(pn_QLChucVuCongViecLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(pn_CongViec, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(pn_ChucVu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pn_QuanLy.addTab("CÔNG VIỆC & CHỨC VỤ", pn_QLChucVuCongViec);

		lbl_tkTimPB.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_tkTimPB.setText("Phòng Ban:");

		lbl_tkTimTenNV.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_tkTimTenNV.setText("Tên Nhân Viên:");

		lbl_tkTimMaNV.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_tkTimMaNV.setText("Mã Nhân Viên:");

		lbl_TimNV.setFont(new java.awt.Font("Tahoma", 1, 36));
		lbl_TimNV.setText("TÌM KIẾM NHÂN VIÊN");

		cbb_tkTimPB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng ban" }));
		cbb_tkTimPB.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbb_tkTimPBActionPerformed(evt);
			}
		});

		btn_tkTimNV.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_tkTimNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loupe.png")));
		btn_tkTimNV.setText("TÌM KIẾM");
		btn_tkTimNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_tkTimNVActionPerformed(evt);
			}
		});

		pn_ThemTK.setBackground(new java.awt.Color(255, 255, 255));
		pn_ThemTK.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "THÔNG TIN TÀI KHOẢN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_ThemTK.setFont(new java.awt.Font("Tahoma", 1, 24));
		lbl_ThemTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/member-card.png")));
		lbl_ThemTK.setText(" THÊM TÀI KHOẢN");

		lbl_tkMaNV.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_tkMaNV.setText("Mã Nhân Viên:");

		lbl_tkTenNV.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_tkTenNV.setText("Tên Nhân Viên:");

		lbl_tkMatKhau.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_tkMatKhau.setText("Mật Khẩu:");

		lbl_tkNLMatKhau.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_tkNLMatKhau.setText("Nhập Lại Mật Khẩu:");

		btn_LuuTK.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_LuuTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png")));
		btn_LuuTK.setText("Lưu");
		btn_LuuTK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_LuuTKActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btn_XoaTK.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png")));
		btn_XoaTK.setText("Xóa");
		btn_XoaTK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaTKActionPerformed(evt);
			}
		});

		btn_XoaTrangTK.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_XoaTrangTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh1.png")));
		btn_XoaTrangTK.setText("Xóa Trắng");
		btn_XoaTrangTK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_XoaTrangTKActionPerformed(evt);
			}
		});

		btn_CapNhatTK.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_CapNhatTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png")));
		btn_CapNhatTK.setText("Cập Nhật");
		btn_CapNhatTK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_CapNhatTKActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout pn_ThemTKLayout = new javax.swing.GroupLayout(pn_ThemTK);
		pn_ThemTK.setLayout(pn_ThemTKLayout);
		pn_ThemTKLayout.setHorizontalGroup(pn_ThemTKLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThemTKLayout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(btn_LuuTK, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_XoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(34, 34, 34)
						.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btn_CapNhatTK, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_XoaTrangTK, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(42, 42, 42))
				.addGroup(pn_ThemTKLayout.createSequentialGroup().addGroup(pn_ThemTKLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_ThemTKLayout.createSequentialGroup().addGap(78, 78, 78).addComponent(lbl_ThemTK))
						.addGroup(pn_ThemTKLayout.createSequentialGroup().addContainerGap()
								.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lbl_tkNLMatKhau).addComponent(lbl_tkMatKhau))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txt_tkMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_tkNLMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(pn_ThemTKLayout.createSequentialGroup().addContainerGap()
								.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lbl_tkTenNV).addComponent(lbl_tkMaNV))
								.addGap(39, 39, 39)
								.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txt_tkMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_tkTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 223,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(20, Short.MAX_VALUE)));
		pn_ThemTKLayout.setVerticalGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_ThemTKLayout.createSequentialGroup()
						.addGap(24, 24, 24).addComponent(lbl_ThemTK).addGap(65, 65, 65)
						.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_tkMaNV)
								.addComponent(txt_tkMaNV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(36, 36, 36)
						.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_tkTenNV)
								.addComponent(txt_tkTenNV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)
						.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_tkMatKhau)
								.addComponent(txt_tkMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(30, 30, 30)
						.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_tkNLMatKhau)
								.addComponent(txt_tkNLMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(75, 75, 75)
						.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btn_LuuTK, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_CapNhatTK, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThemTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btn_XoaTK, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_XoaTrangTK, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(64, Short.MAX_VALUE)));

		pn_DsTaiKhoan.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH TÀI KHOẢN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

//============================================QuanLyTaiKhoan====================================================================
		String[] headerTKNV = ("STT;Mã Nhân Viên;Tên Nhân Viên;Mật Khẩu").split(";");
		modelTKNV = new DefaultTableModel(headerTKNV, 0);
		tbl_QLTK.setModel(modelTKNV);

		scroll_QLTK.setViewportView(tbl_QLTK);
		if (tbl_QLTK.getColumnModel().getColumnCount() > 0) {
			tbl_QLTK.getColumnModel().getColumn(0).setMinWidth(50);
			tbl_QLTK.getColumnModel().getColumn(0).setMaxWidth(50);
		}

		javax.swing.GroupLayout pn_DsTaiKhoanLayout = new javax.swing.GroupLayout(pn_DsTaiKhoan);
		pn_DsTaiKhoan.setLayout(pn_DsTaiKhoanLayout);
		pn_DsTaiKhoanLayout
				.setHorizontalGroup(pn_DsTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLTK, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE));
		pn_DsTaiKhoanLayout
				.setVerticalGroup(pn_DsTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_QLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		javax.swing.GroupLayout pn_QLTaiKhoanLayout = new javax.swing.GroupLayout(pn_QLTaiKhoan);
		pn_QLTaiKhoan.setLayout(pn_QLTaiKhoanLayout);
		pn_QLTaiKhoanLayout.setHorizontalGroup(pn_QLTaiKhoanLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_QLTaiKhoanLayout.createSequentialGroup().addGap(4, 4, 4)
						.addComponent(pn_ThemTK, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pn_QLTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_QLTaiKhoanLayout.createSequentialGroup()
										.addGroup(pn_QLTaiKhoanLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_tkTimPB).addComponent(lbl_tkTimTenNV))
										.addGap(18, 18, 18)
										.addGroup(pn_QLTaiKhoanLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(pn_QLTaiKhoanLayout.createSequentialGroup()
														.addGroup(pn_QLTaiKhoanLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(txt_tkTimTenNV,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 427,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGroup(pn_QLTaiKhoanLayout.createSequentialGroup()
																		.addComponent(cbb_tkTimPB,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				126,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18).addComponent(lbl_tkTimMaNV)
																		.addGap(18, 18, 18)
																		.addComponent(txt_tkTimMaNV)))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(btn_tkTimNV,
																javax.swing.GroupLayout.PREFERRED_SIZE, 155,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(pn_QLTaiKhoanLayout.createSequentialGroup()
														.addGap(144, 144, 144).addComponent(lbl_TimNV))))
								.addComponent(pn_DsTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(1299, 1299, 1299)));
		pn_QLTaiKhoanLayout.setVerticalGroup(pn_QLTaiKhoanLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_QLTaiKhoanLayout.createSequentialGroup().addGroup(pn_QLTaiKhoanLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(pn_QLTaiKhoanLayout.createSequentialGroup().addContainerGap().addComponent(lbl_TimNV)
								.addGap(52, 52, 52)
								.addGroup(pn_QLTaiKhoanLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(pn_QLTaiKhoanLayout.createSequentialGroup()
												.addGroup(pn_QLTaiKhoanLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_tkTimPB,
																javax.swing.GroupLayout.PREFERRED_SIZE, 16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(lbl_tkTimMaNV,
																javax.swing.GroupLayout.PREFERRED_SIZE, 16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txt_tkTimMaNV,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(cbb_tkTimPB,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(21, 21, 21)
												.addGroup(pn_QLTaiKhoanLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_tkTimTenNV,
																javax.swing.GroupLayout.PREFERRED_SIZE, 16,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txt_tkTimTenNV,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(btn_tkTimNV, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 61,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(pn_DsTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(pn_ThemTK, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 0, Short.MAX_VALUE)));

		pn_QuanLy.addTab("TÀI KHOẢN", pn_QLTaiKhoan);

		javax.swing.GroupLayout pn_NguoiQuanLyLayout = new javax.swing.GroupLayout(pn_NguoiQuanLy);
		pn_NguoiQuanLy.setLayout(pn_NguoiQuanLyLayout);
		pn_NguoiQuanLyLayout
				.setHorizontalGroup(pn_NguoiQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(pn_QuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 1426, Short.MAX_VALUE));
		pn_NguoiQuanLyLayout.setVerticalGroup(pn_NguoiQuanLyLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pn_QuanLy));

		JTB_QLLD.addTab("NGƯỜI QUẢN LÝ",
				new javax.swing.ImageIcon(getClass().getResource("/images/community-manager.png")), pn_NguoiQuanLy,
				"NGƯỜI QUẢN LÝ");

		pn_ThongTinCT.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "THÔNG TIN CÔNG TRÌNH",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_pcMaCT.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_pcMaCT.setText("Mã Công Trình:");

		lbl_pcTenCT.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_pcTenCT.setText("Tên Công Trình:");

		lbl_pcNgayCP.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_pcNgayCP.setText("Ngày Cấp Phép:");

		lbl_pcNgayHT.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_pcNgayHT.setText("Ngày Hoàn Thành(Dự kiến):");

		lbl_pcNgayKC.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_pcNgayKC.setText("Ngày Khởi Công:");

		lbl_pcDiaChiCT.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_pcDiaChiCT.setText("Địa Chỉ:");

		lbl_TrangThai1.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_TrangThai1.setText("Trạng Thái:");

		Rbtn_pcTrangThaiDHT.setFont(new java.awt.Font("Tahoma", 0, 14));
		Rbtn_pcTrangThaiDHT.setText("Đã hoàn thành");
		Rbtn_pcTrangThaiDHT.setToolTipText("");
		Rbtn_pcTrangThaiDHT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Rbtn_pcTrangThaiDHTActionPerformed(evt);
			}
		});

		Rbtn_pcTrangThaiCHT.setFont(new java.awt.Font("Tahoma", 0, 14));
		Rbtn_pcTrangThaiCHT.setText("Chưa hoàn thành");
		Rbtn_pcTrangThaiCHT.setToolTipText("");
//============================================ButtonGroup3=============================================
		ButtonGroup buttonGroup3 = new ButtonGroup();
		buttonGroup3.add(Rbtn_pcTrangThaiDHT);
		buttonGroup3.add(Rbtn_pcTrangThaiCHT);

		lbl_GiayPhepSo1.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_GiayPhepSo1.setText("Giấy Phép Số:");

		javax.swing.GroupLayout pn_ThongTinCTLayout = new javax.swing.GroupLayout(pn_ThongTinCT);
		pn_ThongTinCT.setLayout(pn_ThongTinCTLayout);
		pn_ThongTinCTLayout.setHorizontalGroup(pn_ThongTinCTLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_ThongTinCTLayout.createSequentialGroup().addContainerGap().addGroup(pn_ThongTinCTLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_ThongTinCTLayout.createSequentialGroup().addComponent(lbl_pcMaCT)
								.addGap(18, 18, 18).addComponent(txt_pcMaCT))
						.addGroup(pn_ThongTinCTLayout.createSequentialGroup().addComponent(lbl_pcNgayCP)
								.addGap(102, 102, 102).addComponent(DateChooser_pcNgayCP,
										javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
						.addGroup(pn_ThongTinCTLayout.createSequentialGroup().addGroup(pn_ThongTinCTLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lbl_pcTenCT).addComponent(lbl_pcDiaChiCT).addComponent(lbl_GiayPhepSo1))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(pn_ThongTinCTLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txt_ctSoGiayPhep1).addComponent(txt_pcDiaChiCT)
										.addComponent(txt_pcTenCT)))
						.addGroup(pn_ThongTinCTLayout.createSequentialGroup().addComponent(lbl_pcNgayKC)
								.addGap(97, 97, 97).addComponent(DateChooser_pcNgayKC,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGroup(pn_ThongTinCTLayout.createSequentialGroup().addComponent(lbl_TrangThai1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Rbtn_pcTrangThaiDHT)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Rbtn_pcTrangThaiCHT, javax.swing.GroupLayout.PREFERRED_SIZE, 145,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(pn_ThongTinCTLayout.createSequentialGroup().addComponent(lbl_pcNgayHT)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(DateChooser_pcNgayHT, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap()));
		pn_ThongTinCTLayout.setVerticalGroup(pn_ThongTinCTLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_ThongTinCTLayout.createSequentialGroup().addContainerGap()
						.addGroup(pn_ThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_pcMaCT)
								.addComponent(txt_pcMaCT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(27, 27, 27)
						.addGroup(pn_ThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_pcTenCT)
								.addComponent(txt_pcTenCT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(25, 25, 25)
						.addGroup(pn_ThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_pcDiaChiCT)
								.addComponent(txt_pcDiaChiCT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_GiayPhepSo1)
								.addComponent(txt_ctSoGiayPhep1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 19, Short.MAX_VALUE)
						.addGroup(pn_ThongTinCTLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(DateChooser_pcNgayCP, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl_pcNgayCP, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lbl_pcNgayKC)
								.addComponent(DateChooser_pcNgayKC, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lbl_pcNgayHT)
								.addComponent(DateChooser_pcNgayHT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_ThongTinCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_ThongTinCTLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(Rbtn_pcTrangThaiDHT, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(Rbtn_pcTrangThaiCHT, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_TrangThai1))
						.addGap(22, 22, 22)));

		pn_pcQLCongTrinh.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "CÔNG TRÌNH",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_LocCT.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_LocCT.setText("Tìm Kiếm Theo:");

		cbb_LocCT.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Tùy Chọn", "Mã Công Trình", "Tên Công Trình" }));
		cbb_LocCT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbb_LocCTActionPerformed(evt);
			}
		});

		lbl_TimTenCongTrinh.setFont(new java.awt.Font("Tahoma", 0, 16));
		lbl_TimTenCongTrinh.setText("Từ Khóa:");

		btn_pcTimCT.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_pcTimCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loupe.png")));
		btn_pcTimCT.setText("TÌM KIẾM");
		btn_pcTimCT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_pcTimCTActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		pn_pcDsCongTrinh.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH CÔNG TRÌNH",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

//==========================================PhanCongCongTrinh==============================================================
		String[] headerPCNVCT = ("STT;Mã Công Trình;Tên Công Trình;Địa Chỉ;Ngày Cấp Phép;Ngày Khởi Công;Ngày Hoàn Thành;Trạng Thái")
				.split(";");
		modelPCNVCT = new DefaultTableModel(headerPCNVCT, 0);
		tbl_pcQLCT.setModel(modelPCNVCT);

		tbl_pcQLCT.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scroll_DSCongTrinh.setViewportView(tbl_pcQLCT);

		if (tbl_pcQLCT.getColumnModel().getColumnCount() > 0) {
			tbl_pcQLCT.getColumnModel().getColumn(0).setMinWidth(40);
			tbl_pcQLCT.getColumnModel().getColumn(0).setMaxWidth(40);
			tbl_pcQLCT.getColumnModel().getColumn(1).setMinWidth(100);
			tbl_pcQLCT.getColumnModel().getColumn(1).setMaxWidth(100);
			tbl_pcQLCT.getColumnModel().getColumn(2).setMinWidth(120);
			tbl_pcQLCT.getColumnModel().getColumn(2).setMaxWidth(120);
			tbl_pcQLCT.getColumnModel().getColumn(3).setMinWidth(200);
			tbl_pcQLCT.getColumnModel().getColumn(3).setMaxWidth(200);
			tbl_pcQLCT.getColumnModel().getColumn(4).setMinWidth(110);
			tbl_pcQLCT.getColumnModel().getColumn(4).setMaxWidth(110);
			tbl_pcQLCT.getColumnModel().getColumn(5).setMinWidth(120);
			tbl_pcQLCT.getColumnModel().getColumn(5).setMaxWidth(120);
			tbl_pcQLCT.getColumnModel().getColumn(6).setMinWidth(140);
			tbl_pcQLCT.getColumnModel().getColumn(6).setMaxWidth(140);
			tbl_pcQLCT.getColumnModel().getColumn(7).setMinWidth(140);
			tbl_pcQLCT.getColumnModel().getColumn(7).setMaxWidth(140);
		}
		tbl_pcQLCT.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tbl_pcQLCT.getSelectedRow();
				txt_pcMaCT.setText(modelPCNVCT.getValueAt(row, 1).toString());
				txt_pcTenCT.setText(modelPCNVCT.getValueAt(row, 2).toString());
				String temp = modelPCNVCT.getValueAt(row, 3).toString();
				String[] diaChi = temp.split(",");
				txt_pcDiaChiCT.setText(diaChi[1] + "," + diaChi[2]);
				String trangThai = modelPCNVCT.getValueAt(row, 7).toString();

				try {

					Connection con = ConnectDB.getConnect();
					String sql = "SELECT soGiayPhep FROM tbl_CongTrinh WHERE [maCongTrinh]=?";
					PreparedStatement statement = null;
					statement = con.prepareStatement(sql);
					statement.setString(1, txt_pcMaCT.getText());
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						txt_ctSoGiayPhep1.setText(resultSet.getString(1));
					}
				} catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}

				if (trangThai.equalsIgnoreCase("Đã Hoàn Thành")) {
					Rbtn_pcTrangThaiDHT.setSelected(true);
				} else {
					Rbtn_pcTrangThaiCHT.setSelected(true);
				}
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelPCNVCT.getValueAt(row, 4));
					DateChooser_pcNgayCP.setDate(date);
				} catch (ParseException e1) {

					e1.printStackTrace();
				}

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelPCNVCT.getValueAt(row, 5));
					DateChooser_pcNgayKC.setDate(date);
				} catch (ParseException e1) {

					e1.printStackTrace();
				}

				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelPCNVCT.getValueAt(row, 6));
					DateChooser_pcNgayHT.setDate(date);
				} catch (ParseException e1) {

					e1.printStackTrace();
				}

				try {
					loadPCNVJCT(txt_pcMaCT.getText());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout pn_pcDsCongTrinhLayout = new javax.swing.GroupLayout(pn_pcDsCongTrinh);
		pn_pcDsCongTrinh.setLayout(pn_pcDsCongTrinhLayout);
		pn_pcDsCongTrinhLayout.setHorizontalGroup(pn_pcDsCongTrinhLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(scroll_DSCongTrinh));
		pn_pcDsCongTrinhLayout
				.setVerticalGroup(pn_pcDsCongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_DSCongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		btn_OKCongViec.setFont(new java.awt.Font("Tahoma", 1, 16));
		btn_OKCongViec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checklist.png")));
		btn_OKCongViec.setText("Phân Công");
		btn_OKCongViec.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_OKCongViecActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pn_pcQLCongTrinhLayout = new javax.swing.GroupLayout(pn_pcQLCongTrinh);
		pn_pcQLCongTrinh.setLayout(pn_pcQLCongTrinhLayout);
		pn_pcQLCongTrinhLayout.setHorizontalGroup(pn_pcQLCongTrinhLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_pcQLCongTrinhLayout.createSequentialGroup().addGap(45, 45, 45)
						.addGroup(pn_pcQLCongTrinhLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lbl_TimTenCongTrinh, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl_LocCT, javax.swing.GroupLayout.PREFERRED_SIZE, 118,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pn_pcQLCongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txt_pcTimTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, 301,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbb_LocCT, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(52, 52, 52)
						.addComponent(btn_pcTimCT, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(btn_OKCongViec).addContainerGap(45, Short.MAX_VALUE))
				.addComponent(pn_pcDsCongTrinh, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pn_pcQLCongTrinhLayout
				.setVerticalGroup(pn_pcQLCongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_pcQLCongTrinhLayout.createSequentialGroup().addContainerGap()
								.addGroup(pn_pcQLCongTrinhLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(pn_pcQLCongTrinhLayout.createSequentialGroup()
												.addGroup(pn_pcQLCongTrinhLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(cbb_LocCT, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(lbl_LocCT, javax.swing.GroupLayout.PREFERRED_SIZE,
																16, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(pn_pcQLCongTrinhLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_TimTenCongTrinh,
																javax.swing.GroupLayout.PREFERRED_SIZE, 19,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txt_pcTimTenCT,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(btn_pcTimCT, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btn_OKCongViec, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(pn_pcDsCongTrinh, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pn_LocNV.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "NGƯỜI THAM GIA",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		btn_IN.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_IN.setText(">");
		btn_IN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_INActionPerformed(evt);
			}
		});

		btn_OUT.setFont(new java.awt.Font("Tahoma", 1, 18));
		btn_OUT.setText("<");
		btn_OUT.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_OUTActionPerformed(evt);
			}
		});

		pn_pcDsNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH NHÂN VIÊN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

//==============================================PhanCongNhanVien============================================
		String[] headerPCNVNV = ("STT;Mã Nhân Viên;Tên Nhân Viên;Giới Tính;Chức Vụ;Phòng Ban").split(";");
		modelPCNVNV = new DefaultTableModel(headerPCNVNV, 0);
		tbl_pcDanhSachNV.setModel(modelPCNVNV);
		scroll_DSNhanVien.setViewportView(tbl_pcDanhSachNV);
		if (tbl_pcDanhSachNV.getColumnModel().getColumnCount() > 0) {
			tbl_pcDanhSachNV.getColumnModel().getColumn(0).setMinWidth(40);
			tbl_pcDanhSachNV.getColumnModel().getColumn(0).setMaxWidth(40);
			tbl_pcDanhSachNV.getColumnModel().getColumn(1).setMinWidth(100);
			tbl_pcDanhSachNV.getColumnModel().getColumn(1).setMaxWidth(100);
			tbl_pcDanhSachNV.getColumnModel().getColumn(2).setMinWidth(150);
			tbl_pcDanhSachNV.getColumnModel().getColumn(2).setMaxWidth(150);
			tbl_pcDanhSachNV.getColumnModel().getColumn(3).setMinWidth(80);
			tbl_pcDanhSachNV.getColumnModel().getColumn(3).setMaxWidth(80);
			tbl_pcDanhSachNV.getColumnModel().getColumn(4).setMinWidth(100);
			tbl_pcDanhSachNV.getColumnModel().getColumn(4).setMaxWidth(100);
			tbl_pcDanhSachNV.getColumnModel().getColumn(5).setMinWidth(90);
			tbl_pcDanhSachNV.getColumnModel().getColumn(5).setMaxWidth(90);
		}

		javax.swing.GroupLayout pn_pcDsNhanVienLayout = new javax.swing.GroupLayout(pn_pcDsNhanVien);
		pn_pcDsNhanVien.setLayout(pn_pcDsNhanVienLayout);
		pn_pcDsNhanVienLayout
				.setHorizontalGroup(pn_pcDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_DSNhanVien, javax.swing.GroupLayout.Alignment.TRAILING));
		pn_pcDsNhanVienLayout
				.setVerticalGroup(pn_pcDsNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_DSNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		pn_DsNhanVienTGCT.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3),
				"NHÂN VIÊN THAM GIA CÔNG TRÌNH", javax.swing.border.TitledBorder.LEFT,
				javax.swing.border.TitledBorder.TOP));

// ===========================================PhanCongNhanVienThamGiaCongTrinh===============================================
		String[] headerPCNVJCT = ("STT;Mã Nhân Viên;Tên Nhân Viên;Chức Vụ;Công Việc;Ngày Bắt Đầu;Ngày Kết Thúc")
				.split(";");
		modelPCNVJCT = new DefaultTableModel(headerPCNVJCT, 0);
		tbl_pcNVThamGia.setModel(modelPCNVJCT);
		tbl_pcNVThamGia.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		scroll_PhanCongNV.setViewportView(tbl_pcNVThamGia);
		if (tbl_pcNVThamGia.getColumnModel().getColumnCount() > 0) {
			tbl_pcNVThamGia.getColumnModel().getColumn(0).setMinWidth(50);
			tbl_pcNVThamGia.getColumnModel().getColumn(0).setMaxWidth(50);
			tbl_pcNVThamGia.getColumnModel().getColumn(1).setMinWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(1).setMaxWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(2).setMinWidth(150);
			tbl_pcNVThamGia.getColumnModel().getColumn(2).setMaxWidth(150);
			tbl_pcNVThamGia.getColumnModel().getColumn(3).setMinWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(3).setMaxWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(4).setMinWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(4).setMaxWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(5).setMinWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(5).setMaxWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(6).setMinWidth(100);
			tbl_pcNVThamGia.getColumnModel().getColumn(6).setMaxWidth(100);
		}
		@SuppressWarnings("rawtypes")
		JComboBox cbb_ChonCV = new JComboBox();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT tenCongViec FROM tbl_CongViec";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cbb_ChonCV.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		DefaultCellEditor cellEditorNVJCT = new DefaultCellEditor(cbb_ChonCV);
//		tbl_pcNVThamGia.getColumnModel().getColumn(4).setCellEditor(cellEditorNVJCT);

		tbl_pcNVThamGia.getColumnModel().getColumn(5).setCellEditor(new JDateChooserEditor(new JCheckBox()));
		tbl_pcNVThamGia.getColumnModel().getColumn(6).setCellEditor(new JDateChooserEditor(new JCheckBox()));

		javax.swing.GroupLayout pn_DsNhanVienTGCTLayout = new javax.swing.GroupLayout(pn_DsNhanVienTGCT);
		pn_DsNhanVienTGCT.setLayout(pn_DsNhanVienTGCTLayout);
		pn_DsNhanVienTGCTLayout.setHorizontalGroup(
				pn_DsNhanVienTGCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_PhanCongNV, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE));
		pn_DsNhanVienTGCTLayout
				.setVerticalGroup(pn_DsNhanVienTGCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scroll_PhanCongNV, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		javax.swing.GroupLayout pn_LocNVLayout = new javax.swing.GroupLayout(pn_LocNV);
		pn_LocNV.setLayout(pn_LocNVLayout);
		pn_LocNVLayout.setHorizontalGroup(pn_LocNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_LocNVLayout.createSequentialGroup()
						.addComponent(pn_pcDsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pn_LocNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btn_IN).addComponent(btn_OUT, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(pn_DsNhanVienTGCT, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
		pn_LocNVLayout.setVerticalGroup(pn_LocNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pn_pcDsNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(pn_DsNhanVienTGCT, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(pn_LocNVLayout.createSequentialGroup().addGap(50, 50, 50).addComponent(btn_IN)
						.addGap(18, 18, 18).addComponent(btn_OUT).addContainerGap(82, Short.MAX_VALUE)));

		javax.swing.GroupLayout pn_PhanCongLayout = new javax.swing.GroupLayout(pn_PhanCong);
		pn_PhanCong.setLayout(pn_PhanCongLayout);
		pn_PhanCongLayout.setHorizontalGroup(pn_PhanCongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_PhanCongLayout.createSequentialGroup().addGroup(pn_PhanCongLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addComponent(pn_LocNV, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, pn_PhanCongLayout.createSequentialGroup()
								.addComponent(pn_ThongTinCT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pn_pcQLCongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pn_PhanCongLayout
				.setVerticalGroup(pn_PhanCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_PhanCongLayout.createSequentialGroup().addGroup(pn_PhanCongLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(pn_ThongTinCT, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pn_pcQLCongTrinh, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pn_LocNV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(51, Short.MAX_VALUE)));

		javax.swing.GroupLayout pn_PhanCongCVLayout = new javax.swing.GroupLayout(pn_PhanCongCV);
		pn_PhanCongCV.setLayout(pn_PhanCongCVLayout);
		pn_PhanCongCVLayout.setHorizontalGroup(pn_PhanCongCVLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pn_PhanCong,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pn_PhanCongCVLayout
				.setVerticalGroup(pn_PhanCongCVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_PhanCongCVLayout.createSequentialGroup()
								.addComponent(pn_PhanCong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 38, Short.MAX_VALUE)));

		JTB_QLLD.addTab("PHÂN CÔNG NHÂN VIÊN",
				new javax.swing.ImageIcon(getClass().getResource("/images/management.png")), pn_PhanCongCV,
				"PHÂN CÔNG NHÂN VIÊN");

		pn_bccTTNV.setBackground(new java.awt.Color(255, 255, 255));
		pn_bccTTNV.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "THÔNG TIN NHÂN VIÊN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_PB1.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_PB1.setText("Phòng Ban:");

		cbb_nvChonPB1.setBackground(new java.awt.Color(198, 226, 255));
		cbb_nvChonPB1.setFont(new java.awt.Font("Tahoma", 0, 12));
		cbb_nvChonPB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng Ban" }));
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT maPhongBan FROM tbl_PhongBan";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cbb_nvChonPB1.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		AutoCompleteDecorator.decorate(cbb_nvChonPB1);
		cbb_nvChonPB1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbb_nvChonPB1ActionPerformed(evt);
			}
		});

		cbb_nvChonChVu1.setBackground(new java.awt.Color(198, 226, 255));
		cbb_nvChonChVu1.setFont(new java.awt.Font("Tahoma", 0, 12));
		cbb_nvChonChVu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chức Vụ" }));
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT tenChucVu FROM tbl_ChucVu";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cbb_nvChonChVu1.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		AutoCompleteDecorator.decorate(cbb_nvChonChVu1);
		cbb_nvChonChVu1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbb_nvChonChVu1ActionPerformed(evt);
			}
		});

		lbl_ChVu1.setFont(new java.awt.Font("Tahoma", 1, 12));
		lbl_ChVu1.setText("Chức Vụ:");

		lbl_MaNV1.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_MaNV1.setText("Mã Nhân Viên:");

		lbl_TenNV1.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_TenNV1.setText("Họ Và Tên:");

		lbl_Tuoi1.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_Tuoi1.setText("Năm Sinh:");

		lbl_GT1.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_GT1.setText("Giới Tính:");

		Rbtn_bccNam.setText("Nam");
		Rbtn_bccNam.setToolTipText("");

		Rbtn_bccNu.setText("Nữ");
		Rbtn_bccNu.setToolTipText("");

//============================================ButtonGroup4===================================================
		ButtonGroup buttonGroup4 = new ButtonGroup();
		buttonGroup4.add(Rbtn_bccNam);
		buttonGroup4.add(Rbtn_bccNu);

		lbl_CMND1.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_CMND1.setText("Số CMND:");

		lbl_SDT1.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_SDT1.setText("Số Điện Thoại:");

		lbl_DiaChi1.setFont(new java.awt.Font("Tahoma", 1, 14));
		lbl_DiaChi1.setText("Địa Chỉ:");

		javax.swing.GroupLayout pn_bccTTNVLayout = new javax.swing.GroupLayout(pn_bccTTNV);
		pn_bccTTNV.setLayout(pn_bccTTNVLayout);
		pn_bccTTNVLayout.setHorizontalGroup(pn_bccTTNVLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_bccTTNVLayout.createSequentialGroup().addContainerGap().addGroup(pn_bccTTNVLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_bccTTNVLayout.createSequentialGroup()
								.addComponent(lbl_PB1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29,
										Short.MAX_VALUE)
								.addComponent(cbb_nvChonPB1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18).addComponent(lbl_ChVu1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(cbb_nvChonChVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(41, 41, 41))
						.addGroup(pn_bccTTNVLayout.createSequentialGroup().addGroup(pn_bccTTNVLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_bccTTNVLayout.createSequentialGroup().addGroup(pn_bccTTNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lbl_CMND1).addComponent(lbl_TenNV1).addComponent(lbl_MaNV1))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pn_bccTTNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txt_bccnvTenNV).addComponent(txt_bccMaNV)
												.addComponent(DateChooser_bccNamSinh,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txt_bccCMND)))
								.addGroup(pn_bccTTNVLayout.createSequentialGroup()
										.addGroup(pn_bccTTNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_SDT1).addComponent(lbl_DiaChi1))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pn_bccTTNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txt_bccDiaChi).addComponent(txt_bccSDT)))
								.addGroup(pn_bccTTNVLayout.createSequentialGroup()
										.addGroup(pn_bccTTNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_Tuoi1)
												.addGroup(pn_bccTTNVLayout.createSequentialGroup().addComponent(lbl_GT1)
														.addGap(41, 41, 41).addComponent(Rbtn_bccNam).addGap(35, 35, 35)
														.addComponent(Rbtn_bccNu)))
										.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap()))));
		pn_bccTTNVLayout
				.setVerticalGroup(pn_bccTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_bccTTNVLayout.createSequentialGroup().addContainerGap().addGroup(pn_bccTTNVLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(lbl_PB1)
								.addComponent(cbb_nvChonPB1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_ChVu1, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cbb_nvChonChVu1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										pn_bccTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_MaNV1).addComponent(txt_bccMaNV,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										pn_bccTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_TenNV1).addComponent(txt_bccnvTenNV,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(pn_bccTTNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lbl_Tuoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(DateChooser_bccNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(pn_bccTTNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(pn_bccTTNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(Rbtn_bccNam).addComponent(Rbtn_bccNu))
										.addComponent(lbl_GT1, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18, 18, 18)
								.addGroup(
										pn_bccTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_CMND1).addComponent(txt_bccCMND,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										pn_bccTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_SDT1).addComponent(txt_bccSDT,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										pn_bccTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_DiaChi1).addComponent(txt_bccDiaChi,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(34, Short.MAX_VALUE)));

		pn_bccDSNV.setBackground(new java.awt.Color(255, 255, 255));
		pn_bccDSNV.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "DANH SÁCH NHÂN VIÊN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

//===========================================BangChamCongNhanVien================================================================
		String[] headerBCCNV = ("STT;Mã Nhân Viên;Tên Nhân Viên;Ngày Sinh;Giới Tính;Số CMND;Địa Chỉ;Số Điện Thoại;Chức Vụ")
				.split(";");
		modelBCCNV = new DefaultTableModel(headerBCCNV, 0);
		tbl_bccDSNV.setModel(modelBCCNV);
		tbl_bccDSNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		jScrollPane_DSNV.setViewportView(tbl_bccDSNV);
		if (tbl_bccDSNV.getColumnModel().getColumnCount() > 0) {
			tbl_bccDSNV.getColumnModel().getColumn(0).setMinWidth(40);
			tbl_bccDSNV.getColumnModel().getColumn(0).setMaxWidth(40);
			tbl_bccDSNV.getColumnModel().getColumn(1).setMinWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(1).setMaxWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(2).setMinWidth(150);
			tbl_bccDSNV.getColumnModel().getColumn(2).setMaxWidth(150);
			tbl_bccDSNV.getColumnModel().getColumn(3).setMinWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(3).setMaxWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(4).setMinWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(4).setMaxWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(5).setMinWidth(85);
			tbl_bccDSNV.getColumnModel().getColumn(5).setMaxWidth(85);
			tbl_bccDSNV.getColumnModel().getColumn(6).setMinWidth(180);
			tbl_bccDSNV.getColumnModel().getColumn(6).setMaxWidth(180);
			tbl_bccDSNV.getColumnModel().getColumn(7).setMinWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(7).setMaxWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(8).setMinWidth(100);
			tbl_bccDSNV.getColumnModel().getColumn(8).setMaxWidth(100);
		}

		tbl_bccDSNV.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int row = tbl_bccDSNV.getSelectedRow();
				txt_bccMaNV.setText(modelBCCNV.getValueAt(row, 1).toString());
				txt_bccnvTenNV.setText(modelBCCNV.getValueAt(row, 2).toString());
				txt_bccCMND.setText(modelBCCNV.getValueAt(row, 5).toString());
				String temp = modelBCCNV.getValueAt(row, 6).toString();
				String[] diaChi = temp.split(",");
				txt_bccDiaChi.setText(diaChi[1] + "," + diaChi[2] + "," + diaChi[3]);
				txt_bccSDT.setText(modelBCCNV.getValueAt(row, 7).toString());
				try {
					modelBCCCT.setRowCount(0);
					getDataCC(txt_bccMaNV.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modelBCCNV.getValueAt(row, 3));
					DateChooser_bccNamSinh.setDate(date);
				} catch (ParseException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				String gioiTinh = modelBCCNV.getValueAt(row, 4).toString();
				if (gioiTinh.equalsIgnoreCase("Nam")) {
					Rbtn_bccNam.setSelected(true);
				} else {
					Rbtn_bccNu.setSelected(true);
				}
				cbb_nvChonChVu1.setSelectedItem(modelBCCNV.getValueAt(row, 8).toString());
				try {

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});

		javax.swing.GroupLayout pn_bccDSNVLayout = new javax.swing.GroupLayout(pn_bccDSNV);
		pn_bccDSNV.setLayout(pn_bccDSNVLayout);
		pn_bccDSNVLayout
				.setHorizontalGroup(pn_bccDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane_DSNV, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE));
		pn_bccDSNVLayout
				.setVerticalGroup(pn_bccDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane_DSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

		pn_BangChamCong.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "CHẤM CÔNG",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
//=====================================BangChamCongThongTinCongTrinh=====================================================
		String[] headerBCCCT = ("STT;Mã Công Trình;Tên Công Trình;Địa Chỉ;Công Việc;Ngày Bắt Đầu;Ngày Kết Thúc;Số Ngày Nghỉ;Tổng Ngày Công")
				.split(";");
		modelBCCCT = new DefaultTableModel(headerBCCCT, 0);
		tbl_bccBangChamCong.setModel(modelBCCCT);
		tbl_bccDSNV.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		jScrollPane_BangChamCong.setViewportView(tbl_bccBangChamCong);
		if (tbl_bccBangChamCong.getColumnModel().getColumnCount() > 0) {
			tbl_bccBangChamCong.getColumnModel().getColumn(0).setMinWidth(40);
			tbl_bccBangChamCong.getColumnModel().getColumn(0).setMaxWidth(40);
			tbl_bccBangChamCong.getColumnModel().getColumn(1).setMinWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(1).setMaxWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(2).setMinWidth(200);
			tbl_bccBangChamCong.getColumnModel().getColumn(2).setMaxWidth(200);
			tbl_bccBangChamCong.getColumnModel().getColumn(3).setMinWidth(250);
			tbl_bccBangChamCong.getColumnModel().getColumn(3).setMaxWidth(250);
			tbl_bccBangChamCong.getColumnModel().getColumn(4).setMinWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(4).setMaxWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(5).setMinWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(5).setMaxWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(6).setMinWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(6).setMaxWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(7).setMinWidth(115);
			tbl_bccBangChamCong.getColumnModel().getColumn(7).setMaxWidth(115);
			tbl_bccBangChamCong.getColumnModel().getColumn(8).setMinWidth(150);
			tbl_bccBangChamCong.getColumnModel().getColumn(8).setMaxWidth(150);
		}
		modelSLNgayNghi = new DefaultComboBoxModel<>();
		modelSLNgayNghi.addElement(1);
		modelSLNgayNghi.addElement(2);
		modelSLNgayNghi.addElement(3);
		modelSLNgayNghi.addElement(4);
		modelSLNgayNghi.addElement(5);
		modelSLNgayNghi.addElement(6);
		modelSLNgayNghi.addElement(7);
		modelSLNgayNghi.addElement(8);
		modelSLNgayNghi.addElement(9);
		modelSLNgayNghi.addElement(10);
		modelSLNgayNghi.addElement(11);
		modelSLNgayNghi.addElement(12);
		cbb_SLNgayNghi = new JComboBox<String>(modelSLNgayNghi);
		DefaultCellEditor cellEditorBCC = new DefaultCellEditor(cbb_SLNgayNghi);
		tbl_bccBangChamCong.getColumnModel().getColumn(7).setCellEditor(cellEditorBCC);
		String temp = cbb_SLNgayNghi.getSelectedItem().toString();
		cbb_SLNgayNghi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dayOff = Integer.parseInt(temp);
				Date d1 = null;
				Date d2 = null;
				try {
					d1 = sdf.parse((String) modelBCCCT.getValueAt(tbl_bccBangChamCong.getSelectedRow(), 5));
					d2 = sdf.parse((String) modelBCCCT.getValueAt(tbl_bccBangChamCong.getSelectedRow(), 6));
					int totalDay = (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)) - dayOff;
					modelBCCCT.setValueAt(totalDay, tbl_bccBangChamCong.getSelectedRow(), 8);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});

		javax.swing.GroupLayout pn_BangChamCongLayout = new javax.swing.GroupLayout(pn_BangChamCong);
		pn_BangChamCong.setLayout(pn_BangChamCongLayout);
		pn_BangChamCongLayout.setHorizontalGroup(pn_BangChamCongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane_BangChamCong));
		pn_BangChamCongLayout.setVerticalGroup(
				pn_BangChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
						jScrollPane_BangChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE));

		javax.swing.GroupLayout pn_BangChamCongNVLayout = new javax.swing.GroupLayout(pn_BangChamCongNV);
		pn_BangChamCongNV.setLayout(pn_BangChamCongNVLayout);
		pn_BangChamCongNVLayout.setHorizontalGroup(
				pn_BangChamCongNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_BangChamCongNVLayout.createSequentialGroup().addGap(1, 1, 1)
								.addGroup(pn_BangChamCongNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(pn_BangChamCong, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(pn_BangChamCongNVLayout.createSequentialGroup()
												.addComponent(pn_bccTTNV, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(pn_bccDSNV, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(32, Short.MAX_VALUE)));
		pn_BangChamCongNVLayout
				.setVerticalGroup(pn_BangChamCongNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_BangChamCongNVLayout.createSequentialGroup().addGroup(pn_BangChamCongNVLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(pn_bccTTNV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pn_bccDSNV, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pn_BangChamCong, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(77, Short.MAX_VALUE)));

		javax.swing.GroupLayout pn_ChamCongLayout = new javax.swing.GroupLayout(pn_ChamCong);
		pn_ChamCong.setLayout(pn_ChamCongLayout);
		pn_ChamCongLayout.setHorizontalGroup(pn_ChamCongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pn_BangChamCongNV,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		pn_ChamCongLayout.setVerticalGroup(pn_ChamCongLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pn_BangChamCongNV,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		JTB_QLLD.addTab("BẢNG CHẤM CÔNG", new javax.swing.ImageIcon(getClass().getResource("/images/ChamCong.png")),
				pn_ChamCong);

		pn_ThongKeCongTrinh.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "THỐNG KÊ",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

		lbl_TieuChi.setFont(new java.awt.Font("Tahoma", 0, 18));
		lbl_TieuChi.setText("Tiêu Chí:");

		lbl_SoLuong.setFont(new java.awt.Font("Tahoma", 0, 18));
		lbl_SoLuong.setText("Số Lượng:");

		lbl_NamXD.setFont(new java.awt.Font("Tahoma", 0, 18));
		lbl_NamXD.setText("Năm Xây Dựng:");

		txt_NamXD.setFont(new java.awt.Font("Tahoma", 0, 16));

		cbb_TieuChi.setFont(new java.awt.Font("Tahoma", 0, 16));
		cbb_TieuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn tiêu chí",
				"Thống kê số công trình đã hoàn thành", "Thống kê số công trình chưa hoàn thành" }));
		cbb_TieuChi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					cbb_TieuChiActionPerformed(evt);
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		});

		txt_SoLuong.setFont(new java.awt.Font("Tahoma", 0, 16));
		txt_SoLuong.setText("");

		btn_XacNhanThongKe.setFont(new java.awt.Font("Tahoma", 1, 20));
		btn_XacNhanThongKe.setText("Lọc Thông Tin");
		btn_XacNhanThongKe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btn_XacNhanThongKeActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
//===========================================ThongKeCongTrinh============================================================
		String[] headerTKCT = ("STT;Mã Công Trình;Tên Công Trình;Địa Chỉ;Loại Hình;Số Giấy Phép;Ngày Cấp Phép;Ngày Khởi Công;Ngày Hoàn Thành;Trạng Thái")
				.split(";");
		modelTKCT = new DefaultTableModel(headerTKCT, 0);
		tbl_Thongke.setModel(modelTKCT);
		scroll_QLCT1.setViewportView(tbl_Thongke);
		if (tbl_Thongke.getColumnModel().getColumnCount() > 0) {
			tbl_Thongke.getColumnModel().getColumn(0).setMinWidth(40);
			tbl_Thongke.getColumnModel().getColumn(0).setMaxWidth(40);
			tbl_Thongke.getColumnModel().getColumn(1).setMinWidth(120);
			tbl_Thongke.getColumnModel().getColumn(1).setMaxWidth(120);
			tbl_Thongke.getColumnModel().getColumn(2).setMinWidth(150);
			tbl_Thongke.getColumnModel().getColumn(2).setMaxWidth(150);
			tbl_Thongke.getColumnModel().getColumn(3).setMinWidth(230);
			tbl_Thongke.getColumnModel().getColumn(3).setMaxWidth(230);
			tbl_Thongke.getColumnModel().getColumn(4).setMinWidth(120);
			tbl_Thongke.getColumnModel().getColumn(4).setMaxWidth(120);
			tbl_Thongke.getColumnModel().getColumn(5).setMinWidth(120);
			tbl_Thongke.getColumnModel().getColumn(5).setMaxWidth(120);
			tbl_Thongke.getColumnModel().getColumn(6).setMinWidth(150);
			tbl_Thongke.getColumnModel().getColumn(6).setMaxWidth(150);
			tbl_Thongke.getColumnModel().getColumn(7).setMinWidth(120);
			tbl_Thongke.getColumnModel().getColumn(7).setMaxWidth(120);
			tbl_Thongke.getColumnModel().getColumn(8).setMinWidth(150);
			tbl_Thongke.getColumnModel().getColumn(8).setMaxWidth(150);
			tbl_Thongke.getColumnModel().getColumn(9).setMinWidth(150);
			tbl_Thongke.getColumnModel().getColumn(9).setMaxWidth(150);
		}

		javax.swing.GroupLayout pn_ThongKeCongTrinhLayout = new javax.swing.GroupLayout(pn_ThongKeCongTrinh);
		pn_ThongKeCongTrinh.setLayout(pn_ThongKeCongTrinhLayout);
		pn_ThongKeCongTrinhLayout.setHorizontalGroup(pn_ThongKeCongTrinhLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_ThongKeCongTrinhLayout.createSequentialGroup().addGap(205, 205, 205)
						.addGroup(pn_ThongKeCongTrinhLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_ThongKeCongTrinhLayout.createSequentialGroup().addComponent(lbl_SoLuong)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txt_SoLuong))
								.addGroup(pn_ThongKeCongTrinhLayout.createSequentialGroup().addComponent(lbl_TieuChi)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(cbb_TieuChi, javax.swing.GroupLayout.PREFERRED_SIZE, 375,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl_NamXD)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txt_NamXD, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btn_XacNhanThongKe).addGap(179, 179, 179))
				.addComponent(scroll_QLCT1));
		pn_ThongKeCongTrinhLayout.setVerticalGroup(
				pn_ThongKeCongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						pn_ThongKeCongTrinhLayout.createSequentialGroup().addGroup(pn_ThongKeCongTrinhLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_ThongKeCongTrinhLayout.createSequentialGroup().addContainerGap()
										.addGroup(pn_ThongKeCongTrinhLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lbl_TieuChi, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(pn_ThongKeCongTrinhLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lbl_NamXD)
														.addComponent(txt_NamXD, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(cbb_TieuChi,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(18, 18, 18)
										.addGroup(pn_ThongKeCongTrinhLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_SoLuong).addComponent(txt_SoLuong,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(btn_XacNhanThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 94,
										Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(scroll_QLCT1, javax.swing.GroupLayout.PREFERRED_SIZE, 510,
										javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout pn_ThongKeLayout = new javax.swing.GroupLayout(pn_ThongKe);
		pn_ThongKe.setLayout(pn_ThongKeLayout);
		pn_ThongKeLayout
				.setHorizontalGroup(pn_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_ThongKeLayout.createSequentialGroup()
								.addComponent(pn_ThongKeCongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 40, Short.MAX_VALUE)));
		pn_ThongKeLayout
				.setVerticalGroup(pn_ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pn_ThongKeLayout.createSequentialGroup()
								.addComponent(pn_ThongKeCongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 69, Short.MAX_VALUE)));

		JTB_QLLD.addTab("THỐNG KÊ", new javax.swing.ImageIcon(getClass().getResource("/images/analytics.png")),
				pn_ThongKe);

		TTCN.setBackground(new java.awt.Color(255, 255, 255));

		lbl_ttcnPB.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_ttcnPB.setText("Phòng Ban:");
		try {
			Connection connection = ConnectDB.getConnect();
			String sql = "SELECT tenPhongBan FROM tbl_PhongBan JOIN tbl_NhanVien \n"
					+ "ON tbl_PhongBan.maPhongBan = tbl_NhanVien.maPhongBan\n" + "WHERE maNhanVien = '" + maTaiKhoan
					+ "';";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				txt_ttcnPhongBan.setText(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		lbl_ttcnMaNV.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_ttcnMaNV.setText("Mã Nhân Viên:");

		lbl_ttcnTenNV.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_ttcnTenNV.setText("Họ Và Tên:");
		try {
			Connection connection = ConnectDB.getConnect();
			String sql = "SELECT tenNhanVien FROM tbl_NhanVien WHERE maNhanVien = '" + maTaiKhoan + "';";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				txt_ttcnTenNV.setText(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lbl_ttcnGT.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_ttcnGT.setText("Giới Tính:");

		Rbtn_ttcnNam.setFont(new java.awt.Font("Tahoma", 0, 16));
		Rbtn_ttcnNam.setText("Nam");

		Rbtn_ttcnNu.setFont(new java.awt.Font("Tahoma", 0, 16));
		Rbtn_ttcnNu.setText("Nữ");

//==========================================ButtonGroup5==============================================
		ButtonGroup buttonGroup5 = new ButtonGroup();
		buttonGroup5.add(Rbtn_ttcnNam);
		buttonGroup5.add(Rbtn_ttcnNu);

		try {
			Connection connection = ConnectDB.getConnect();
			String sql = "SELECT gioiTinh FROM tbl_NhanVien WHERE maNhanVien = '" + maTaiKhoan + "';";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				boolean gioiTinh = resultSet.getBoolean(1);
				if (gioiTinh == true) {
					Rbtn_ttcnNam.setSelected(true);
				} else {
					Rbtn_ttcnNu.setSelected(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lbl_ttcnDiaChi.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_ttcnDiaChi.setText("Địa Chỉ:");

		lbl_ttcnSDT.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_ttcnSDT.setText("Số Điện Thoại:");
		try {
			Connection connection = ConnectDB.getConnect();
			String sql = "SELECT soDT FROM tbl_NhanVien WHERE maNhanVien = '" + maTaiKhoan + "';";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				txt_ttcnSDT.setText(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lbl_ttcnTuoi.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_ttcnTuoi.setText("Năm Sinh:");
		try {
			Connection connection = ConnectDB.getConnect();
			String sql = "SELECT ngaySinh FROM tbl_NhanVien WHERE maNhanVien = '" + maTaiKhoan + "';";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(1));
				DateChooser_ttcnNamSinh.setDate(date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		lbl_ttcnCMND.setFont(new java.awt.Font("Tahoma", 1, 16));
		lbl_ttcnCMND.setText("Số CMND:");

		try {
			Connection connection = ConnectDB.getConnect();
			String sql = "SELECT soCMND FROM tbl_NhanVien WHERE maNhanVien = '" + maTaiKhoan + "';";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				txt_ttcnCMND.setText(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection connection = ConnectDB.getConnect();
			String sql = "SELECT diaChi FROM tbl_NhanVien WHERE maNhanVien = '" + maTaiKhoan + "';";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				txt_ttcnDiaChi.setText(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		btn_HoanTat.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_HoanTat.setText("HOÀN TẤT");
		btn_HoanTat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_HoanTatActionPerformed(evt);
			}
		});

		txt_ttcnMaNV.setText(maTaiKhoan);

		lbl_Profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png")));

		btn_DangXuat.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_DangXuat.setText("Đăng Xuất");
		btn_DangXuat.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png")));
		btn_DangXuat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_DangXuatActionPerformed(evt);
			}
		});

		btn_DoiMK.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_DoiMK.setText("Đổi Mật Khẩu");
		btn_DoiMK.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/padlock.png")));
		btn_DoiMK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_DoiMKActionPerformed(evt);
			}
		});

		btn_TroGiup.setFont(new java.awt.Font("Tahoma", 1, 14));
		btn_TroGiup.setText("Trợ Giúp");
		btn_TroGiup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png")));
		btn_TroGiup.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_TroGiupActionPerformed(evt);
			}
		});

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "CÔNG VIỆC CÁ NHÂN",
				javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
//===================================ThongTinCaNhan==================================================
		String[] headerTTCN = ("STT;Mã Công Trình;Tên Công Trình;Địa Điểm;Công Việc;Ngày Khởi Công;Ngày Hoàn Thành(DK);Mô Tả")
				.split(";");
		modelTTCN = new DefaultTableModel(headerTTCN, 0);
		jTable1.setModel(modelTTCN);

		jScrollPane1.setViewportView(jTable1);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setMinWidth(50);
			jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
			jTable1.getColumnModel().getColumn(1).setMinWidth(120);
			jTable1.getColumnModel().getColumn(1).setMaxWidth(120);
			jTable1.getColumnModel().getColumn(2).setMinWidth(180);
			jTable1.getColumnModel().getColumn(2).setMaxWidth(180);
			jTable1.getColumnModel().getColumn(3).setMinWidth(300);
			jTable1.getColumnModel().getColumn(3).setMaxWidth(300);
			jTable1.getColumnModel().getColumn(4).setMinWidth(150);
			jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
			jTable1.getColumnModel().getColumn(5).setMinWidth(150);
			jTable1.getColumnModel().getColumn(5).setMaxWidth(150);
			jTable1.getColumnModel().getColumn(6).setMinWidth(150);
			jTable1.getColumnModel().getColumn(6).setMaxWidth(150);
			jTable1.getColumnModel().getColumn(7).setMinWidth(250);
			jTable1.getColumnModel().getColumn(7).setMaxWidth(250);
		}

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE));

		javax.swing.GroupLayout TTCNLayout = new javax.swing.GroupLayout(TTCN);
		TTCN.setLayout(TTCNLayout);
		TTCNLayout.setHorizontalGroup(TTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						TTCNLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 152,
										javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(TTCNLayout.createSequentialGroup().addContainerGap(14, Short.MAX_VALUE)
						.addComponent(lbl_Profile)
						.addGroup(TTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(TTCNLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(TTCNLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												TTCNLayout.createSequentialGroup().addGap(899, 899, 899).addComponent(
														btn_DoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 152,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(TTCNLayout.createSequentialGroup().addGroup(TTCNLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(TTCNLayout.createSequentialGroup().addGroup(TTCNLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lbl_ttcnTenNV)
														.addComponent(lbl_ttcnMaNV,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(lbl_ttcnGT)).addGap(42, 42, 42)
														.addGroup(TTCNLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addGroup(TTCNLayout.createSequentialGroup()
																		.addComponent(Rbtn_ttcnNam).addGap(33, 33, 33)
																		.addComponent(Rbtn_ttcnNu))
																.addComponent(txt_ttcnMaNV)
																.addComponent(txt_ttcnPhongBan)
																.addComponent(txt_ttcnTenNV,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 200,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(0, 174, Short.MAX_VALUE))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TTCNLayout
														.createSequentialGroup().addComponent(lbl_ttcnPB)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(TTCNLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(lbl_ttcnTuoi).addComponent(lbl_ttcnCMND)
																.addComponent(lbl_ttcnSDT).addComponent(lbl_ttcnDiaChi))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
												.addGroup(TTCNLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(TTCNLayout.createSequentialGroup()
																.addComponent(txt_ttcnCMND,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 201,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		180, Short.MAX_VALUE)
																.addComponent(btn_TroGiup,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 152,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(TTCNLayout.createSequentialGroup().addGroup(TTCNLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(DateChooser_ttcnNamSinh,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 201,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(txt_ttcnSDT,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 204,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(txt_ttcnDiaChi,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 204,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(0, 0, Short.MAX_VALUE))))))
								.addGroup(TTCNLayout.createSequentialGroup().addGap(266, 266, 266)
										.addComponent(btn_HoanTat, javax.swing.GroupLayout.PREFERRED_SIZE, 284,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))))
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		TTCNLayout.setVerticalGroup(TTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(TTCNLayout.createSequentialGroup()
						.addComponent(btn_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(5, 5, 5)
						.addGroup(TTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(TTCNLayout.createSequentialGroup()
										.addComponent(btn_DoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(TTCNLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(TTCNLayout.createSequentialGroup()
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(btn_TroGiup,
																javax.swing.GroupLayout.PREFERRED_SIZE, 46,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(TTCNLayout.createSequentialGroup().addGap(18, 18, 18)
														.addGroup(TTCNLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(TTCNLayout.createSequentialGroup()
																		.addGap(2, 2, 2)
																		.addGroup(TTCNLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(lbl_ttcnPB)
																				.addComponent(txt_ttcnPhongBan,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
																.addGroup(TTCNLayout.createSequentialGroup()
																		.addGroup(TTCNLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(txt_ttcnCMND,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(lbl_ttcnCMND))
																		.addGap(18, 18, 18)
																		.addGroup(TTCNLayout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(TTCNLayout
																						.createSequentialGroup()
																						.addGroup(TTCNLayout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										lbl_ttcnMaNV)
																								.addComponent(
																										txt_ttcnMaNV,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										lbl_ttcnTuoi))
																						.addGap(18, 18, 18)
																						.addGroup(TTCNLayout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										txt_ttcnTenNV,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										lbl_ttcnTenNV))
																						.addGap(18, 18, 18)
																						.addGroup(TTCNLayout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.BASELINE)
																								.addComponent(
																										lbl_ttcnGT)
																								.addComponent(
																										Rbtn_ttcnNu)
																								.addComponent(
																										Rbtn_ttcnNam)))
																				.addGroup(TTCNLayout
																						.createSequentialGroup()
																						.addComponent(
																								DateChooser_ttcnNamSinh,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(18, 18, 18)
																						.addGroup(TTCNLayout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										lbl_ttcnSDT)
																								.addComponent(
																										txt_ttcnSDT,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGap(18, 18, 18)
																						.addGroup(TTCNLayout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										lbl_ttcnDiaChi)
																								.addComponent(
																										txt_ttcnDiaChi,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE))))))))
										.addGap(29, 29, 29).addComponent(btn_HoanTat,
												javax.swing.GroupLayout.PREFERRED_SIZE, 48,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_Profile))
						.addGap(27, 27, 27)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE)));

		javax.swing.GroupLayout pn_TTCNLayout = new javax.swing.GroupLayout(pn_TTCN);
		pn_TTCN.setLayout(pn_TTCNLayout);
		pn_TTCNLayout.setHorizontalGroup(pn_TTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pn_TTCNLayout.createSequentialGroup()
						.addComponent(TTCN, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 12, Short.MAX_VALUE)));
		pn_TTCNLayout
				.setVerticalGroup(
						pn_TTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pn_TTCNLayout.createSequentialGroup()
										.addComponent(TTCN, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));

		JTB_QLLD.addTab("THÔNG TIN CÁ NHÂN",
				new javax.swing.ImageIcon(getClass().getResource("/images/background.png")), pn_TTCN,
				"THÔNG TIN NGƯỜI DÙNG");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				JTB_QLLD, javax.swing.GroupLayout.PREFERRED_SIZE, 1372, javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(JTB_QLLD));

		pack();
		setLocationRelativeTo(null);
		getDataPCNVCT();
		getDataPCNVNV();
		getDataQLCT();
		getDataBCCNV();
		getDataQLPB();
		getDataQLCV();
		getDataQLCVu();
		getDataFTTC(maTaiKhoan);
	}

	private void cbb_LocCTActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btn_CapNhatTKActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		String maTaiKhoan = txt_tkMaNV.getText();
		String tenTaiKhoan = txt_tkTenNV.getText();
		String matKhau = txt_tkMatKhau.getText();
		TaiKhoan tk = new TaiKhoan(maTaiKhoan, tenTaiKhoan, matKhau);
		if (txt_tkMatKhau.getText().equalsIgnoreCase(txt_tkNLMatKhau.getText())) {
			taiKhoan_DAO.updateTaiKhoan(tk);
			deleteDataQLTKNV();
			getDataQLTK();
			JOptionPane.showMessageDialog(this, "Sửa Thành Công");
		} else {
			JOptionPane.showMessageDialog(this, "Error:Hai Mật Khẩu Không Trùng Nhau!!!");
		}

	}

	private void btn_XoaTrangTKActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btn_XoaTKActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void cbb_tkTimPBActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btn_CapNhatChVActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_CapNhatChV)) {
			String maCongViec = txt_cvMaChV.getText();
			String tenCongViec = txt_cvTenChV.getText();
			String moTa = txt_cvMoTaChV.getText();
			ChucVu chucVu = new ChucVu(maCongViec, tenCongViec, moTa);
			chucVu_DAO.updateChucVu(chucVu);
			deleteDataQLChucVu();
			getDataQLCVu();
			JOptionPane.showMessageDialog(this, "Sửa thành công");
			XoaTrangChV();
		}
	}

	private void btn_XoaTrangChVActionPerformed(java.awt.event.ActionEvent evt) {
		Object o = evt.getSource();
		if (o.equals(btn_XoaTrangChV)) {
			txt_cvMaChV.setText("");
			txt_cvTenChV.setText("");
			txt_cvMoTaChV.setText("");
		}
	}

	private void btn_XoaChVActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_XoaChV)) {
			int rowIndex = tbl_QLChV.getSelectedRow();
			String rowData = modelChV.getValueAt(rowIndex, 1).toString();

			if (JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Muốn Xóa?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				congViec_DAO.deleteCongViec(rowData);
				modelChV.removeRow(rowIndex);
				JOptionPane.showMessageDialog(this, "Xóa thành công");
				XoaTrangChV();
			}
		}
	}

	private void btn_CapNhatCVActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_CapNhatCV)) {
			String maCongViec = txt_cvMaCV.getText();
			String tenCongViec = txt_cvTenCV.getText();
			String moTa = txt_cvMoTaCV.getText();
			CongViec cv = new CongViec(maCongViec, tenCongViec, moTa);
			congViec_DAO.updateCongViec(cv);
			deleteDataQLCongViec();
			getDataQLCV();
			JOptionPane.showMessageDialog(this, "Sửa Thành Công");
			XoaTrangCV();
		}
	}

	private void btn_XoaTrangCVActionPerformed(java.awt.event.ActionEvent evt) {
		Object o = evt.getSource();
		if (o.equals(btn_XoaTrangCV)) {
			txt_cvMaCV.setText("");
			txt_cvTenCV.setText("");
			txt_cvMoTaCV.setText("");
		}
	}

	private void btn_XoaCVActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_XoaCV)) {
			int rowIndex = tbl_QLCV.getSelectedRow();
			String rowData = modelCV.getValueAt(rowIndex, 1).toString();
			if (JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Muốn Xóa?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				congViec_DAO.deleteCongViec(rowData);
				modelCV.removeRow(rowIndex);
				JOptionPane.showMessageDialog(this, "Xóa thành công");
				XoaTrangCV();
			}
		}
	}

	private void btn_CapNhatCTActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_CapNhatCT)) {
			String maCT = txt_ctMaCT.getText();
			String tenCT = txt_ctTenCT.getText();
			String diaChi = txt_ctDiaChiCT.getText() + "," + cbb_ctPhuong.getSelectedItem().toString() + ","
					+ cbb_ctQuan.getSelectedItem().toString();
			String loaiHinh = cbb_ctLoaiHinhCT.getSelectedItem().toString();
			String tempSGP = txt_ctSoGiayPhep.getText();
			int giayPhepSo = Integer.parseInt(tempSGP);
			SimpleDateFormat nCP = new SimpleDateFormat("yyyy-MM-dd");
			String ngayCP = nCP.format(DateChooser_ctNgayCP.getDate());
			SimpleDateFormat nKC = new SimpleDateFormat("yyyy-MM-dd");
			String ngayKC = nKC.format(DateChooser_ctNgayKC.getDate());
			SimpleDateFormat nHT = new SimpleDateFormat("yyyy-MM-dd");
			String ngayHT = nHT.format(DateChooser_ctNgayHT.getDate());
			boolean trangthai = Rbtn_pcTrangThaiDHT.isSelected();
			CongTrinh ct = new CongTrinh(maCT, tenCT, diaChi, loaiHinh, giayPhepSo, ngayCP, ngayKC, ngayHT, trangthai);
			congTrinh_DAO.updateCongTrinh(ct);
			deleteDataQLCT();
			getDataQLCT();
			JOptionPane.showMessageDialog(this, "Sửa thành công");
			XoaTrangCT();
		}
	}

	private void btn_XoaTrangCTActionPerformed(java.awt.event.ActionEvent evt) {
		Object o = evt.getSource();
		if (o.equals(btn_XoaTrangCT)) {
			txt_ctMaCT.setText("");
			txt_ctTenCT.setText("");
			txt_ctDiaChiCT.setText("");
			cbb_ctQuan.setSelectedItem(0);
			cbb_ctPhuong.setSelectedItem(0);
			DateChooser_ctNgayCP.setDate(null);
			DateChooser_ctNgayKC.setDate(null);
			DateChooser_ctNgayHT.setDate(null);
			Rbtn_pcTrangThaiCHT.setSelected(false);
			Rbtn_pcTrangThaiDHT.setSelected(false);
		}
	}

	private void btn_XoaCTActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_XoaCT)) {
			int rowIndex = tbl_QLCT.getSelectedRow();
			String rowData = modelCT.getValueAt(rowIndex, 1).toString();
			if (JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Muốn Xóa?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				congTrinh_DAO.deleteCongTrinh(rowData);
				modelCT.removeRow(rowIndex);
				JOptionPane.showMessageDialog(this, "Xóa Thành Công");
				XoaTrangCT();
			}
		}
	}

	private void btn_XoaTrangPBActionPerformed(java.awt.event.ActionEvent evt) {
		Object o = evt.getSource();
		if (o.equals(btn_XoaTrangPB)) {
			txt_pbMaPB.setText("");
			txt_pbTenPB.setText("");
			txt_pbHotline.setText("");
			txt_pbMoTa.setText("");
		}
	}

	private void btn_CapNhatPBActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_CapNhatPB)) {
			String maCT = txt_pbMaPB.getText();
			String tenCT = txt_pbTenPB.getText();
			String hotLine = txt_pbHotline.getText();
			String moTa = txt_pbMoTa.getText();

			PhongBan pb = new PhongBan(maCT, tenCT, hotLine, moTa);
			phongBan_DAO.updatePhongBan(pb);
			deleteDataQLPB();
			getDataQLPB();
			JOptionPane.showMessageDialog(this, "Sửa thành công");
			XoaTrangPB();
		}
	}

	private void btn_XoaPBActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_XoaPB)) {
			int rowIndex = tbl_QLPB.getSelectedRow();
			String rowData = modelPB.getValueAt(rowIndex, 1).toString();
			if (JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Muốn Xóa?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				phongBan_DAO.deletePhongBan(rowData);
				modelPB.removeRow(rowIndex);
				JOptionPane.showMessageDialog(this, "Xóa Thành Công!!!");
				XoaTrangPB();
			}
		}
	}

	private void btn_XoaTrangNVActionPerformed(java.awt.event.ActionEvent evt) {
		Object o = evt.getSource();
		if (o.equals(btn_XoaTrangNV)) {
			txt_nvMaNV.setText("");
			txt_nvTenNV.setText("");
			txt_nvCMND.setText("");
			Rbtn_Nam.setSelected(false);
			Rbtn_Nu.setSelected(false);
			DateChooser_NamSinh.setDate(null);
			txt_nvSDT.setText("");
			txt_nvDiaChiNV.setText("");
			cbb_nvChonPB.setSelectedIndex(0);
			cbb_nvChonChV.setSelectedIndex(0);
			cbb_nvThanhPho.setSelectedIndex(0);
			cbb_nvQuanHuyen.setSelectedIndex(0);
			cbb_nvPhuongXa.setSelectedIndex(0);

		}
	}

	private void btn_CapNhatNVActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_CapNhatNV)) {
			String maNhanVien = txt_nvMaNV.getText();
			String tenNhanVien = txt_nvTenNV.getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinh = dateFormat.format(DateChooser_NamSinh.getDate());
			boolean gioiTinh = Rbtn_Nu.isSelected();
			String soCMND = txt_nvCMND.getText();
			String diaChi = txt_nvDiaChiNV.getText();
			String soDT = txt_nvSDT.getText();
			String tenChucVu = cbb_nvChonChV.getSelectedItem().toString();
			String maPhongBan = cbb_nvChonPB.getSelectedItem().toString();
			NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soCMND, diaChi, soDT, tenChucVu,
					maPhongBan);

			nhanVien_DAO.updateNhanVien(nv);
			deleteDataQLNV();
			getDataQLNV();
			JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
			XoaTrangNV();
		}
	}

	private void btn_XoaNVActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_XoaNV)) {
			int rowIndex = tbl_QLNV.getSelectedRow();
			String rowData = modelNV.getValueAt(rowIndex, 1).toString();
			if (JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Muốn Xóa?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				nhanVien_DAO.deleteNhanVien(rowData);
				modelNV.removeRow(rowIndex);
				JOptionPane.showMessageDialog(this, "Xóa Thành Công");
				XoaTrangNV();
			}
		}
	}

	private void cbb_nvTimChucVuActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		String tenChucVu = cbb_nvTimChucVu.getSelectedItem().toString();
		if (cbb_nvTimChucVu.getSelectedItem().toString().equalsIgnoreCase(tenChucVu)) {
			cbb_nvTimPB.setSelectedIndex(0);
			getDataTheoChV(tenChucVu);
			cbb_nvTimChucVu.setSelectedItem(tenChucVu);
		}
	}

	private void btn_LuuCTActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_LuuCT)) {
			if (validDataCT()) {
				String maCT = txt_ctMaCT.getText();
				String tenCT = txt_ctTenCT.getText();
				String diaChi = txt_ctDiaChiCT.getText();
				String loaiHinh = cbb_ctLoaiHinhCT.getSelectedItem().toString();
				String tempSGP = txt_ctSoGiayPhep.getText();
				int giayPhepSo = Integer.parseInt(tempSGP);
				SimpleDateFormat nCP = new SimpleDateFormat("yyyy-MM-dd");
				String ngayCP = nCP.format(DateChooser_ctNgayCP.getDate());
				SimpleDateFormat nKC = new SimpleDateFormat("yyyy-MM-dd");
				String ngayKC = nKC.format(DateChooser_ctNgayKC.getDate());
				SimpleDateFormat nHT = new SimpleDateFormat("yyyy-MM-dd");
				String ngayHT = nHT.format(DateChooser_ctNgayHT.getDate());
				boolean trangThai = Rbtn_TrangThaiDHT.isSelected();

				CongTrinh ct = new CongTrinh(maCT, tenCT, diaChi, loaiHinh, giayPhepSo, ngayCP, ngayKC, ngayHT,
						trangThai);

				if (congTrinh_DAO.addCongTrinh(ct)) {
					modelCT.addRow(new Object[] { tbl_QLCT.getRowCount() + 1, ct.getMaCongTrinh(), ct.getTenCongTrinh(),
							ct.getDiaDiem(), ct.getNgayCapPhep(), ct.getNgayKhoiCong(), ct.getNgayHoanThanh(),
							ct.isTrangThai() ? "Đã hoàn thành" : "Chưa hoàn thành" });
					JOptionPane.showMessageDialog(this, "Thêm thành công");
					XoaTrangCT();

				} else {
					return;
				}
			}
		}
	}

	private void btn_LuuNVActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_LuuNV)) {
			if (validDataNV()) {
				String maNhanVien = txt_nvMaNV.getText();
				String tenNhanVien = txt_nvTenNV.getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String ngaySinh = dateFormat.format(DateChooser_NamSinh.getDate());
				boolean gioiTinh = Rbtn_Nam.isSelected();
				String soCMND = txt_nvCMND.getText();
				String diaChi = txt_nvDiaChiNV.getText() + ", " + cbb_nvPhuongXa.getSelectedItem().toString() + ", "
						+ cbb_nvQuanHuyen.getSelectedItem().toString() + ", "
						+ cbb_nvThanhPho.getSelectedItem().toString();
				String soDT = txt_nvSDT.getText();
				String tenChucVu = cbb_nvChonChV.getSelectedItem().toString();
				String maPhongBan = cbb_nvChonPB.getSelectedItem().toString();

				NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soCMND, diaChi, soDT, tenChucVu,
						maPhongBan);

				try {
					if (nhanVien_DAO.addNhanVien(nv)) {
						modelNV.addRow(new Object[] { tbl_QLNV.getRowCount() + 1, nv.getMaNhanVien(),
								nv.getTenNhanVien(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(),
								nv.getDiaChi(), nv.getSoDT(), nv.getChucVu(), nv.getPhongBan() });
						JOptionPane.showMessageDialog(this, "Thêm Thành Công");
						XoaTrangNV();
					} else {
						return;
					}
				} catch (HeadlessException | SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}

	private void btn_LuuPBActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_LuuPB)) {
			if (validDataPB()) {
				String tenPB = txt_pbTenPB.getText();
				String hotline = txt_pbHotline.getText();
				String moTa = txt_pbMoTa.getText();
				PhongBan pb = new PhongBan(phongBan_DAO.sinhMaPBTuDong(), tenPB, hotline, moTa);

				if (phongBan_DAO.addPhongBan(pb)) {
					modelPB.addRow(new Object[] { tbl_QLPB.getRowCount() + 1, pb.getMaPhongBan(), pb.getTenPhongBan(),
							pb.getHotLine(), pb.getMoTa() });
					JOptionPane.showMessageDialog(this, "Thêm Thành Công!!!");
					XoaTrangPB();
				} else {
					return;
				}
			}
		}
	}

	private void btn_LuuCVActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_LuuCV)) {
			if (validDataCV()) {
				String tenCongViec = txt_cvTenCV.getText();
				String moTa = txt_cvMoTaCV.getText();
				CongViec congViec = new CongViec(congViec_DAO.sinhMaCongViecTuDong(), tenCongViec, moTa);
				if (congViec_DAO.addCongViec(congViec)) {
					modelCV.addRow(new Object[] { tbl_QLCV.getRowCount() + 1, congViec.getMaCongViec(),
							congViec.getTenCongViec(), congViec.getMoTa() });
					JOptionPane.showMessageDialog(this, "Thêm Thành Công!!!");
					XoaTrangCV();
				} else {
					return;
				}
			}
		}
	}

	private void btn_LuuChVActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_LuuChV)) {
			if (validDataChV()) {
				String tenChucVu = txt_cvTenChV.getText();
				String moTa = txt_cvMoTaChV.getText();
				ChucVu chucVu = new ChucVu(chucVu_DAO.sinhMaChucVuTuDong(), tenChucVu, moTa);
				if (chucVu_DAO.addChucVu(chucVu)) {
					modelChV.addRow(new Object[] { tbl_QLChV.getRowCount() + 1, chucVu.getMaChucVu(),
							chucVu.getTenChucVu(), chucVu.getMoTa() });
					JOptionPane.showMessageDialog(this, "Thêm Thành Công!!!");
					XoaTrangChV();
				} else {
					return;
				}
			}
		}
	}

	private void btn_LuuTKActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		if (validDataTK()) {
			String maNhanVien = txt_tkMaNV.getText();
			String matKhau = txt_tkMatKhau.getText();
			TaiKhoan taikhoan = new TaiKhoan(new NhanVien(maNhanVien), matKhau);
			if (taiKhoan_DAO.addTaiKhoan(taikhoan)) {
				modelTKNV.addRow(new Object[] { tbl_QLTK.getRowCount() + 1, taikhoan.getNhanVien().getMaNhanVien(),
						taikhoan.getNhanVien().getTenNhanVien(), taikhoan.getMatKhau() });
				JOptionPane.showMessageDialog(this, "Thêm Thành Công!!!");
				deleteDataQLTKNV();
				getDataQLTK();

			} else {
				JOptionPane.showMessageDialog(null, "Trùng Tài Khoản!!!");
				;
			}
		}
	}

	private void btn_pcTimCTActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		boolean in1 = cbb_LocCT.getSelectedItem().toString().equalsIgnoreCase("Mã Công Trình");
		boolean in2 = cbb_LocCT.getSelectedItem().toString().equalsIgnoreCase("Tên Công Trình");
		String inIndex = txt_pcTimTenCT.getText();
		if (in1 && inIndex.length() > 0) {
			List<CongTrinh> dsCT = congTrinh_DAO.getCongTrinhTheoMaCT(inIndex);
			if (dsCT != null) {
				deleteDataPCNVCT();
				for (CongTrinh ct : dsCT) {
					if (!(ct.isTrangThai())) {
						modelPCNVCT.addRow(new Object[] { modelPCNVCT.getRowCount() + 1, ct.getMaCongTrinh(),
								ct.getTenCongTrinh(), ct.getDiaDiem(), ct.getNgayCapPhep(), ct.getNgayKhoiCong(),
								ct.getNgayHoanThanh(), ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
					}
				}
				XoaTrangPCNV();
			}
		} else if (in2 && inIndex.length() > 0) {
			List<CongTrinh> dsCT = congTrinh_DAO.getCongTrinhTheoTenCT(inIndex);
			if (dsCT != null) {
				deleteDataPCNVCT();
				for (CongTrinh ct : dsCT) {
					if (!(ct.isTrangThai())) {
						modelPCNVCT.addRow(new Object[] { modelPCNVCT.getRowCount() + 1, ct.getMaCongTrinh(),
								ct.getTenCongTrinh(), ct.getDiaDiem(), ct.getNgayCapPhep(), ct.getNgayKhoiCong(),
								ct.getNgayHoanThanh(), ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
					}
				}
				XoaTrangPCNV();
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"Dữ Liệu Không Tồn Tại, Vui Lòng Chọn Lại Lựa Chọn Hoặc Nhập Lại Dữ Liệu");
			XoaTrangPCNV();
		}

	}

	private void btn_INActionPerformed(java.awt.event.ActionEvent evt) {
		if (txt_pcMaCT.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Công Trình Để PCNV!!!");
			return;
		}
		if (tbl_pcDanhSachNV.getSelectedRowCount() > 1) {
			PhanCong phanCong = new PhanCong();
			phanCong.setVisible(true);
			phanCong.getBtn_DongY().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int[] indexs = tbl_pcDanhSachNV.getSelectedRows();
					Object[] row = new Object[7];
					for (int i = 0; i < indexs.length; i++) {
						row[0] = modelPCNVJCT.getRowCount() + 1;
						row[1] = modelPCNVNV.getValueAt(indexs[i], 1);
						row[2] = modelPCNVNV.getValueAt(indexs[i], 2);
						row[3] = modelPCNVNV.getValueAt(indexs[i], 5);
						row[4] = phanCong.getCbb_ChonCongViec().getSelectedItem().toString();
						row[5] = phanCong.getPc_NgayBatDau();
						row[6] = phanCong.getPc_NgayKetThuc();
						Date date1 = null;
						Date date2 = null;
						LocalDate localDate = LocalDate.now();
						Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
						try {
							date1 = sdf.parse(row[5].toString());
							date2 = sdf.parse(row[6].toString());

							if (date1.before(date) || date1.equals(date)) {
								JOptionPane.showMessageDialog(null, "Ngày Bắt Đầu Phải Lớn Hơn Ngày Hiện Tại");
								return;
							}
							if (date2.before(date1) || date2.equals(date1)) {
								JOptionPane.showMessageDialog(null,
										"Ngày Kết Thúc Không Được Bằng Hoặc Bé Hơn Ngày Bắt Đầu");
								return;
							}
						} catch (ParseException e) {
							e.printStackTrace();
						}
						if (row[3].toString().equalsIgnoreCase("Lao Động")) {
							modelPCNVJCT.addRow(row);
						} else {
							JOptionPane.showMessageDialog(null, "Chỉ Được Phân Công Hàng Loạt Cho Lao Động");
							return;
						}

					}
					return;
				}
			});

		} else {
			String chucVu = modelPCNVNV.getValueAt(tbl_pcDanhSachNV.getSelectedRow(), 4).toString();
			if (chucVu.equalsIgnoreCase("Lao Động")) {
				DefaultCellEditor cellEditorNVJCT1 = new DefaultCellEditor(cbbCongViec_LaoDong);
				tbl_pcNVThamGia.getColumnModel().getColumn(4).setCellEditor(cellEditorNVJCT1);
			} else if (chucVu.equalsIgnoreCase("Bảo Vệ")) {
				DefaultCellEditor cellEditorNVJCT2 = new DefaultCellEditor(cbbCongViec_BaoVe);
				tbl_pcNVThamGia.getColumnModel().getColumn(4).setCellEditor(cellEditorNVJCT2);
			} else if (chucVu.equalsIgnoreCase("Kiến Trúc Sư")) {
				DefaultCellEditor cellEditorNVJCT3 = new DefaultCellEditor(cbbCongViec_kTrucSu);
				tbl_pcNVThamGia.getColumnModel().getColumn(4).setCellEditor(cellEditorNVJCT3);
			} else if (chucVu.equalsIgnoreCase("Kỹ Sư Xây Dựng")) {
				DefaultCellEditor cellEditorNVJCT4 = new DefaultCellEditor(cbbCongViec_KSXD);
				tbl_pcNVThamGia.getColumnModel().getColumn(4).setCellEditor(cellEditorNVJCT4);
			} else if (chucVu.equalsIgnoreCase("Quản Lý Công Trình")) {
				DefaultCellEditor cellEditorNVJCT5 = new DefaultCellEditor(cbbCongViec_QLCT);
				tbl_pcNVThamGia.getColumnModel().getColumn(4).setCellEditor(cellEditorNVJCT5);
			} else if (chucVu.equalsIgnoreCase("Kỹ Sư Điện")) {
				DefaultCellEditor cellEditorNVJCT6 = new DefaultCellEditor(cbbCongViec_KSD);
				tbl_pcNVThamGia.getColumnModel().getColumn(4).setCellEditor(cellEditorNVJCT6);
			}
			Object[] rowData = { tbl_pcNVThamGia.getRowCount() + 1,
					tbl_pcDanhSachNV.getValueAt(tbl_pcDanhSachNV.getSelectedRow(), 1),
					tbl_pcDanhSachNV.getValueAt(tbl_pcDanhSachNV.getSelectedRow(), 2),
					tbl_pcDanhSachNV.getValueAt(tbl_pcDanhSachNV.getSelectedRow(), 4), "Chọn Công Việc" };
			modelPCNVJCT.addRow(rowData);
		}

	}

	private void btn_OUTActionPerformed(java.awt.event.ActionEvent evt) {
		if (tbl_pcNVThamGia.getSelectedRow() > 1) {
			int[] indexs = tbl_pcNVThamGia.getSelectedRows();
			for (int i = indexs.length - 1; i >= 0; i--) {
				modelPCNVJCT.removeRow(indexs[i]);
			}
		} else {
			modelPCNVJCT.removeRow(tbl_pcNVThamGia.getSelectedRow());
		}

	}

	private void btn_HoanTatActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btn_tkTimNVActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btn_nvTimNVActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_nvTimNV)) {
			String in1 = txt_nvTimMaNV.getText().trim();
			String in2 = txt_nvTimTenNV.getText().trim();
			cbb_nvTimPB.setSelectedIndex(0);
			cbb_nvTimChucVu.setSelectedIndex(0);

			if (in1 != null && in1.trim().length() > 0) {
				List<NhanVien> dsNV = nhanVien_DAO.getNVTheoMaNV(in1);
				if (dsNV != null) {
					deleteDataQLNV();
					for (NhanVien nv : dsNV) {
						modelNV.addRow(new Object[] { modelNV.getRowCount() + 1, nv.getMaNhanVien(),
								nv.getTenNhanVien(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(),
								nv.getDiaChi(), nv.getSoDT(), nv.getChucVu(), nv.getPhongBan() });
					}
				}
			} else if (in2 != null && in2.trim().length() > 0) {
				List<NhanVien> dsNV = nhanVien_DAO.getNVTheoTenNV(in2);
				if (dsNV != null) {
					deleteDataQLNV();
					for (NhanVien nv : dsNV) {
						modelNV.addRow(new Object[] { modelNV.getRowCount() + 1, nv.getMaNhanVien(),
								nv.getTenNhanVien(), nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(),
								nv.getDiaChi(), nv.getSoDT(), nv.getChucVu(), nv.getPhongBan() });
					}
				}
			} else {
				deleteDataQLNV();
				getDataQLNV();
			}

		}
	}

	private void btn_pbTimPBActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_pbTimPB)) {
			String in1 = txt_pbMaPB.getText().trim();
			String in2 = txt_pbTenPB.getText().trim();
			if (in1 != null && in1.trim().length() > 0) {
				List<PhongBan> dsPB = phongBan_DAO.getPBTheoMaPB(in1);
				if (dsPB != null) {
					deleteDataQLPB();
					for (PhongBan pb : dsPB) {
						modelPB.addRow(new Object[] { modelPB.getRowCount() + 1, pb.getMaPhongBan(),
								pb.getTenPhongBan(), pb.getHotLine(), pb.getMoTa() });

					}
				}
			} else if (in2 != null && in2.trim().length() > 0) {
				List<PhongBan> dsPB = phongBan_DAO.getPhongBanTheoTenPB(in2);
				if (dsPB != null) {
					deleteDataQLPB();

					for (PhongBan pb : dsPB) {
						modelPB.addRow(new Object[] { modelPB.getRowCount() + 1, pb.getMaPhongBan(),
								pb.getTenPhongBan(), pb.getHotLine(), pb.getMoTa() });
					}
				}
			} else {
				deleteDataQLPB();
				getDataQLPB();
			}

		}
	}

	private void btn_ctTimCTActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		Object o = evt.getSource();
		if (o.equals(btn_ctTimCT)) {
			String in1 = txt_ctTimMaCT.getText().trim();
			String in2 = txt_ctTimTenCT.getText().trim();
			if (in1 != null && in1.trim().length() > 0) {
				List<CongTrinh> dsCT = congTrinh_DAO.getCongTrinhTheoMaCT(in1);
				if (dsCT != null) {
					deleteDataQLCT();
					for (CongTrinh ct : dsCT) {
						modelCT.addRow(new Object[] { modelCT.getRowCount() + 1, ct.getMaCongTrinh(),
								ct.getTenCongTrinh(), ct.getDiaDiem(), ct.getNgayCapPhep(), ct.getNgayKhoiCong(),
								ct.getNgayHoanThanh(), ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
					}
				}

			} else if (in2 != null && in2.trim().length() > 0) {
				List<CongTrinh> dsCT = congTrinh_DAO.getCongTrinhTheoTenCT(in2);
				if (dsCT != null) {
					deleteDataQLCT();
					for (CongTrinh ct : dsCT) {
						modelCT.addRow(new Object[] { modelCT.getRowCount() + 1, ct.getMaCongTrinh(),
								ct.getTenCongTrinh(), ct.getDiaDiem(), ct.getNgayCapPhep(), ct.getNgayKhoiCong(),
								ct.getNgayHoanThanh(), ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
					}
				}
			}

			else {
				deleteDataQLCT();
				getDataQLCT();
			}

		}
	}

	private void cbb_ctLoaiHinhCTActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		modelCT.setRowCount(0);
		String maCongTrinh = cbb_ctLoaiHinhCT.getSelectedItem().toString();
		if (cbb_ctLoaiHinhCT.getSelectedItem().toString().equalsIgnoreCase(maCongTrinh)) {
			// cbb_nvTimChucVu.setSelectedIndex(0);
			getDataTheoCT(maCongTrinh);
			cbb_ctLoaiHinhCT.setSelectedItem(maCongTrinh);
		}

	}

	private void btn_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
		dangNhap.setVisible(true);
		dangNhap.setLocationRelativeTo(null);
	}

	private void btn_DoiMKActionPerformed(java.awt.event.ActionEvent evt) {
		doiMatKhau.setVisible(true);
		doiMatKhau.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void btn_TroGiupActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btn_ThongTinActionPerformed(java.awt.event.ActionEvent evt) {
		thongTin.setVisible(true);
		thongTin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void Rbtn_TrangThaiDHTActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void cbb_nvTimPBActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		modelNV.setRowCount(0);
		String temp = cbb_nvTimPB.getSelectedItem().toString();
		String[] temp1 = temp.split("-");
		String maPhongBan = temp1[0];
		cbb_nvTimChucVu.setSelectedIndex(0);
		getDataNVTheoPB(maPhongBan);
		cbb_nvTimPB.setSelectedItem(temp1[0] + "-" + temp1[1]);

	}

	private void btn_XacNhanThongKeActionPerformed(ActionEvent evt) throws SQLException {
		modelTKCT.setRowCount(0);
		txt_SoLuong.setText("");
		Object o = evt.getSource();
		if (o.equals(btn_XacNhanThongKe)) {
			getDataTKCTWD(txt_NamXD.getText());
			int temp = modelTKCT.getRowCount();
			String quantity = Integer.toString(temp);
			txt_SoLuong.setText(quantity);
		}
	}

	private void Rbtn_pcTrangThaiDHTActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void cbb_TieuChiActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		modelTKCT.setRowCount(0);
		if (cbb_TieuChi.getSelectedIndex() == 0) {
			txt_SoLuong.setText("");
			JOptionPane.showMessageDialog(this, "Vui lòng chọn Tiêu Chí!");
			return;
		}
		if (cbb_TieuChi.getSelectedItem().toString().equalsIgnoreCase("Thống kê số Công Trình đã hoàn thành")) {
			getDataTKCT1();
			int temp = modelTKCT.getRowCount();
			String quantity = Integer.toString(temp);
			txt_SoLuong.setText(quantity);
			txt_NamXD.setText("");
		} else if (cbb_TieuChi.getSelectedItem().toString()
				.equalsIgnoreCase("Thống kê số Công Trình chưa hoàn thành")) {
			getDataTKCT0();
			int temp = modelTKCT.getRowCount();
			String quantity = Integer.toString(temp);
			txt_SoLuong.setText(quantity);
			txt_NamXD.setText("");
		}
	}

	private void cbb_TimCMActionPerformed(ActionEvent evt) throws SQLException {
		modelCM.setRowCount(0);
		if (cbb_TimCM.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui Lòng Chọn Chuyên Môn Muốn Lọc");
			return;
		}
		if (cbb_TimCM.getSelectedItem().toString().equalsIgnoreCase("Kỹ Sư")) {
			getDataQLCM0();
		}
		if (cbb_TimCM.getSelectedItem().toString().equalsIgnoreCase("Quản Lý")) {
			getDataQLCM1();
		}
		if (cbb_TimCM.getSelectedItem().toString().equalsIgnoreCase("Kinh Tế")) {
			getDataQLCM2();
		}
		if (cbb_TimCM.getSelectedItem().toString().equalsIgnoreCase("Công Nhân")) {
			getDataQLCM3();
		}
	}

	private void cbb_nvChonChVu1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void cbb_nvChonPB1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void btn_OKCongViecActionPerformed(java.awt.event.ActionEvent evt) {
		String maNhanVien;
		String maCongTrinh = txt_pcMaCT.getText();
		String tenCongViec;
		String ngayBD;
		String ngayKT;
		for (int i = 0; i < tbl_pcNVThamGia.getRowCount(); i++) {
			tenCongViec = tbl_pcNVThamGia.getValueAt(i, 4).toString();
			if (tenCongViec.equalsIgnoreCase("Chọn Công Việc")) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn Công Việc cho Nhân Viên");
				return;
			}

		}

		try {
			@SuppressWarnings("static-access")
			Connection con = ConnectDB.getInstance().getConnect();
			Statement statement = con.createStatement();
			statement.executeUpdate("DELETE FROM tbl_PhanCongNhanVien WHERE maCongTrinh = '" + maCongTrinh + "'");
			PreparedStatement preparedStatement = con.prepareStatement(
					"INSERT INTO tbl_PhanCongNhanVien(maNhanVien, maCongTrinh, tenCongViec, ngayBatDau, ngayKetThuc) VALUES(?, ?, ?, ?, ?)");

			for (int i = 0; i < tbl_pcNVThamGia.getRowCount(); i++) {
				maNhanVien = tbl_pcNVThamGia.getValueAt(i, 1).toString();
				tenCongViec = tbl_pcNVThamGia.getValueAt(i, 4).toString();
				ngayBD = tbl_pcNVThamGia.getValueAt(i, 5).toString();
				ngayKT = tbl_pcNVThamGia.getValueAt(i, 6).toString();

				preparedStatement.setString(1, maNhanVien);
				preparedStatement.setString(2, maCongTrinh);
				preparedStatement.setString(3, tenCongViec);
				preparedStatement.setString(4, ngayBD);
				preparedStatement.setString(5, ngayKT);
				preparedStatement.executeUpdate();

			}

			JOptionPane.showMessageDialog(this, "Phân Công Thành Công!");
			updatePCNVJCT(maCongTrinh);
			modelPCNVJCT.setRowCount(0);
			tbl_pcQLCT.getSelectionModel().clearSelection();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Một Nhân Viên không thể làm hai công việc giống nhau!");
		}
	}

//===================================================XoaTrang=================================================================================
	private void XoaTrangNV() {
		txt_nvMaNV.setText("");
		txt_nvTenNV.setText("");
		txt_nvCMND.setText("");
		Rbtn_Nam.setSelected(false);
		Rbtn_Nu.setSelected(false);
		DateChooser_NamSinh.setDate(null);
		txt_nvSDT.setText("");
		txt_nvDiaChiNV.setText("");
		cbb_nvChonPB.setSelectedIndex(0);
		cbb_nvChonChV.setSelectedIndex(0);
		cbb_nvThanhPho.setSelectedIndex(0);
		cbb_nvQuanHuyen.setSelectedIndex(0);
		cbb_nvPhuongXa.setSelectedIndex(0);

	}

	private void XoaTrangCT() {
		txt_ctMaCT.setText("");
		txt_ctTenCT.setText("");
		DateChooser_ctNgayCP.setDate(null);
		DateChooser_ctNgayKC.setDate(null);
		DateChooser_ctNgayHT.setDate(null);
		Rbtn_pcTrangThaiCHT.setSelected(false);
		Rbtn_pcTrangThaiDHT.setSelected(false);
	}

	private void XoaTrangPB() {
		txt_pbMaPB.setText("");
		txt_pbTenPB.setText("");
		txt_pbHotline.setText("");
		txt_pbMoTa.setText("");
	}

	private void XoaTrangChV() {
		txt_cvMaChV.setText("");
		txt_cvTenChV.setText("");
		txt_cvMoTaChV.setText("");
	}

	private void XoaTrangCV() {
		txt_cvMaCV.setText("");
		txt_cvTenCV.setText("");
		txt_cvMoTaCV.setText("");
	}

	@SuppressWarnings("unused")
	private void XoaTrangTK() {
		txt_tkMaNV.setText("");
		txt_tkTenNV.setText("");
		txt_tkMatKhau.setText("");
		txt_tkNLMatKhau.setText("");
	}

	private void XoaTrangPCNV() {
		txt_pcMaCT.setText("");
		txt_pcTenCT.setText("");
		txt_pcDiaChiCT.setText("");
		txt_ctSoGiayPhep1.setText("");
		Rbtn_pcTrangThaiDHT.setSelected(false);
		Rbtn_pcTrangThaiCHT.setSelected(false);
		DateChooser_pcNgayCP.setDate(null);
		DateChooser_pcNgayKC.setDate(null);
		DateChooser_pcNgayHT.setDate(null);
	}

//===================================================DataAccessDiaChi==========================================================================
	private void cbb_nvThanhPhoActionPerformed(ActionEvent evt) {
		try {
			cbbTPSelectChange(evt);
			cbb_nvQuanHuyen.setSelectedIndex(0);
			cbb_nvPhuongXa.setSelectedIndex(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cbb_nvQuanHuyenActionPerformed(ActionEvent evt) {
		try {
			cbbQHSelectChange(evt);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void loadCBB_TP(String sql) throws SQLException {
		ArrayList<TinhTP> listTP = new ArrayList<>();
		DefaultComboBoxModel modelTP = new DefaultComboBoxModel();
		ResultSet rsTP = ConnectDB.executeQuery(sql);
		while (rsTP.next()) {
			listTP.add(new TinhTP(rsTP.getString("idTP"), rsTP.getString("name")));
		}
		for (TinhTP tp : listTP) {
			modelTP.addElement(tp);
		}
		this.cbb_nvThanhPho.setModel(modelTP);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void loadCBB_QH(String sql) throws SQLException {
		DefaultComboBoxModel modelQH = new DefaultComboBoxModel();
		ArrayList<QuanHuyen> listQH = new ArrayList<>();
		ResultSet rsQH = ConnectDB.executeQuery(sql);
		while (rsQH.next()) {
			listQH.add(new QuanHuyen(rsQH.getString("idQH"), rsQH.getString("idTP"), rsQH.getString("name")));
		}
		for (QuanHuyen qh : listQH) {
			modelQH.addElement(qh);
		}
		this.cbb_nvQuanHuyen.setModel(modelQH);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void loadCBB_PX(String sql) throws SQLException {
		ArrayList<PhuongXa> listPX = new ArrayList<>();
		DefaultComboBoxModel modelPX = new DefaultComboBoxModel();
		ResultSet rsPX = ConnectDB.executeQuery(sql);
		while (rsPX.next()) {
			listPX.add(new PhuongXa(rsPX.getString("idPX"), rsPX.getString("idQH"), rsPX.getString("name")));
		}
		for (PhuongXa px : listPX) {
			modelPX.addElement(px);
		}
		this.cbb_nvPhuongXa.setModel(modelPX);

	}

	private void cbb_ctQuanActionPerformed(ActionEvent evt) {
		try {
			cbbQHFCTSelectChange(evt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void loadCBB_QHFCT(String sql) throws SQLException {
		DefaultComboBoxModel modelQH = new DefaultComboBoxModel();
		ArrayList<QuanHuyen> listQH = new ArrayList<>();
		ResultSet rsQH = ConnectDB.executeQuery(sql);
		while (rsQH.next()) {
			listQH.add(new QuanHuyen(rsQH.getString("idQH"), rsQH.getString("idTP"), rsQH.getString("name")));
		}
		for (QuanHuyen qh : listQH) {
			modelQH.addElement(qh);
		}
		this.cbb_ctQuan.setModel(modelQH);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void loadCBB_PXFCT(String sql) throws SQLException {
		ArrayList<PhuongXa> listPX = new ArrayList<>();
		DefaultComboBoxModel modelPX = new DefaultComboBoxModel();
		ResultSet rsPX = ConnectDB.executeQuery(sql);
		while (rsPX.next()) {
			listPX.add(new PhuongXa(rsPX.getString("idPX"), rsPX.getString("idQH"), rsPX.getString("name")));
		}
		for (PhuongXa px : listPX) {
			modelPX.addElement(px);
		}
		this.cbb_ctPhuong.setModel(modelPX);
	}

	private void cbbQHFCTSelectChange(ActionEvent evt) throws SQLException {
		String QH_ID = ((QuanHuyen) (Object) cbb_ctQuan.getSelectedItem()).getIdQH().toString();
		loadCBB_PXFCT("SELECT * FROM PhuongXa WHERE idQH  = " + QH_ID + "");
	}

	private void cbbTPSelectChange(ActionEvent evt) throws SQLException {
		String TP_ID = ((TinhTP) (Object) cbb_nvThanhPho.getSelectedItem()).getIdTP().toString();
		loadCBB_QH("SELECT * FROM QuanHuyen WHERE idTP  = " + TP_ID + "");
	}

	private void cbbQHSelectChange(ActionEvent evt) throws SQLException {
		String QH_ID = ((QuanHuyen) (Object) cbb_nvQuanHuyen.getSelectedItem()).getIdQH().toString();
		loadCBB_PX("SELECT * FROM PhuongXa WHERE idQH  = " + QH_ID + "");
	}
//============================================================Database==========================================================================

	/*
	 * DataIngestion
	 */

//=========================================================QuanLyNhanVien=====================================================================
	private void getDataQLNV() throws SQLException {
		int i = 1;
		List<NhanVien> list = nhanVien_DAO.getAllNhanVien();
		if (list.size() != 0) {
			for (NhanVien nv : list) {
				modelNV.addRow(new Object[] { i, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(),
						nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(), nv.getDiaChi(), nv.getSoDT(), nv.getChucVu(),
						nv.getPhongBan() });
				i++;
			}
		}
	}

	private void deleteDataQLNV() {
		DefaultTableModel tableModel = (DefaultTableModel) tbl_QLNV.getModel();
		tableModel.getDataVector().removeAllElements();
	}

	private void getDataNVTheoPB(String id) throws SQLException {
		int i = 1;
		List<NhanVien> list = nhanVien_DAO.getNVTheoMaPB(id);
		if (list.size() != 0) {
			for (NhanVien nv : list) {
				modelNV.addRow(new Object[] { i, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(),
						nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(), nv.getDiaChi(), nv.getSoDT(), nv.getChucVu(),
						nv.getPhongBan() });
				i++;
			}
		}
	}

	private void getDataTheoChV(String id) throws SQLException {
		int i = 1;
		List<NhanVien> list = nhanVien_DAO.getNVTheoChVNV(id);
		if (list.size() != 0) {
			for (NhanVien nv : list) {
				modelNV.addRow(new Object[] { i, nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(),
						nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(), nv.getDiaChi(), nv.getSoDT(), nv.getChucVu(),
						nv.getPhongBan() });
				i++;
			}
		}
	}

	private void getDataTheoCT(String id) throws SQLException {
		int i = 1;
		List<CongTrinh> list = congTrinh_DAO.getCongTrinhTheoLH(id);
		if (list.size() != 0) {
			for (CongTrinh ct : list) {
				modelCT.addRow(new Object[] { i, ct.getMaCongTrinh(), ct.getTenCongTrinh(), ct.getDiaDiem(),
						ct.getLoaiHinh(), ct.getGiayPhepSo(), ct.getNgayCapPhep(), ct.getNgayKhoiCong(),
						ct.getNgayHoanThanh(), ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
				i++;
			}
		}
	}

//==================================================QuanLyChuyenMon=============================================
	private void getDataQLCM0() throws SQLException {
		List<NhanVien> list = nhanVien_DAO.getAllNhanVien();
		if (list.size() != 0) {
			for (NhanVien nv : list) {
				if (nv.getChucVu().toString().matches("Kỹ Sư Xây Dựng|Kiến Trúc Sư|Kỹ Sư Điện|Kỹ Sư IOT|Kỹ Sư  WEB")) {
					modelCM.addRow(new Object[] { modelCM.getRowCount() + 1, nv.getMaNhanVien(), nv.getTenNhanVien(),
							nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(), nv.getDiaChi(),
							nv.getSoDT(), "Kỹ Sư", nv.getChucVu(), nv.getPhongBan() });
				}
			}
		}
	}

	private void getDataQLCM1() throws SQLException {
		List<NhanVien> list = nhanVien_DAO.getAllNhanVien();
		if (list.size() != 0) {
			for (NhanVien nv : list) {
				if (nv.getChucVu().toString().matches("Giám Đốc|Quản Lý Công Trường|Trưởng Phòng Nhân Sự")) {
					modelCM.addRow(new Object[] { modelCM.getRowCount() + 1, nv.getMaNhanVien(), nv.getTenNhanVien(),
							nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(), nv.getDiaChi(),
							nv.getSoDT(), "Quản Lý", nv.getChucVu(), nv.getPhongBan() });
				}
			}
		}
	}

	private void getDataQLCM2() throws SQLException {
		List<NhanVien> list = nhanVien_DAO.getAllNhanVien();
		if (list.size() != 0) {
			for (NhanVien nv : list) {
				if (nv.getChucVu().toString()
						.matches("Chuyên Viên Thiết Kế|Chuyên Viên Marketing|Chuyên Viên Phân Tích|Kế Toán")) {
					modelCM.addRow(new Object[] { modelCM.getRowCount() + 1, nv.getMaNhanVien(), nv.getTenNhanVien(),
							nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(), nv.getDiaChi(),
							nv.getSoDT(), "Kinh Tế - Tài Chính", nv.getChucVu(), nv.getPhongBan() });
				}
			}
		}
	}

	private void getDataQLCM3() throws SQLException {
		List<NhanVien> list = nhanVien_DAO.getAllNhanVien();
		if (list.size() != 0) {
			for (NhanVien nv : list) {
				if (nv.getChucVu().toString().matches("Lao Động|Đầu Bếp|Bếp Trưởng|Bảo Vệ|Tổ Trưởng Bảo Vệ")) {
					modelCM.addRow(new Object[] { modelCM.getRowCount() + 1, nv.getMaNhanVien(), nv.getTenNhanVien(),
							nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(), nv.getDiaChi(),
							nv.getSoDT(), "Công Nhân", nv.getChucVu(), nv.getPhongBan() });
				}
			}
		}
	}

//===================================================QuanLyCongTrinh============================================
	private void getDataQLCT() throws SQLException {
		int i = 1;
		List<CongTrinh> list = congTrinh_DAO.getAllCongTrinh();
		if (list.size() != 0) {
			for (CongTrinh ct : list) {
				modelCT.addRow(new Object[] { i, ct.getMaCongTrinh(), ct.getTenCongTrinh(), ct.getDiaDiem(),
						ct.getLoaiHinh(), ct.getGiayPhepSo(), ct.getNgayCapPhep(), ct.getNgayKhoiCong(),
						ct.getNgayHoanThanh(), ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
				i++;
			}
		}
	}

	private void getDataTKCT0() throws SQLException {
		List<CongTrinh> list = congTrinh_DAO.getAllCongTrinh();
		if (list.size() != 0) {
			for (CongTrinh ct : list) {
				if (!(ct.isTrangThai())) {
					modelTKCT.addRow(new Object[] { modelTKCT.getRowCount() + 1, ct.getMaCongTrinh(),
							ct.getTenCongTrinh(), ct.getDiaDiem(), ct.getLoaiHinh(), ct.getGiayPhepSo(),
							ct.getNgayCapPhep(), ct.getNgayKhoiCong(), ct.getNgayHoanThanh(),
							ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
				}
			}
		}
	}

	private void getDataTKCTWD(String date) throws SQLException {
		String id = txt_NamXD.getText();
		List<CongTrinh> list = congTrinh_DAO.getCongTrinhTheoY(id);
		if (list.size() != 0) {
			for (CongTrinh ct : list) {
				modelTKCT.addRow(new Object[] { modelTKCT.getRowCount() + 1, ct.getMaCongTrinh(), ct.getTenCongTrinh(),
						ct.getDiaDiem(), ct.getLoaiHinh(), ct.getGiayPhepSo(), ct.getNgayCapPhep(),
						ct.getNgayKhoiCong(), ct.getNgayHoanThanh(),
						ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });

			}
		}
	}

	private void getDataTKCT1() throws SQLException {
		List<CongTrinh> list = congTrinh_DAO.getAllCongTrinh();
		if (list.size() != 0) {
			for (CongTrinh ct : list) {
				if (ct.isTrangThai()) {
					modelTKCT.addRow(new Object[] { modelTKCT.getRowCount() + 1, ct.getMaCongTrinh(),
							ct.getTenCongTrinh(), ct.getDiaDiem(), ct.getLoaiHinh(), ct.getGiayPhepSo(),
							ct.getNgayCapPhep(), ct.getNgayKhoiCong(), ct.getNgayHoanThanh(),
							ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
				}
			}
		}
	}

	private void getDataQLPB() throws SQLException {
		int i = 1;
		List<PhongBan> list = phongBan_DAO.getAllPhongBan();
		if (list.size() != 0) {
			for (PhongBan pb : list) {
				modelPB.addRow(
						new Object[] { i, pb.getMaPhongBan(), pb.getTenPhongBan(), pb.getHotLine(), pb.getMoTa() });
				i++;
			}
		}
	}

	private void getDataQLCV() throws SQLException {
		int i = 1;
		List<CongViec> list = congViec_DAO.getAllCongViec();
		if (list.size() != 0) {
			for (CongViec cv : list) {
				modelCV.addRow(new Object[] { i, cv.getMaCongViec(), cv.getTenCongViec(), cv.getMoTa() });
				i++;
			}
		}
	}

	private void getDataQLCVu() throws SQLException {
		int i = 1;
		List<ChucVu> list = chucVu_DAO.getAllChucVu();
		if (list.size() != 0) {
			for (ChucVu cv : list) {
				modelChV.addRow(new Object[] { i, cv.getMaChucVu(), cv.getTenChucVu(), cv.getMoTa() });
				i++;
			}
		}
	}

//	private void getDataTheoPB(String id) throws SQLException {
//		int i = 1;
//		List<PhongBan> list = phongBan_DAO.getPBTheoMaPB(id);
//		if (list.size() != 0) {
//			for (PhongBan pb : list) {
//				modelPB.addRow(
//						new Object[] { i, pb.getMaPhongBan(), pb.getTenPhongBan(), pb.getHotLine(), pb.getMoTa() });
//				i++;
//			}
//		}
//	}

	private void deleteDataPCNVCT() {
		DefaultTableModel tableModel = (DefaultTableModel) tbl_pcQLCT.getModel();
		tableModel.getDataVector().removeAllElements();
	}

//================================================PhanCongNhanVien=========================================================================
	@SuppressWarnings("static-access")
	public void loadPCNVJCT(String maCongTrinh) throws SQLException {
		ConnectDB.getConnect();
		Connection con = ConnectDB.getInstance().getConnect();
		modelPCNVJCT.setRowCount(0);
		PreparedStatement statement = con.prepareStatement(
				"SELECT tbl_NhanVien.maNhanVien, tenNhanVien, maPhongBan, tenCongViec, ngayBatDau, ngayKetThuc FROM tbl_NhanVien JOIN tbl_PhanCongNhanVien "
						+ "ON tbl_NhanVien.maNhanVien = tbl_PhanCongNhanVien.maNhanVien WHERE tbl_PhanCongNhanVien.maCongTrinh = ?");
		statement.setString(1, maCongTrinh);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Object[] rowData = { tbl_pcNVThamGia.getRowCount() + 1, resultSet.getString(1), resultSet.getString(2),
					resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6) };
			modelPCNVJCT.addRow(rowData);
		}
	}

	@SuppressWarnings("static-access")
	public void updatePCNVJCT(String maCongTrinh) throws SQLException {
		modelPCNVJCT.setRowCount(0);
		int i = 1;

		Connection con = ConnectDB.getInstance().getConnect();
		PreparedStatement statement = con.prepareStatement(
				"SELECT tbl_NhanVien.maNhanVien, tenNhanVien, maPhongBan, tenCongViec, ngayBatDau, ngayKetThuc FROM tbl_NhanVien JOIN tbl_PhanCongNhanVien "
						+ "ON tbl_NhanVien.maNhanVien = tbl_PhanCongNhanVien.maNhanVien WHERE tbl_PhanCongNhanVien.maCongTrinh = ?");
		statement.setString(1, maCongTrinh);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Object[] rowData = { i, resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4), resultSet.getString(5), resultSet.getString(6) };
			modelPCNVJCT.addRow(rowData);
			i++;
		}
	}

	private void getDataPCNVCT() throws SQLException {
		int i = 1;
		List<CongTrinh> list = congTrinh_DAO.getAllCongTrinh();
		if (list.size() != 0) {
			for (CongTrinh ct : list) {
				if (!(ct.isTrangThai())) {
					modelPCNVCT.addRow(new Object[] { i, ct.getMaCongTrinh(), ct.getTenCongTrinh(), ct.getDiaDiem(),
							ct.getNgayCapPhep(), ct.getNgayKhoiCong(), ct.getNgayHoanThanh(),
							ct.isTrangThai() ? "Đã Hoàn Thành" : "Chưa Hoàn Thành" });
					i++;
				}
			}
		}
	}

	private void getDataPCNVNV() throws SQLException {
		List<NhanVien> list = nhanVien_DAO.getAllNhanVien();
		if (list.size() != 0) {
			for (NhanVien nv : list) {
				if (nv.getChucVu().toString()
						.matches("Lao Động|Kỹ Sư Xây Dựng|Quản Lý Công Trường|Kỹ Sư Điện|Kiến Trúc Sư|Bảo Vệ")) {
					modelPCNVNV.addRow(new Object[] { modelPCNVNV.getRowCount() + 1, nv.getMaNhanVien(),
							nv.getTenNhanVien(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getChucVu(), nv.getPhongBan() });
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private void updateTablePCNVNV() throws SQLException {
		ArrayList<NhanVien> listNV;
		listNV = nhanVien_DAO.getAllNhanVien();
	}

//=============================================BangChamCong=========================================
	private void getDataBCCNV() throws SQLException {
		int i = 1;
		List<PhanCongNhanVien> list = phanCong_DAO.getAllPCNVInCT();
		if (list.size() != 0) {
			for (PhanCongNhanVien nv : list) {
				modelBCCNV.addRow(new Object[] { i, nv.getNhanVien().getMaNhanVien(), nv.getTenNhanVien(),
						nv.getNgaySinh(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSoCMND(), nv.getDiaChi(), nv.getSoDT(),
						nv.getTenChucVu() });
				i++;
			}
		}
	}

	private void getDataCC(String id) throws SQLException {
		int i = 1;
		List<PhanCongNhanVien> list = phanCong_DAO.getPCNVTheoMaNV(id);
		if (list.size() != 0) {
			for (PhanCongNhanVien pcnv : list) {
				modelBCCCT.addRow(new Object[] { i, pcnv.getCongTrinh().getMaCongTrinh(), pcnv.getTenCongTrinh(),
						pcnv.getDiaDiem(), pcnv.getCongViec(), pcnv.getNgayBatDau(), pcnv.getNgayKetThuc() });
				i++;
			}
		}
	}

//===========================================ThongTinCaNhan==========================================
	private void getDataQLTK() throws SQLException {
		int i = 1;
		List<TaiKhoan> list = taiKhoan_DAO.getAllTaiKhoan1();
		if (list.size() != 0) {
			for (TaiKhoan tk : list) {
				modelTKNV.addRow(new Object[] { i, tk.getMaNhanVien(), tk.getTenTaiKhoan(), tk.getMatKhau() });
				i++;
			}
		}
	}

	private void getDataFTTC(String id) throws SQLException {
		List<PhanCongNhanVien> list = phanCong_DAO.getPCNVTheoMaNVTT(id);
		DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
		if (list.size() != 0) {
			for (PhanCongNhanVien pcnv : list) {
				tableModel.addRow(new Object[] { jTable1.getRowCount() + 1, pcnv.getCongTrinh().getMaCongTrinh(),
						pcnv.getTenCongTrinh(), pcnv.getDiaDiem(), pcnv.getCongViec(), pcnv.getNgayBatDau(),
						pcnv.getNgayKetThuc(), pcnv.getMoTa() });

			}
		}
	}

//===========================================DeleteDataInTable========================================
	private void deleteDataQLTKNV() {
		DefaultTableModel tableModel = (DefaultTableModel) tbl_QLTK.getModel();
		tableModel.getDataVector().removeAllElements();
	}

	private void deleteDataQLChucVu() {
		DefaultTableModel tableModel = (DefaultTableModel) tbl_QLChV.getModel();
		tableModel.getDataVector().removeAllElements();
	}

	private void deleteDataQLCT() {
		DefaultTableModel tableModel = (DefaultTableModel) tbl_QLCT.getModel();
		tableModel.getDataVector().removeAllElements();
	}

	private void deleteDataQLPB() {
		DefaultTableModel tableModel = (DefaultTableModel) tbl_QLPB.getModel();
		tableModel.getDataVector().removeAllElements();
	}

	private void deleteDataQLCongViec() {
		DefaultTableModel tableModel = (DefaultTableModel) tbl_QLCV.getModel();
		tableModel.getDataVector().removeAllElements();
	}

//===========================================CheckValidData==========================================
	private boolean validDataTK() {
		if (txt_tkMaNV.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error: Mã Nhân Viên Không Được Để Trống");
			return false;
		}
		if (txt_tkMatKhau.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Error: Mật Khẩu Không Được Để Trống");
			return false;
		}
		if(txt_tkNLMatKhau.getText().length() < 0) {
			JOptionPane.showMessageDialog(this, "Error: Nhập Lại Mật Khẩu Đang Trống");
			return false;
		}
		if(!txt_tkNLMatKhau.getText().equalsIgnoreCase(txt_tkMatKhau.getText())) {
			JOptionPane.showMessageDialog(this, "Error: Hai Mật Khẩu Không Khớp Nhau");
			return false;
		}
		return true;
	}

	private boolean validDataNV() {
//		String phongBan = cbb_nvChonPB.getSelectedItem().toString();
//		String chucVu = cbb_nvChonChV.getSelectedItem().toString();
//		String tenNV = txt_nvTenNV.getText().trim();
		Date ngaySinh;
		ngaySinh = DateChooser_NamSinh.getDate();
		String CMND = txt_nvCMND.getText().trim();
		String sDT = txt_nvSDT.getText().trim();
//		String Tinh = cbb_nvThanhPho.getSelectedItem().toString();
//		String Quan = cbb_nvQuanHuyen.getSelectedItem().toString();
//		String Phuong = cbb_nvPhuongXa.getSelectedItem().toString();
//		String diaChi = txt_nvDiaChiNV.getText().trim();
		if (cbb_nvChonPB.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Phòng Ban Không Được Để Trống ");
			return false;

		}
		if (cbb_nvChonChV.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Chức Vụ Không Được Để Trống ");
			return false;

		}
		if (txt_nvTenNV.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Tên Nhân Viên Không Được Để Trống ");
			return false;

		}
		if (ngaySinh == null) {
			JOptionPane.showMessageDialog(null, "Error:Ngày Sinh Không Được Để Trống ");
			return false;
		}
		if (!(CMND.length() > 0 && CMND.matches("\\d{8}"))) {
			JOptionPane.showMessageDialog(this, "Error: Số CMND Phải Đủ 8 Số");
			return false;
		}
		if (!(sDT.length() > 0 && sDT.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this, "Error: Số Điện Thoại Phải Đủ 10 Số");
			return false;
		}
		if (cbb_nvThanhPho.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Tỉnh/Thành Phố Không Được Để Trống ");
			return false;

		}
		if (cbb_nvQuanHuyen.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Quận/Huyện Không Được Để Trống ");
			return false;

		}
		if (cbb_nvPhuongXa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Phường/Xã Không Được Để Trống ");
			return false;

		}
		if (txt_nvDiaChiNV.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Địa Chỉ Không Được Để Trống ");
			return false;

		}

		return true;

	}

	private boolean validDataCT() {
//		String maCT = txt_ctMaCT.getText().trim();
		String tenCT = txt_ctTenCT.getText().trim();
		String diaChi = txt_ctDiaChiCT.getText().trim();
		String loaiHinh = cbb_ctLoaiHinhCT.getSelectedItem().toString();
//		String tempSGP = txt_ctSoGiayPhep.getText();
//		int giayPhepSo = Integer.parseInt(tempSGP);
		Date dateCP, dateKC, dateHT;
		dateCP = DateChooser_ctNgayCP.getDate();
		dateKC = DateChooser_ctNgayKC.getDate();
		dateHT = DateChooser_ctNgayHT.getDate();

		boolean trangThai = Rbtn_TrangThaiDHT.isSelected();

		if (!(tenCT.length() > 0 && tenCT.matches("[[A-Za-z] \\s]{1,20}"))) {
			JOptionPane.showMessageDialog(this, "Error: Tên Công Trình không có ký tự đặc biệt và tối đa là 20 chữ ");
			return false;

		}
		if (!(diaChi.length() > 0 && diaChi.matches("[[A-Za-z0-9] \\s]{1,20}"))) {
			JOptionPane.showMessageDialog(this, "Error: Địa chỉ không có ký tự đặc biệt và tối đa 20 chữ số ");
			return false;
		}
		if (dateCP == null) {
			JOptionPane.showMessageDialog(this, "Error: Chọn ngày cấp phép");
			return false;
		}
		if (dateKC == null) {
			JOptionPane.showMessageDialog(this, "Error: Chọn ngày khởi công");
			return false;
		}
		if (dateHT == null) {
			JOptionPane.showMessageDialog(this, "Error: Chọn ngày hoàn thành");
			return false;
		}
		if (!(dateCP.before(dateKC))) {
			JOptionPane.showMessageDialog(this, "Eror: Ngày cấp phép phải trước ngày khởi công");
			return false;
		}
		if (!(dateKC.before(dateHT))) {
			JOptionPane.showMessageDialog(this, "Eror: Ngày khởi công phải trước ngày hoàn thành");
			return false;
		}
		if (loaiHinh == null) {
			JOptionPane.showMessageDialog(null, "Error:Loại Hình Không Được Để Trống ");
			return false;

		}
		if (txt_ctSoGiayPhep.getText().length() > 3) {
			JOptionPane.showMessageDialog(null, "Error:Số Giấy Phép Không Được Để Trống Và Phải Nhiều Hơn 3 Số ");
			return false;
		}
		if (trangThai) {
			JOptionPane.showMessageDialog(null, "Error:Trạng Thái Không Được Để Trống ");
			return false;

		}
		return true;

	}

	private boolean validDataPB() {

		String tenPB = txt_pbTenPB.getText().trim();
		String hotLine = txt_pbHotline.getText().trim();
		String moTa = txt_pbMoTa.getText().trim();

		if ((tenPB.length() > 0 && tenPB.matches("[[A-Za-z] \\s]{1,20}"))) {
			JOptionPane.showMessageDialog(this, "Error: Tên phòng ban không có ký tự đặc biệt và tối đa là 20 chữ ");
			return false;

		}
		if (!(hotLine.length() > 0 && hotLine.matches("\\d{10}"))) {
			JOptionPane.showMessageDialog(this, "Error: Số điện thoại phải đủ 10 số ");
			return false;
		}
		if ((moTa.length() > 0 && moTa.matches("[[A-Za-z]]"))) {
			JOptionPane.showMessageDialog(this, "Error: Mô tả không có ký tự đặc biệt và tối đa là 40 chữ cái");
			return false;
		}
		return true;
	}

	private boolean validDataChV() {
//		String tenCVu = txt_cvTenChV.getText().trim();
//		String moTa = txt_cvMoTaChV.getText().trim();
		if (txt_cvTenChV.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Tên Chức Vụ Không Được Để Trống ");
			return false;

		}
		if (txt_cvMoTaChV.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Mô Tả Chức Vụ Không Được Để Trống ");
			return false;

		}

		return true;
	}

	private boolean validDataCV() {
//		String tenCV = txt_cvTenCV.getText().trim();
//		String moTa = txt_cvMoTaCV.getText().trim();

		if (txt_cvTenCV.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Tên Công Việc Không Được Để Trống ");
			return false;

		}
		if (txt_cvMoTaCV.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Error:Mô Tả Công Việc Không Được Để Trống ");
			return false;

		}

		return true;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(QLLD_Application.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(QLLD_Application.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(QLLD_Application.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(QLLD_Application.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						new QLLD_Application("ACCOUNT").setVisible(true);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.toedter.calendar.JDateChooser DateChooser_NamSinh;
	private com.toedter.calendar.JDateChooser DateChooser_bccNamSinh;
	private com.toedter.calendar.JDateChooser DateChooser_ctNgayCP;
	private com.toedter.calendar.JDateChooser DateChooser_ctNgayHT;
	private com.toedter.calendar.JDateChooser DateChooser_ctNgayKC;
	private com.toedter.calendar.JDateChooser DateChooser_pcNgayCP;
	private com.toedter.calendar.JDateChooser DateChooser_pcNgayHT;
	private com.toedter.calendar.JDateChooser DateChooser_pcNgayKC;
	private com.toedter.calendar.JDateChooser DateChooser_ttcnNamSinh;
	private javax.swing.JTabbedPane JTB_QLLD;
	private javax.swing.JRadioButton Rbtn_Nam;
	private javax.swing.JRadioButton Rbtn_Nu;
	private javax.swing.JRadioButton Rbtn_TrangThaiCHT;
	private javax.swing.JRadioButton Rbtn_TrangThaiDHT;
	private javax.swing.JRadioButton Rbtn_bccNam;
	private javax.swing.JRadioButton Rbtn_bccNu;
	private javax.swing.JRadioButton Rbtn_pcTrangThaiCHT;
	private javax.swing.JRadioButton Rbtn_pcTrangThaiDHT;
	private javax.swing.JRadioButton Rbtn_ttcnNam;
	private javax.swing.JRadioButton Rbtn_ttcnNu;
	private javax.swing.JPanel TTCN;
	private javax.swing.JButton btn_CapNhatCT;
	private javax.swing.JButton btn_CapNhatCV;
	private javax.swing.JButton btn_CapNhatChV;
	private javax.swing.JButton btn_CapNhatNV;
	private javax.swing.JButton btn_CapNhatPB;
	private javax.swing.JButton btn_CapNhatTK;
	private javax.swing.JButton btn_DangXuat;
	private javax.swing.JButton btn_DoiMK;
	private javax.swing.JButton btn_HoanTat;
	private javax.swing.JButton btn_IN;
	private javax.swing.JButton btn_LuuCT;
	private javax.swing.JButton btn_LuuCV;
	private javax.swing.JButton btn_LuuChV;
	private javax.swing.JButton btn_LuuNV;
	private javax.swing.JButton btn_LuuPB;
	private javax.swing.JButton btn_LuuTK;
	private javax.swing.JButton btn_OKCongViec;
	private javax.swing.JButton btn_OUT;
	private javax.swing.JButton btn_ThongTin;
	private javax.swing.JButton btn_TroGiup;
	private javax.swing.JButton btn_XacNhanThongKe;
	private javax.swing.JButton btn_XoaCT;
	private javax.swing.JButton btn_XoaCV;
	private javax.swing.JButton btn_XoaChV;
	private javax.swing.JButton btn_XoaNV;
	private javax.swing.JButton btn_XoaPB;
	private javax.swing.JButton btn_XoaTK;
	private javax.swing.JButton btn_XoaTrangCT;
	private javax.swing.JButton btn_XoaTrangCV;
	private javax.swing.JButton btn_XoaTrangChV;
	private javax.swing.JButton btn_XoaTrangNV;
	private javax.swing.JButton btn_XoaTrangPB;
	private javax.swing.JButton btn_XoaTrangTK;
	private javax.swing.JButton btn_ctTimCT;
	private javax.swing.JButton btn_nvTimNV;
	private javax.swing.JButton btn_pbTimPB;
	private javax.swing.JButton btn_pcTimCT;
	private javax.swing.JButton btn_tkTimNV;
	private javax.swing.JComboBox<String> cbb_LocCT;
	private javax.swing.JComboBox<String> cbb_TieuChi;
	private javax.swing.JComboBox<String> cbb_TimCM;
	private javax.swing.JComboBox<String> cbb_ctLoaiHinhCT;
	private javax.swing.JComboBox<String> cbb_ctPhuong;
	private javax.swing.JComboBox<String> cbb_ctQuan;
	private javax.swing.JComboBox<String> cbb_nvChonChV;
	private javax.swing.JComboBox<String> cbb_nvChonChVu1;
	private javax.swing.JComboBox<String> cbb_nvChonPB;
	private javax.swing.JComboBox<String> cbb_nvChonPB1;
	private javax.swing.JComboBox<String> cbb_nvPhuongXa;
	private javax.swing.JComboBox<String> cbb_nvQuanHuyen;
	private javax.swing.JComboBox<String> cbb_nvThanhPho;
	private javax.swing.JComboBox<String> cbb_nvTimChucVu;
	private javax.swing.JComboBox<String> cbb_nvTimPB;
	private javax.swing.JTextField txt_pbTimMaPB;
	private javax.swing.JComboBox<String> cbb_tkTimPB;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane_BangChamCong;
	private javax.swing.JScrollPane jScrollPane_DSNV;
	private javax.swing.JTable jTable1;
	private javax.swing.JToolBar jToolBar1;
	private javax.swing.JLabel lblTimNV;
	private javax.swing.JLabel lbl_Background;
	private javax.swing.JLabel lbl_CMND;
	private javax.swing.JLabel lbl_CMND1;
	private javax.swing.JLabel lbl_ChVu;
	private javax.swing.JLabel lbl_ChVu1;
	private javax.swing.JLabel lbl_ChuyenMon;
	private javax.swing.JLabel lbl_DiaChi;
	private javax.swing.JLabel lbl_DiaChi1;
	private javax.swing.JLabel lbl_DiaChi2;
	private javax.swing.JLabel lbl_DiaChi3;
	private javax.swing.JLabel lbl_DiaChi4;
	private javax.swing.JLabel lbl_DiaChi5;
	private javax.swing.JLabel lbl_DiaChiCT;
	private javax.swing.JLabel lbl_GT;
	private javax.swing.JLabel lbl_GT1;
	private javax.swing.JLabel lbl_GhiChu;
	private javax.swing.JLabel lbl_GiayPhepSo;
	private javax.swing.JLabel lbl_GiayPhepSo1;
	private javax.swing.JLabel lbl_Hotline;
	private javax.swing.JLabel lbl_LoaiHinh;
	private javax.swing.JLabel lbl_LocCT;
	private javax.swing.JLabel lbl_MaCT;
	private javax.swing.JLabel lbl_MaChucVu;
	private javax.swing.JLabel lbl_MaCongViec;
	private javax.swing.JLabel lbl_MaNV;
	private javax.swing.JLabel lbl_MaNV1;
	private javax.swing.JLabel lbl_MaPB;
	private javax.swing.JLabel lbl_MoTaCV;
	private javax.swing.JLabel lbl_MoTaChucVu;
	private javax.swing.JLabel lbl_NamXD;
	private javax.swing.JLabel lbl_NgayCP;
	private javax.swing.JLabel lbl_NgayHT;
	private javax.swing.JLabel lbl_NgayKC;
	private javax.swing.JLabel lbl_PB;
	private javax.swing.JLabel lbl_PB1;
	private javax.swing.JLabel lbl_Profile;
	private javax.swing.JLabel lbl_SDT;
	private javax.swing.JLabel lbl_SDT1;
	private javax.swing.JLabel lbl_SoLuong;
	private javax.swing.JLabel lbl_TKCT;
	private javax.swing.JLabel lbl_TKPB;
	private javax.swing.JLabel lbl_TenCT;
	private javax.swing.JLabel lbl_TenChucVu;
	private javax.swing.JLabel lbl_TenCongViec;
	private javax.swing.JLabel lbl_TenNV;
	private javax.swing.JLabel lbl_TenNV1;
	private javax.swing.JLabel lbl_TenPB;
	private javax.swing.JLabel lbl_TenPM;
	private javax.swing.JLabel lbl_TenPM2;
	private javax.swing.JLabel lbl_ThemCT;
	private javax.swing.JLabel lbl_ThemNV;
	private javax.swing.JLabel lbl_ThemPB;
	private javax.swing.JLabel lbl_ThemTK;
	private javax.swing.JLabel lbl_TieuChi;
	private javax.swing.JLabel lbl_TimChucVu;
	private javax.swing.JLabel lbl_TimMaCT;
	private javax.swing.JLabel lbl_TimMaNV;
	private javax.swing.JLabel lbl_TimMaPB;
	private javax.swing.JLabel lbl_TimNV;
	private javax.swing.JLabel lbl_TimPB;
	private javax.swing.JLabel lbl_TimTenCT;
	private javax.swing.JLabel lbl_TimTenCongTrinh;
	private javax.swing.JLabel lbl_TimTenNV;
	private javax.swing.JLabel lbl_TimTenPB;
	private javax.swing.JLabel lbl_TrangThai;
	private javax.swing.JLabel lbl_TrangThai1;
	private javax.swing.JLabel lbl_Tuoi;
	private javax.swing.JLabel lbl_Tuoi1;
	private javax.swing.JLabel lbl_cvThemChucVu;
	private javax.swing.JLabel lbl_cvThemCongViec;
	private javax.swing.JLabel lbl_logo;
	private javax.swing.JLabel lbl_pcDiaChiCT;
	private javax.swing.JLabel lbl_pcMaCT;
	private javax.swing.JLabel lbl_pcNgayCP;
	private javax.swing.JLabel lbl_pcNgayHT;
	private javax.swing.JLabel lbl_pcNgayKC;
	private javax.swing.JLabel lbl_pcTenCT;
	private javax.swing.JLabel lbl_tkMaNV;
	private javax.swing.JLabel lbl_tkMatKhau;
	private javax.swing.JLabel lbl_tkNLMatKhau;
	private javax.swing.JLabel lbl_tkTenNV;
	private javax.swing.JLabel lbl_tkTimMaNV;
	private javax.swing.JLabel lbl_tkTimPB;
	private javax.swing.JLabel lbl_tkTimTenNV;
	private javax.swing.JLabel lbl_ttcnCMND;
	private javax.swing.JLabel lbl_ttcnDiaChi;
	private javax.swing.JLabel lbl_ttcnGT;
	private javax.swing.JLabel lbl_ttcnMaNV;
	private javax.swing.JLabel lbl_ttcnPB;
	private javax.swing.JLabel lbl_ttcnSDT;
	private javax.swing.JLabel lbl_ttcnTenNV;
	private javax.swing.JLabel lbl_ttcnTuoi;
	private javax.swing.JPanel pn_BangChamCong;
	private javax.swing.JPanel pn_BangChamCongNV;
	private javax.swing.JPanel pn_ChamCong;
	private javax.swing.JPanel pn_ChucVu;
	private javax.swing.JPanel pn_CongViec;
	private javax.swing.JPanel pn_DsCongTrinh;
	private javax.swing.JPanel pn_DsNhanVien;
	private javax.swing.JPanel pn_DsNhanVienTGCT;
	private javax.swing.JPanel pn_DsPhongBan;
	private javax.swing.JPanel pn_DsTaiKhoan;
	private javax.swing.JPanel pn_Header;
	private javax.swing.JPanel pn_LocNV;
	private javax.swing.JPanel pn_NguoiQuanLy;
	private javax.swing.JPanel pn_PhanCong;
	private javax.swing.JPanel pn_PhanCongCV;
	private javax.swing.JPanel pn_QLChucVuCongViec;
	private javax.swing.JPanel pn_QLChuyenMon;
	private javax.swing.JPanel pn_QLCongTrinh;
	private javax.swing.JPanel pn_QLNhanVien;
	private javax.swing.JPanel pn_QLPhongBan;
	private javax.swing.JPanel pn_QLTaiKhoan;
	private javax.swing.JTabbedPane pn_QuanLy;
	private javax.swing.JPanel pn_QuanLyCM;
	private javax.swing.JPanel pn_TTCN;
	private javax.swing.JPanel pn_ThemCT;
	private javax.swing.JPanel pn_ThemChucVu;
	private javax.swing.JPanel pn_ThemCongViec;
	private javax.swing.JPanel pn_ThemPB;
	private javax.swing.JPanel pn_ThemTK;
	private javax.swing.JPanel pn_ThongKe;
	private javax.swing.JPanel pn_ThongKeCongTrinh;
	private javax.swing.JPanel pn_ThongTinCT;
	private javax.swing.JPanel pn_TrangChu;
	private javax.swing.JPanel pn_bccDSNV;
	private javax.swing.JPanel pn_bccTTNV;
	private javax.swing.JPanel pn_dsChucVu;
	private javax.swing.JPanel pn_dsCongViec;
	private javax.swing.JPanel pn_nvThemNV;
	private javax.swing.JPanel pn_pcDsCongTrinh;
	private javax.swing.JPanel pn_pcDsNhanVien;
	private javax.swing.JPanel pn_pcQLCongTrinh;
	private javax.swing.JScrollPane scroll_DSCongTrinh;
	private javax.swing.JScrollPane scroll_DSNhanVien;
	private javax.swing.JScrollPane scroll_GhiChu;
	private javax.swing.JScrollPane scroll_MoTaCongViec;
	private javax.swing.JScrollPane scroll_MoTaCongViec1;
	private javax.swing.JScrollPane scroll_PhanCongNV;
	private javax.swing.JScrollPane scroll_QLCM;
	private javax.swing.JScrollPane scroll_QLCT;
	private javax.swing.JScrollPane scroll_QLCT1;
	private javax.swing.JScrollPane scroll_QLCV;
	private javax.swing.JScrollPane scroll_QLCV1;
	private javax.swing.JScrollPane scroll_QLNV;
	private javax.swing.JScrollPane scroll_QLPB;
	private javax.swing.JScrollPane scroll_QLTK;
	private javax.swing.JTable tbl_ChuyenMon;
	private javax.swing.JTable tbl_QLCT;
	private javax.swing.JTable tbl_QLCV;
	private javax.swing.JTable tbl_QLChV;
	private javax.swing.JTable tbl_QLNV;
	private javax.swing.JTable tbl_QLPB;
	private javax.swing.JTable tbl_QLTK;
	private javax.swing.JTable tbl_Thongke;
	private javax.swing.JTable tbl_bccBangChamCong;
	private javax.swing.JTable tbl_bccDSNV;
	private javax.swing.JTable tbl_pcDanhSachNV;
	private javax.swing.JTable tbl_pcNVThamGia;
	private javax.swing.JTable tbl_pcQLCT;
	private javax.swing.JTextField txt_NamXD;
	private javax.swing.JTextField txt_SoLuong;
	private javax.swing.JTextField txt_bccCMND;
	private javax.swing.JTextField txt_bccDiaChi;
	private javax.swing.JTextField txt_bccMaNV;
	private javax.swing.JTextField txt_bccSDT;
	private javax.swing.JTextField txt_bccnvTenNV;
	private javax.swing.JTextField txt_ctDiaChiCT;
	private javax.swing.JTextField txt_ctMaCT;
	private javax.swing.JTextField txt_ctSoGiayPhep;
	private javax.swing.JTextField txt_ctSoGiayPhep1;
	private javax.swing.JTextField txt_ctTenCT;
	private javax.swing.JTextField txt_ctTimMaCT;
	private javax.swing.JTextField txt_ctTimTenCT;
	private javax.swing.JTextField txt_cvMaCV;
	private javax.swing.JTextField txt_cvMaChV;
	private javax.swing.JTextArea txt_cvMoTaCV;
	private javax.swing.JTextArea txt_cvMoTaChV;
	private javax.swing.JTextField txt_cvTenCV;
	private javax.swing.JTextField txt_cvTenChV;
	private javax.swing.JTextField txt_nvCMND;
	private javax.swing.JTextField txt_nvDiaChiNV;
	private javax.swing.JTextField txt_nvMaNV;
	private javax.swing.JTextField txt_nvSDT;
	private javax.swing.JTextField txt_nvTenNV;
	private javax.swing.JTextField txt_nvTimMaNV;
	private javax.swing.JTextField txt_nvTimTenNV;
	private javax.swing.JTextField txt_pbHotline;
	private javax.swing.JTextField txt_pbMaPB;
	private javax.swing.JTextArea txt_pbMoTa;
	private javax.swing.JTextField txt_pbTenPB;
	private javax.swing.JTextField txt_pbTimTenPB;
	private javax.swing.JTextField txt_pcDiaChiCT;
	private javax.swing.JTextField txt_pcMaCT;
	private javax.swing.JTextField txt_pcTenCT;
	private javax.swing.JTextField txt_pcTimTenCT;
	private javax.swing.JTextField txt_tkMaNV;
	private javax.swing.JTextField txt_tkMatKhau;
	private javax.swing.JTextField txt_tkNLMatKhau;
	private javax.swing.JTextField txt_tkTenNV;
	private javax.swing.JTextField txt_tkTimMaNV;
	private javax.swing.JTextField txt_tkTimTenNV;
	private javax.swing.JTextField txt_ttcnCMND;
	private javax.swing.JTextField txt_ttcnDiaChi;
	private javax.swing.JTextField txt_ttcnMaNV;
	private javax.swing.JTextField txt_ttcnPhongBan;
	private javax.swing.JTextField txt_ttcnSDT;
	private javax.swing.JTextField txt_ttcnTenNV;
	// End of variables declaration//GEN-END:variables
}