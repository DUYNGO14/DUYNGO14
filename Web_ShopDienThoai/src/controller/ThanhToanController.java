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

import bean.khachhangbean;
import bean.loaiBean;
import bo.dienThoaiBo;
import bo.khachhangbo;
import bo.loaiBo;
import bo.thongkebo;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet("/ThanhToanController")
public class ThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			Locale localeVN = new Locale("vi", "VN");
			NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
			loaiBo lbo = new loaiBo();
			ArrayList<loaiBean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			String tien = request.getParameter("tt");
			request.setAttribute("tien", tien);
			long tien1 = Long.parseLong(tien);
			String vc = request.getParameter("vc");
			request.setAttribute("vc", vc);
			String mavc = request.getParameter("mavc");
			thongkebo tkbo=new thongkebo();
			if(mavc!=null) {
				tkbo.xoavoucher(Long.parseLong(mavc));
			}
			String tong = currencyVN.format(tien1);
			request.setAttribute("tong", tong);
			khachhangbo khbo=new khachhangbo();
			long makh= (long)session.getAttribute("makh");
			khachhangbean kh= khbo.getKhachHangma(makh);
			request.setAttribute("khachhang", kh);
			RequestDispatcher rd = request.getRequestDispatcher("thanhtoan.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
