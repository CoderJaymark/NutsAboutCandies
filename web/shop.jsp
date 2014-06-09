<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.nutsaboutcandies.dao.InventoryDao, com.nutsaboutcandies.model.Product,
	com.nutsaboutcandies.user.*, com.nutsaboutcandies.services.*, java.io.File" %>
<%@ include file="header.jsp" %>
<%
	InventoryDao dao = new InventoryDao();
	List<Product> products = dao.retrieveProducts(false);
	pageContext.setAttribute("products", products);
	Cart cart;
	String filename= "";
%>

	
		<div class="row col-md-10 col-md-offset-1">

			<div class="col-md-9">
				<div class="panel panel-success">
					<div class="panel-heading">
							<div class="row"  style="font-size: small">
							
						<div class="col-md-3">
							PRODUCTS
						</div>
						</div>
						
						
						
					</div>
					<div class="panel-body">
					<c:forEach items="${products }" var="p" varStatus="counter">
					<c:choose>
					 			<c:when test="${p.image ==  'default.png'}">
					 				<c:set var="img" value="images/default.png"></c:set>
					 			</c:when>
					 			<c:otherwise>
					 				<c:set var="img" value="images/uploads/${p.image }"></c:set>
					 			</c:otherwise>
					 		</c:choose>
					<c:choose>
						<c:when test="${counter.index mod 3 eq 0 }">
							<div class="row">
						</c:when>
					</c:choose>	
						
								<div class="col-md-4">
									<div class="thumbnail  products" id="Label${counter.index }">
										<img src="${img }" width=100px" height="100px">
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
						<c:if test="${counter.index % 3 < 2 }">
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
					<p>Cart Subtotal : <b>P ${sessionScope.cart.subtotal}</b></p> 
					
					<a href="checkout.jsp" class="btn btn-warning btn-sm">Checkout</a>
					<a href="cart.jsp" class="btn btn-warning btn-sm">Show cart</a>
					<hr>
					<i>Recently added products</i>
					<table width="100%">
					
					
					 	<c:forEach items="${sessionScope.cart.products }" var = "p" varStatus="counter">
					 		<c:if test="${counter.index lt 5 }">
					 		<tr>
					 		<c:choose>
					 			<c:when test="${p.image ==  'default.png'}">
					 				<c:set var="img" value="images/default.png"></c:set>
					 			</c:when>
					 			<c:otherwise>
					 				<c:set var="img" value="images/uploads/${p.image }"></c:set>
					 			</c:otherwise>
					 		</c:choose>
					 		<td width="25%"><img  style="margin: 5px" src="${img }" width="40px" height="40px"></td>
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