<%@page import="java.util.ArrayList"%>
<%@page import="com.distribuida.model.Author"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Author author = (Author) request.getAttribute("author");
%>


	<form action="/tarea_cliente_quarkus/" method="post">
		<input type="hidden" name="method" value="put" />
		<input type="hidden" name="id" value="<%=author.getId() %>" />
		<label>
		Nombre
		<input type="text" name="name" value="<%=author.getName() %>" />
		</label>
		<label>
		Genero
		<input type="text" name="gender" value="<%=author.getGenre() %>" />
		</label>
		<label>
		Edad
		<input type="number" name="age" value="<%=author.getAge() %>" />
		</label>
		
		<input type="submit" value="Actualizar">
	</form>






</body>
</html>
