package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.dangnhapbean;

public class dangnhapdao {
	public dangnhapbean login(String user,String pass)throws Exception{
		String query="select * from KhachHang where tendangnhap=? and matkhau=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return new dangnhapbean(rs.getString(1),rs.getString(2), (long)0);
        }
        rs.close();
        ps.close();
        return null;
	}
	public dangnhapbean loginAdmin(String user,String pass,long quyen)throws Exception{
		String query="select * from DangNhap where tendangnhap=? and matkhau=? and quyen=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, pass);
        ps.setLong(3, quyen);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return new dangnhapbean(rs.getString(1),rs.getString(2), rs.getLong(3));
        }
        rs.close();
        ps.close();
        return null;
	}
	public static void main(String[] args) {
		try {
			dangnhapdao dndao=new dangnhapdao();
			dangnhapbean n=dndao.loginAdmin("NgoDuy", "12345",(long)1);
			System.out.println(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
