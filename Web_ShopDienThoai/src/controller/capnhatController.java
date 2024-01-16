package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.dienThoaiBean;
import bean.loaiBean;
import bo.dienThoaiBo;
import bo.loaiBo;
import bo.thongkebo;

/**
 * Servlet implementation class capnhatController
 */
@WebServlet("/capnhatController")
public class capnhatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public capnhatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			dienThoaiBo dtbo = new dienThoaiBo();
			loaiBo lb=new loaiBo();
			ArrayList<loaiBean> dsloai=lb.getloai();
			request.setAttribute("dsloai", dsloai);
			thongkebo  tkbo = new thongkebo();
//			Cập nhật hãng điện thoaij
			/*
			 * String updateloai = request.getParameter("updateloai"); String maloai2=
			 * request.getParameter("maloai2"); String tenloai2=
			 * request.getParameter("tenloai2"); if(maloai2!=null && tenloai2!=null &&
			 * updateloai!=null) { request.setAttribute("mahang",maloai2);
			 * request.setAttribute("tenloai", tenloai2); request.setAttribute("upadteloai",
			 * updateloai); }
			 * 
			 * String maloai1=request.getParameter("mahang"); String
			 * tenloai1=request.getParameter("tenloai"); String tenloainew =
			 * request.getParameter("tenloainew"); if(tenloainew!=null) {
			 * tkbo.updateloaidienthoai(tenloainew,maloai1); request.setAttribute("update",
			 * "upadte"); request.setAttribute("mahang",maloai1);
			 * request.setAttribute("tenloai", tenloai1); request.setAttribute("tenloainew",
			 * tenloainew); }
			 */
			//cập nhật điện thoại
			String updatedt = request.getParameter("updatedienthoai");
			if(updatedt!=null) {
				request.setAttribute("updatedt", updatedt);
			}
			String madt2 = request.getParameter("madt");
			dienThoaiBean dt = dtbo.TimdienthoaiMa(madt2);
			String madt = dt.getMadt();
			String tendt = dt.getTendt();
			long gia =  dt.getGia();
			double kichthuocman = dt.getKichthuocman();
			long pin = dt.getPin();
			String maloai = dt.getMaloai();
			String chip = dt.getChip();
			long ram = dt.getRam();
			long dungluong = dt.getDungluong();
			String hinhanh = dt.getAnh();
			long soluong = dt.getSoluong();
			request.setAttribute("madt",madt );
			request.setAttribute("tendt",tendt );
			request.setAttribute("gia",gia );
			request.setAttribute("kichthuocman",kichthuocman );
			request.setAttribute("pin", pin);
			request.setAttribute("maloai", maloai);
			request.setAttribute("tenloai",lb.Tenloai(maloai));
			request.setAttribute("chip", chip);
			request.setAttribute("ram", ram);
			request.setAttribute("dungluong",dungluong );
			request.setAttribute("hinhanh", hinhanh);
			request.setAttribute("soluong",soluong );
			//Cập nhật điện thoại
			String maloai3 = request.getParameter("maloai");
			String madt1 = request.getParameter("madt");
			String tendt1 = request.getParameter("tendt");
			String gia1 =request.getParameter("gia");
			String kichthuocman1 =request.getParameter("kichthuocman");
			String pin1 =request.getParameter("pin");
			String chip1 =request.getParameter("chip");
			String ram1 =request.getParameter("ram");
			String dungluong1 =request.getParameter("dungluong");
			String hinhanh1 =request.getParameter("hinhanh");
			String soluong1 =request.getParameter("soluong");
			if(maloai3!=null && madt1!=null &&tendt1!=null &&gia1!=null &&kichthuocman1!=null && pin1!=null && chip1!=null &&ram1!=null &&dungluong1!=null &&hinhanh1!=null && soluong1!=null ) {
				tkbo.updatedienthoai(tendt1,Long.parseLong(gia1),Double.parseDouble(kichthuocman1), Long.parseLong(pin1), maloai3, chip1,Long.parseLong(ram1),Long.parseLong(dungluong1), hinhanh1, Long.parseLong(soluong1), madt1);
				request.setAttribute("updatedt1", "update");
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
