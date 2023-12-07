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

import bean.dienThoaiBean;
import bean.giohangbean;
import bean.loaiBean;
import bo.datmuabo;
import bo.dienThoaiBo;
import bo.giohangbo;
import bo.loaiBo;
import dao.giohangdao;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			loaiBo lbo=new loaiBo();
			ArrayList<loaiBean> dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			
			String madt = request.getParameter("mdt");
			String tendt = request.getParameter("tendt");
			String chip=request.getParameter("chip");
			String ram=request.getParameter("ram");
			String dungluong=request.getParameter("dungluong");
			String gia = request.getParameter("gia");
			String anh= request.getParameter("anh");
			String kichthuocman=request.getParameter("ktm");
			String pin = request.getParameter("pin");
			String ml=request.getParameter("maloai");
			Long soluong=(long)0;
			if(session.getAttribute("dn")==null) {
				response.sendRedirect("DangNhapController");
			}else {
				if(madt!=null) {
					giohangdao ghbo= new giohangdao();
					if(session.getAttribute("gh")==null) {
						session.setAttribute("gh", ghbo);
					}
					ghbo = (giohangdao)session.getAttribute("gh");
					ghbo.Themhang(madt, tendt, Long.parseLong(gia), Double.parseDouble(kichthuocman),Long.parseLong(pin),ml,chip,Long.parseLong(ram),Long.parseLong(dungluong),anh,soluong);
					session.setAttribute("gh", ghbo);
				}
				if(session.getAttribute("gh")!=null) {
					giohangdao ghbo=(giohangdao)session.getAttribute("gh");
					request.setAttribute("ghbo", ghbo);
					RequestDispatcher rd=request.getRequestDispatcher("giohang.jsp");
					rd.forward(request, response);
				}else {
					request.setAttribute("ghbo", null);
					RequestDispatcher rd=request.getRequestDispatcher("giohang.jsp");
					rd.forward(request, response);
				}
			}
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("giohang.jsp");
			 * rd.forward(request, response);
			 */
			}catch (Exception e) {
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
