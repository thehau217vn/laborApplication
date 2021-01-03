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
				String maTaiKhoan = resultSet.getString(1);
				String tenTaiKhoan = resultSet.getString(2);
				String matKhau = resultSet.getString(3);
				@SuppressWarnings("unused")
				TaiKhoan taiKhoan = new TaiKhoan(maTaiKhoan, tenTaiKhoan, matKhau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTK;
	}

	public ArrayList<TaiKhoan> getNVTheoMaTK(String id) throws SQLException {
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;

		try {
			String sql = "SELECT * FROM tbl_TaiKhoan WHERE [maTaiKhoan] = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maTaiKhoan = resultSet.getString(1);
				String tenTaiKhoan = resultSet.getString(2);
				String matKhau = resultSet.getString(3);
				@SuppressWarnings("unused")
				TaiKhoan taiKhoan = new TaiKhoan(maTaiKhoan, tenTaiKhoan, matKhau);
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
			statement = con.prepareStatement("INSERT INTO " + " tbl_TaiKhoan VALUES(?, ?, ?)");
			statement.setString(1, taiKhoan.getMaTaiKhoan());
			statement.setString(2, taiKhoan.getTenTaiKhoan());
			statement.setString(3, taiKhoan.getMatKhau());
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
			statement = con
					.prepareStatement("UPDATE tbl_TaiKhoan SET tenTaiKhoan=?, " + "matKhau=? WHERE maTaiKhoan=?");

			statement.setString(1, taiKhoan.getMaTaiKhoan());
			statement.setString(2, taiKhoan.getTenTaiKhoan());
			statement.setString(3, taiKhoan.getMatKhau());
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
			String sql = "DELETE FROM tbl_TaiKhoan WHERE [maTaiKhoan] = ?";
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
