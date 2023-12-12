package bo;

import java.util.ArrayList;

import bean.giohangbean;
import dao.giohangdao;

public class giohangbo {
	giohangdao ghdao=new giohangdao();
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	
	
	public int SoLuongSp() {
		return ghdao.SoLuongSp();
	}
	public int SoLuongMatHang(String madt) {
		return ghdao.SoLuongMatHang(madt);
	}
	
	public void Themhang(String madt, String tendt, Long gia, Double kichthuocman, Long pin, String maloai, String chip,
			Long ram, Long dungluong, String anh, Long soluong) throws Exception{
		ghdao.Themhang(madt, tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong);
	}
	public void Xoahang(String madt) throws Exception{
		ghdao.Xoahang(madt);
	}
	public Long Tongtien() throws Exception{
		return ghdao.Tongtien();
	}
	public void Cong(String madt) throws Exception{
		ghdao.Cong(madt);
	}
	public void tru(String madt) throws Exception{
		ghdao.tru(madt);
	}
	public long sohang(String madt) throws Exception{
		return ghdao.sohang(madt);
	}
	public ArrayList<giohangbean> getGioHang(long makh) throws Exception{
		return ghdao.getGioHang(makh);
	}
	public void deletetGiohang(String madt) throws Exception{
		ghdao.deletetGiohang(madt);
	}
	public void insertGiohang(String madt,long soluong,long makh) throws Exception{
		ghdao.insertGiohang(madt, soluong, makh);
	}
	public void deletetGiohang1(long makh) throws Exception{
		ghdao.deletetGiohang1(makh);
	}
	public void updateSoluongCong(String madt,long makh) throws Exception{
		ghdao.updateSoluongCong(madt, makh);
	}
	public void updateSoluongTru(String madt,long makh) throws Exception{
		ghdao.updateSoluongTru(madt, makh);
	}
	public static void main(String[] args) {
		try {
			giohangbean g= new giohangbean("m1", "ip", (long)1000, (double)1.1,  (long)1000, "m", "sadsa",  (long)12,  (long)64, "sdef",  (long)1);
			giohangbo gd=new giohangbo();
			ArrayList<giohangbean> gio=new ArrayList<>();
			gd.Themhang("m1", "ip", (long)1000, (double)1.1,  (long)1000, "m", "sadsa",  (long)12,  (long)64, "sdef",  (long)1);
			System.out.println(gio);
			System.out.println(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
