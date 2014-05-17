<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${empty sessionScope.admin}">
	<c:redirect url="login.jsp"/>
</c:if>

<html>
<head>
	
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body  data-spy="scroll" data-target="#mynav" style="">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Nuts About Candies</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Shop</a></li>
						<li><a href="#">My Cart <span class="badge">42</span></a></li>
						<li><a href="#">Checkout</a></li>
						
					</ul>
<form class="navbar-form navbar-left">
      <input type="text" class="form-control col-lg-8" placeholder="Search">
    </form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Sign up</a></li>
						<li><a href="#">Login</a></li>

					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
		
		<div class="progress progress-striped active ">
  <div class="progress-bar progress-bar-success" style="width: 80%"></div>
</div>

	</div>
	
	<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>