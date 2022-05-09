<%@ page import="com.immune.tienda.entity.Product" %>


 
<html lang = "es">
	<head>
		<meta charset = "utf-8">
        <link rel="stylesheet" type= "text/css" href="CSS/style.css"></link>
	</head>
	<body>
	<h2>Update</h2>
	<p>---------------------------------</p>
	<form action=/updateProduct type="POST">
		<p>Select ID:</p>
		<input type="number" min="0" name="ID"></input>
		<p>New Name:</p>
		<input type="text" name="newName"></input>
		<p>New Price:</p>
		<input type="number" min=0 step=0.01 name="newPrice"></input>
		<input name="rolID" value="<%=request.getAttribute("rolID")%>" class="invisible"></input>
		</br>
		</br>
		<input type="submit" value="Change"></input>
	</form>
	<%
        if(request.getAttribute("respuesta")!=null){
            Boolean respuesta = (Boolean) request.getAttribute("respuesta");
            if(respuesta){
                %><p>Error, try again.</p><%
            }
            else{
                %><p>Product updated successfully</p><% 
            }
        }
        %>
	 <form action="/menu" method="POST" class="button">
            <button type="submit" >Menu</button>
    		<input name="rolID" value="<%=request.getAttribute("rolID")%>" class="invisible"></input>
    </form>
	</body>
</html>	


