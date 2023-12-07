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
	public void tru(String madt) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMadt().toLowerCase().trim().equals(madt.toLowerCase().trim())) {
				long a = ds.get(i).getSoluong();
				if(a>0) {
					ds.get(i).setSoluong(a-1);
					ds.get(i).setThanhtien(ds.get(i).getSoluong()*ds.get(i).getGia());
					return;
				}else { if(a==0){
					Xoahang(madt);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			giohangdao ghdao=new giohangdao();
			System.out.println(ghdao.sohang("ip1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
