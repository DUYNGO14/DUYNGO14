package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.dangnhapbean;

public class dangkidao {
	public dangnhapbean checklogin(String user)throws Exception{
		String query="select * from DangNhap where TenDangNhap=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return new dangnhapbean(rs.getString(1),rs.getString(2), 0);
        }
        rs.close();
        ps.close();
        return null;
	}
	public void sigup(String user,String pass) throws Exception{
		String query="insert into DangNhap values(?,?,0)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, pass);
        ps.executeUpdate();
        ps.close();
	}
	public void KhachHang(String hoten,String user,String pass) throws Exception{
		String query="insert into KhachHang(hoten,tendn,pass) values (?,?,?)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, hoten);
        ps.setString(2, user);
        ps.setString(3, pass);
        ps.executeUpdate();
        ps.close();
	}
	public static void main(String[] args) {
		dangkidao dkdao = new dangkidao();
		try {
			dangnhapbean dnbean = dkdao.checklogin("abcdf");
			if(dnbean==null) {
				System.out.println("Ko cos");
			}else {
				System.out.println("Có");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
