package bo;

import bean.dangnhapbean;
import dao.dangnhapdao;

public class dangnhapbo {
	dangnhapdao dndao=new dangnhapdao();
	public dangnhapbean login(String user,String pass)throws Exception{
		return dndao.login(user, pass);
	}
	public dangnhapbean loginAdmin(String user,String pass,int quyen)throws Exception{
		return dndao.loginAdmin(user, pass, quyen);
	}
	public static void main(String[] args) {
		try {
			dangnhapbo d= new dangnhapbo();
			dangnhapbean dn= d.loginAdmin("LeAA", "123", 1);
			System.out.println(dn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
