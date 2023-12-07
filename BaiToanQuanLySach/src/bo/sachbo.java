package bo;

import java.util.ArrayList;

import bean.sachbean;
import dao.sachdao;

public class sachbo {
//viết hàm getsach()
//viết hàm SuaSoLuong()
//hàm tìm sách theo maloai -> tra ve 1 arraylist<sachbean>
//hàm tìm sách theo  masach-> tra ve 1 sachbean

	sachdao sdao = new sachdao();
	ArrayList<sachbean> ds;

	public ArrayList<sachbean> getsach() throws Exception {
		return ds = sdao.getsach();
	}

	public ArrayList<sachbean> SuaSoLuong(String masach, long soluong) throws Exception {
		int n=ds.size();
        for(int i=0;i<n;i++) {
            sachbean s=ds.get(i);
            if(s.getMasach().toLowerCase().trim().equals(
                    masach.toLowerCase().trim())) {
                s.setSoluong(s.getSoluong()-soluong);
                ds.set(i, s);//Sua trong mang
                //Sua trong csdl
               sdao.SuaSoLuong(masach, soluong);
            }
        }
        return ds;
	}

	public ArrayList<sachbean> TimSachMaLoai(String maloai) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds) {
			if (s.getMaloai().toLowerCase().trim().equals(maloai.toLowerCase().trim())) {
				tam.add(s);
			}
		}
		return tam;
	}

	public sachbean TimSachMaSach(String masach) throws Exception {
		sachbean kq = new sachbean();
		for (sachbean s : ds) {
			if (s.getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				kq = s;
			}
		}
		return kq;
	}
	public ArrayList<sachbean> TimSachMaSach1(String masach) throws Exception {
		ArrayList<sachbean> tam = new ArrayList<sachbean>();
		for (sachbean s : ds) {
			if (s.getMasach().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				tam.add(s);
			}
		}
		return tam;
	}
}
