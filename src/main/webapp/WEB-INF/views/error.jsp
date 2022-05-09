<%@ page import="com.immune.tienda.entity.Product" %>


 
<html lang = "es">
	<head>
		<meta charset = "utf-8">
        <link rel="stylesheet" type= "text/css" href="CSS/style.css"></link>
	</head>
	<body>
	<h3> An error has ocurred. Try again.</h3>
		<form class="button" action="menu" method="POST">
        	<a href="/">Log in</a>
			<p name="rolID" class="invisible"><%=request.getAttribute("rolID")%></p>
		</form>
	</body>
</html>	


