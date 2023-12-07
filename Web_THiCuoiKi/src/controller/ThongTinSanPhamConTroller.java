package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

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
 * Servlet implementation class ThongTinSanPhamConTroller
 */
@WebServlet("/ThongTinSanPhamConTroller")
public class ThongTinSanPhamConTroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinSanPhamConTroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		loaiBo lbo=new loaiBo();
		ArrayList<loaiBean> dsloai=lbo.getloai();
		request.setAttribute("dsloai", dsloai);
		dienThoaiBo dtbo=new dienThoaiBo();
		int ranNum = ThreadLocalRandom.current().nextInt(1,15);
		String madt = request.getParameter("mdt");
		dienThoaiBean dt = dtbo.TimdienthoaiMa(madt);
		ArrayList<dienThoaiBean> ds = dtbo.getdienthoai2(ranNum);
		request.setAttribute("dienthoai", dt);
		request.setAttribute("ds", ds);
		RequestDispatcher rd = request.getRequestDispatcher("thongtinsanpham.jsp");
		rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
