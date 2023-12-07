package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	public static void main(String[] args) {
		try {
			loaiDao l = new loaiDao();
			ArrayList<loaiBean> ds = l.getloai();
			for (loaiBean a : ds) {
				System.out.println(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
