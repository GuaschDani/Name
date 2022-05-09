<%@ page import="com.immune.tienda.entity.Product" %>
<%@ page import="com.immune.tienda.service.ProductService" %>
 
<html lang = "es">
	<head>
		<meta charset = "utf-8">
        <link rel="stylesheet" type= "text/css" href="CSS/style.css"></link>
	</head>
	<body>
	<h2>Delete</h2>
	<p>---------------------------------</p>
    <div class="deleteDiv">
        <form class="formDelete" action="/deleteProduct" method="POST">
            <p>Product ID to be deleted:</p>
            <input type="number" min=0 step=0.01 name="ID" required="required"></input>
            <button type="submit" >Delete</button>
            <input name="rolID" value="<%=request.getAttribute("rolID")%>" class="invisible"></input>
        </form>
        
        <%
            if(request.getAttribute("respuesta")!=null){
                Boolean respuesta = (Boolean) request.getAttribute("respuesta");
                if(respuesta){
                    %><p>Error, try again.</p><%
                }
                else{
                    %><p>Product deleted successfully</p><% 
                }
            }
            %>
     
     <form action="/menu" method="POST" class="button">
            <button type="submit" >Menu</button>
            <input name="rolID" value="<%=request.getAttribute("rolID")%>" class="invisible"></input>
    </form>
    </div>
   
</html>	

