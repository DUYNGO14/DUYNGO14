package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public long MaKhachhang(String usename,String pass) throws Exception{
		long makh=0;
		String query = "select makh from KhachHang where tendangnhap=? and matkhau=?";
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
		String query = "select max(mahoadon) from HoaDon";
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
		String query="insert into HoaDon(makh,ngaymua,damua) values (?,?,0)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, makh);
        Date ngaymua = new Date(System.currentTimeMillis());
        ps.setDate(2, ngaymua);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void HoaDonChiTiet(String madt,long l,long maxhd) throws Exception{
		String query="insert into HoaDonChiTiet(madt,soluongmua,mahoadon,damua) values(?,?,?,0)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, madt);
        ps.setLong(2, l);
        ps.setLong(3, maxhd);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void UpdateKhachHang(String diachi,String sodt,long makh) throws Exception{
		String query="update KhachHang set diachi=? , sodt=? where makh=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, diachi);
        ps.setString(2, sodt);
        ps.setLong(3, makh);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public static void main(String[] args) {
		try {
			datmuadao dt=new datmuadao();
			dt.UpdateKhachHang("Phú Lôc-Huế", "0353322690", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
