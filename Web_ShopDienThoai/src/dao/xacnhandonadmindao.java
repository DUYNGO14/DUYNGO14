package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.xacnhanmuaAdminbean;


public class xacnhandonadmindao {
	public ArrayList<xacnhanmuaAdminbean> getdonhang() throws Exception{
		ArrayList<xacnhanmuaAdminbean> ds= new ArrayList<xacnhanmuaAdminbean>();
		try {
			String query = "select * from view_xacnhandonhangAdmin where damua=0";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long MaChiTietHD = rs.getLong("machitiethoadon");
				String tendt = rs.getString("tendt");
				String hoten = rs.getString("hoten");
				Long soluongmua = rs.getLong("soluongmua");
				Long gia = rs.getLong("gia");
				Long thanhtien = rs.getLong("thanhtien");
				Boolean damua=rs.getBoolean("damua");
				ds.add(new xacnhanmuaAdminbean(MaChiTietHD, hoten, tendt, gia, soluongmua, thanhtien, damua));
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public ArrayList<xacnhanmuaAdminbean> getdonhangdaxacnhan() throws Exception{
		ArrayList<xacnhanmuaAdminbean> ds= new ArrayList<xacnhanmuaAdminbean>();
		try {
			String query = "select * from view_xacnhandonhangAdmin where damua=1";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long MaChiTietHD = rs.getLong("machitiethoadon");
				String tendt = rs.getString("tendt");
				String hoten = rs.getString("hoten");
				Long soluongmua = rs.getLong("soluongmua");
				Long gia = rs.getLong("gia");
				Long thanhtien = rs.getLong("thanhtien");
				Boolean damua=rs.getBoolean("damua");
				ds.add(new xacnhanmuaAdminbean(MaChiTietHD, hoten, tendt, gia, soluongmua, thanhtien, damua));
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	public Long DoanhThu() throws Exception{
		xacnhandonadmindao xndao = new xacnhandonadmindao();
		long doanhthu =0;
		ArrayList<xacnhanmuaAdminbean> ds = xndao.getdonhangdaxacnhan();
		for (xacnhanmuaAdminbean x : ds) {
			doanhthu+=x.getThanhtien();
		}
		return doanhthu;
	}
	public void XacNhanDon(long MaChiTietHD) throws Exception{
		String query="update HoaDonChiTiet set damua=1 where machitiethoadon=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, MaChiTietHD);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public xacnhanmuaAdminbean getdienthoaibanchay() throws Exception{
		xacnhanmuaAdminbean ds= new xacnhanmuaAdminbean();
		try {
			String query = "select top 1 tendt,sum(soluongmua) as sl from view_xacnhandonhangAdmin where damua=1 group by tendt order by sl desc";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String tendt = rs.getString("tendt");
				Long soluongmua = rs.getLong("sl");
				ds=new xacnhanmuaAdminbean(null, null, tendt, null, soluongmua, null, null);
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
			xacnhandonadmindao xndao=new xacnhandonadmindao();
			xacnhanmuaAdminbean ds = xndao.getdienthoaibanchay();
			System.out.println(ds);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
