package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.dienThoaiBean;
import bean.donhangbean;

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
	public void deleteGiohang(long makh) throws Exception{
		String query="delete from Giohang where makh=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, makh);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public ArrayList<donhangbean> getDonHangCXN(long makh) throws Exception{
		try {
			ArrayList<donhangbean> ds = new ArrayList<donhangbean>();
			String query="select * from View_DonHangChoXacNhan where makh=?";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, makh);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String madt = rs.getString("madt");
				String tendt = rs.getString("tendt");
				Long gia = rs.getLong("gia");
				Double kichthuocman=rs.getDouble("kichthuocman");
				Long pin = rs.getLong("pin");
				String maloai = rs.getString("maloai");
				String chip = rs.getString("chip");
				Long ram = rs.getLong("ram");
				Long dungluong = rs.getLong("dungluong");
				String anh = rs.getString("anh");
				Long soluongmua = rs.getLong("soluongmua");
				Long mahoadon=rs.getLong("mahoadon");
				Date ngaymua = rs.getDate("ngaymua");
				ds.add(new donhangbean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluongmua,mahoadon,ngaymua));
			}
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public long getMaHoaDon(long mahoadon) throws Exception{
		try {
			String query="select mahoadon from HoaDonChiTiet where mahoadon=?";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, mahoadon);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getLong(1);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void deleteHoaDonChiTiet(long mahoadon,String madt) throws Exception{
		String query="delete from HoaDonChiTiet where mahoadon=? and madt=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, mahoadon);
        ps.setString(2,madt);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void deleteHoaDon(long mahoadon,long makh) throws Exception{
		String query="delete from HoaDon where mahoadon=? and makh=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, mahoadon);
        ps.setLong(2,makh);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public static void main(String[] args) {
		try {
			datmuadao dt=new datmuadao();
			System.out.println(dt.getMaHoaDon(1));
			dt.deleteHoaDonChiTiet(1, "ip2");
			if(dt.getMaHoaDon(1)==0) {
				dt.deleteHoaDon(1, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
