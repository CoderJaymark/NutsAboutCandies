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
	
	<link href="../bootstrap/css/dataTables.bootstrap.css" rel="stylesheet">
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
					<a href="index.jsp" class="list-group-item">Add product</a>
					<a href="#" class="list-group-item active">Display products</a>
					<a href="#" class="list-group-item">Update products</a>
				</div>
			</div>
			<div class="col-md-9">
				<div class="well">
				<table class="table table-condensed table-hover table-striped" cellspacing="0" id="products">
				
				<thead>
					<tr>
						<td></td>
						<td></td>
						<td><strong>ID</strong></td>
						<td><strong>Name</strong></td>
						<td><strong>Type</strong></td>
						<td><strong>Category</strong></td>
						<td><strong>Price</strong></td>
						<td><strong>Size</strong></td>
						<td><strong>Shelf life</strong></td>
						<td><strong>Weight</strong></td>
						<td><strong>Image</strong></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products }" var="p">
					
					<tr>
						<td><a href="product.remove?id=${p.id }" onclick="return confirm('Are you sure you want to delete ${p.name}?')"><span class='glyphicon glyphicon-remove'></span></a></td>
						<td><a href="product.update?id=${p.id }"><span style="color:blue;" class='glyphicon glyphicon-pencil'></span></a></td>
						<td>${p.id}</td>
						<td>${p.name}</td>
						<td>${p.type}</td>
						<td>${p.category}</td>
						<td>${p.price}</td>
						<td>${p.size}</td>
						<td>${p.shelfLife}</td>
						<td>${p.weight}</td>
						<td><img alt="" src="../images/uploads/${p.image}" width="50px" height="50px"></td>
					</tr>
					</c:forEach>
				</tbody>	
				</table>
				</div>
			</div>
		</div>
		

	</div>
	
	<script type="text/javascript" src="../bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../bootstrap/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="../bootstrap/js/dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="admin.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    $('#products').dataTable();
	} );
	</script>
	
</body>
</html>