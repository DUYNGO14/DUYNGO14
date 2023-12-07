package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.thongkedao;

public class thongkebo {
	thongkedao tkdao = new thongkedao();
	public ArrayList<khachhangbean> getKhachhang() throws Exception{
		return tkdao.getKhachhang();
	}
	public static void main(String[] args) {
		try {
			thongkebo tkdao=new thongkebo();
			ArrayList<khachhangbean> ds = tkdao.getKhachhang();
			for (khachhangbean k : ds) {
				System.out.println(k);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
