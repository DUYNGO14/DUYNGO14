package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.sachbean;
import bo.giohangbo;

/**
 * Servlet implementation class xoacontrolerr
 */
@WebServlet("/xoacontrolerr")
public class xoacontrolerr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoacontrolerr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		giohangbo ghbo = (giohangbo)session.getAttribute("gh");
		String ms = request.getParameter("ms");
		String ms1= request.getParameter("ms1");
		
		String tru = request.getParameter("tru");
		String cong = request.getParameter("cong");
		String xoaall = request.getParameter("xoa");
		try {
			if(ms!=null){
				ghbo.Xoahang(ms);
			}
			if(xoaall!=null){
				session.removeAttribute("gh");
			}
			if(tru!=null){
				ghbo.tru(ms1);
			}
			if(cong!=null){
				ghbo.Cong(ms1);
			}
			String xoac = request.getParameter("xoachon");
		    String[] gt = request.getParameterValues("c1");
		    if(gt!=null){
		    	for(String c : gt){
		    		ghbo.Xoahang(c);
		    	}
		    	RequestDispatcher rd = request.getRequestDispatcher("giohangController");
				rd.forward(request, response);
		    }
		    RequestDispatcher rd = request.getRequestDispatcher("giohangController");
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
