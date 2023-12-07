package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bo.datmuabo;
import bo.giohangbo;

/**
 * Servlet implementation class xacnhancontroller
 */
@WebServlet("/xacnhancontroller")
public class xacnhancontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhancontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("dn")==null) {
			response.sendRedirect("dangnhapController");
		}else {
			datmuabo dmbo = new datmuabo();
			try {
				int makh = (int) session.getAttribute("makh");
				dmbo.HoaDon(makh);
				long maxhd = dmbo.MaHoaDon();
				//them vao chi tiet hoa don
				giohangbo gh = (giohangbo)session.getAttribute("gh");
				for (giohangbean g : gh.ds) {
					dmbo.HoaDonChiTiet(g.getMasach(),g.getSoluong(), maxhd);
				}
				session.removeAttribute("gh");
				response.sendRedirect("sachcontroller");
			} catch (Exception e) {
				e.printStackTrace();
			}
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
