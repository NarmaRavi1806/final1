<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box
}

.mySlides1 {
	display: none
}

img {
	vertical-align: bottom;
}

/* Slideshow container */
.slideshow-container {
	max-width: 300px;
	position: relative;
	margin: auto;
	align-content: flex-start;
}

/* Next & previous buttons */
.prev, .next {
	cursor: pointer;
	position: absolute;
	top: 50%;
	width: auto;
	padding: 16px;
	margin-top: -22px;
	color: white;
	font-weight: bold;
	font-size: 18px;
	transition: 0.6s ease;
	border-radius: 0 3px 3px 0;
	user-select: none;
}

/* Position the "next button" to the right */
.next {
	right: 0;
	border-radius: 3px 0 0 3px;
}

/* On hover, add a grey background color */
.prev:hover, .next:hover {
	background-color: #f1f1f1;
	color: black;
}
/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product page</title>
</head>
<body>
	<div class="site-name" style="color: Red; font-size: 50px">
		<b>CapStore</b>&nbsp; &nbsp; <img
			src="C:\Users\bsruthi\Desktop\capstore.png" width="125" height="125" />
	</div>
	<br>
	<br>
	<br>
	<div class="slideshow-container">
		<div class="mySlides1">
			<div class="numbertext">1 / 2</div>
			<img src="C:\Users\bsruthi\Desktop\HTML\birthday.bmp"
				style="width: 100%">
		</div>

		<div class="mySlides1">
			<div class="numbertext">2 / 2</div>
			<img src="C:\Users\bsruthi\Desktop\HTML\penguin.jpg"
				style="width: 100%">
		</div>

		<a class="prev" onclick="plusSlides(-1, 0)">&#10094;</a> <a
			class="next" onclick="plusSlides(1, 0)">&#10095;</a>
	</div>

	<script>
		var slideIndex = [ 1, 1 ];
		var slideId = [ "mySlides1" ]
		showSlides(1, 0);
		showSlides(1, 1);

		function plusSlides(n, no) {
			showSlides(slideIndex[no] += n, no);
		}

		function showSlides(n, no) {
			var i;
			var x = document.getElementsByClassName(slideId[no]);
			if (n > x.length) {
				slideIndex[no] = 1
			}
			if (n < 1) {
				slideIndex[no] = x.length
			}
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			x[slideIndex[no] - 1].style.display = "block";
		}
	</script>


	<div>
		<table>
			<tr>

				<td>
					<h2>Description:</h2> <br>
				</td>
			</tr>


			<tr>
				<td>productName</td>
				<td>:${product.productName}</td></tr>
			<tr>
				<td>productCategory</td>
				<td>:${product.category}</td></tr>
			<tr>
				<td>productPrice</td>
				<td>:${product.price}</td></tr>
		</table>
		<br> <br>
		<form >
		<button type="submit" formaction="Buy.jsp">Buy Now</button>
		&nbsp; &nbsp; &nbsp;
		
		<button type="submit" onclick="cart()">Add to Cart</button>
		&nbsp; &nbsp;
		<button type="submit" onclick="wishlist()">Add to Wish List</button>
		&nbsp; &nbsp;
		</form>
		
		<script type="text/javascript">
		function cart(){
			
			alert("Product added to the cart Succesfully");
		}
		
		function wishlist(){
			alert("Product added to the Wish List Succesfully");
		}
		</script>
	</div>
	<br>
	<br>
	<br>
	<h2>Comments:</h2>
	<form action="">
		<div>
			<textarea placeholder="Write your Comments here" id="ryp-review-text"
				class="a-form-error" style="height: 100px; width: 480px"></textarea>
		</div>
		<br>
		
		<button type="submit">Submit</button>
		<br>
	</form>
</body>
</html>