package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhanCongNhanVien;
import entity.CongTrinh;
import entity.CongViec;
import entity.NhanVien;

public class PhanCongNhanVien_DAO {
	public ArrayList<PhanCongNhanVien> getAllPCNV() {
		ArrayList<PhanCongNhanVien> dsPCNV = new ArrayList<PhanCongNhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnect();
			String sql = "SELECT * FROM tbl_PhanCongNhanVien;";
			Statement statement = con.createStatement();	
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				NhanVien nhanVien = new NhanVien(resultSet.getString(1));
				String tenNhanVien = resultSet.getString(2);
				CongViec congViec = new CongViec(resultSet.getString(3));
				CongTrinh tenCongTrinh = new CongTrinh(resultSet.getString(4));
				String ngayBatDau = resultSet.getString(5);
				String ngayKetThuc = resultSet.getString(6);
				PhanCongNhanVien phanCongNhanVien = new PhanCongNhanVien(nhanVien, tenNhanVien, congViec,
						tenCongTrinh, ngayBatDau, ngayKetThuc);
				dsPCNV.add(phanCongNhanVien);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPCNV;
	}
	
	public ArrayList<PhanCongNhanVien> getPCNVTheoMaPC(String id) throws SQLException {
		ArrayList<PhanCongNhanVien> dsPCNV = new ArrayList<PhanCongNhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		try {
			String sql = "SELECT * FROM tbl_PhanCongNhanVien WHERE [maPhanCong] = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				NhanVien nhanVien = new NhanVien(resultSet.getString(1));
				String tenNhanVien = resultSet.getString(2);
				CongViec congViec = new CongViec(resultSet.getString(3));
				CongTrinh tenCongTrinh = new CongTrinh(resultSet.getString(4));
				String ngayBatDau = resultSet.getString(5);
				String ngayKetThuc = resultSet.getString(6);
				PhanCongNhanVien phanCongNhanVien = new PhanCongNhanVien(nhanVien, tenNhanVien, congViec,
						tenCongTrinh, ngayBatDau, ngayKetThuc);
				dsPCNV.add(phanCongNhanVien);
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

		return dsPCNV;
	}
	
//	public ArrayList<PhanCongNhanVien> loadPCNVJCT(String id) throws SQLException {
//		ArrayList<PhanCongNhanVien> dsPCNV = new ArrayList<PhanCongNhanVien>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnect();
//		PreparedStatement statement = null;
//		try {
//			String sql = "SELECT NV.maNhanVien, tenNhanVien, maPhongBan, tenCongViec FROM tbl_NhanVien NV JOIN tbl_PhanCongNhanVien PCNV"
//						+ "ON NV.maNhanVien = PCNV.maNhanVien WHERE maCongTrinh = ?";
//			statement = con.prepareStatement(sql);
//			statement.setString(1, id);
//			ResultSet resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				NhanVien nhanVien = new NhanVien(resultSet.getString(1));
//				String tenNhanVien = resultSet.getString(2);
//				CongViec congViec = new CongViec(resultSet.getString(3));
//				CongTrinh tenCongTrinh = new CongTrinh(resultSet.getString(4));
//				String ngayBatDau = resultSet.getString(5);
//				String ngayKetThuc = resultSet.getString(6);
//				PhanCongNhanVien phanCongNhanVien = new PhanCongNhanVien(nhanVien, tenNhanVien, congViec,
//						tenCongTrinh, ngayBatDau, ngayKetThuc);
//				dsPCNV.add(phanCongNhanVien);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//
//		return dsPCNV;
//	}
//	public boolean createPCNV(PhanCongNhanVien phanCongNV) throws SQLException {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnect();
//		PreparedStatement statement = null;
//		int n = 0;
//		try {
//			statement = con.prepareStatement("INSERT INTO" + "tbl_PhanCongNhanVien VALUES(?, ?, ?, ?, ?, ?);");
//			statement.setString(1, phanCongNV.getNhanVien().getMaNhanVien());
//			statement.setString(2, phanCongNV.getCongViec().getMaCongViec());
//			statement.setString(3, phanCongNV.getTenCongViec());
//			statement.setString(4, phanCongNV.getCongTrinh().getTenCongTrinh());
//			statement.setString(5, phanCongNV.getNgayBatDau());
//			statement.setString(6, phanCongNV.getNgayKetThuc());
//			n = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		con.close();
//		return n > 0;
//	}

//	public boolean updatePCNV(PhanCongNhanVien phanCongNV) throws SQLException {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnect();
//		PreparedStatement statement = null;
//		int n = 0;
//		try {
//			statement = con.prepareStatement("UPDATE tbl_PhanCongNhanVien SET [maNhanVien]=?,[maCongViec]=?,[tenCongViec]=?,"
//					+ "[tenCongTrinh]=?,[ngayBatDau]=?,[ngayKetThuc]=?");
//			statement.setString(1, phanCongNV.getNhanVien().getMaNhanVien());
//			statement.setString(2, phanCongNV.getCongViec().getMaCongViec());
//			statement.setString(3, phanCongNV.getTenCongViec());
//			statement.setString(4, phanCongNV.getCongTrinh().getTenCongTrinh());
//			statement.setString(5, phanCongNV.getNgayBatDau());
//			statement.setString(6, phanCongNV.getNgayKetThuc());
//			n = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				statement.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		con.close();
//		return n > 0;
//	}

	public boolean deletePCNV(String id) throws SQLException {
//		ArrayList<PhanCongNhanVien> dsPCNV = new ArrayList<PhanCongNhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnect();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "DELETE FROM tbl_PhanCongNhanVien WHERE [maPhanCong] = ?;";
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
		con.close();
		return n > 0;
	}
}
