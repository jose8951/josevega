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
table, th, td {border: 1px solid black; border-collapse: collapse;}
</style>
</head>
<body>

<table>
	<tr>
	<th  colspan="7"><spring:message code="listauno.titulo" /></th>
	</tr>
	<tr>
	<th><spring:message code="listauno.id" /></th>
	<th><spring:message code="listauno.nombre" /></th>
	<th><spring:message code="listauno.apellido" /></th>
	<th><spring:message code="listauno.edad" /></th>
	<th><spring:message code="listauno.sexo" /></th>
	<th><spring:message code="listauno.codigoProfesor" /></th>
	<th><spring:message code="listauno.codigoPadre" /></th>
	</tr>
	<c:forEach items="${lista}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.nombre}
			<td>${item.apellido }</td>
			<td>${item.edad}</td>
			<td>${item.sexo}</td>
			<td>${item.codigoProfesor.id}</td>
			<td>${item.codigoPadre.id }</td>
		</tr>	
	</c:forEach>
</table>
<br>
<a href="formDentro.jsp">inicio</a>

</body>
</html>