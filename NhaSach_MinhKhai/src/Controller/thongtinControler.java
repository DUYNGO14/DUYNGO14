package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.sachbean;

/**
 * Servlet implementation class thongtinControler
 */
@WebServlet("/thongtinControler")
public class thongtinControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public thongtinControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String ms = request.getParameter("ms");
			String ts = request.getParameter("ts");
			String tg = request.getParameter("tg");
			String anh = request.getParameter("anh");
			String gia = request.getParameter("gia") ;
			String sl = request.getParameter("sl");
			String ml = request.getParameter("ml");
			sachbean s = new sachbean(ms, ts, tg, Long.parseLong(sl),Long.parseLong(gia) , anh, ml);
			request.setAttribute("sach", s);
			RequestDispatcher rd = request.getRequestDispatcher("thongtinsp.jsp");
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
