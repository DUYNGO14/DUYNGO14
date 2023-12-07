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

import bean.Loaibean;
import bean.sachbean;
import bo.giohangbo;
import bo.loaibo;
import bo.sachbo;
import dao.sachdao;


@WebServlet("/sachcontroller")
public class sachcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public sachcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			sachbo sbo= new sachbo();
			loaibo lbo = new loaibo();
			int max=0;
			ArrayList<Loaibean> dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			/* ArrayList<sachbean> ds = sbo.getsach(); */
			//phaan trang
			String indexpage = "";
			String ml1=request.getParameter("ml1");
			String index1=request.getParameter("index1");
			String makh = request.getParameter("makh");
			String ms2= request.getParameter("ms2");
			giohangbo g=new giohangbo();
			if(ms2!=null) {
				g.xoasach(ms2);
			}
			if(session.getAttribute("quyen")==null) {
				session.setAttribute("quyen", (int)0);
			}
			if(index1!=null) {
				indexpage=index1;
			}else {
				indexpage=request.getParameter("index");
			}
			if(indexpage==null) {
				indexpage="1";
			}
			int index = Integer.parseInt(indexpage);
			request.setAttribute("tag", index);
			ArrayList<sachbean> ds = sbo.getsach1(index);
			String ml = request.getParameter("ml");
			request.setAttribute("ml", ml);
			
			String key = request.getParameter("txttk");
			if(ml!=null){
				ds=sbo.timMa(ml,index);
				max=sbo.Countml(ml);
			}else if(key!=null)  {
				ds=sbo.timSach(key);
				max=ds.size();
			}
			if(ml==null && key==null) {
				max = sbo.Count();
			}
			if(ml1!=null&&index1!=null) {
				ds=sbo.timMa(ml1,index);
				max=sbo.Countml(ml1);
			}
			int maxpage=0;
			if(max%15==0) {
				maxpage=max/15;
			}else {
				maxpage=(max/15)+1;
			}
			ArrayList<sachbean> dsall = sbo.getsach();
			request.setAttribute("dsall", dsall);
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("dssach", ds);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
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
