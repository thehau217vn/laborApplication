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
			String sql = "SELECT * FROM tbl_CongViec ORDER BY [maCongViec];";
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
			statement = con.prepareStatement("INSERT INTO" + " tbl_CongViec VALUES(?, ?, ?)");
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

	public String sinhMaCongViecTuDong() throws SQLException {
		String count = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		String sql = "select COUNT(tbl_CongViec.maCongViec) from tbl_CongViec";
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
		return "HNVCV" + count;
	}

	public boolean kiemTraCongViecDaTonTai(String tenCongViecCanKiemTra) throws SQLException {
		CongViec cv = null;
		boolean result = true;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		String sql = "select *\r\n" + "from tbl_CongViec cv\r\n" + "where cv.TenCongViec like N'%"
				+ tenCongViecCanKiemTra + "%'";
		Statement statement;
		ResultSet res = null;
		try {
			statement = con.createStatement();
			res = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result = res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
