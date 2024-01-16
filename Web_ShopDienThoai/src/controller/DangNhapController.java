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
import bo.dangnhapbo;
import bo.datmuabo;
import dao.dangnhapdao;
/*import dao.datmuadao;*/
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			dangnhapbo dnbo = new dangnhapbo();
       		datmuabo dmbo = new datmuabo();
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			String q = request.getParameter("quyen");
			String answer = request.getParameter("answer");
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			dangnhapbean dnbean = null;
			/* dangnhapbean dnbean = dnbo.login(un, pass); */
			if(session.getAttribute("dem")==null) {
				session.setAttribute("dem", (int)0);
			}
			int dem=(int)session.getAttribute("dem");
			if (un != null && pass != null && q!=null) {
				dnbean=dnbo.loginAdmin(un, pass, Long.parseLong(q));
				if(answer==null) {
					if (dnbean!=null) {
						session.setAttribute("dem", (int)0);
						session.setAttribute("dn", un);
						session.setAttribute("makh", dmbo.MaKhachhang(un,pass));
						session.setAttribute("quyen", Long.parseLong(q));
						response.sendRedirect("HomeController");
						return;
					} else {
						dem=dem+1;
						session.setAttribute("dem", dem);
						request.setAttribute("kt", "Đăng nhập sai!");
					}
				}else {
					if (dnbean!=null && captcha.isCorrect(answer)) {
						session.setAttribute("dem", (int)0);
						session.setAttribute("dn", un);
						session.setAttribute("makh", dmbo.MaKhachhang(un,pass));
						session.setAttribute("quyen", Long.parseLong(q));
						response.sendRedirect("HomeController");
						return;
					} else {
						session.setAttribute("dem", dem);
						request.setAttribute("kt", "Đăng nhập sai!");
					}
				}
			}else if(q==null){
				request.setAttribute("thieuquyen", "thieuquyen");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
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
