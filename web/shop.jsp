<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.nutsaboutcandies.dao.InventoryDao, com.nutsaboutcandies.model.Product,
	com.nutsaboutcandies.user.*, com.nutsaboutcandies.services.*, java.io.File" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	InventoryDao dao = new InventoryDao();
	List<Product> products = dao.retrieveProducts();
	pageContext.setAttribute("products", products);
	Cart cart;
	String filename= "";
//	if(session.getAttribute("user")==null) {
	//	filename = getServletContext().getRealPath("") + File.separator + "guest.xml";
		//cart = XMLRecorder.retrieveCart(filename);
		//pageContext.setAttribute("cart", cart);
//	}
%>
<head>
	
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
	<style type="text/css">
		.sortOptionsLabel {
			font-weight: normal;
			cursor:pointer;
		}

		.tooltipImages, .products, .visibleLabel {
			cursor: pointer;
		}

	</style>
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
						<li><a href="index.html">Home</a></li>
						<li class="active"><a href="#">Shop</a></li>
						<li><a href="cart.html">My Cart <span class="badge">${cart.numberOfItems }</span></a></li>
						<li><a href="checkout.html">Checkout</a></li>
						
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Sign up</a></li>
						<li><a href="#">Login</a></li>

					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>
		<div class="row col-md-10 col-md-offset-1">
			<form class="form-horizontal" method="post" action="../admin/add.jay">

				<div class="form-group">
					<div class="input-group  col-md-4 pull-right">
						<span style="padding:0px 4px" class="input-group-addon">Search</span>
						<input type="search" class="form-control input-sm" id="searchBar" aria-controls="products">
						<span class="input-group-btn">
							<button class="btn btn-success btn-sm" type="button">Go!</button>
						</span>
					</div>
				</div>
			</form>
		</div>
		<div class="row col-md-10 col-md-offset-1">

			<div class="col-md-9">
				<div class="panel panel-success">
					<div class="panel-heading">
							<div class="row"  style="font-size: small">
							<div class="col-md-9">
						<ul class="breadcrumb">
							<li>Sort by</li>
							<li class="sortOptions" ><label style="font-weight: bold" id="sortByName" class="sortOptionsLabel">Name</label> </li>
							<li class="sortOptions" ><label  id="sortByCategory" class="sortOptionsLabel">Category</label></li>
							<li class="sortOptions" ><label  id="sortByType" class="sortOptionsLabel">Type</label> </li>
							<li class="sortOptions" ><label  id="sortBySize" class="sortOptionsLabel">Size</label> </li>
							<li class="sortOptions" ><label  id="sortByPrice" class="sortOptionsLabel">Price</label> </li>
							<li class="sortOptions" ></li>
							<label style="font-weight: normal">    [<a href="#">asc</a> | <a href="#">desc</a>] </label>
						</ul>
						</div>
						<div class="col-md-3">
							Show <select class="select">
								<option value="5">5
								<option value="10">10		
							</select>  items
						</div>
						</div>
						
						
						
					</div>
					<div class="panel-body">
					<c:forEach items="${products }" var="p" varStatus="counter">
					<c:choose>
						<c:when test="${counter.index mod 3 eq 0 }">
							<div class="row">
						</c:when>
					</c:choose>	
						
								<div class="col-md-4">
									<div class="thumbnail  products" id="Label${counter.index }">
										<img src="images/default.png" width=100px" height="100px">
										<div class="caption">
											<h6>${p.name }</h6>
											<form method="post" action="cart.add">
											<input type="submit" class="btn btn-primary btn-sm" value="Add to cart">
 											<input type="text" id="quantity" size="5" name="quantity" required placeholder="Qty">
											<input type="hidden" value="${p.id }" name="id">
											</form>
											<div class="accordion" id="Label${counter.index }">
												<h6 id="Label${counter.index }" class="hiddenLabel">Details</h6>
												<div>
													<table border="0" style="font-size: smaller">
														<tr>
															<td width="60px">Category</td>
															<td><i>${p.category }</i></td>
															
														</tr>
														<tr>
															<td>Type</td>
															<td><i>${p.type }</i></td>
															
														</tr>
														
														<tr>
															<td>Size</td>
															<td><i>${p.size }</i></td>
															
														</tr>
														
														<tr>
															<td>Price</td>
															<td><i>${p.price }</i></td>
															
														</tr>
														
														<tr>
															<td>Stock</td>
															<td><i>${p.stock }</i></td>
															
														</tr>
														
														<tr rowspan="2">
								<td>Ingredient</td>
								<td>
									<c:forEach items="${p.items }" var="i">
										
											${i.name } <i>( ${i.category } )</i><br>
											
										
									</c:forEach>
								</td>
								</tr>	
							<tr>
														
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>

							
							<c:choose>
							<c:when test="${counter.index%3 == 2 }">
							</div>
						</c:when>
						<c:when test="${counter.last}">
						<c:if test="${counter.index % 3 == 0 }">
							</div>
						</c:if>
						</c:when>
						</c:choose>
						</c:forEach>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h6 class="panel-title">Your Cart </h6> 

					</div>
					<div class="panel-body" style="font-size: smaller">
					<c:choose>
						<c:when test="${sessionScope.cart.numberOfItems eq 0 or empty sessionScope.cart }"><label><i>No items</i></label></c:when>
					
					<c:otherwise>
					<p>Cart Subtotal : <b>P ${sessionScope.cart.total}</b></p> 
					
					<button class="btn btn-warning btn-sm">Checkout</button>
					<hr>
					<i>Recently added products</i>
					<table width="100%">
					
					
					 	<c:forEach items="${sessionScope.cart.products }" var = "p" varStatus="counter">
					 		<c:if test="${counter.index lt 5 }">
					 		<tr>
					 		<td width="25%"><img  style="margin: 5px" src="images/uploads/${p.image }" width="40px" height="40px"></td>
					 		<td width="70%">${ p.name}<br>${p.stock } x &#8369; ${p.price }</td>
					 		<td width="5%"><a href="cart.remove?id=${counter.index }" onclick="return confirm('Are you sure you want to remove this product?') ">x</a></td>
					 		
					 		</tr>
					 		</c:if>
					 	</c:forEach>
					 	</table>
					</c:otherwise>	
					</c:choose>
					</div>
				</div>
			</div>
		</div>

	</div>
	
	<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="bootstrap/js/dataTables.bootstrap.js"></script>
	
	<script src="bootstrap/js/jquery-ui.js"></script>
	<c:if test="${!empty sessionScope.stock_error}">
	<div class="modal fade" id="success" tabindex="-1" role="dialog" aria-labledBy="modalTitle" aria-hidden="true">
	
			<div class="modal-dialog model-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
						<h4 class="modal-title" id="modalTitle">Sorry</h4>
					</div>
						
								
								<div class="modal-body">
									<c:if test="${sessionScope.stock_error eq 'Out of stock' }">
										<p>${product_name } is out of stock.</p>
									</c:if>
									<c:if test="${sessionScope.stock_error eq 'Over stock' }">
										<p>Quantity can't be over ${sessionScope.stock }.</p>
									</c:if>
								</div>
							
					
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		$(document).ready(function(){
			$('#success').modal('show');
		});
		</script>
		<c:remove var="stock_error"/>
		</c:if>
	<script type="text/javascript">
	var last = "";
		$(document).ready(function() {
			$('#dataTableSearch').remove();
			$('#products').dataTable();
			$('#sortByName').click(function(){
				$('#nameSort').click();
	    	// $('#sortByName').css({"font-weight": "bold"});
	    });
			$('#sortByCategory').click(function(){
				$('#categorySort').click();
			});
			$('#sortByType').click(function(){
				$('#typeSort').click();
			});
			$('#sortBySize').click(function(){
				$('#sizeSort').click();
			});
			$('#sortByPrice').click(function(){
				$('#priceSort').click();
			});
			$('.sortOptionsLabel').click(function(){
				$('.sortOptionsLabel').css({"font-weight": "normal"});
				$(this).css({"font-weight": "bold"});
			});
			$('.hiddenLabel').click(function(e){
				if(last != null ){
					
				}
				
				//$('.hiddenLabel#'+e.target.id).click();
				
					if('.accordion#'+e.target.id != last) {
						$(last).accordion({
							 active: false
							 });
					}
					last = '.accordion#'+e.target.id; 
			});
		

		

		
			

		} );

		 $(function() {
			 $( ".accordion" ).accordion({
			 collapsible: true,
			 active: false
			 });
			
			 });

		 
	</script>

</body>
</html>