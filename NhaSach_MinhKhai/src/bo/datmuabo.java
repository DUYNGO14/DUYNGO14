package bo;

import java.util.ArrayList;

import bean.xacnhanmuabean;
import dao.datmuadao;

public class datmuabo {
	datmuadao dmdao = new datmuadao();
	public long MaKhachhang() throws Exception{
		return dmdao.MaKhachhang();
	}
	public int MaKhachhang(String usename,String pass) throws Exception{
		return dmdao.MaKhachhang(usename, pass);
	}
	public long MaHoaDon() throws Exception{
		return dmdao.MaHoaDon();
	}
	public void HoaDon(int makh) throws Exception{
		dmdao.HoaDon(makh);
	}
	public void HoaDonChiTiet(String masach,long sl,long mahd) throws Exception{
		dmdao.HoaDonChiTiet(masach, sl, mahd);
	}
	public void XacNhan(long MaChiTietHD) throws Exception{
		dmdao.XacNhan(MaChiTietHD);
	}
	public ArrayList<xacnhanmuabean> getxacnhan() throws Exception {
		return dmdao.getxacnhan();
	}
	public static void main(String[] args) {
		try {
			datmuabo d= new datmuabo();
			d.XacNhan(26);
			ArrayList<xacnhanmuabean> ds = d.getxacnhan();
			for (xacnhanmuabean x : ds) {
				System.out.println(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
