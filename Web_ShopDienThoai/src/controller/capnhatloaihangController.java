package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.thongkebo;

/**
 * Servlet implementation class capnhatloaihangController
 */
@WebServlet("/capnhatloaihangController")
public class capnhatloaihangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public capnhatloaihangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			thongkebo  tkbo = new thongkebo();
//			Cập nhật hãng điện thoaij
			String updateloai = request.getParameter("updateloai");
			String maloai2= request.getParameter("maloai2"); 
			String tenloai2= request.getParameter("tenloai2");
			if(maloai2!=null && tenloai2!=null && updateloai!=null) {
			 request.setAttribute("mahang",maloai2); 
			 request.setAttribute("tenloainew", tenloai2); 
			 request.setAttribute("upadteloai", updateloai);
			}

			String maloai1=request.getParameter("mahang");
			String tenloainew = request.getParameter("tenloainew");
			if(tenloainew!=null) {
				tkbo.updateloaidienthoai(tenloainew,maloai1);
				request.setAttribute("update", "upadte");
				request.setAttribute("mahang",maloai1); 
				request.setAttribute("tenloainew", tenloainew);
			}
			RequestDispatcher rd = request.getRequestDispatcher("capnhat.jsp");
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
