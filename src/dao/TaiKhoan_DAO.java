package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;

public class TaiKhoan_DAO {

	public ArrayList<TaiKhoan> getAllTaiKhoan() {
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnect();

			String sql = "SELECT * FROM tbl_TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String matKhau = resultSet.getString(2);
				TaiKhoan taiKhoan = new TaiKhoan(maNhanVien, matKhau);
				dsTK.add(taiKhoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTK;
	}

	public ArrayList<TaiKhoan> getAllTaiKhoan1() {
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnect();

			String sql = "SELECT tbl_NhanVien.maNhanVien AS maNhanVien, tenNhanVien, matKhau FROM tbl_NhanVien JOIN tbl_TaiKhoan\r\n"
					+ "ON tbl_NhanVien.maNhanVien = tbl_TaiKhoan.maNhanVien ORDER BY tbl_NhanVien.maNhanVien;";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenNhanVien = resultSet.getString(2);
				String matKhau = resultSet.getString(3);
				TaiKhoan taiKhoan = new TaiKhoan(maNhanVien, tenNhanVien, matKhau);
				dsTK.add(taiKhoan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTK;
	}
//

	public ArrayList<TaiKhoan> getTKTheoMaNV(String id) throws SQLException {
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;

		try {
			String sql = "SELECT tbl_NhanVien.maNhanVien AS maNhanVien, tenNhanVien, matKhau FROM tbl_NhanVien JOIN tbl_TaiKhoan\r\n"
					+ "ON tbl_NhanVien.maNhanVien = tbl_TaiKhoan.maNhanVien WHERE tbl_NhanVien.maNhanVien LIKE ?;";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + id + "%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenNhanVien = resultSet.getString(2);
				String matKhau = resultSet.getString(3);
				TaiKhoan taiKhoan = new TaiKhoan(maNhanVien, tenNhanVien, matKhau);
				dsTK.add(taiKhoan);
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
		return dsTK;
	}

	public ArrayList<TaiKhoan> getTKTheoTenNV(String id) throws SQLException {
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT tbl_NhanVien.maNhanVien, tbl_NhanVien.tenNhanVien, matKhau FROM tbl_TaiKhoan JOIN tbl_NhanVien "
					+ "ON tbl_NhanVien.maNhanVien = tbl_TaiKhoan.maNhanVien "
					+ "WHERE tbl_NhanVien.tenNhanVien LIKE ?;";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + id + "%");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String maNhanVien = resultSet.getString(1);
				String tenTaiKhoan = resultSet.getString(2);
				// String matKhau = resultSet.getString(3);
				TaiKhoan taiKhoan = new TaiKhoan(maNhanVien, tenTaiKhoan);
				dsTK.add(taiKhoan);
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

		return dsTK;
	}

	public boolean addTaiKhoan(TaiKhoan taiKhoan) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;

		try {
			statement = con.prepareStatement("INSERT INTO " + "tbl_TaiKhoan VALUES(?, ?);");
			statement.setString(1, taiKhoan.getNhanVien().getMaNhanVien());
			statement.setString(2, taiKhoan.getMatKhau());

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

	public boolean updateTaiKhoan(TaiKhoan taiKhoan) throws SQLException {

		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;

		try {

			statement = con.prepareStatement("UPDATE tbl_TaiKhoan SET matKhau=? WHERE maNhanVien=?");

			statement.setString(1, taiKhoan.getMaNhanVien());
			statement.setString(2, taiKhoan.getMatKhau());
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

	public boolean deleteTaiKhoan(String id) throws SQLException {
//		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "DELETE FROM tbl_TaiKhoan WHERE [maNhanVien] = ?";
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
}