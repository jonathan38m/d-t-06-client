<%@page import="com.distribuida.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.distribuida.model.Book"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Detalles del libro </h2>
<%
   Book book = (Book) request.getAttribute("book");
%>

<table border="1">
    <tr>
        <td>Id</td>
        <td>ISBN</td>
        <td>Nombre</td>
        <td>Author Id</td>
    </tr>
    <tr valign="top">
        <td><%=book.getId() %></td>
        <td><%=book.getIsbn() %></td>
        <td><%=book.getTitle() %></td>
        <td><%=book.getAuthor_id() %></td>
    </tr>


</table>

</body>
</html>
