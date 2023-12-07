package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.sachbean;

public class themsanphamdao {
	private static final String NULL = null;
	public void insertsach(String masach,String ts,Long sl,Long gia,String ml,Long st,String anh,Date ngaynhap,String tg) throws Exception{
		String query="insert into sach(masach,tensach,soluong,gia,maloai,sotap,anh,NgayNhap,tacgia) values (?,?,?,?,?,?,?,?,?)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, masach);
        ps.setString(2, ts);
        ps.setLong(3, sl);
        ps.setLong(4, gia);
        ps.setString(5, ml);
        ps.setLong(6, st);
        ps.setString(7, anh);
        ps.setDate(8, ngaynhap);
        ps.setString(9, tg);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void updatesach(String masach,String ts,Long sl,Long gia,String ml,Long st,String anh,Date ngaynhap,String tg) throws Exception{
		String query="update sach set    where masach=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, masach);
        ps.setString(2, ts);
        ps.setLong(3, sl);
        ps.setLong(4, gia);
        ps.setString(5, ml);
        ps.setLong(6, st);
        ps.setString(7, anh);
        ps.setDate(8, ngaynhap);
        ps.setString(9, tg);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public static void main(String[] args) {
		try {
			themsanphamdao tspdao= new themsanphamdao();
			sachdao s= new sachdao();
			Date ngaynhap = new Date(System.currentTimeMillis());
			tspdao.insertsach("y40","jksdfh",(long)4,(long)3456,"Y hoc",(long)1,"jdskhfjdskhfd",ngaynhap,"Ngo DUy");
			ArrayList<sachbean> ds=s.getsach();
			for (sachbean t : ds) {
				System.out.println(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
