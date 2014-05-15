<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${empty sessionScope.admin}">
	<c:redirect url="login.jsp"/>
</c:if>

<html>
<head>
	<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body  data-spy="scroll" data-target="#mynav" style="">
	<div class="container">
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Nuts About Candies Admin</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Inventory</a></li>
						<li><a href="#">Customers</a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="admin.logout">Logout</a></li>

					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
		<div class="row">
			<div class="col-md-3">
				<p class="lead">Product operations</p>
				<div class="list-group">
					<a href="#" class="list-group-item active">Add product</a>
					<a href="#" class="list-group-item">Display products</a>
					<a href="#" class="list-group-item">Update products</a>
				</div>
			</div>
			<div class="col-md-9">
				<div class="well">
					<form method="post" action="product.add" id="formConfirm">
						<fieldset>
							<legend>Product confirmation</legend>
							<table class="table">
							<tr>
								<td>Name</td>
								<td><b>${product.name }</b></td>
							</tr>	
							<tr>
								<td>Type</td>
								<td><b>${product.type }</b></td>
								</tr>	
							<tr>
								<td>Category</td>
								<td><b>${product.category }</b></td>
								</tr>	
							<tr>
								<td>Size</td>
								<td><b>${product.size }</b></td>
								</tr>	
							<tr><td>Price</td>
								<td><b>${product.price }</b></td>
								</tr>	
							<tr>
								<td>Weight</td>
								<td><b>${product.weight }</b></td>
								</tr>	
							<tr>
								<td>Shelf life</td>
								<td><b>${product.shelfLife }</b></td>
								</tr>	
							<tr>
								<td>Stock</td>
								<td><b>${product.stock }</b></td>
								</tr>	
							<tr rowspan="2">
								<td>Ingredient</td>
								<td>
									<c:forEach items="${product.items }" var="i">
										
											<b>${i.name } </b>( ${i.category } )
											<br>
											<input type="hidden" name="ingredient_name" value="${i.name }"/>
											<input type="hidden" name="ingredient_category" value="${i.category }"/>
										
									</c:forEach>
								</td>
								</tr>	
							<tr>
								<td>Image</td>
								
								
								<td><img alt="" src="../images/uploads/${product.image }" width = "200px" height = "200px"></td>
								</tr>
								<tr>
								</tr>
							</table>
							<input type="hidden" name="product_name" value="${product.name }"/>
							<input type="hidden" name="product_size" value="${product.size }"/>
							<input type="hidden" name="product_stock" value="${product.stock }"/>
							<input type="hidden" name="product_type" value="${product.type }"/>
							<input type="hidden" name="hiddenFileName" value="${product.image }"/>
							
							<div class="pull-right">
							
						<input type="button" class="btn btn-warning" value="Back" onclick="window.history.back()" />
						<input type="submit" class="btn btn-success" value="Confirm" />
					</div>
						</fieldset>
						
					</form>
					
				</div>
			</div>
		</div>
		

	</div>
	
	<script type="text/javascript" src="../bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="admin.js"></script>
	
</body>
</html>