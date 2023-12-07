<%@page import="bo.giohangbo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="bean.Loaibean"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<!------ Include the above in your HEAD tag ---------->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css_jsp/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<section class="mymainmenu bg-dark mb-4">
		<div class="container-fluid ">
			<div class="row">
				<div class="col-md-5 ">
					<ul class="nav justify-content-left mt-2">
						<li class="nav-item "><a class="nav-link active text-white linkl" aria-current="page" href="sachcontroller">Trang chủ</a></li>
						<c:if test="${quyen==0}">
						<%
						if (session.getAttribute("gh") != null) {
							giohangbo ghbo = (giohangbo) session.getAttribute("gh");
						%>
						<li class="nav-item" ><a class="nav-link text-white linkl" href="giohangController">
						<i class="fa-solid fa-bag-shopping"></i>
						Giỏ hàng(<%=ghbo.ds.size()%>)</a></li>
						<%} else {%>
						<li class="nav-item"><a class="nav-link text-white linkl" href="giohangController">
						<i class="fa-solid fa-bag-shopping"></i>
						Giỏ hàng(0)</a></li>
						<%}%>
						<li class="nav-item"><a class="nav-link text-white linkl" href="thanhtoan.jsp">
						<i class="fa-brands fa-paypal"></i>
						Thanh Toán</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="lichsuController">Lịch sử mua hàng</a></li>
						</c:if>
						<c:if test="${quyen==1}">
						<li class="nav-item"><a class="nav-link text-white linkl" href="adminxacnhancontroller">Xác nhận đơn</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="thongkekhachhangController">Khách hàng</a></li>
						<li class="nav-item"><a class="nav-link text-white linkl" href="themsanphamController">Thêm sản phẩm</a></li>
						</c:if>
					</ul>
				</div>
				<div class="col-md-5">
					<div class="input-group mt-2">
						<form class="d-flex" action="sachcontroller" method="post">
							<input class="form-control me-2" name="txttk" type="text" placeholder="Search" aria-label="Search">
							<button class="btn btn-success" type="submit">Search</button>
						</form>
					</div>
				</div>

				<div class="col-md-2">
					<div class="row">
					<!--  -->
					<%if(session.getAttribute("dn")==null){%>
						<div class="col-md mt-2">
							<i class="fa-solid fa-right-to-bracket text-success"></i>
							<a href="dangkiController" class="text-decoration-none pb"><strong class="text-white">Đăng kí</strong></a>
						</div>
						<div class="col-md mt-2">
							<i class="fa-solid fa-right-to-bracket text-success"></i>
							<a href="dangnhapController" class="text-decoration-none"><strong class="text-white">Đăng nhập</strong></a>
						</div>
					</div>
					<%}else{ %>
						<div class="col-md mt-2">
							<i class="fa-solid fa-user text-success"></i>
							<a href="#" class="text-decoration-none pb"><strong class="text-white">HI!<%=session.getAttribute("dn") %></strong></a>
						</div>
						<div class="col-md mt-2">
							<i class="fa-solid fa-right-from-bracket text-success"></i>
							<a href="dangxuat.jsp" class="text-decoration-none"><strong class="text-white">Đăng Xuất</strong></a>
						</div>
					<%} %>
					<!--  -->
				</div>
			</div>
		</div>
	</section>
	<!--end of menu-->
	<c:if test="${quyen==0}">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">
						<i class="fa fa-list"></i> Danh mục sản phẩm
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${dsloai}" var="o">
							<li class="list-group-item text-white"><a href="sachcontroller?ml=${o.maloai}">${o.tenloai}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-md-9">
				<div class="row row-cols-1 row-cols-md-3 g-4">
					<c:forEach items="${dssach}" var="o">
						<div class="col-12 col-md-6 col-lg-4 mb-4">
							<div class="card" style="width: 18rem , height: 23rem;">
								<a href="thongtinControler?ms=${o.masach}&anh=${o.anh}&ts=${o.tensach}&tg=${o.tacgia}&gia=${o.gia}&sl=${o.soluong}&ml=${o.maloai}">
									<img class="card-img-top" src="${o.anh}" alt="Card image cap">
								</a>
								<div class="card-body">
									<h4 class="card-title show_txt" >
										<a href="#" title="View Product">${o.tensach}</a>
									</h4>
									<p class="card-text show_txt">${o.tacgia}</p>
									<strong>Tác giả:${o.tacgia}</strong> <br> <strong>Giá:${o.gia}vnđ</strong>
									<br> <strong>Số lượng sách:${o.soluong} </strong> <br>
									<a
										href="giohangController?ms=${o.masach} &ts=${o.tensach}&gia=${o.gia}&tg=${o.tacgia}&anh=${o.anh}">
										<button type="button" class="btn btn-success">
										<i class="fa-solid fa-cart-plus"></i>
										Đặt hàng</button>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<nav class="page" aria-label="Page navigation example pb-3">
			  <ul class="nav justify-content-center">
			    <c:forEach begin="1" end="${maxpage}" var="i">
			    <c:if test="${ml==null}">
			    <li class="page-item"><a class="page-link" id="${tag==i?"activeq":""}" href="sachcontroller?index=${i}">${i}</a></li>
			    </c:if>
			    <c:if test="${ml!=null}">
			    <li class="page-item"><a class="page-link" id="${tag==i?"activeq":""}" href="sachcontroller?index1=${i}&ml1=${ml}">${i}</a></li>
			    </c:if>
			    </c:forEach>
			  </ul>
		</nav>
	</div>
	</c:if>
	<c:if test="${quyen==1}">
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase text-nowrap">
						 Danh mục sản phẩm
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${dsloai}" var="o">
							<li class="list-group-item text-white"><a href="sachcontroller?ml=${o.maloai}">${o.tenloai}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-md-10">
	                <div class="row pt-3">
	                    <table class="table">
	                        <thead>
	                          <tr>
	                          	<th scope="col col-md-2 ">Ảnh sản phẩm</th>
	                            <th scope="col col-md-2 ">Tên sách</th>
	                            <th scope="col col-md-2">Tác giả</th>
	                            <th scope="col col-md-2">Giá</th>
	                            <th scope="col col-md-2">Số lượng sách</th>
	                            <th scope="col col-md-2">Xóa mặt hàng</th>
	                          </tr>
	                        </thead>
	                        <tbody>
		                      	<c:forEach items="${dssach}" var="o">
		                          <tr>
		                          	<td><div class="">
									<a href="thongtinControler?ms=${o.masach}&anh=${o.anh}&ts=${o.tensach}&tg=${o.tacgia}&gia=${o.gia}&sl=${o.soluong}&ml=${o.maloai}">
									<img class="" src="${o.anh}" width="150px" height="150px" alt="Card image cap">
									</a>	
									</div></td>
		                            <td><div class="mt-5">${o.tensach}</div></td>
		                            <td><div class="mt-5">${o.tacgia}</div></td>
		                            <td><div class="mt-5">${o.gia}vnđ</div></td>
		                            <td><div class="mt-5">${o.soluong} cuốn</div></td>
		                            <td><div class="mt-5">
		                            	<a href="sachcontroller?ms2=${o.masach}"> 
		                            		<i class="fa-solid fa-trash text-success"></i>
		                            	</a>
		                            </div></td>
		                          </tr>
		                        </c:forEach>
	                        </tbody>
	                     </table>
	                </div>
        		</div>
		</div>
		<nav class="page" aria-label="Page navigation example pb-3">
			  <ul class="nav justify-content-center">
			    <c:forEach begin="1" end="${maxpage}" var="i">
			    <c:if test="${ml==null}">
			    <li class="page-item"><a class="page-link" id="${tag==i?"activeq":""}" href="sachcontroller?index=${i}">${i}</a></li>
			    </c:if>
			    <c:if test="${ml!=null}">
			    <li class="page-item"><a class="page-link" id="${tag==i?"activeq":""}" href="sachcontroller?index1=${i}&ml1=${ml}">${i}</a></li>
			    </c:if>
			    </c:forEach>
			  </ul>
		</nav>
	</div>
	</c:if>
</body>
</html>

