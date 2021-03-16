<%@page import="java.util.ArrayList"%>
<%@page import="com.distribuida.model.Author"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


	<form action="/tarea_cliente_quarkus/" method="post">
		<input type="hidden" name="method" value="store" />
		<input type="hidden" name="id" required="required" />
		<label>
		Nombre
		<input type="text" name="name" required="required" />
		</label>
		<label>
		Genero
		<input type="text" name="gender" required="required" />
		</label>
		<label>
		Edad
		<input type="number" name="age" required="required" />
		</label>
		
		<input type="submit" value="Crear">
	</form>






</body>
</html>
