package bo;

import bean.dangnhapbean;
import dao.dangnhapdao;

public class dangnhapbo {
	dangnhapdao dndao=new dangnhapdao();
	public dangnhapbean login(String user,String pass)throws Exception{
		return dndao.login(user, pass);
	}
	public dangnhapbean loginAdmin(String user,String pass,long quyen)throws Exception{
		return dndao.loginAdmin(user, pass, quyen);
	}
}
