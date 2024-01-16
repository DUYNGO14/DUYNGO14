package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.giohangbean;
import bean.xacnhanmuaAdminbean;

public class giohangdao {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public int SoLuongSp() {
		int sl = ds.size();
		return sl;
	}
	public int SoLuongMatHang(String masach) {
		int sl=0;
		for (giohangbean g : ds) {
			if(g.getMadt().equals(masach)) {
				sl+=g.getSoluong();
			}
		}
		return sl;
	}
	public void Themhang(String madt, String tendt, Long gia, Double kichthuocman, Long pin, String maloai, String chip,
			Long ram, Long dungluong, String anh, Long soluong) throws Exception{
		int n=ds.size();
		soluong=(long)1;
		if(n==0) {
			ds.add(new giohangbean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
		}else {
			for (int i=0;i<n;i++) {
				if(ds.get(i).getMadt().toLowerCase().trim().equals(madt.toLowerCase().trim())){
					long sl= ds.get(i).getSoluong()+(long)1;
					ds.get(i).setSoluong(sl);
					long g = ds.get(i).getGia();
					long tt = sl*g;
					ds.get(i).setThanhtien(tt);
					return;
				}
			}

			ds.add(new giohangbean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
		}
	}
	public void Themhang1(String madt, String tendt, Long gia, Double kichthuocman, Long pin, String maloai, String chip,
			Long ram, Long dungluong, String anh, Long soluong) throws Exception{
		ds.add(new giohangbean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
	}
	public void Xoahang(String madt) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMadt().toLowerCase().trim().equals(madt.toLowerCase().trim())) {
				ds.remove(i);
				return;
			}
		}
	}
	public Long Tongtien() throws Exception{
		Long tong=(long) 0;
		for (giohangbean gh : ds) {
			tong+= gh.getThanhtien();
		}
		return tong;
	}
	public long sohang(String madt) throws Exception{
		String query = "select soluong from dienthoai where madt=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, madt);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return rs.getLong(1);
		}
		return 0;	
	}
	public void Cong(String madt) throws Exception{
		giohangdao ghdao=new giohangdao();
		int n = ds.size();
		long sl=ghdao.sohang(madt);
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMadt().toLowerCase().trim().equals(madt.toLowerCase().trim())) {
				long a = ds.get(i).getSoluong();
				if (a<sl) {
					ds.get(i).setSoluong(a+1);
					ds.get(i).setThanhtien(ds.get(i).getSoluong()*ds.get(i).getGia());
					return;
				}
			}
		}
	}
	public void deletetGiohang(String madt) throws Exception{
		String query="delete from Giohang where madt=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, madt);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void tru(String madt) throws Exception{
		giohangdao ghdao=new giohangdao();
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMadt().toLowerCase().trim().equals(madt.toLowerCase().trim())) {
				long a = ds.get(i).getSoluong();
				if(a>0) {
					ds.get(i).setSoluong(a-1);
					ds.get(i).setThanhtien(ds.get(i).getSoluong()*ds.get(i).getGia());
					return;
				}else{
					Xoahang(madt);
					deletetGiohang(madt);
				}
			}
		}
	}
	public ArrayList<giohangbean> getGioHang(long makh) throws Exception{
		ArrayList<giohangbean>ds = new ArrayList<giohangbean>();
		String query = "select * from View_GioHang where makh=?";
		Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setLong(1, makh);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String madt =rs.getString("madt");
			String tendt=rs.getString("tendt");
			Long gia=rs.getLong("gia");
			Double kichthuocman=rs.getDouble("kichthuocman");
			Long pin=rs.getLong("pin");
			String maloai=rs.getString("maloai");
			String chip=rs.getString("chip");
			Long ram=rs.getLong("ram");
			Long dungluong=rs.getLong("dungluong");
			String anh=rs.getString("anh");
			Long soluong=rs.getLong("soluong");
			ds.add(new giohangbean(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong));
		}
		return ds;	
	}
	public void insertGiohang(String madt,long soluong,long makh) throws Exception{
		String query="insert into Giohang(madt,soluong,makh) values (?,?,?)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, madt);
        ps.setLong(2, soluong);
        ps.setLong(3, makh);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	
	public void deletetGiohang1(long makh) throws Exception{
		String query="delete from Giohang where makh=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setLong(1, makh);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void updateSoluongCong(String madt,long makh) throws Exception{
		String query="update Giohang set soluong=soluong+1 where madt=? and makh=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, madt);
        ps.setLong(2, makh);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public void updateSoluongTru(String madt,long makh) throws Exception{
		String query="update Giohang set soluong=soluong-1 where madt=? and makh=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, madt);
        ps.setLong(2, makh);
        ps.executeUpdate();
        ps.close();
        conn.close();
	}
	public long SoLuong(String madt,long makh) throws Exception{
		String query="select soluong from Giohang where madt=? and makh=?";
		Connection conn = new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, madt);
		ps.setLong(2, makh);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			return rs.getLong(1);
		}
		return 0;
	}
	public static void main(String[] args) {
		try {
			giohangdao ghdao=new giohangdao();
			ArrayList<giohangbean> ds = ghdao.getGioHang(2);
			for (giohangbean g : ds) {
				System.out.println(g.getSoluong());
			}
			/*
			 * ghdao.insertGiohang("ip11",2,4); ghdao.deletetGiohang("ip10");
			 */
			System.out.println(ghdao.SoLuong("no1", 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
