package controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dienThoaiBean;
import bean.loaiBean;
import bean.xacnhanmuaAdminbean;
import bo.dienThoaiBo;
import bo.giohangbo;
import bo.loaiBo;
import bo.xacnhandonhangAdminbo;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			Locale localeVN = new Locale("vi", "VN");
			NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
			HttpSession session= request.getSession();
			loaiBo lbo=new loaiBo();
			dienThoaiBo dtbo=new dienThoaiBo();
			ArrayList<loaiBean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			//xoa hang
			String madtdelete = request.getParameter("madtdelete");
			if(madtdelete!=null) {
				dtbo.deleteDienThoai(madtdelete);
			}
			//cap nhat so luong
			String madtupdate=request.getParameter("madtupdate");
			String soluongnew = request.getParameter("soluongnew");
			request.setAttribute("madtupdate", madtupdate);
			request.setAttribute("soluongnew", soluongnew);
			/* session.setAttribute("quyen",0); */
			 if(madtupdate!=null && soluongnew!=null && Long.parseLong(soluongnew)>=0) {
				 dtbo.updateSoluong(madtupdate,Long.parseLong(soluongnew)); 
			 }
			//phân trang
			String indexpage="";
			String ml1=request.getParameter("ml1");
			String index1=request.getParameter("index1");
			String index2=request.getParameter("index");
			String index3= request.getParameter("index2");
			if(index1!=null) {
				indexpage=index1;
			}else if(index2!=null){
				indexpage=index2;
			}else {
				indexpage=index3;
			}
			if(indexpage==null) {
				indexpage="1";
			}
			int index=Integer.parseInt(indexpage);
			request.setAttribute("tag", index);
			ArrayList<dienThoaiBean> dsdt=dtbo.getdienthoai1(index);
			String ml = request.getParameter("ml");
			request.setAttribute("ml", ml);
			String key = request.getParameter("txttk");
			
			String tk= request.getParameter("tk");
			if(tk!=null) {
				key=tk;
			}
			request.setAttribute("key", key);
			int max=0;

			if(ml!=null) {
				int k=0;
				dsdt=dtbo.getMaLoai(ml, index);
				max=dtbo.Countml(ml);
				k=max;
				request.setAttribute("k", k);
			}else if((key!=null && key!="")|| (tk!=null&&index3!=null)) {
				int k=0;
				dsdt=dtbo.getTenDienThoai(key,index);
				max=dtbo.CountTimkiem(key);
				k=max;
				request.setAttribute("k", k);
			}else if(key==""){
				dsdt=dtbo.getdienthoai1(index);
				max=dtbo.Count();
			}
			if(ml==null && key==null) {
				max=dtbo.Count();
			}
			if(ml1!=null&&index1!=null) {
				dsdt=dtbo.getMaLoai(ml1,index);
				max=dtbo.Countml(ml1);
			}
			int maxpage=0;
			if(max%16==0) {
				maxpage=max/16;
			}else {
				maxpage=(max/16)+1;
			}
			xacnhandonhangAdminbo xnbo = new xacnhandonhangAdminbo();
			long dt = xnbo.DoanhThu();
			xacnhanmuaAdminbean banchay = xnbo.getdienthoaibanchay();
			request.setAttribute("banchay", banchay.getTendt());
			request.setAttribute("doanhthu", currencyVN.format(dt));
			giohangbo ghbo=new giohangbo();
			request.setAttribute("dsdt", dsdt);
			request.setAttribute("maxpage", maxpage);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
