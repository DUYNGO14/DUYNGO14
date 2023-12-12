package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.dienThoaiBean;
import bean.loaiBean;
import bo.dienThoaiBo;
import bo.loaiBo;

/**
 * Servlet implementation class themsanphamController
 */
@WebServlet("/themsanphamController")
public class themsanphamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themsanphamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loaiBo lb=new loaiBo();
			ArrayList<loaiBean> dsloai=lb.getloai();
			request.setAttribute("dsloai", dsloai);
			dienThoaiBo dtbo=new dienThoaiBo();
			String maloai = request.getParameter("maloai");
			String madt = request.getParameter("madt");
			String tendt = request.getParameter("tendt");
			String gia =request.getParameter("gia");
			String kichthuocman =request.getParameter("kichthuocman");
			String pin =request.getParameter("pin");
			String chip =request.getParameter("chip");
			String ram =request.getParameter("ram");
			String dungluong =request.getParameter("dungluong");
			String hinhanh =request.getParameter("hinhanh");
			String soluong =request.getParameter("soluong");
			String dt1=request.getParameter("dt");
			String hang=request.getParameter("hang");
			String mahang=request.getParameter("mahang");
			String tenloai=request.getParameter("tenloai");
			request.setAttribute("add",null);
			request.setAttribute("hang", null);
			request.setAttribute("addt",null);
			request.setAttribute("addh",null);
			if(dt1!=null) {
				request.setAttribute("themdt", "dt");
			}
			if(hang!=null) {
				request.setAttribute("hang", "dt");
			}
			if(maloai!=null && madt!=null &&tendt!=null &&gia!=null &&kichthuocman!=null && pin!=null && chip!=null &&ram!=null &&dungluong!=null &&hinhanh!=null && soluong!=null ) {
				
				dienThoaiBean dt = dtbo.TimdienthoaiMa(madt);
				if(dt==null) {
					request.setAttribute("add", "add");
					dtbo.insertdienthoai(madt, tendt,Long.parseLong(gia) ,Double.parseDouble(kichthuocman) ,Long.parseLong(pin) , maloai, chip, Long.parseLong(ram), Long.parseLong(dungluong), hinhanh, Long.parseLong(soluong));
				}else {
					request.setAttribute("maloai", maloai);
					request.setAttribute("madt", madt);
					request.setAttribute("tendt", tendt);
					request.setAttribute("gia", gia);
					request.setAttribute("kichthuocman", kichthuocman);
					request.setAttribute("pin", pin);
					request.setAttribute("chip", chip);
					request.setAttribute("ram", ram);
					request.setAttribute("dungluong", dungluong);
					request.setAttribute("hinhanh", hinhanh);
					request.setAttribute("soluong", soluong);
					request.setAttribute("trung", "trung");
				}
				request.setAttribute("addt", "jdskh");
			}
			if(mahang!=null && tenloai!=null) {
				loaiBean l=lb.TimMaLoai(mahang);
				if(l==null) {
					request.setAttribute("hang1", "dt");
					lb.inserthang(mahang, tenloai);
				}else {
					request.setAttribute("mahang", mahang);
					request.setAttribute("tenloai", tenloai);
					request.setAttribute("trung", "trung");
				}
				request.setAttribute("addh", "jdskh");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=  request.getRequestDispatcher("themsanpham.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
