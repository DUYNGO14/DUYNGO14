package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Loaibean;
import bean.dangnhapbean;
import bo.dangnhapbo;
import dao.KetNoi;
import dao.dangnhapdao;
import dao.datmuadao;
import nl.captcha.Captcha;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			HttpSession session = request.getSession();
			dangnhapbo dnbo = new dangnhapbo();
			datmuadao dmdao = new datmuadao();
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			String answer = request.getParameter("answer");
			String q = request.getParameter("quyen");
			dangnhapbean dnbean = null;
			int quyen = 0;
			if(q!=null) {
				quyen=Integer.parseInt(q);
			}
			if(session.getAttribute("quyen")==null) {
				session.setAttribute("quyen", (int)0);
			}
			if(session.getAttribute("dem")==null){
				session.setAttribute("dem",(int)0);
			}
			int dem =(int)session.getAttribute("dem");
			if (un != null && pass != null) {
				dnbean=dnbo.loginAdmin(un, pass, quyen);
				if(answer!=null) {
					if(captcha.isCorrect(answer)) {	 
						 if (dnbean!=null) {
								session.setAttribute("dn", un);
								session.setAttribute("makh", dmdao.MaKhachhang(un,pass));
								session.setAttribute("dem", (int)0);
								session.setAttribute("quyen", quyen);
								response.sendRedirect("sachcontroller");
								return;
							} else {
								session.removeAttribute("quyen");
								request.setAttribute("kt", "Đăng nhập sai!");
							}
					}else {
						response.sendRedirect("dangnhap.jsp");
					}
				}else {
					if (dnbean!=null) {
						session.setAttribute("dn", un);
						session.setAttribute("makh", dmdao.MaKhachhang(un,pass));
						session.setAttribute("dem", (int)0);
						session.setAttribute("quyen", quyen);
						response.sendRedirect("sachcontroller");
						return;
					} else {
						dem =dem+1;
						session.removeAttribute("quyen");
						request.setAttribute("kt", "Đăng nhập sai!");
					}
					session.setAttribute("dem", dem);
				}
				
			}
			RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
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
