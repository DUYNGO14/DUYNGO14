package bo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.giohangbean;
import bean.sachbean;
import dao.KetNoi;
import dao.datmuadao;

public class giohangbo {
	
	//viết hàm thêm/xóa/tổng tiền vào giỏ:ds
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public int SoLuongSp() {
		int sl = ds.size();
		return sl;
	}
	public int SoLuongMatHang(String masach) {
		int sl=0;
		for (giohangbean g : ds) {
			if(g.getMasach().equals(masach)) {
				sl+=g.getSoluong();
			}
		}
		return sl;
	}
	public void Themhang(String masach, String tensach, String tacgia, Long soluong, Long gia,
			String anh) throws Exception{
		int n=ds.size();
		if(n==0) {
			soluong=(long)1;
			ds.add(new giohangbean(masach, tensach, tacgia, soluong, gia, anh));
		}else {
			for (int i=0;i<n;i++) {
				if(ds.get(i).getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())){
					long sl= ds.get(i).getSoluong()+(long)1;
					ds.get(i).setSoluong(sl);
					long g = ds.get(i).getGia();
					long tt = sl*g;
					ds.get(i).setThanhtien(tt);
					return;
				}
			}
			soluong=(long)1;
			ds.add(new giohangbean(masach, tensach, tacgia, soluong, gia, anh));
		}
	}
	public void Xoahang(String masach) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				ds.remove(i);
				return;
			}
		}
	}
	public void XoaALL() {
		ds.clear();
	}
	public Long Tongtien() throws Exception{
		Long tong=(long) 0;
		for (giohangbean gh : ds) {
			tong+= gh.getThanhtien();
		}
		return tong;
	}
	public void Cong(String masach) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				long a = ds.get(i).getSoluong();
				ds.get(i).setSoluong(a+1);
				ds.get(i).setThanhtien(ds.get(i).getSoluong()*ds.get(i).getGia());
				return;
			}
		}
	}
	public void tru(String masach) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				long a = ds.get(i).getSoluong();
				if(a>0) {
					ds.get(i).setSoluong(a-1);
					ds.get(i).setThanhtien(ds.get(i).getSoluong()*ds.get(i).getGia());
					return;
				}else { if(a==0){
					Xoahang(masach);
					}
				}
			}
		}
	}
	public int xoasach(String masach) throws Exception{
		String query = "delete from sach where masach=?";
		try {
			Connection conn = new KetNoi().getConnection();// mo ket noi voi sql
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, masach);
			int rs = ps.executeUpdate();
			conn.close();
			ps.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		try {
			giohangbo g= new giohangbo();
			g.xoasach("y40");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

