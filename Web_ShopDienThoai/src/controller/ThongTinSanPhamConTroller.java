package controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.danhgiabean;
import bean.dienThoaiBean;
import bean.loaiBean;
import bo.danhgiabo;
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
		HttpSession session = request.getSession();
		long makh = (long)session.getAttribute("makh");
		request.setAttribute("makh", makh);
		dienThoaiBo dtbo=new dienThoaiBo();
		danhgiabo dgbo = new danhgiabo();
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		loaiBo lbo=new loaiBo();
		ArrayList<loaiBean> dsloai=lbo.getloai();
		request.setAttribute("dsloai", dsloai);
		//danh sách lấy từ tranh chủ
		String madt="";
		String madt1 = request.getParameter("mdt");
		String madt2 = request.getParameter("madtdg");
		String noidung = request.getParameter("noidung");
		if(madt1!=null) {
			madt=madt1;
		}else if(madt2!=null) {
			madt=madt2;
		}
		if(madt2!=null && noidung!=null) {
			dgbo.insertdanhgia(noidung, madt2, makh);
			request.setAttribute("danhgia", "danhgia");
		}else {
			request.setAttribute("nd", "noidung");
		}
		dienThoaiBean dt = dtbo.TimdienthoaiMa(madt);
		request.setAttribute("dienthoai", dt);
		request.setAttribute("gia", currencyVN.format(dt.getGia()));
		//danh sách đánh giá
		ArrayList<danhgiabean> dsdanhgia = dgbo.getdanhgiamadt(madt);
		request.setAttribute("dem", dsdanhgia.size());
		request.setAttribute("dsdanhgia", dsdanhgia);
		//danh sach sản phẩm ngẫu nhiên
		int ranNum = ThreadLocalRandom.current().nextInt(1,15);
		ArrayList<dienThoaiBean> ds = dtbo.getdienthoai2(ranNum);
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
