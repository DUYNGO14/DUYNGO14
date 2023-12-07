package bo;

import java.util.ArrayList;

import bean.loaiBean;
import dao.loaiDao;

public class loaiBo {
	loaiDao ldao=new loaiDao();
	public ArrayList<loaiBean> getloai() throws Exception{
		return ldao.getloai();
	}
}
