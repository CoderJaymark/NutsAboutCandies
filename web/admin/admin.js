var removeButtonCounter = 1;
var text = "";
$(document).ready(function(){
	$('#addIngredientButton').click(function(){

		text = "";
		text += "<div id='ingredient_" + removeButtonCounter + "' ";
		text += "class='form-group'><label class='col-md-2 control-label' for='ingredient_name'>Name</label><div class='col-md-4'>";
		text += "<input required id='ingredient_name' name='ingredient_name' placeholder='ingredient name' class='form-control input-md' type='text'></div>";
		text += "<label class='col-md-2 control-label' for='ingredient_type'>Type</label><div class='col-md-2'><select name='ingredient_type' class='select form-control'>";
		text += "<option name='Nut' value='Nuts'>Nut</option><option name='Candy' value='Candies'>Candy</option></select></div>";
		text += "<div class='col-md-2'><a href='#' onclick = 'removeField("+removeButtonCounter+")' class='removeButtons' id='form_" + removeButtonCounter + "'";
		text += ">remove</a></div></div>";
//		text = $(text);
		$('#ingredient_form').append($(text));
		removeButtonCounter++;
		
	});

	$('.removeButtons').click(function(){
		alert("as");
	});
	
	$('#upload').change(function(){
		var text = $('#upload').val();
		text = text.substring(text.lastIndexOf('\\')+1);
		$('#imageName').text('Image : ' + text);
		$('#hiddenFileName').val(text);
	
	});
});

function removeField(id) {
	$('#ingredient_' + id).remove();

}

