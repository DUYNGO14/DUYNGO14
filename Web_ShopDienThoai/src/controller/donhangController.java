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

import bean.dienThoaiBean;
import bean.donhangbean;
import bean.loaiBean;
import bo.datmuabo;
import bo.dienThoaiBo;
import bo.loaiBo;

/**
 * Servlet implementation class donhangController
 */
@WebServlet("/donhangController")
public class donhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donhangController() {
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
			loaiBo lbo=new loaiBo();
			dienThoaiBo dtbo=new dienThoaiBo();
			datmuabo dmbo=new datmuabo();
			ArrayList<loaiBean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			if(session.getAttribute("dn")==null) {
				response.sendRedirect("DangNhapController");
			}else {
				long makh= (long)session.getAttribute("makh");
				ArrayList<donhangbean> dsdon=dmbo.getDonHangCXN(makh);
				long dem = dsdon.size();
				request.setAttribute("dem", dem);
				request.setAttribute("dsdon", dsdon);
				String madt = request.getParameter("madt");
				String mahoadon=request.getParameter("mahoadon");
				if(madt!=null && mahoadon!=null) {
					dmbo.deleteHoaDonChiTiet(Long.parseLong(mahoadon), madt);	
				}
				if(dmbo.getMaHoaDon(Long.parseLong(mahoadon))==0) {
					dmbo.deleteHoaDon(Long.parseLong(mahoadon),makh);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("donhang.jsp");
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
