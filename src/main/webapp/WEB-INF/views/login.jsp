
 
<html lang = "es">
	<head>
		<meta charset = "utf-8">
        <link rel="stylesheet" type= "text/css" href="CSS/style.css"></link>
	</head>
	<body>
        <h2>Log in</h2>
        <p>---------------------------------</p>
        <form class="formulario" action = "/login" method="POST">
            <p>E-mail:</p>
            <input type="text" name="mail" required="required"></input>
            <p>Password:</p>
            <input type="password" name="password" required="required"></input>
            </br>
            </br>
            <input  type="submit" value="Login"></input>
        </form>
        <%
        if(request.getAttribute("respuesta")!=null){
            Boolean respuesta = (Boolean) request.getAttribute("respuesta");
            if(respuesta){
                %><p>Error, try again.</p><%
            }
        }
        %>
	</body>
</html>	