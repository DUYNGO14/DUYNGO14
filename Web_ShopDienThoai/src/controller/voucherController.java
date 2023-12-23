package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.loaiBean;
import bean.voucherbean;
import bo.loaiBo;
import bo.thongkebo;

/**
 * Servlet implementation class voucherController
 */
@WebServlet("/voucherController")
public class voucherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public voucherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			long makh= (long)session.getAttribute("makh");
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			loaiBo lbo=new loaiBo();
			ArrayList<loaiBean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			thongkebo tkbo=new thongkebo();
			ArrayList<voucherbean> ds = new ArrayList<voucherbean>();			
			ArrayList<voucherbean> dsgiam = tkbo.getVoucher1(1);
			ArrayList<voucherbean> dsship = tkbo.getVoucher1(2);
			ArrayList<voucherbean> dsvou = tkbo.getVouchermakh(makh);
			String vcb= request.getParameter("vcb");
			String vcc=request.getParameter("vcc");
			request.setAttribute("vcc", vcc);
			request.setAttribute("vcb", vcb);
			int k=0;
			if(vcb!=null) {
				request.setAttribute("dsv", dsvou);
				k=dsvou.size();
				request.setAttribute("check", k);
			}
			if(vcc!=null) {
				request.setAttribute("dsv", tkbo.getVoucher());
				k=tkbo.getVoucher().size();
				request.setAttribute("check", k);
			}
			String mavc = request.getParameter("mavc");
			if(mavc!=null) {
				tkbo.insertvoucher(Long.parseLong(mavc), makh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("voucher.jsp");
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
