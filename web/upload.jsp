<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Upload File</title>
   
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        <table>
        <tr>
                <td>Enter Filename : </td>
                <td><input type="text" name="qwe" size="20" id="postn234ame"/> </td>
            </tr>
            <tr>
                <td>Select File : </td>
                <td><input  name="file2" type="file" id="imagename"/> </td>
            </tr>
            <tr>
                <td>Enter Filename : </td>
                <td><input type="hidden" name="photoname2" size="20" id="postname"/> </td>
            </tr>
        </table>
        <p/>
        <input type="submit" value="Upload File"/>
    </form>
     <script type="text/javascript" src="bootstrap/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#imagename').change(function(){
			var text = $('#imagename').val();
			text = text.substring(text.lastIndexOf('\\')+1);
			$('#postname').val(text);
		
		});
	});
		
</script>
 </body>
</html>