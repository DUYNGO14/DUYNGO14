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
import bean.loaiVoucherbean;
import bo.dienThoaiBo;
import bo.loaiBo;
import bo.thongkebo;

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			thongkebo tkbo=new thongkebo();
			loaiBo lb=new loaiBo();
			ArrayList<loaiBean> dsloai=lb.getloai();
			request.setAttribute("dsloai", dsloai);
			dienThoaiBo dtbo=new dienThoaiBo();
			//Thông tin điệ thoại
			String maloai = request.getParameter("maloai");
			String madt = request.getParameter("madt");
			String tendt = request.getParameter("tendt");
			String gia =request.getParameter("gia");
			String kichthuocman =request.getParameter("kichthuocman");
			String pin =request.getParameter("pin");
			String chip =request.getParameter("chip");
			String ram =request.getParameter("ram");
			String dungluong =request.getParameter("dungluong");
			String hinhanh =request.getParameter("hinhanh");
			String soluong =request.getParameter("soluong");
			String dt1=request.getParameter("dt");
			String hang=request.getParameter("hang");
			//thông tin hãng mới
			String mahang=request.getParameter("mahang");
			String tenloai=request.getParameter("tenloai");
			String dsloai1 = request.getParameter("dsloai1");
			if(dsloai1!=null) {
				request.setAttribute("dsloai1", dsloai1);
			}
			String dsloai2 = request.getParameter("dsloai2");
			if(dsloai2!=null) {
				request.setAttribute("dsloai2", dsloai2);
			}
			String maloai1 = request.getParameter("maloai1");
			if(maloai1!=null) {
				int check = tkbo.Checkdienthoai(maloai1);
				if(check==0) {
					tkbo.xoaloaidienthoai(maloai1);
				}else {
					tkbo.xoadienthoaitheomaloai(maloai1);
					tkbo.xoaloaidienthoai(maloai1);
				}
			}
			
			//thông tin voucher
			String maloaivoucher = request.getParameter("maloaivoucher");
			String tenvoucher = request.getParameter("tenvoucher");
			String  giatri=request.getParameter("giatri");
			String soluongvc = request.getParameter("soluongvc");
			
			ArrayList<loaiVoucherbean> dsloaivoucher = tkbo.getloaivoucher();
			request.setAttribute("dsloaivoucher", dsloaivoucher);
			String vc = request.getParameter("vc");
			String dsvou = request.getParameter("ds");
			String xoavoucher = request.getParameter("mavoucher");
			if(xoavoucher!=null) {
				long mavoucher = Long.parseLong(xoavoucher);
				long check = tkbo.checkVoucherMavorcher(mavoucher);
				if(check!=0) {
					tkbo.xoavoucher_khachhang(mavoucher);
					tkbo.xoavoucher1(mavoucher);
				}else {
					tkbo.xoavoucher1(mavoucher);
				}
			}
			
			request.setAttribute("dsvou", dsvou);
			request.setAttribute("dsvoucher", tkbo.getVoucher());
			request.setAttribute("add",null);
			request.setAttribute("hang", null);
			request.setAttribute("addt",null);
			request.setAttribute("addh",null);
			request.setAttribute("voucher",null);
			request.setAttribute("thieu", null);
			if(dt1!=null) {
				request.setAttribute("themdt", "dt");
			}
			if(hang!=null) {
				request.setAttribute("hang", "dt");
			}
			if(vc!=null) {
				request.setAttribute("vc", "vc");
			}
			if(maloai!=null && madt!=null &&tendt!=null &&gia!=null &&kichthuocman!=null && pin!=null && chip!=null &&ram!=null &&dungluong!=null &&hinhanh!=null && soluong!=null ) {
				
				dienThoaiBean dt = dtbo.TimdienthoaiMa(madt);
				if(dt==null) {
					request.setAttribute("add", "add");
					dtbo.insertdienthoai(madt, tendt,Long.parseLong(gia) ,Double.parseDouble(kichthuocman) ,Long.parseLong(pin) , maloai, chip, Long.parseLong(ram), Long.parseLong(dungluong), hinhanh, Long.parseLong(soluong));
				}else {
					request.setAttribute("maloai", maloai);
					request.setAttribute("madt", madt);
					request.setAttribute("tendt", tendt);
					request.setAttribute("gia", gia);
					request.setAttribute("kichthuocman", kichthuocman);
					request.setAttribute("pin", pin);
					request.setAttribute("chip", chip);
					request.setAttribute("ram", ram);
					request.setAttribute("dungluong", dungluong);
					request.setAttribute("hinhanh", hinhanh);
					request.setAttribute("soluong", soluong);
					request.setAttribute("trung", "trung");
				}
				request.setAttribute("addt", "jdskh");
			}
			if(mahang!=null && tenloai!=null) {
				loaiBean l=lb.TimMaLoai(mahang);
				if(l==null) {
					request.setAttribute("hang1", "dt");
					lb.inserthang(mahang, tenloai);
				}else {
					request.setAttribute("mahang", mahang);
					request.setAttribute("tenloai", tenloai);
					request.setAttribute("trung", "trung");
				}
				request.setAttribute("addh", "jdskh");	
			}
			if(maloaivoucher==null) {
				request.setAttribute("tenvoucher", tenvoucher);
				request.setAttribute("giatri", giatri);
				request.setAttribute("soluongvc", soluongvc);
				request.setAttribute("thieu", "thieu");
			}else if(maloaivoucher!=null && tenvoucher!=null && giatri!=null && soluongvc!=null) {
				tkbo.insertvoucher1(tenvoucher, Long.parseLong(giatri), Long.parseLong(soluongvc), Long.parseLong(maloaivoucher));
				request.setAttribute("voucher", "voucher");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=  request.getRequestDispatcher("themsanpham.jsp");
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
