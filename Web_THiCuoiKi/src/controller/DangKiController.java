package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dangnhapbean;
import bo.dangkibo;
import bo.dangnhapbo;
import dao.dangkidao;
/*import dao.datmuadao;*/

/**
 * Servlet implementation class DangKiController
 */
@WebServlet("/DangKiController")
public class DangKiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			dangkibo dkbo = new dangkibo();
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			String repass = request.getParameter("txtpass1");
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			dangnhapbean dnbean = dkbo.checklogin(un,pass);
			/* datmuadao dmdao = new datmuadao(); */
			if (un != null && pass != null && fullname!=null && email!=null) {
				if(pass.equals(repass)==false){
					request.setAttribute("ktt", "false");
					response.sendRedirect("dangkiController");
				} else {
				if (dnbean==null) {
					dkbo.sigup(un,pass);
					dkbo.KhachHang(fullname, un, pass,email);
					HttpSession session = request.getSession();
					session.setAttribute("dn", un);
					/* session.setAttribute("makh", dmdao.MaKhachhang()); */
					response.sendRedirect("DangNhapController");
					return;
				} else {
					request.setAttribute("kt", "false");
				}
			}}
			RequestDispatcher rd = request.getRequestDispatcher("dangki.jsp");
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
