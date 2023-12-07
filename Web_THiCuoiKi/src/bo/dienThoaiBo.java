package bo;

import java.util.ArrayList;

import bean.dienThoaiBean;
import dao.dienThoaiDao;

public class dienThoaiBo {
	dienThoaiDao dtdao=new dienThoaiDao();
	ArrayList<dienThoaiBean> ds;
	public ArrayList<dienThoaiBean> getdienthoai() throws Exception {
		return ds=dtdao.getdienthoai();
	}
	public ArrayList<dienThoaiBean> getdienthoai1(int index) throws Exception {
		return ds=dtdao.getdienthoai1(index);
	}
	public ArrayList<dienThoaiBean> getdienthoai2(int index) throws Exception {
		return ds=dtdao.getdienthoai2(index);
	}
	public ArrayList<dienThoaiBean> getMaLoai(String maloai1,int index) throws Exception {
		return ds=dtdao.getMaLoai(maloai1, index);
	}
	public int Count() throws Exception{
		return dtdao.Count();
	}
	public int Countml(String maloai) throws Exception{
		return dtdao.Countml(maloai);
	}
	public dienThoaiBean TimdienthoaiMa(String madt1) throws Exception{
		return dtdao.TimdienthoaiMa(madt1);
	}
	public ArrayList<dienThoaiBean> getTenDienThoai(String tendt1,int index) throws Exception{
		return dtdao.getTenDienThoai(tendt1, index);
	}
	public int CountTimkiem(String tendt1) throws Exception{
		return dtdao.CountTimkiem(tendt1);
	}
	public ArrayList<dienThoaiBean> timDienThoai(String key) throws Exception{
		ArrayList<dienThoaiBean> ds = dtdao.getdienthoai(); 
		ArrayList<dienThoaiBean> tam = new ArrayList<dienThoaiBean>();
		for (dienThoaiBean dt : ds) {
			if(dt.getMadt().toLowerCase().trim().contains(key.toLowerCase().trim())
			|| dt.getTendt().toLowerCase().trim().contains(key.toLowerCase().trim())
			|| dt.getChip().toLowerCase().trim().contains(key.toLowerCase().trim())
			) {
				tam.add(dt);
			}
		}
		return tam;
	}
	public Long timsl(String madt) throws Exception{
		long sl=0;
		for (dienThoaiBean s : ds) {
			if(s.getMadt().toLowerCase().trim().equals(madt.toLowerCase().trim())) {
				sl= s.getSoluong();
			}
		}
		return sl;
	}
	public static void main(String[] args) {
		try {
			dienThoaiBo dtbo = new dienThoaiBo();
			ArrayList<dienThoaiBean> ds = dtbo.timDienThoai("	");
			for (dienThoaiBean d : ds) {
				System.out.println(d);
			}
			System.out.println(ds.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
