package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.khachhangbean;
import bean.lichsubean;

public class thongkedao {
	public ArrayList<khachhangbean> getKhachhang() throws Exception{
		ArrayList<khachhangbean> ds = new ArrayList<khachhangbean>();
        try {
        	String query = "select * from KhachHang";
            Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Long makh=rs.getLong("makh");
            	String hoten = rs.getString("hoten");
            	String diachi = rs.getString("diachi");
            	String sdt = rs.getString("sodt");
            	String email = rs.getString("email");
            	String tendn = rs.getString("tendn");
            	String pass = rs.getString("pass");
            	ds.add(new khachhangbean(makh, hoten, diachi, sdt, email, tendn, pass));
            }
            conn.close();
            rs.close();
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return ds;
	}
	public static void main(String[] args) {
		try {
			thongkedao tkdao=new thongkedao();
			ArrayList<khachhangbean> ds = tkdao.getKhachhang();
			for (khachhangbean k : ds) {
				System.out.println(k);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
