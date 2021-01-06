package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChucVu;

public class ChucVu_DAO {
	public ArrayList<ChucVu> getAllChucVu() {
		ArrayList<ChucVu> dsCV = new ArrayList<ChucVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT * FROM tbl_ChucVu ORDER BY [maChucVu];";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String maChucVu = resultSet.getString(1);
				String tenChucVu = resultSet.getString(2);
				String moTa = resultSet.getString(3);
				ChucVu chucVu = new ChucVu(maChucVu, tenChucVu, moTa);
				dsCV.add(chucVu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCV;
	}

	public ArrayList<ChucVu> getTheoMaChucVu(String id) throws SQLException {
		ArrayList<ChucVu> dsCV = new ArrayList<ChucVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_ChucVu WHERE [maChucVu] = ?;";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String maChucVu = resultSet.getString(1);
				String tenChucVu = resultSet.getString(2);
				String moTa = resultSet.getString(3);
				ChucVu chucVu = new ChucVu(maChucVu, tenChucVu, moTa);
				dsCV.add(chucVu);
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
		return dsCV;
	}

	public ArrayList<ChucVu> getChucVuTheoMaCV(String id) throws SQLException {
		ArrayList<ChucVu> dsCV = new ArrayList<ChucVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_ChucVu WHERE [maChucVu] = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maChucVu = resultSet.getString(1);
				String tenChucVu = resultSet.getString(2);
				String moTa = resultSet.getString(3);
				ChucVu chucVu = new ChucVu(maChucVu, tenChucVu, moTa);
				dsCV.add(chucVu);
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

		return dsCV;
	}
	
	public String sinhMaChucVuTuDong() throws SQLException {
		String count = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		String sql = "select COUNT(chucVu.MaChucVu)\r\n" + 
				"from tbl_ChucVu chucVu";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet res = statement.executeQuery(sql);
			res.next();
			count = res.getInt(1) + 1 + "";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i <= 3 - count.split("").length ; i++) {
			count = "0" + count;
		}
		return "HNVRL" + count;
	}
	
	public boolean addChucVu(ChucVu chucVu) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO " + " tbl_ChucVu VALUES(?, ?, ?)");
			statement.setString(1, chucVu.getMaChucVu());
			statement.setString(2, chucVu.getTenChucVu());
			statement.setString(3, chucVu.getMoTa());
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

	public boolean updateChucVu(ChucVu chucVu) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE tbl_ChucVu SET [tenChucVu]=?, [moTa]=? WHERE maChucVu=?");

			statement.setString(1, chucVu.getTenChucVu());
			statement.setString(2, chucVu.getMoTa());
			statement.setString(3, chucVu.getMaChucVu());
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

	public boolean deleteChucVu(String id) throws SQLException {
//		ArrayList<ChucVu> dsCV = new ArrayList<ChucVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "DELETE FROM tbl_ChucVu WHERE [maChucVu] = ?";
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
