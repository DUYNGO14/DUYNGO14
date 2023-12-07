package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.batch.Main;

import bean.dangnhapbean;



public class dangnhapdao {
	public dangnhapbean login(String user,String pass)throws Exception{
		String query="select * from DangNhap where TenDangNhap=? and MatKhau=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return new dangnhapbean(rs.getString(1),rs.getString(2), 0);
        }
        rs.close();
        ps.close();
        return null;
	}
	public dangnhapbean loginAdmin(String user,String pass,int quyen)throws Exception{
		String query="select * from DangNhap where TenDangNhap=? and MatKhau=? and Quyen=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, pass);
        ps.setInt(3, quyen);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return new dangnhapbean(rs.getString(1),rs.getString(2), rs.getInt(3));
        }
        rs.close();
        ps.close();
        return null;
	}
	public static void main(String[] args) {
		try {
			dangnhapdao d= new dangnhapdao();
			dangnhapbean dn= d.loginAdmin("NgoDuy", "12345", 0);
			System.out.println(dn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
