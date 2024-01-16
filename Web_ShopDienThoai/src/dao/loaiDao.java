package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.danhgiabean;
import bean.dienThoaiBean;
import bean.loaiBean;


public class loaiDao {
	public ArrayList<loaiBean> getloai() throws Exception{
		ArrayList<loaiBean> ds = new ArrayList<loaiBean>();
		String query = "select * from loai";
        try {
        	Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        	PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maloai = rs.getString("maloai");
                String tenloai = rs.getString("tenloai");
                ds.add( new loaiBean(maloai, tenloai));
            }
            conn.close();
            rs.close();
            return ds;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
		return null;
	}
	public void inserthang(String maloai,String tenloai)throws Exception{
		String query="insert into loai(maloai,tenloai) values(?,?)";
		Connection conn= new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, maloai);
		ps.setString(2, tenloai);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	public loaiBean TimMaLoai(String maloai) throws Exception{
		try {
			loaiBean l=new loaiBean();
			String query="select * from loai where maloai=?";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, maloai);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return l= new loaiBean(rs.getString(1), rs.getString(2)) ;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String Tenloai(String maloai) throws Exception{
		try {
			String query="select tenloai from loai where maloai=?";
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, maloai);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getString(1) ;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		try {
			loaiDao l = new loaiDao();
			ArrayList<loaiBean> ds = l.getloai();
			System.out.println(l.Tenloai("ip"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
