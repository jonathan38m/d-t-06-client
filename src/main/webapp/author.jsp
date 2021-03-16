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
   Author author = (Author) request.getAttribute("author");
%>

<table border="1">
    <tr>
        <td>Id</td>
        <td>Nombre</td>
        <td>Apellidos</td>
        <td>Promedio</td>
    </tr>
    <tr valign="top">
        <td><%=author.getId() %></td>
        <td><%=author.getName() %></td>
        <td><%=author.getAge() %></td>
        <td><%=author.getGenre() %></td>
        <td>
		</td>
    </tr>


</table>

</body>
</html>
