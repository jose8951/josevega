<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name" /></title>
<style>
	table,th,td{border:1px solid black; border-collapse:collapse;}
	td{width:150px;}
</style>
</head>
<body>


<table>
	<tr>
	<th colspan="8"><spring:message code="listaBorrado.titulo" /></th>
	</tr>
	<tr>
	<th><spring:message code="listauno.nombre" /></th>
	<th><spring:message code="listauno.apellido" /></th>
	<th><spring:message code="listauno.edad" /></th>
	<th><spring:message code="listauno.sexo" /></th>
	<th><spring:message code="form.fecha" /></th>
	<th><spring:message code="listauno.codigoPadre" /></th>
	<th><spring:message code="form.curso" /></th>
	<th><spring:message code="accion.eliminar" /></th>
	</tr>
	<c:forEach items="${lista}" var="item">
		<tr>
		<td>${item.nombre}</td>
		<td>${item.apellido}</td>
		<td>${item.edad}</td>
		<td>${item.sexo}</td>
		<td>${item.fecha}</td>
		<td>${item.codigoPadre.nombre}</td>
		<td>${item.codigoProfesor.id}</td>
		<td><a href="borrar?id=${item.id}"><spring:message code="accion.eliminar" /></a>
		
		</tr>
	</c:forEach>

</table>
<br>
<a href="formDentro.jsp">inicio</a>
</body>
</html>