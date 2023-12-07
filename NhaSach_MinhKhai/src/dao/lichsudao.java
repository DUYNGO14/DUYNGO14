package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.lichsubean;

public class lichsudao {
	public ArrayList<lichsubean> getLichSu(long makh1) throws Exception{
		ArrayList<lichsubean> ds = new ArrayList<lichsubean>();
        try {
        	String query = "select * from LichSuMuaHang where makh=?";
            Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, makh1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	String masach= rs.getString("masach");
            	String tensach=rs.getString("tensach");
            	long soluongmua=rs.getLong("SoLuongMua");
            	long gia=rs.getLong("gia");
            	long thanhtien=rs.getLong("ThanhTien");
            	int damua=rs.getInt("damua");
            	long makh=rs.getLong("makh");
    			String anh=rs.getString("anh");
                ds.add(new lichsubean(masach, tensach, soluongmua, gia, thanhtien, damua, makh, anh));
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
			lichsudao lsdao = new lichsudao();
			ArrayList<lichsubean> ds = lsdao.getLichSu(23);
			for (lichsubean s : ds) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
