package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.sachbean;

public class sachdao {
//viết hàm getsah->lấy về toàn bộ sách
//viết hàm SuaSoLuong() -> giảm số lượng  trong bảng sách khi bán 	
	public ArrayList<sachbean> getsach() throws Exception{
		ArrayList<sachbean> ds= new ArrayList<sachbean>();
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "select * from sach";
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		ResultSet rs =  cmd.executeQuery();
		while(rs.next()) {
			String masach = rs.getString("masach");
			String tensach= rs.getString("tensach");
			long soluong = rs.getLong("soluong");
			long gia= rs.getLong("gia"); 
			String maloai= rs.getString("maloai"); 
			String sotap= rs.getString("sotap"); 
			String anh= rs.getString("anh");
			Date ngayNhap = rs.getDate("ngayNhap"); 
			String tacgia= rs.getString("tacgia");
			ds.add(new sachbean(masach, tensach, soluong, gia, maloai, sotap, anh, ngayNhap, tacgia));
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return ds;
	}
	public 	int SuaSoLuong(String masach,long soluong) throws Exception {
        KetNoi kn= new KetNoi();
        kn.ketnoi();
        String sql="update sach set soluong = soluong - ? where masach like ?";
        PreparedStatement cmd=kn.cn.prepareStatement(sql);
        cmd.setLong(1, soluong);
        cmd.setString(2,masach);
        int kq= cmd.executeUpdate();
        cmd.close();
        kn.cn.close();
        return kq;
	}
}
