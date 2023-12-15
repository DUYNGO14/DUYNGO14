package bo;


import java.util.ArrayList;


import bean.donhangbean;

import dao.datmuadao;

public class datmuabo {
	datmuadao dmdao=new datmuadao();
	public long MaKhachhang() throws Exception{
		return dmdao.MaKhachhang();
	}
	public long MaKhachhang(String usename,String pass) throws Exception{
		return dmdao.MaKhachhang(usename, pass);
	}
	public long MaHoaDon() throws Exception{
		return dmdao.MaHoaDon();
	}
	public void HoaDon(long makh) throws Exception{
		dmdao.HoaDon(makh);
	}
	public void HoaDonChiTiet(String madt,long l,long maxhd) throws Exception{
		dmdao.HoaDonChiTiet(madt, l, maxhd);
	}
	public void UpdateKhachHang(String sodt,String diachi,long makh) throws Exception{
		dmdao.UpdateKhachHang(sodt, diachi, makh);
	}
	public void deleteGiohang(long makh) throws Exception{
		dmdao.deleteGiohang(makh);
	}
	public ArrayList<donhangbean> getDonHangCXN(long makh) throws Exception{
		return dmdao.getDonHangCXN(makh);
	}
	public void deleteHoaDonChiTiet(long mahoadon,String madt) throws Exception{
		dmdao.deleteHoaDonChiTiet(mahoadon, madt);
	}
	public void deleteHoaDon(long mahoadon,long makh) throws Exception{
		dmdao.deleteHoaDon(mahoadon, makh);
	}
	public long getMaHoaDon(long mahoadon) throws Exception{
		return dmdao.getMaHoaDon(mahoadon);
	}
	public static void main(String[] args) {
		try {
			datmuabo dmbo=new datmuabo();
			dmbo.deleteHoaDon(1,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
