<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.nutsaboutcandies.dao.InventoryDao, com.nutsaboutcandies.model.Product,
	com.nutsaboutcandies.user.*, com.nutsaboutcandies.services.*, java.io.File" %>
<%@ include file="header.jsp" %>

<div class="row col-md-10 col-md-offset-1">
	<div class="col-md-9">
		<div class="panel panel-success">
			<div class="panel-heading">
				<div class="row"  style="font-size: small">	
					<div class="col-md-12">
							Shopping cart
					<c:choose>
						<c:when test="${empty sessionScope.cart or sessionScope.cart.numberOfItems eq 0}">
							</div>
							<div class="panel-body">
								<center>
								<img src="images/empty-cart.png">
								</center>
							</div>
						</c:when>
						<c:otherwise>
					<div class="pull-right">
						<button class="btn btn-md btn-warning">Proceed to checkout</button>
					</div>
					</div>
					<hr>
					<div class="panel-body">
						<table class="table table-condensed table-bordered" style="color: black">
							<tr>
								<td></td>
								<td></td>
								<td>Product name</td>
								<td>Price</td>
								<td>Qty</td>
								<td>Subtotal</td>
							</tr>
							<form action="cart.update" method="post">
							<c:forEach items="${sessionScope.cart.products }" var = "p" varStatus="counter">
							<c:choose>
					 			<c:when test="${p.image ==  'default.png'}">
					 				<c:set var="img" value="images/default.png"></c:set>
					 			</c:when>
					 			<c:otherwise>
					 				<c:set var="img" value="images/uploads/${p.image }"></c:set>
					 			</c:otherwise>
					 		</c:choose>
					 			<c:if test="${counter.index lt 5 }">
					 				<tr>
					 					<td><a href="cart.remove?id=${counter.index }" onclick="return confirm('Are you sure you want to remove this product?') "><span class='glyphicon glyphicon-remove'></span></a></td>
					 					<td><img  style="margin: 5px" src="${img }" width="80px" height="80px"></td>
					 					<td>${p.name }</td>
					 					<td>${p.price }</td>
					 					<td><input type="text" value="${p.stock }" size="3" name="quantities"></td>
					 					<td>P ${p.price * p.stock }</td>
					 		
					 				</tr>
					 			</c:if>
					 		</c:forEach>
					 		
					 		<tfoot>
					 		<td colspan="6">
					 		<div class="col-md-12">
							<a href="shop.jsp" class="btn btn-sm btn-warning">Continue shopping</a>
							<div class="pull-right">
								<input type="submit" class="btn btn-sm btn-warning" value="Update cart">
							</div>
							</form>
						</div>
						</td>
					 		</tfoot>
						</table>
					</div>
					</c:otherwise>
					</c:choose>
				
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="panel panel-success">
			<div class="panel-heading">
				Payment details
			</div>
			<div class="panel-body">
				<c:choose>
						<c:when test="${sessionScope.cart.numberOfItems eq 0 or empty sessionScope.cart }"><label><i>No items</i></label></c:when>
					
					<c:otherwise>
						<table>
							<tr>
								<td>Subtotal</td>
								<td>${sessionScope.cart.subtotal }</td>
							</tr>
							<tr>
								<td>Discount</td>
								<td>${sessionScope.cart.discount }</td>
							</tr>
							<tr>
								<td width="150px">Delivery charge</td>
								<td>${sessionScope.cart.deliveryCharge }</td>
							</tr>
							<tr>
								<td><strong>Total</strong></td>
								<td></td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>
	
	<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.dataTables.js"></script>
	<script type="text/javascript" src="bootstrap/js/dataTables.bootstrap.js"></script>
	<script src="bootstrap/js/jquery-ui.js"></script>
</body>
</html>