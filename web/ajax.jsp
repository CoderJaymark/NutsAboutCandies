<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<title>AJAX calls using Jquery in Servlet</title>
        <script type="text/javascript" src="bootstrap/js/jquery.js">
        <script type="text/javascript" src="bootstrap/js/jquery.form.js">
        </script>
        <script>
            $(document).ready(function() {                        
                $('#submit').click(function(event) {  
                    var username=$('#user').val();
                 $.get('ActionServlet',{user:username},function(responseText) { 
                        $('#welcometext').text(responseText);         
                    });
                });
                $('#photoimg').change(function(e) { 
            		$('#uploadForm').submit();
               		$("#preview").html('');
               		$("#preview").html('<img src="loader.gif" alt="Uploading...."/>');
               		$("#uploadForm").ajaxForm({
               			target: '#preview'
               		}).submit();
                });
            });
        </script>
</head>
<body>
<form id="form1">
<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
Enter your Name:
<input type="text" id="user"/>
<input type="button" id="submit" value="Ajax Submit"/>
<br/>
<div id="welcometext">
</div>
</form>
<form action="FileUploadServlet" method="post" enctype="multipart/form-data" id="uploadForm">

Select File to Upload: <span class="btn btn-default btn-file">Upload<input  type="file" name="photoimg" id="photoimg" /></span>
<br>
<input type="text" name="asd"><br>
</form>
<div id='preview'>
</div>
</body>
</html>