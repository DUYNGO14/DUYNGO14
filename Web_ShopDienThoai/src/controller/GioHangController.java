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
import bean.giohangbean;
import bean.loaiBean;
import bo.datmuabo;
import bo.dienThoaiBo;
import bo.giohangbo;
import bo.loaiBo;
import dao.giohangdao;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
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
			loaiBo lbo=new loaiBo();
			ArrayList<loaiBean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			String madt = request.getParameter("mdt");
			String tendt = request.getParameter("tendt");
			String chip=request.getParameter("chip");
			String ram=request.getParameter("ram");
			String dungluong=request.getParameter("dungluong");
			String gia = request.getParameter("gia");
			String anh= request.getParameter("anh");
			String kichthuocman=request.getParameter("ktm");
			String pin = request.getParameter("pin");
			String ml=request.getParameter("maloai");
			Long soluong=(long)0;
			Long makh= (long)session.getAttribute("makh");
			String giatri = request.getParameter("giatri");
			String huy = request.getParameter("huy");
			String mavc=request.getParameter("mavc");
			request.setAttribute("mavc", mavc);
			if(huy!=null) {
				request.setAttribute("giatri", 0);
			}
			request.setAttribute("giatri", giatri);
			if(session.getAttribute("dn")==null) {
				response.sendRedirect("DangNhapController");
			}else {
				giohangdao ghbo= new giohangdao();
				ArrayList<giohangbean> ds = ghbo.getGioHang(makh);
				for (giohangbean i : ds) {
					soluong=ghbo.SoLuong(i.getMadt(), makh);
					ghbo.Themhang1(i.getMadt(), i.getTendt(), i.getGia(), i.getKichthuocman(), i.getPin(), i.getMaloai(), i.getChip(), i.getRam(), i.getDungluong(), i.getAnh(), i.getSoluong());
				}
				if(session.getAttribute("gh")==null) {
					session.setAttribute("gh", ghbo);
				}
				if(madt!=null) {
					if(ghbo.SoLuong(madt, makh)==0) {
						ghbo.insertGiohang(madt, (long)1, makh);
					}else {
						ghbo.updateSoluongCong(madt, makh);
					}
					ghbo = (giohangdao)session.getAttribute("gh");
					ghbo.Themhang(madt, tendt, Long.parseLong(gia), Double.parseDouble(kichthuocman),Long.parseLong(pin),ml,chip,Long.parseLong(ram),Long.parseLong(dungluong),anh,soluong);
					session.setAttribute("gh", ghbo);
				}
				Locale localeVN = new Locale("vi", "VN");
				NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
				/*
				 * String str1 = currencyVN.format(); System.out.println("Số " + vnd +
				 * " sau khi định dạng = " + str1);
				 * System.out.println("Kiểu đơn vị tiền tệ của " + localeVN.getCountry() +
				 * " là " + currencyVN.getCurrency());
				 */
				if(session.getAttribute("gh")!=null) {
					ghbo=(giohangdao)session.getAttribute("gh");
					request.setAttribute("ghbo", ghbo);
					long tongtien = ghbo.Tongtien();
					String str1 = currencyVN.format(tongtien);
					request.setAttribute("str1", str1);
					request.setAttribute("tongtien", tongtien);
					RequestDispatcher rd=request.getRequestDispatcher("giohang.jsp");
					rd.forward(request, response);
				}else {
					request.setAttribute("ghbo", null);
					RequestDispatcher rd=request.getRequestDispatcher("giohang.jsp");
					rd.forward(request, response);
				}
			}
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("giohang.jsp");
			 * rd.forward(request, response);
			 */
			}catch (Exception e) {
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
