<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bo.giohangbo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="bean.Loaibean"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="sachcontroller">Trang chủ</a></li>
				<%if(session.getAttribute("gh")!=null){
					giohangbo ghbo = (giohangbo)session.getAttribute("gh");%>
					<li><a href="giohangController">Giỏ hàng (<%=ghbo.ds.size()%>)</a></li>
				<%}else{%>
					<li><a href="giohangController">Giỏ hàng(0)</a></li>
				<%} %>
				<li><a href="thanhtoan.jsp">Thanh toán</a></li>
				<li><a href="lichsu.jsp">Lịch sử mua hàng</a></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<%
				if (session.getAttribute("dn") != null) {
				%>
				<li><a href="#"><span class="glyphicon glyphicon-user">Hi!<%=session.getAttribute("dn")%></span>
				</a></li>
				<li><a href="dangxuat.jsp"><span
						class="glyphicon glyphicon-log-out"></span>Đăng xuất</a></li>
				<%
				} else {
				%>
				<li><a href="dangnhapController"><span>
						<class="glyphicon glyphicon-log-out"></span>Đăng nhập</a></li>
				<li><a href="dangkiController"><span
						class="glyphicon glyphicon-log-in"></span>Đăng kí</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</nav>
	<%
		sachbo sbo= new sachbo();
	%>
	<table class="table">
		<tr>
			<td width="200" valign="top">
				<table class="table table-hover">
					<%
					ArrayList<Loaibean> dsloai=(ArrayList<Loaibean>)request.getAttribute("dsloai");
					for(Loaibean l: dsloai){ %>
						<tr>
							<td><a href="sachcontroller?ml=<%=l.getMaloai()%>"><%=l.getTenloai()%></a></td>
						</tr>
					<%} %>
				</table>
			</td>
			<td width="980" valign="top">
				<table class="table">
					<% 
					request.setCharacterEncoding("utf-8");
					response.setCharacterEncoding("utf-8");
					ArrayList<sachbean> ds=(ArrayList<sachbean>)request.getAttribute("dssach");
					if(ds!=null){
						int n = ds.size();
						for(int i=0;i<n;i++){
							sachbean sb = ds.get(i);%>
							<tr>
								<td>
									<a href="thongtinsp.jsp?ms=<%=sb.getMasach()%>&ts=<%=sb.getTensach()%>&gia=<%=sb.getGia()%>&tg=<%=sb.getTacgia()%>&anh=<%=sb.getAnh()%>&sl=<%=sb.getSoluong()%>" class="text-decoration-none">
									<img alt="sach"class="rounded mx-auto d-block mt-4"  src="<%=sb.getAnh()%>" width="200px" height="250px"> <br>
									<strong>Tên sách:<%=sb.getTensach() %></strong> <br></a>
									<strong>Tác giả:<%=sb.getTacgia() %></strong> <br>
									<strong>Giá:<%=sb.getGia() %>vnd</strong> <br>
									<strong>Số lượng sách:<%=sb.getSoluong() %></strong> <br>
									<a href="giohangController?ms=<%=sb.getMasach()%>&ts=<%=sb.getTensach()%>&gia=<%=sb.getGia()%>&tg=<%=sb.getTacgia()%>&anh=<%=sb.getAnh()%>">
										<button type="button" class="btn btn-success">Đặt hàng</button> 	
									</a>
								</td>
								<%i++; if(i<n){ sb=ds.get(i); %>
								<td>
									<a href="thongtinsp.jsp?ms=<%=sb.getMasach()%>&ts=<%=sb.getTensach()%>&gia=<%=sb.getGia()%>&tg=<%=sb.getTacgia()%>&anh=<%=sb.getAnh()%>&sl=<%=sb.getSoluong()%>" class="text-decoration-none">
									<img alt="sach" class="rounded mx-auto d-block mt-4" src="<%=sb.getAnh()%>" width="200px" height="250px"> <br>
									<strong>Tên sách:<%=sb.getTensach() %></strong> <br></a>
									<strong>Tác giả:<%=sb.getTacgia() %></strong> <br>
									<strong>Giá:<%=sb.getGia() %>vnđ</strong> <br>
									<strong>Số lượng sách:<%=sb.getSoluong() %></strong> <br>
									<a href="giohangController?ms=<%=sb.getMasach()%>&ts=<%=sb.getTensach()%>&gia=<%=sb.getGia()%>&tg=<%=sb.getTacgia()%>&anh=<%=sb.getAnh()%>">
										<button type="button" class="btn btn-success">Đặt hàng</button>
									</a>
								</td>
								<%i++; if(i<n){ sb=ds.get(i); %>
								<td>
									<a href="thongtinsp.jsp?ms=<%=sb.getMasach()%>&ts=<%=sb.getTensach()%>&gia=<%=sb.getGia()%>&tg=<%=sb.getTacgia()%>&anh=<%=sb.getAnh()%>&sl=<%=sb.getSoluong()%>" class="text-decoration-none">
									<img alt="sach"  src="<%=sb.getAnh()%>" width="200px" height="250px"> <br>
									<strong>Tên sách:<%=sb.getTensach() %></strong> <br></a>
									<strong>Tác giả:<%=sb.getTacgia() %></strong> <br>
									<strong>Giá:<%=sb.getGia() %>vnđ</strong> <br>
									<strong>Số lượng sách:<%=sb.getSoluong() %></strong> <br>
									<a href="giohangController?ms=<%=sb.getMasach()%>&ts=<%=sb.getTensach()%>&gia=<%=sb.getGia()%>&tg=<%=sb.getTacgia()%>&anh=<%=sb.getAnh()%>">
										<button type="button" class="btn btn-success">Đặt hàng</button>
									</a>
								</td>
								
							</tr>
						<%} %><%} %><%}} %>
				</table>
			</td>
			<td>
				<form action="sachcontroller" method="post" >
					<input type="text"name="txttk">
					<input type="submit" name="th" value="Tìm kiếm" class="btn btn-success">					
				</form>
			</td>
		</tr>
	</table>
	<nav class="page" aria-label="Page navigation example">
		  <ul class="nav justify-content-center">
		    <c:forEach begin="1" end="${maxpage}" var="i">
		    <li class="page-item"><a class="page-link" id="${tag==i?"activeq":""}" href="sachcontroller?index=${i}">${i}</a></li>
		    </c:forEach>
		  </ul>
	</nav>
</body>
</html>
