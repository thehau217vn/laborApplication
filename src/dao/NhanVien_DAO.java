package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {

	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT * FROM tbl_NhanVien;";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenNhanVien = resultSet.getString(2);
				String ngaySinh = resultSet.getString(3);
				boolean gioiTinh = resultSet.getBoolean(4);
				String soCMND = resultSet.getString(5);
				String diaChi = resultSet.getString(6);
				String soDT = resultSet.getString(7);
				String chucVu = resultSet.getString(8);
				String maPhongBan = resultSet.getString(9);
				NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soCMND, diaChi, soDT,
						chucVu, maPhongBan);
				dsNV.add(nhanVien);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public ArrayList<NhanVien> getNhanVienInCT() {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT tbl_NhanVien.maNhanVien, tenNhanVien, ngaySinh, gioiTinh, diaChi, soDT, tenChucVu, maPhongBan FROM tbl_NhanVien JOIN tbl_PhanCongNhanVien "
					+ "ON tbl_PhanCongNhanVien.maNhanVien = tbl_NhanVien.maNhanVien;";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenNhanVien = resultSet.getString(2);
				String ngaySinh = resultSet.getString(3);
				boolean gioiTinh = resultSet.getBoolean(4);
				String soCMND = resultSet.getString(5);
				String diaChi = resultSet.getString(6);
				String soDT = resultSet.getString(7);
				String chucVu = resultSet.getString(8);
				String maPhongBan = resultSet.getString(9);
				NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soCMND, diaChi, soDT,
						chucVu, maPhongBan);
				dsNV.add(nhanVien);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNV;
	}
	
	public ArrayList<NhanVien> getNVTheoMaNV(String id) throws SQLException {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_NhanVien WHERE [maNhanVien] = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenNhanVien = resultSet.getString(2);
				String ngaySinh = resultSet.getString(3);
				boolean gioiTinh = resultSet.getBoolean(4);
				String soCMND = resultSet.getString(5);
				String diaChi = resultSet.getString(6);
				String soDT = resultSet.getString(7);
				String chucVu = resultSet.getString(8);
				String maPhongBan = resultSet.getString(9);
				NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soCMND, diaChi, soDT,
						chucVu, maPhongBan);
				dsNV.add(nhanVien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return dsNV;
	}

	public ArrayList<NhanVien> getNVTheoMaPB(String id) throws SQLException {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_NhanVien WHERE [maPhongBan] = ? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenNhanVien = resultSet.getString(2);
				String ngaySinh = resultSet.getString(3);
				boolean gioiTinh = resultSet.getBoolean(4);
				String soCMND = resultSet.getString(5);
				String diaChi = resultSet.getString(6);
				String soDT = resultSet.getString(7);
				String chucVu = resultSet.getString(8);
				String maPhongBan = resultSet.getString(9);
				NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soCMND, diaChi, soDT, chucVu, maPhongBan);
				dsNV.add(nhanVien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return dsNV;
	}
	
	public ArrayList<NhanVien> getNVTheoTenNV(String id) throws SQLException {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_NhanVien WHERE [tenNhanVien] LIKE ?;";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + id + "%");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenNhanVien = resultSet.getString(2);
				String ngaySinh = resultSet.getString(3);
				boolean gioiTinh = resultSet.getBoolean(4);
				String soCMND = resultSet.getString(5);
				String diaChi = resultSet.getString(6);
				String soDT = resultSet.getString(7);
				String chucVu = resultSet.getString(8);
				String maPhongBan = resultSet.getString(9);
				NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soCMND, diaChi, soDT, chucVu, maPhongBan);
				dsNV.add(nhanVien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return dsNV;
	}
	
	public ArrayList<NhanVien> getNVTheoChVNV(String id) throws SQLException {
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_NhanVien WHERE [tenChucVu] LIKE ?;";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + id + "%");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenNhanVien = resultSet.getString(2);
				String ngaySinh = resultSet.getString(3);
				boolean gioiTinh = resultSet.getBoolean(4);
				String soCMND = resultSet.getString(5);
				String diaChi = resultSet.getString(6);
				String soDT = resultSet.getString(7);
				String chucVu = resultSet.getString(8);
				String maPhongBan = resultSet.getString(9);
				NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, ngaySinh, gioiTinh, soCMND, diaChi, soDT, chucVu, maPhongBan);
				dsNV.add(nhanVien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return dsNV;
	}

	
	public boolean addNhanVien(NhanVien nhanVien) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;

		try {
			statement = con.prepareStatement("INSERT INTO" + " tbl_NhanVien VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, nhanVien.getMaNhanVien());
			statement.setString(2, nhanVien.getTenNhanVien());
			statement.setString(3, nhanVien.getNgaySinh());
			statement.setBoolean(4, nhanVien.isGioiTinh());
			statement.setString(5, nhanVien.getSoCMND());
			statement.setString(6, nhanVien.getDiaChi());
			statement.setString(7, nhanVien.getSoDT());
			statement.setString(8, nhanVien.getChucVu());
			statement.setString(9, nhanVien.getPhongBan());
			n = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean updateNhanVien(NhanVien nhanVien) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE tbl_NhanVien SET tenNhanVien=?, ngaySinh=?, gioiTinh=?, "
					+ "soCMND=?, diaChi=?, soDT=?, tenChucVu=?, maPhongBan=? WHERE maNhanVien=?");
			statement.setString(1, nhanVien.getTenNhanVien());
			statement.setString(2, nhanVien.getNgaySinh());
			statement.setBoolean(3, nhanVien.isGioiTinh());
			statement.setString(4, nhanVien.getSoCMND());
			statement.setString(5, nhanVien.getDiaChi());
			statement.setString(6, nhanVien.getSoDT());
			statement.setString(7, nhanVien.getChucVu());
			statement.setString(8, nhanVien.getPhongBan());
			statement.setString(9, nhanVien.getMaNhanVien());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean deleteNhanVien(String id) throws SQLException {
//		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "DELETE FROM tbl_NhanVien WHERE [maNhanVien] = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public String sinhMaNVTuDong() throws SQLException {
		String count = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		String sql = "select COUNT(tbl_NhanVien.maNhanVien) from tbl_NhanVien";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			res.next();
			count = res.getInt(1) + 1 + "";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i <= 3 - count.split("").length; i++) {
			count = "0" + count;
		}
		return "HNVNV" + count;
	}

}
