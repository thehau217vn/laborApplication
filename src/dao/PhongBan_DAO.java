package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getAllPhongBan() {
		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT * FROM tbl_PhongBan;";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String maPhongBan = resultSet.getString(1);
				String tenPhongBan = resultSet.getString(2);
				String hotLine = resultSet.getString(3);
				String moTa = resultSet.getString(4);
				PhongBan phongBan = new PhongBan(maPhongBan, tenPhongBan, hotLine, moTa);
				dsPB.add(phongBan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPB;
	}

	public ArrayList<PhongBan> getTheoMaPB(String id) throws SQLException {
		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_PhongBan WHERE [maPhongBan] = ?;";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String maPhongBan = resultSet.getString(1);
				String tenPhongBan = resultSet.getString(2);
				String hotLine = resultSet.getString(3);
				String moTa = resultSet.getString(4);
				PhongBan phongBan = new PhongBan(maPhongBan, tenPhongBan, hotLine, moTa);
				dsPB.add(phongBan);
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
		return dsPB;
	}

	public ArrayList<PhongBan> getPBTheoMaPB(String id) throws SQLException {
		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_PhongBan WHERE [maPhongBan] = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maPhongBan = resultSet.getString(1);
				String tenPhongBan = resultSet.getString(2);
				String hotLine = resultSet.getString(3);
				String moTa = resultSet.getString(4);
				PhongBan phongBan = new PhongBan(maPhongBan, tenPhongBan, hotLine, moTa);
				dsPB.add(phongBan);
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

		return dsPB;
	}

	public ArrayList<PhongBan> getPhongBanTheoTenPB(String id) throws SQLException {
		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_PhongBan WHERE [maPhongBan] = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maPhongBan = resultSet.getString(1);
				String tenPhongBan = resultSet.getString(2);
				String hotLine = resultSet.getString(3);
				String moTa = resultSet.getString(4);
				PhongBan phongBan = new PhongBan(maPhongBan, tenPhongBan, hotLine, moTa);
				dsPB.add(phongBan);
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

		return dsPB;
	}

	public boolean addPhongBan(PhongBan phongBan) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO " + " tbl_PhongBan VALUES(?, ?, ?, ?)");
			statement.setString(1, phongBan.getMaPhongBan());
			statement.setString(2, phongBan.getTenPhongBan());
			statement.setString(3, phongBan.getHotLine());
			statement.setString(4, phongBan.getMoTa());
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

	public boolean updatePhongBan(PhongBan phongBan) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement(
					"UPDATE tbl_PhongBan SET [tenPhongBan]=?, [hotLine]=?, [moTa]=? WHERE maPhongBan=?");
			statement.setString(1, phongBan.getTenPhongBan());
			statement.setString(2, phongBan.getHotLine());
			statement.setString(3, phongBan.getMoTa());
			statement.setString(4, phongBan.getMaPhongBan());
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

	public boolean deletePhongBan(String id) throws SQLException {
//		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "DELETE FROM tbl_PhongBan WHERE [maPhongBan] = ?";
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

	public String sinhMaPBTuDong() throws SQLException {
		String count = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		String sql = "select COUNT(tbl_PhongBan.maPhongBan) from tbl_PhongBan";
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
		return "HNVPB" + count;
	}
}
