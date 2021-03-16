<%@page import="com.distribuida.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
	Book book = (Book) request.getAttribute("book");
%>


	<form action="/tarea_cliente_quarkus/books" method="post">
		<input type="hidden" name="method" value="store" />
		<input type="hidden" name="id"  />
		<label>
		title
		<input type="text" name="title" />
		</label>
		<label>
		ISBN
		<input type="text" name="isbn" />
		</label>
		<label>
		Autor
		<input type="number" name="author_id" />
		</label>
		
		<input type="submit" value="Crear">
	</form>






</body>
</html>
