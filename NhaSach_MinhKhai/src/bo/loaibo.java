package bo;

import java.util.ArrayList;

import bean.Loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<Loaibean> ds;
	public ArrayList<Loaibean> getloai() throws Exception{
		return ds=ldao.getloai();
	}
}
