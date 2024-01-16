package bo;

import java.util.ArrayList;

import bean.dienThoaiBean;
import bean.khachhangbean;
import bean.loaiVoucherbean;
import bean.voucherbean;
import dao.thongkedao;

public class thongkebo {
	thongkedao tkdao=new thongkedao();
	public ArrayList<dienThoaiBean> thongKeBanChay(long t) throws Exception{
		return tkdao.thongKeBanChay(t);
	}
	public ArrayList<khachhangbean> thongKeKhachVip(long t) throws Exception{
		return tkdao.thongKeKhachVip(t);
	}
	public ArrayList<voucherbean> getVoucher() throws Exception{
		return tkdao.getVoucher();
	}
	public ArrayList<voucherbean> getVoucher1(long maloaivoucher1) throws Exception{
		return tkdao.getVoucher1(maloaivoucher1);
	}
	public ArrayList<voucherbean> getVouchermakh(long makh) throws Exception{
		return tkdao.getVouchermakh(makh);
	}
	public void insertvoucher(long mavoucher,long makh)throws Exception{
		tkdao.insertvoucher(mavoucher, makh);
	}
	public void insertvoucher1(String tenvoucher,long giatri,long soluong,long maloaivoucher)throws Exception{
		tkdao.insertvoucher1(tenvoucher, giatri, soluong, maloaivoucher);
	}
	public ArrayList<loaiVoucherbean> getloaivoucher() throws Exception{
		return tkdao.getloaivoucher();
	}
	public void xoavoucher(long mavoucher) throws Exception{
		tkdao.xoavoucher(mavoucher);
	}
	public void xoavoucher_khachhang(long mavoucher) throws Exception{
		tkdao.xoavoucher_khachhang(mavoucher);
	}
	public void xoavoucher1(long mavoucher) throws Exception{
		tkdao.xoavoucher1(mavoucher);
	}
	public long checkVoucherMavorcher(long mavoucher1) throws Exception{
		return tkdao.checkVoucherMavorcher(mavoucher1);
	}
	public int Checkdienthoai(String maloai) throws Exception{
		return tkdao.Checkdienthoai(maloai);
	}
	public void xoadienthoaitheomaloai(String maloai) throws Exception{
		tkdao.xoadienthoaitheomaloai(maloai);
	}
	public void xoaloaidienthoai(String maloai) throws Exception{
		tkdao.xoaloaidienthoai(maloai);
	}
	public void updateloaidienthoai(String newtenloai,String maloai) throws Exception{
		tkdao.updateloaidienthoai(newtenloai, maloai);
	}
	public void updatedienthoai(String tendt,long gia,double kichthuocman,long pin,String maloai,String chip,long ram,long dungluong,String anh,long soluong,String madt) throws Exception{
		tkdao.updatedienthoai(tendt, gia, kichthuocman, pin, maloai, chip, ram, dungluong, anh, soluong, madt);
	}
	public String dinhdangtien(long l) throws Exception{
		return tkdao.dinhdangtien(l);
	}
}
