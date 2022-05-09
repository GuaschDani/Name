<%@ page import="com.immune.tienda.entity.Product" %>
<%@ page import="com.immune.tienda.service.ProductService" %>
 
<html lang = "es">
	<head>
		<meta charset = "utf-8">
        <link rel="stylesheet" type= "text/css" href="CSS/style.css"></link>
	</head>
	<body>
    <h2>Read</h2>
    <p>---------------------------------</p>
    
		<%Iterable<Product> products = (Iterable<Product>) request.getAttribute("products");%>  
        <table>
            <tr>
                <th>ID </td>
                <th>Name </td>
                <th>Price</td>
                <th>LM</td>
                
            </tr>
                <%
            for (Product product : products){
            %> 
                <tr>
                <td><%=product.getID()%></td>
                    <td><%=product.getName()%></td>
                    <td><%=product.getPrice()%></td>
                    <td><%=product.getLM()%></td>

                </tr> 
                <%
            }  
        %>
        </table>
        <div class="menu">
        <p>Search product by ID:</p>
        <form action="/productByID" method="POST" class="button">
            <input type="number" min=0 step=0.01 name="ID" required="required"></input>
            <button type="submit" >Buscar</button>
            <input name="rolID" value="<%=request.getAttribute("rolID")%>" class="invisible"></input>
        </form>
        <%
        if(request.getAttribute("respuesta")!=null){
            Product product = (Product) request.getAttribute("product");
            Boolean respuesta = (Boolean) request.getAttribute("respuesta");
            if(respuesta){
                %><p>Error, try again.</p><%
            }
            else{
            %>
            <table>
            <tr>
                <th>ID </td>
                <th>Name </td>
                <th>Price</td>
                <th>LM</td>
                
            </tr>
             <tr>
                <td><%=product.getID()%></td>
                    <td><%=product.getName()%></td>
                    <td><%=product.getPrice()%></td>
                    <td><%=product.getLM()%></td>
                </tr> 
            </table>
            <%
            }
        }
        %>
       <form action="/menu" method="POST" class="button">
            <button type="submit" >Menu</button>
            <input name="rolID" value="<%=request.getAttribute("rolID")%>" class="invisible"></input>
        </form>
    </div>
	</body>
</html>	

