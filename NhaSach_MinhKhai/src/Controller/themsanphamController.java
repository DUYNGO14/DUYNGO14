package Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Loaibean;
import bean.lichsubean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;
import bo.themsanphambo;

/**
 * Servlet implementation class themsanphamController
 */
@WebServlet("/themsanphamController")
public class themsanphamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themsanphamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			loaibo lbo = new loaibo();
			sachbo sbo=new sachbo();
			themsanphambo tspbo=new themsanphambo();
			ArrayList<Loaibean> dsloai = lbo.getloai();
			ArrayList<sachbean> dssach=new ArrayList<sachbean>();
			request.setAttribute("dsloai", dsloai);	
			String maloai =request.getParameter("maloai");
			String masach =request.getParameter("masach");
			String tensach =request.getParameter("tensach");
			String tacgia =request.getParameter("tacgia");
			String soluong =request.getParameter("soluong");
			String giasach =request.getParameter("giasach");
			String sotap =request.getParameter("sotap");
			String hinhanh =request.getParameter("hinhanh");
			
			if(maloai!=null && masach!=null && tensach!=null && tacgia!=null && soluong!=null && giasach!=null && sotap!=null && hinhanh!=null) {
				int dem = sbo.CheckMasach(masach).size();
				request.setAttribute("th", "th");
				if(dem==0) {
					Date ngaynhap = new  Date(System.currentTimeMillis());
					tspbo.insertsach(masach, tensach, Long.parseLong(soluong), Long.parseLong(giasach), maloai, Long.parseLong(sotap), hinhanh, ngaynhap, tacgia);
					request.setAttribute("tc", "tha");
				}else {
					request.setAttribute("maloai", maloai);
					request.setAttribute("masach", masach);
					request.setAttribute("tensach", tensach);
					request.setAttribute("tacgia", tacgia);
					request.setAttribute("soluong", soluong);
					request.setAttribute("giasach", giasach);
					request.setAttribute("sotap", sotap);
					request.setAttribute("hinhanh", hinhanh);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("themsanpham.jsp");
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
