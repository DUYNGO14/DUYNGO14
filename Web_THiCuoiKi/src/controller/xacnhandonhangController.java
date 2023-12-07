package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.xacnhanmuaAdminbean;
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
			xacnhandonhangAdminbo xnbo=new xacnhandonhangAdminbo();
			ArrayList<xacnhanmuaAdminbean> ds = xnbo.getdonhang();
			request.setAttribute("dsxn", ds);
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
