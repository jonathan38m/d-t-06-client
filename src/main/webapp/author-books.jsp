<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.distribuida.model.Book"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Los autores son: </h2>
<%
   List<Book> books = (List<Book>) request.getAttribute("books");
%>

<table border="1">
    <tr>
        <td>Id</td>
        <td>Autor id</td>
        <td>ISBN</td>
        <td>Title</td>
        <td></td>
    </tr>
    <%
        for (Book book: books)
        {
    %>
    <tr valign="top">
        <td><%=book.getId() %></td>
        <td><%=book.getAuthor_id() %></td>
        <td><%=book.getIsbn() %></td>
        <td><%=book.getTitle() %></td>
        <td>
			<form action="/tarea_cliente_quarkus/books" method="post">
				<input type="hidden" name="method" value="show" />
				<input type="hidden" name="id" value="<%=book.getId() %>" />
				<input type="submit" value="ver">
			</form>
			<form action="/tarea_cliente_quarkus/books" method="post">
				<input type="hidden" name="method" value="delete" />
				<input type="hidden" name="id" value="<%=book.getId() %>" />
				<input type="submit" value="Eliminar">
			</form>
			<form action="/tarea_cliente_quarkus/books" method="post">
				<input type="hidden" name="method" value="edit" />
				<input type="hidden" name="id" value="<%=book.getId() %>" />
				<input type="submit" value="Actualizar">
			</form>
		</td>
    </tr>

    <% } %>


</table>


</body>
</html>
