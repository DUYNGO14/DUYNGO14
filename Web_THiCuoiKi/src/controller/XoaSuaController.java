package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.giohangdao;

/**
 * Servlet implementation class XoaSuaController
 */
@WebServlet("/XoaSuaController")
public class XoaSuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession sesion = request.getSession();
			giohangdao ghdao = (giohangdao)sesion.getAttribute("gh");
			String[] cong = request.getParameterValues("cong");
			String tru = request.getParameter("tru");
			String[] xoa = request.getParameterValues("xoa");
			String[] xoachon = request.getParameterValues("c1");
			String xoaall=request.getParameter("xoaall");
			if(xoaall!=null) {
				sesion.removeAttribute("gh");
				RequestDispatcher rd = request.getRequestDispatcher("GioHangController");
				rd.forward(request, response);
			}
			if(xoa!=null){
		    	for(String c : xoa){
		    		ghdao.Xoahang(c);
		    	}
		    	RequestDispatcher rd = request.getRequestDispatcher("GioHangController");
				rd.forward(request, response);
		    }
			if(xoachon!=null){
		    	for(String c : xoachon){
		    		ghdao.Xoahang(c);
		    	}
		    	RequestDispatcher rd = request.getRequestDispatcher("GioHangController");
				rd.forward(request, response);
		    }
			if(cong!=null){
		    	for(String c : cong){
		    		ghdao.Cong(c);
		    	}
		    	RequestDispatcher rd = request.getRequestDispatcher("GioHangController");
				rd.forward(request, response);
		    }
			if(tru!=null){
		    	ghdao.tru(tru);
		    	RequestDispatcher rd = request.getRequestDispatcher("GioHangController");
				rd.forward(request, response);
		    }
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
