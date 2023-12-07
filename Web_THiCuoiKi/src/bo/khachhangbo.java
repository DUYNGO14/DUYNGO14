package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao=new khachhangdao();
	public ArrayList<khachhangbean> getKhachHang() throws Exception{
		return khdao.getKhachHang();
	}
	public static void main(String[] args) {
		try {
			khachhangbo k =new khachhangbo();
			ArrayList<khachhangbean> ds= k.getKhachHang();
			for (khachhangbean kh : ds) {
				System.out.println(kh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
