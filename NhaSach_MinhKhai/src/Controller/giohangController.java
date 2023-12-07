package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class giohangController
 */
@WebServlet("/giohangController")
public class giohangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public giohangController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session= request.getSession();
			String ms = request.getParameter("ms");
			String ts = request.getParameter("ts");
			String tg = request.getParameter("tg");
			String anh = request.getParameter("anh");
			String gia = request.getParameter("gia") ;
			Long sl =(long)0;
			if(session.getAttribute("dn")==null) {
				response.sendRedirect("dangnhapController");
			}else {
				if(ms!=null && ts!=null && tg!=null && anh!=null){
					giohangbo ghbo = new giohangbo();
					if(session.getAttribute("gh")==null){
						session.setAttribute("gh",ghbo);
					}
					ghbo = (giohangbo)session.getAttribute("gh");
					ghbo.Themhang(ms, ts, tg,sl,Long.parseLong(gia), anh);
					session.setAttribute("gh",ghbo);
				}
				if(session.getAttribute("gh")!=null){
					giohangbo ghbo = (giohangbo)session.getAttribute("gh");
					request.setAttribute("ghbo", ghbo);
					RequestDispatcher rd = request.getRequestDispatcher("giohang.jsp");
					rd.forward(request, response);
				}else {
					request.setAttribute("ghbo", null);
					RequestDispatcher rd = request.getRequestDispatcher("giohang.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
