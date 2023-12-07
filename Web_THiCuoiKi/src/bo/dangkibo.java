package bo;

import bean.dangnhapbean;
import dao.dangkidao;

public class dangkibo {
	dangkidao dkdao=new dangkidao();
	public dangnhapbean checklogin(String user,String pass)throws Exception{
		return dkdao.checklogin(user, pass);
	}
	public void sigup(String user,String pass) throws Exception{
		dkdao.sigup(user, pass);
	}
	public void KhachHang(String hoten,String user,String pass,String email) throws Exception{
		dkdao.KhachHang(hoten, user, pass,email);
	}
}
