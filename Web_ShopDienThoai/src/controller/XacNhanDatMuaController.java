package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.loaiBean;
import bo.datmuabo;
import bo.loaiBo;
import dao.giohangdao;

/**
 * Servlet implementation class XacNhanDatMuaController
 */
@WebServlet("/XacNhanDatMuaController")
public class XacNhanDatMuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanDatMuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			
			if(session.getAttribute("dn")==null) {
				response.sendRedirect("DangNhapController");
			}else {
				loaiBo lbo= new loaiBo();
				ArrayList<loaiBean> dsloai=lbo.getloai();
				request.setAttribute("dsloai", dsloai);
				datmuabo dmbo= new datmuabo();
				long makh = (long)session.getAttribute("makh");
				String hoten =request.getParameter("txtname");
				String email =request.getParameter("txtemail");
				String sdt =request.getParameter("txtsdt");
				String diachi  =request.getParameter("txtdiachi");
				/*
				 * String state =request.getParameter("txtstate"); String zip
				 * =request.getParameter("txtzip");
				 */
				String namecard =request.getParameter("txtnamecard");
				String exp =request.getParameter("txtexp");
				String cardnumber =request.getParameter("txtcard");
				/*
				 * String expyear =request.getParameter("txtyear"); String cvv
				 * =request.getParameter("txtcvv");
				 */
				if(hoten!=null && email!=null && sdt!=null && diachi!=null  && namecard!=null && exp!=null  && cardnumber!=null ) {
					dmbo.HoaDon(makh);
					dmbo.UpdateKhachHang(diachi,sdt,makh);
					long maxhd = dmbo.MaHoaDon();
					giohangdao ghdao=(giohangdao)session.getAttribute("gh");
					for (giohangbean g : ghdao.ds) {
						dmbo.HoaDonChiTiet(g.getMadt(),g.getSoluong(), maxhd);
					}
					/* dmbo.deleteGiohang(makh); */
					session.removeAttribute("gh");
					dmbo.deleteGiohang(makh);
					response.sendRedirect("HomeController");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
