package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.lichsubean;

public class lichsumuahangdao {
	public ArrayList<lichsubean> getLichSu(long makh1) throws Exception{
		ArrayList<lichsubean> ds = new ArrayList<lichsubean>();
        try {
        	String query = "select * FROM [ShopDienThoai].[dbo].[LichSuMuaHang] where makh=?";
            Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setLong(1, makh1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	 String madt = rs.getString("madt");
            	  String tendt= rs.getString("tendt");
            	  Long slmua=rs.getLong("soluongmua");
            	  Long gia=rs.getLong("gia");
            	  Double ktm=rs.getDouble("kichthuocman");
            	  Long pin=rs.getLong("pin");
            	  String chip= rs.getString("chip");
            	  Long ram=rs.getLong("ram");
            	  Long dl=rs.getLong("dungluong");
            	  String anh= rs.getString("anh");
            	  Long thanhtien=rs.getLong("thanhtien");
            	  Long makh=rs.getLong("makh");
                ds.add(new lichsubean(madt, tendt, slmua, gia, ktm, pin, chip, ram, dl, anh, thanhtien, makh));
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
			lichsumuahangdao lsdao=new lichsumuahangdao();
			ArrayList<lichsubean> ls = lsdao.getLichSu(2);
			for (lichsubean l : ls) {
				System.out.println(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
