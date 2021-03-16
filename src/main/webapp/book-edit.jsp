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
		<input type="hidden" name="method" value="put" />
		<input type="hidden" name="id" value="<%=book.getId() %>" />
		<label>
		title
		<input type="text" name="title" value="<%=book.getTitle() %>" />
		</label>
		<label>
		Genero
		<input type="text" name="isbn" value="<%=book.getIsbn() %>" />
		</label>
		<label>
		Autor
		<input type="number" name="author_id" value="<%=book.getAuthor_id() %>" />
		</label>
		
		<input type="submit" value="Actualizar">
	</form>






</body>
</html>
