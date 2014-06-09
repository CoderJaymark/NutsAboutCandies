<%@ include file="header.jsp" %>
		
		
		<div class="col-md-6 col-md-offset-3">
		<div class="well">
			<form class="form-horizontal" method="post" action="user.signup">
				<fieldset>	
					<legend>Signup</legend>
					<!-- Text input-->
					<div class="row">
					<div class="col-md-6">
					<label class="control-label " for="firstname" >First name</label> 
					<div class="form-group">
						 
						<div class="col-md-12">
							<input id="firstname" name="firstname" class="form-control input-sm" required type="text">
						</div>
					</div>

					<label class=" control-label " for="lastname">Last name</label>  
					<div class="form-group">
						
						<div class="col-md-12">
							<input id="lastname" name="lastname" class="form-control input-sm" required type="text">
						</div>
					</div>

					<label class=" control-label " for="email">Email</label>  
					<div class="form-group">
						
						<div class="col-md-12">
							<input id="email" name="email" class="form-control input-sm" required type="email">
						</div>
					</div>
					</div>
					<div class="col-md-6">
					<label class="control-label " for="password">Password</label>
					<div class="form-group">
						  
						<div class="col-md-12">
							<input id="password" name="password" class="form-control input-sm" required type="password">
						</div>
					</div>

					<label class="control-label " for="password2">Repeat password</label>  
					<div class="form-group">
						
						<div class="col-md-12">
							<input id="password2" name="password2" class="form-control input-sm" required type="password">
						</div>
					</div>

					<label class="control-label " for="contact">Contact number</label>
					<div class="form-group">
						  
						<div class="col-md-12">
							<input id="contact" name="contact" class="form-control input-sm" required type="text">
						</div>
					</div>
					</div>
					</div>
					<legend>Address</legend>
					<div class="row">
					<div class="col-md-6">
					<label class="control-label" for="unit">Unit number</label>
					<div class="form-group">
						  
						<div class="col-md-12">
							<input id="unit" name="unit" class="form-control input-sm" required type="text">
						</div>
					</div>

					<label class="control-label " for="street">Street</label>
					<div class="form-group">
						  
						<div class="col-md-12">
							<input id="street" name="street"  class="form-control input-sm" required type="text">
						</div>
					</div>
					</div>
					<div class="col-md-6">
					<label class="control-label " for="barangay">Barangay</label>
					<div class="form-group">
						  
						<div class="col-md-12">
							<input id="barangay" name="barangay" class="form-control input-sm" required type="text">
						</div>
					</div>

					<label class="control-label " for="city">City</label>
					<div class="form-group">
						  
						<div class="col-md-12">
							<input id="city" name="city" class="form-control input-sm" required type="text">
						</div>
					</div>
					</div>
					</div>
					<div class="form-group pull-right">
						<div class="col-md-12">
							<input class="btn btn-success" required type="submit" value="Sign up">
						</div>
					</div>
				</fieldset>

			</form>

		</div>
	</div>

	</div>
	
	<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>

</body>
</html>