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
	public void XacNhanDon(long MaChiTietHD) throws Exception{
		String query="update HoaDonChiTiet set damua=1 where machitiethoadon=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, MaChiTietHD);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public static void main(String[] args) {
		try {
			xacnhandonadmindao xndao=new xacnhandonadmindao();
			xndao.XacNhanDon(3);
			ArrayList<xacnhanmuaAdminbean> ds= xndao.getdonhang();
			for (xacnhanmuaAdminbean xn : ds) {
				System.out.println(xn);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
