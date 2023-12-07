package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dangnhapbean;
import dao.dangkidao;
import dao.dangnhapdao;
import dao.datmuadao;

/**
 * Servlet implementation class dangkiController
 */
@WebServlet("/dangkiController")
public class dangkiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkiController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			dangkidao dkdao = new dangkidao();
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			String repass = request.getParameter("txtpass1");
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			dangnhapbean dnbean = dkdao.checklogin(un);
			datmuadao dmdao = new datmuadao();
			if (un != null && pass != null && fullname!=null && email!=null) {
				if(pass.equals(repass)==false){
					request.setAttribute("ktt", "false");
					response.sendRedirect("dangkiController");
				} else {
				if (dnbean==null) {
					dkdao.sigup(un,pass);
					dkdao.KhachHang(fullname, un, pass);
					HttpSession session = request.getSession();
					session.setAttribute("dn", un);
					session.setAttribute("makh", dmdao.MaKhachhang());
					response.sendRedirect("dangnhapController");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
