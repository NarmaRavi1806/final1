<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Management</title>
</head>
<body>
	<div class="site-name" style="color: Red; font-size: 50px">
		<b>CapStore</b>&nbsp; &nbsp; <img
			src="C:\Users\bsruthi\Desktop\capstore.png" width="125" height="125" />
	</div>

	<div class="header-bar" align="Right">
		<j:if test="${pageContext.request.userPrincipal.name != null}">
        Hello Merchant  &nbsp;|&nbsp;
            <a href="${pageContext.request.contextPath}/logout"
					onclick="alertName()">Logout</a>
				<br>
				<br>
				<script type="text/javascript">
					function alertName() {
						alert("Logged out Successfully");
					}
				</script>
			<a href="Home.jsp""${pageContext.request.contextPath}/home">Home
			</a> &nbsp;|&nbsp;
             <a href="${pageContext.request.contextPath}/order">Order
			</a>&nbsp;|&nbsp;
            <a href="MessagesPage.jsp""${pageContext.request.contextPath}/contact">Messages
			</a>&nbsp;|&nbsp;
			<a href="DandP.jsp""${pageContext.request.contextPath}/discounts&promos">Discounts
				& Promos </a>
		</j:if>
	</div>
	<br>
	<br>
	<div class="page-heading" style="color: blue; font-size: 25px">
		<b>Product Management</b>
	</div>
	<br>
	<br>
	<div align="center">
		<a href="AddProduct.jsp""${pageContext.request.contextPath}/addProduct">Add Product </a><br/><br/>
		<a href="RemoveProduct.jsp""${pageContext.request.contextPath}/removeProduct">Remove Product </a><br/><br/>
		<a href="UpdateProduct.jsp""${pageContext.request.contextPath}/updateProduct">Update Product </a><br/><br/>
		<a href="FindProductById.jsp""${pageContext.request.contextPath}/findbyid">Find Product By Id </a><br/><br/>
		<a href="FindProductByCategory.jsp""${pageContext.request.contextPath}/findbycategory">Find Product By Category </a><br/><br/>
		<a href="RemoveCategory.jsp""${pageContext.request.contextPath}/removeCategory">Remove Category</a><br/><br/>
		<a href="ViewAllCategories.jsp""${pageContext.request.contextPath}/viewAllCategories">View All Categories </a><br/><br/>
		
		
	</div>
</body>
</html>