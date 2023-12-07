package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Loaibean;


public class loaidao {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	public ArrayList<Loaibean> getloai() throws Exception{
		ArrayList<Loaibean> ds = new ArrayList<Loaibean>();
		String query = "select * from loai";
        try {
            conn = new KetNoi().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maloai = rs.getString("maloai");
                String tenloai = rs.getString("tenloai");
                ds.add( new Loaibean(maloai, tenloai));
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        conn.close();
        rs.close();
		return ds;
	}
}
