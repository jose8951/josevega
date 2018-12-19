<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
</head>
<body>
<h1>listado de alumnos</h1>
<table>
	<tr>
	<th>id</th>
	<th>nombre</th>
	<th>apellido</th>
	<th>edad</th>
	<th>sexo</th>
	<th>Curso del profesor</th>
	<th>Apellido del padre</th>
	</tr>
	<c:forEach items="${lista}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.nombre }</td>
			<td>${item.apellido }</td>
			<td>${item.edad}</td>
			<td>${item.sexo }</td>
			<td>${item.codigoProfesor.id}</td>
			<td>${item.codigoPadre.nombre}</td>
		</tr>
	
	</c:forEach>
</table>
<a href="formDentro.jsp">inicio</a>

</body>
</html>