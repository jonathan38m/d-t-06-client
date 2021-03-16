<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.distribuida.model.Author"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Los autores son: </h2>
<%
    List<Author> authors = (List<Author>) request.getAttribute("authors");
%>

<table border="1">
    <tr>
        <td>Id</td>
        <td>Nombre</td>
        <td>Apellidos</td>
        <td>Promedio</td>
    </tr>
    <%
        for (Author author: authors)
        {
    %>
    <tr valign="top">
        <td><%=author.getId() %></td>
        <td><%=author.getName() %></td>
        <td><%=author.getAge() %></td>
        <td><%=author.getGenre() %></td>
        <td>
			<form action="/tarea_cliente_quarkus/" method="post">
				<input type="hidden" name="method" value="show" />
				<input type="hidden" name="id" value="<%=author.getId() %>" />
				<input type="submit" value="ver">
			</form>
			<form action="/tarea_cliente_quarkus/" method="post">
				<input type="hidden" name="method" value="delete" />
				<input type="hidden" name="id" value="<%=author.getId() %>" />
				<input type="submit" value="Eliminar">
			</form>
			<form action="/tarea_cliente_quarkus/" method="post">
				<input type="hidden" name="method" value="edit" />
				<input type="hidden" name="id" value="<%=author.getId() %>" />
				<input type="submit" value="Actualizar">
			</form>
			<form action="/tarea_cliente_quarkus/" method="post">
				<input type="hidden" name="method" value="getbooks" />
				<input type="hidden" name="id" value="<%=author.getId() %>" />
				<input type="submit" value="Libros">
			</form>
		</td>
    </tr>

    <% } %>


</table>

<form action="/tarea_cliente_quarkus/" method="post">
	<input type="hidden" name="method" value="create" />
	<input type="submit" value="Crear">
</form>
<a href="/tarea_cliente_quarkus/books">Libros</a>

</body>
</html>
