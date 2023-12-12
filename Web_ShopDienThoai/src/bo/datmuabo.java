package bo;

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
}
