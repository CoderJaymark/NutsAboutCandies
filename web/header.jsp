<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
						<li <c:if test="${fn:contains(pageContext.request.requestURL, '/index.jsp')}"> class='active' </c:if> ><a href="index.jsp">Home</a></li>
						<li <c:if test="${fn:contains(pageContext.request.requestURL, '/shop.jsp')}"> class='active' </c:if>><a href="shop.jsp">Shop</a></li>
						<li <c:if test="${fn:contains(pageContext.request.requestURL, '/cart.jsp')}"> class='active' </c:if>><a href="cart.jsp">My Cart <span class="badge">
						<c:choose>
						<c:when test="${sessionScope.cart.numberOfItems eq 0 or empty sessionScope.cart }">0</c:when>
					
					<c:otherwise>
						${sessionScope.cart.numberOfItems }
						</c:otherwise>
						</c:choose>
						</span></a></li>
						<li <c:if test="${fn:contains(pageContext.request.requestURL, '/checkout.jsp')}"> class='active' </c:if>><a href="checkout.html">Checkout</a></li>
						
					</ul>
				
					<ul class="nav navbar-nav navbar-right">
						<li><a href="signup.jsp">Sign up</a></li>
						<li><a href="#" data-toggle="modal" data-target="#myModal">Login</a></li>

					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Login</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<fieldset>	
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="textinput">Email</label>  
								<div class="col-md-12">
									<input id="email" name="email" placeholder="me@sample.com" class="form-control input-md" type="email">
								</div>
							</div>

							<!-- Password input-->
							<div class="form-group">
								<label class="col-md-3 control-label" for="password">Password</label>
								<div class="col-md-12">
									<input id="password" name="password" placeholder="password" class="form-control input-md" type="password">
								</div>
							</div>

						</fieldset>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-success">Login</button>
				</div>
			</div>
		</div>
	</div>