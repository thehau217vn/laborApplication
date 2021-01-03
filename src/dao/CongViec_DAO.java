package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CongViec;

public class CongViec_DAO {
	public ArrayList<CongViec> getAllCongViec() {
		ArrayList<CongViec> dsCV = new ArrayList<CongViec>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT * FROM tbl_CongViec;";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				String maCongViec = resultSet.getString(1);
				String tenCongViec = resultSet.getString(2);
				String moTa = resultSet.getString(3);
				CongViec congViec = new CongViec(maCongViec, tenCongViec, moTa);
				dsCV.add(congViec);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCV;
	}

	public ArrayList<CongViec> getCVTheoMaCV(String id) throws SQLException {
		ArrayList<CongViec> dsCV = new ArrayList<CongViec>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_CongViec WHERE [maCongViec] = ?;";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String maCongViec = resultSet.getString(1);
				String tenCongViec = resultSet.getString(2);
				String moTa = resultSet.getString(3);
				CongViec congViec = new CongViec(maCongViec, tenCongViec, moTa);
				dsCV.add(congViec);
			}
			con.close();
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
	
	public boolean addCongViec(CongViec congViec) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("INSERT INTO " + " tbl_ChucVu VALUES(?, ?, ?)");
			statement.setString(1, congViec.getMaCongViec());
			statement.setString(2, congViec.getTenCongViec());
			statement.setString(3, congViec.getMoTa());
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

	public boolean updateCongViec(CongViec congViec) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			statement = con.prepareStatement("UPDATE tbl_CongViec SET [tenCongViec]=?, [moTa]=? WHERE maCongViec=?");

			statement.setString(1, congViec.getTenCongViec());
			statement.setString(2, congViec.getMoTa());
			statement.setString(3, congViec.getMaCongViec());
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

	public boolean deleteCongViec(String id) throws SQLException {
//		ArrayList<CongViec> dsCV = new ArrayList<CongViec>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "DELETE FROM tbl_CongViec WHERE [maCongViec] = ?";
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
