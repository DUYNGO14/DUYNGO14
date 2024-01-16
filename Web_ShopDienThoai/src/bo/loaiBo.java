package bo;

import java.util.ArrayList;

import bean.loaiBean;
import dao.loaiDao;

public class loaiBo {
	loaiDao ldao=new loaiDao();
	public ArrayList<loaiBean> getloai() throws Exception{
		return ldao.getloai();
	}
	public void inserthang(String maloai,String tenloai)throws Exception{
		ldao.inserthang(maloai, tenloai);
	}
	public loaiBean TimMaLoai(String maloai) throws Exception{
		return ldao.TimMaLoai(maloai);
	}
	public String Tenloai(String maloai) throws Exception{
		return ldao.Tenloai(maloai);
	}
}
