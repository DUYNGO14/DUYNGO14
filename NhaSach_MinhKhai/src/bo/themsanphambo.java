package bo;

import java.sql.Date;

import dao.themsanphamdao;

public class themsanphambo {
	themsanphamdao tspdao=new themsanphamdao();
	public void insertsach(String masach,String ts,Long sl,Long gia,String ml,Long st,String anh,Date ngaynhap,String tg) throws Exception{
		tspdao.insertsach(masach, ts, sl, gia, ml, st, anh, ngaynhap, tg);
	}
	public static void main(String[] args) {
		try {
			themsanphambo tspbo=new themsanphambo();
			Date ngaynhap=new Date(System.currentTimeMillis());
			System.out.println(ngaynhap);
			tspbo.insertsach("b100", "Hoa Lá", (long)12, (long)12000, "ccc", (long)1, "image_sach/tin4.jpg", ngaynhap, "Ngô Duy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
