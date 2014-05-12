<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${!empty sessionScope.admin}">
	<c:redirect url="index.jsp"/>
</c:if>

<html>
<head>
	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
		#footer {
			position: absolute;
			bottom: 0;
			width: 100%;
			/* Set the fixed height of the footer here */
			height: 60px;
			background-color: #f5f5f5;
		}
	</style>
</head>
<body>
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
				<a class="navbar-brand" href="#">Nuts About Candies Admin</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				
				
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#" data-toggle="modal" data-target="#myModal">Login</a></li>
					
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>

	<div class="col-md-4 col-md-offset-4">
	<c:if test="${sessionScope.wrong_credentials}">
		<div class="alert alert-dismissable alert-danger">
  			<button type="button" class="close" data-dismiss="alert">×</button>
  			<strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
		</div>
		<c:remove var="wrong_credentials"/>
	</c:if>
		<div class="well">
			<form class="form-horizontal" action="admin.login" method="post">
				<fieldset>	
					<legend>Login</legend>
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="textinput">Email</label>  
						<div class="col-md-12">
							<input id="email" name="email" placeholder="me@sample.com" class="form-control input-md" type="email">
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-2 control-label" for="password">Password</label>
						<div class="col-md-12">
							<input id="password" name="password" placeholder="password" class="form-control input-md" type="password">
						</div>
					</div>
					<div class="form-group pull-right">
						<div class="col-md-12">
							<input class="btn btn-success" type="submit" value="Login">
						</div>
					</div>
				</fieldset>

			</form>

		</div>
	</div>
	
	</div>
	
	<div id="footer">
	<div class="container">
			<p class="text-muted">Place sticky footer content here.</p>
	</div>
	</div>
	<script type="text/javascript" src="../bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js"></script>

</body>
</html>