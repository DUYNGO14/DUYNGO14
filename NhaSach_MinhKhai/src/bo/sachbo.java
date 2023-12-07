package bo;

import java.util.ArrayList;
import java.util.Iterator;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
	sachdao sdao = new sachdao();
	ArrayList<sachbean> ds;
	public ArrayList<sachbean> getsach() throws Exception{
		return ds=sdao.getsach();
	}
	public ArrayList<sachbean> getsach1(int index) throws Exception{
		return ds=sdao.getsach1(index);
	}
	public ArrayList<sachbean> timMa(String maloai,int index) throws Exception {
		return ds = sdao.getMaloai(maloai, index);
	}
	public int Count() throws Exception{
		return sdao.Count();
	}
	public int Countml(String maloai) throws Exception{
		return sdao.Countml(maloai);
	}
	public ArrayList<sachbean> timSach(String key) throws Exception{
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds) {
			if(s.getMasach().toLowerCase().trim().contains(key.toLowerCase().trim()) || 
			   s.getTensach().toLowerCase().trim().contains(key.toLowerCase().trim()) || 
			   s.getTacgia().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				tam.add(s);
			}
		}
		return tam;
	}
	
	public Long timsl(String masach) throws Exception{
		long sl=0;
		for (sachbean s : ds) {
			if(s.getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				sl= s.getSoluong();
			}
		}
		return sl;
	}
	public ArrayList<sachbean> getmasach(String ms) throws Exception {
		return sdao.getmasach(ms);
	}
	public ArrayList<sachbean> CheckMasach(String ms) throws Exception {
		return sdao.CheckMasach(ms);
	}
	public static void main(String[] args) {
		try {
			sachbo sbo=new sachbo();
			ArrayList<sachbean> ds = sbo.getmasach("y9");
			for (sachbean s : ds) {
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
