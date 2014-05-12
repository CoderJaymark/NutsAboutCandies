<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${empty sessionScope.admin}">
	<c:redirect url="login.jsp"/>
</c:if>

<html>
<head>
	<style type="text/css">
	.btn-file {
    position: relative;
    overflow: hidden;
}
.btn-file input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    min-width: 100%;
    min-height: 100%;
    font-size: 999px;
    text-align: right;
    filter: alpha(opacity=0);
    opacity: 0;
    outline: none;
    background: white;
    cursor: inherit;
    display: block;
}
	</style>
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
					<form class="form-horizontal" method="POST" action="../admin/add.jay"  enctype="multipart/form-data" >
						<fieldset>	
						
							<legend>Add product</legend>
							
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-2 control-label" for="product_name">Name</label>  
								<div class="col-md-10">
									<input required id="product_name" name="product_name" placeholder="Product name" class="form-control input-md" type="text">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label" for="product_type">Type</label>  
								<div class="col-md-2">
									<!-- <input id="product_type" name="product_type" class="form-control input-md" type="text"> -->
									<select class="select form-control" name="product_type">
										<option name="Regular" value="Regular">Regular</option>
										<option name="Premium" value="Premium">Premium</option>
									</select>
								</div>
								<label class="col-md-2 control-label" for="product_size">Size</label>  
								<div class="col-md-2">
									<!-- <input id="product_type" name="product_type" class="form-control input-md" type="text"> -->
									<select class="select form-control" name="product_size">
										<option name="Regular" value="Regular">Small</option>
										<option name="Premium" value="Premium">Medium</option>
										<option name="Premium" value="Premium">Large</option>
									</select>
								</div>
								<label class="col-md-2 control-label" for="product_stock">Stock</label>  
								<div class="col-md-2">
									<input required id="product_stock" name="product_stock" class="form-control input-md" type="text">

								</div>

							</div>
							<br>
							
							<span class="btn btn-default btn-file">Upload image for this product <input  type="file" name="fileName" id="upload" /></span>
							<label id="imageName"> Image : None</label>
							<input type="hidden" name="hiddenFileName" id="hiddenFileName">
							<br>
							<legend><h4>Add Ingredient</h4></legend>
							<div id="ingredient_form">
								<div class="form-group">
  
									<label class="col-md-2 control-label" for="ingredient_name">Name</label>  
									<div class="col-md-4">
										<input required id="ingredient_name" name="ingredient_name" placeholder="ingredient name" class="form-control input-md" type="text">
									</div>
									<label class="col-md-2 control-label" for="ingredient_type">Type</label>  
									<div class="col-md-2">
										<select class="select form-control" name="ingredient_type">
											<option name="Nut" value="Nuts">Nut</option>
											<option name="Candy" value="Candies">Candy</option>
										</select>
									</div>
									<div class="col-md-2">
										<a href="#" id="addIngredientButton">Add more</a> <span class='glyphicon glyphicon-plus'></span> 

									</div>
								</div>


							</div>

							<div class="form-group pull-right">
								<div class="col-md-12">
									<input class="btn btn-success btn-lg" type="submit" id="submitButton" value="Add product">
									<label id="asd">Submit</label>
								</div>
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
	<script type="text/javascript">
	$(document).ready(function(){
		
		$('#asd').click(function(){
			alert('asd');
			$('#imageForm').submit();
			});
		});
		
	</script>
</body>
</html>