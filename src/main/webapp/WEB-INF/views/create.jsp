
<html lang = "es">
	<head>
		<meta charset = "utf-8">
        <link rel="stylesheet" type= "text/css" href="CSS/style.css"></link>
	</head>
	<body>
        <h2>Create</h2>
        <p>---------------------------------</p>
        <form class="formulario" action="/registrar" method="POST">
            <p>Name:</p>
            <input type="text" name="name" required="required">
            <p>Price:</p>
            <input type="number" min=0 step=0.01 name="price" required="required">
            </br>
            </br>
            <input name="rolID" value="<%=request.getAttribute("rolID")%>" class="invisible"></input>
            <input type="submit" value="Register new product">
            
        </form>
        <%
        if(request.getAttribute("respuesta")!=null){
            Boolean respuesta = (Boolean) request.getAttribute("respuesta");
            if(respuesta){
                %><p>Error, try again.</p><%
            }
            else{
                 %><p>Product registered successfully.</p><%
            }
        }
        %>
        <form action="/menu" method="POST" class="button">
            <button type="submit" >Menu</button>
            <input name="rolID" value="<%=request.getAttribute("rolID")%>" class="invisible"></input>
        </form>
	</body>
</html>	

