<%-- 
    Document   : Formulario
    Created on : 6/03/2019, 04:31:07 AM
    Author     : TOSHIBA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <script src="moderador.js"></script>
<title> Didier�s Sports</title>
<meta charset="UTF-8">
<style type="text/css">
	#header{
		
	margin:auto;
	
	width:500px;
	font-family:Arial, Helvetica, sans-serif;
	}

	ul,ol {
		list-style:none;
	}
	.nav li a{
		background-color:#000;
		color:#fff;
		text-decoration:none;
		padding:10px 15px;
		display:block;
	}

	.nav li a:hover{
		background-color:#434343;
	}
	.nav>li{
	float:left;
	}
	
</style>
</head>
<body style="background-color:beige;" id="cuerpo">

<font size='5'><font face="Comic Sans MS,Arial,Verdana">REGISTRO</font></font>
	<form method="post" action="index1.jsp">
           <input type="hidden" name="registroForm"/>
           <br>
          Nombres:<br>
          <input type="text" name="nombre" value="">
          <br><br>
          Apellido:<br>
          <input type="text" name="apellido" value="">
          <br><br>
          Correo electronico:<br>
          <input type="text" name="correo" value="">
          <br><br>
          Telefono:<br>
          <input type="text" name="telefono" value="">
          <br><br>
          Contrase�a:<br>
          <input type="password" name="clave" value="">
          <br><br>
          <input type="submit" name="sub1">
        </form>


</body>
</html>
