package bo;

import java.util.ArrayList;

import bean.danhgiabean;
import bean.danhsachdanhgiabean;
import dao.danhgiadao;

public class danhgiabo {
	danhgiadao dgdao=new danhgiadao();
	public long getMamadanhgia() throws Exception{
		return dgdao.getMamadanhgia();
	}
	public void insertdanhgia(String noidung,String madt,long makh) throws Exception{
		dgdao.insertdanhgia(noidung, madt, makh);
	}
	public ArrayList<danhgiabean> getdanhgia() throws Exception{
		return dgdao.getdanhgia();
	}
	public ArrayList<danhgiabean> getdanhgiamadt(String madt1) throws Exception{
		return dgdao.getdanhgiamadt(madt1);
	}
	public ArrayList<danhsachdanhgiabean> danhsachdanhgia() throws Exception{
		return dgdao.danhsachdanhgia();
	}
}
