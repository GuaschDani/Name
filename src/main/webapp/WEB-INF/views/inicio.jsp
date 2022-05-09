
<html lang = "es">
	<head>
		<meta charset = "utf-8">
        <link rel="stylesheet" type= "text/css" href="CSS/style.css"></link>
	</head>
	<body>
    <h2>Menu</h2>
    <p>---------------------------------</p>
    <div class="inicio" >
    <form action="/read" method="POST" class="button">
            <button type="submit" >Read</button>
            <input name="rolID" class="invisible" value="<%=request.getAttribute("rolID")%>"></p>
        </form>
      
    <% Integer rolID = (Integer) request.getAttribute("rolID");
        if (rolID == 2 || rolID == 3){  %>   
        <form action="/update" method="POST" class="button">
            <button type="submit" >Update</button>
            <input name="rolID" class="invisible" value="<%=request.getAttribute("rolID")%>"></p>
        </form>
    <%}%>
    <% if (rolID == 3){ %>
        <form action="/create" method="POST" class="button">
            <button type="submit" >Create</button>
            <input name="rolID" class="invisible" value="<%=request.getAttribute("rolID")%>"></p>
        </form>
        <form action="/delete" method="POST" class="button">
            <button type="submit" >Delete</button>
            <input name="rolID" class="invisible" value="<%=request.getAttribute("rolID")%>"></p>
        </form>
    <%}%>
    <a href="/">Log out</a>    
    </div>
	</body>
</html>	

