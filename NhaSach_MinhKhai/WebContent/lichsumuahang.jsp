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
						<li class="nav-item"><a class="nav-link text-white linkl" href="lichsumuahang.jsp">Lịch sử mua hàng</a></li>
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
	<section class="title-cart border-bottom border-susscer border-3">
            <div class="container">
                <div class="row pt-3">
                    <div class="col-12 a-left  mb-4 fs-4">
                        <strong>LỊCH SỬ MUA HÀNG</strong>
                    </div>
               </div>
    </section>
    <section class="product-cart border-bottom border-danger border-3">
            <div class="container">
                <div class="row pt-3">
                    <table class="table">
                        <thead>
                          <tr>
                            <th scope="col col-md-4 ">Thông tin sản phẩm</th>
                            <th scope="col col-md-2">Đơn giá</th>
                            <th scope="col col-md-2">Số lượng mua</th>
                            <th scope="col col-md-2">Thành tiền</th>
                          </tr>
                        </thead>
                        <tbody>
                      <c:forEach items="${dsls}" var="o">
                          <tr>
                            <td class="row">
                                <div class="col-md-4">
                                    <img  src="${o.anh}" alt="Sap" style="width:100px; height: 150px;">
                                </div>
                                <div class="col-md-6 mt-5">${o.tensach}</div>
                            </td>
                            <td  ><div class=" mt-5">${o.gia}</div></td>
                            <td>
                                <div class=" mt-5">${o.soluongmua}</div>
                            </td>
                            <td  ><div class="mt-5 ">${o.gia}</div></td>
                          </tr>
                          </c:forEach>
                        </tbody>
                     </table>
                </div>
            </div>
      </section>
</body>
</html>