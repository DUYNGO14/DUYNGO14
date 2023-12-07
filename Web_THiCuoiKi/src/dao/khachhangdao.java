package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;

public class khachhangdao {
	public ArrayList<khachhangbean> getKhachHang() throws Exception{
		ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
		String query = "select * from KhachHang";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long makh=rs.getLong("makh");
            	String hoten = rs.getString("hoten");
            	String diachi = rs.getString("diachi");
            	String sdt = rs.getString("sodt");
            	String email = rs.getString("email");
            	String tendn = rs.getString("tendangnhap");
            	String pass = rs.getString("matkhau");
				
				ds.add(new khachhangbean(makh, hoten, diachi, sdt, email, tendn, pass));
			}
			
			rs.close();
			conn.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) {
		try {
			khachhangdao khdao = new khachhangdao();
			ArrayList<khachhangbean> ds= khdao.getKhachHang();
			for (khachhangbean k : ds) {
				System.out.println(k);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
