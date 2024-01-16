package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaiBean;
import bean.xacnhanmuaAdminbean;
import bo.loaiBo;
import bo.xacnhandonhangAdminbo;

/**
 * Servlet implementation class xacnhandonhangController
 */
@WebServlet("/xacnhandonhangController")
public class xacnhandonhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhandonhangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loaiBo lbo= new loaiBo();
			ArrayList<loaiBean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			xacnhandonhangAdminbo xnbo=new xacnhandonhangAdminbo();
			ArrayList<xacnhanmuaAdminbean> ds = xnbo.getdonhang();
			request.setAttribute("sodonxn", ds.size());
			ArrayList<xacnhanmuaAdminbean> dsdxn = xnbo.getdonhangdaxacnhan();
			request.setAttribute("sodondxn", dsdxn.size());
			String xn1=request.getParameter("xn1");
			String xn2=request.getParameter("xn2");
			request.setAttribute("xn1", xn1);
			request.setAttribute("xn2", xn2);
			request.setAttribute("dsxn", ds);
			request.setAttribute("dsdxn", dsdxn);
			String mact = request.getParameter("mact");
			if(mact!=null) {
				xnbo.XacNhanDon(Long.parseLong(mact));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("xacnhandonhangAdmin.jsp");
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
