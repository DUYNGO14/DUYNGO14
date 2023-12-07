<%@page import="java.awt.RenderingHints"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bo.giohangbo"%>
<%@page import="bean.giohangbean"%>
<%@page import="java.util.ArrayList"%>
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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="sachcontroller">Trang chủ</a></li>
				<%if(session.getAttribute("gh")!=null){
					giohangbo ghbo = (giohangbo)session.getAttribute("gh");%>
					<li><a href="giohangController">Giỏ hàng (<%=ghbo.SoLuongSp()%>)</a></li>
				<%}else{%>
					<li><a href="giohangController">Giỏ hàng(0)</a></li>
				<%} %>
				<li><a href="thanhtoan.jsp">Thanh toán</a></li>
				<li><a href="lichsuController">Lịch sử mua hàng</a></li>
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
				<li><a href="dangnhapController"><span
						class="glyphicon glyphicon-log-out"></span>Đăng nhập</a></li>
				<li><a href="dangki.jsp"><span
						class="glyphicon glyphicon-log-in"></span>Đăng kí</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</nav>	
	<%
	giohangbo ghbo = (giohangbo)request.getAttribute("ghbo");
	if(ghbo!=null){
		int n = ghbo.ds.size();
	%>
		
		<section class="title-cart border-bottom border-danger border-3">
            <div class="container">
                <div class="row pt-3">
                    <div class="col-12 a-left  mb-4 fs-4">
                        <h3>GIỎ HÀNG CỦA BẠN</h3>
                    </div>
                </div>
            </div>
        </section>
		<section class="product-cart border-bottom border-danger border-3">
			<div class="container">
				<div class="row mb-5">
					<div class="site-blocks-table">
						<form action="xoacontrolerr" method="post">
							<table class="table">
									<thead>
										<tr>
											<th scope="col col-md-2 "></th>
											<th scope="col col-md-2 ">Sản phẩm</th>
											<th scope="col col-md-2 ">Tên sách</th>
				                            <th scope="col col-md-2">Đơn giá</th>
				                            <th scope="col col-md-2">Số lượng</th>
				                            <th scope="col col-md-2">Thành tiền</th>
				                            <th scope="col col-md-2">Xóa</th>
										</tr>
									</thead>
									<%for(int i=0;i<n;i++){ 
									giohangbean g = ghbo.ds.get(i);%>
		                          		<tr>
			                          		<td>
			                          			<input type="checkbox" name="c1" value="<%=g.getMasach()%>" >
			                          		</td>
		                            		<td><img  src="<%=g.getAnh() %>" alt="Sap" style="width: 150px; height: 150px;"></td>
		                            		<td><div class="mt-5 text-start"><%=g.getTensach() %></div></td>
		                            		<td ><div class="mt-5"><%=g.getGia() %>vnđ</div></td>
		                            		<td>      		
							                    <a href="xoacontrolerr?tru=t&ms1=<%=g.getMasach()%>"><button type="button" class="btn btn-success w-100" name="tru">-</button></a>
			    								<input type="text" name="txtsl" style="width: 40px;" id="" value="<%=g.getSoluong()%>">
			                                    <a href="xoacontrolerr?cong=c&ms1=<%=g.getMasach()%>"><button type="button" class="btn btn-success w-100" name="cong">+</button></a>
		                            		</td>
		                            		<td><div class="mt-5"><%=g.getThanhtien()%>vnđ</div></td>
		                            		<td><div class="mt-5">
		                            			<a href="xoacontrolerr?ms=<%=g.getMasach()%>"> 
		                            				<i class="fa-solid fa-trash text-success"></i>
		                            			</a>
		                            		</div></td>
		                          		</tr>
										<%}%>
								</table>
								<input type="submit" name="xoachon" value="Xóa chọn" class="btn btn-success">
							</form>
							<br>
							<form action=xacnhancontroller method="post">
								<div class="container">
									<div class="row">
										<div class="col-md-6"><input type="submit" name="xacnhan" value="Xác nhận đặt mua" class="btn btn-success"></div>
										<div class="col-md-6 justify-content-end">
											<div align='center' style="font-size: 18px;"><strong >Tổng tiền:  <%=ghbo.Tongtien()%>vnđ </strong></div>
											<div class="row">
											<div class="col-md-3"></div>
											<div class="col-md-2"><a href="thanhtoan.jsp?tt=<%=ghbo.Tongtien()%>"><button type="button" class="btn btn-success w-100">Thanh toán</button></a></div>
											<div class="col-md-2"><a href="sachcontroller"><button type="button" class="btn btn-success w-100" name="Mua thêm">Mua thêm</button></a></div>
											<div class="col-md-2"><a href="xoacontrolerr?xoa=x"><button type="button" class="btn btn-success w-100" name="xoaAll">Xóa hết </button></a></div>
											<div class="col-md-3"></div>
											</div>
										</div>
									</div>
								</div>
							</form>
					</div>
				</div>
			</div>
		</section>
		
		<%}else{%>
				<div style="font-size: 100px; color: red" align="center" ><i class="fa-brands fa-shopify"></i></div>		
				<div style="font-size: 20px; color: red" align="center">Không có sản phẩm nào!</div>
				<div align="center"><a href="sachcontroller"><button type="button" class="btn btn-success w-100" name="Mua thêm">Mua thêm</button></a></div>
			<%} %>
		
</body>
</html>
