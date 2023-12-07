package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sachbean;
import bean.xacnhanmuabean;



public class datmuadao {
	public long MaKhachhang() throws Exception{
		long makh = 0;
		String query = "select max(makh) from KhachHang";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				makh=rs.getLong(1);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return makh;
	}
	
	public int MaKhachhang(String usename,String pass) throws Exception{
		int makh=0;
		String query = "select makh from KhachHang where tendn=? and pass=?";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, usename);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				makh= rs.getInt(1);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return makh;
	}
	public long MaHoaDon() throws Exception{
		long mahd = 0;
		String query = "select max(MaHoaDon) from hoadon";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mahd=rs.getLong(1);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mahd;
	}
	public void HoaDon(long makh) throws Exception{
		String query="insert into hoadon(makh,NgayMua,damua) values (?,?,0)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, makh);
        Date ngaymua = new Date(System.currentTimeMillis());
        ps.setDate(2, ngaymua);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void HoaDonChiTiet(String masach,long l,long maxhd) throws Exception{
		String query="insert into ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon,damua) values (?,?,?,0)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, masach);
        ps.setLong(2, l);
        ps.setLong(3, maxhd);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void XacNhan(long MaChiTietHD) throws Exception{
		String query="update ChiTietHoaDon set damua=1 where MaChiTietHD=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, MaChiTietHD);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	
	public ArrayList<xacnhanmuabean> getxacnhan() throws Exception {
		ArrayList<xacnhanmuabean> ds = new ArrayList<xacnhanmuabean>();
		String query = "select * from View_AdminXacNhanMua where damua=0";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long MaChiTietHD = rs.getLong("MaChiTietHD");
				String tensach = rs.getString("tensach");
				String hoten = rs.getString("hoten");
				Long SoLuongMua = rs.getLong("SoLuongMua");
				Long gia = rs.getLong("gia");
				Long thanhtien = rs.getLong("thanhtien");
				Boolean damua=rs.getBoolean("damua");
				ds.add(new xacnhanmuabean(MaChiTietHD, hoten, tensach, gia, SoLuongMua, thanhtien, damua));
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public static void main(String[] args) {
		try {
			datmuadao d = new datmuadao();
			int makh= d.MaKhachhang("ngoduy","1234");
			System.out.println(d.MaKhachhang("ngoduy","1234"));
			Date date = new Date(System.currentTimeMillis());
			System.out.println(d.MaHoaDon()); 
			System.out.println(date);
			d.XacNhan(27);
			ArrayList<xacnhanmuabean> ds = d.getxacnhan();
			for (xacnhanmuabean x : ds) {
				System.out.println(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
