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
<title>Insert title here</title>
<style>
	table,th,td{border:1px solid black; border-collapse:collapse;}
	td{width:110px;}
</style>
</head>
<body>
<h1>lista de alumno a Actualizar</h1>
<table>
	<tr>
		<td>nombre</td>
		<td>apellido</td>
		<td>edad</td>
		<td>sexo</td>
		<td>fecha</td>
		<td>codigo padre</td>
		<td>codigo profesor</td>	
		<td>Actualizar</td>	
	</tr>
	<c:forEach items="${lista}" var="item">
		<tr>
		<td>${item.nombre}</td>
		<td>${item.apellido}</td>
		<td>${item.edad}</td>
		<td>${item.sexo}</td>
		<td>${item.fecha}</td>
		<td>${item.codigoPadre.nombre}</td>
		<td>${item.codigoProfesor.nombre}</td>
		<td><a href="buscarUpdate?id=${item.id}">Actualizar</a>
		
		</tr>
	</c:forEach>
</table>

<a href="formDentro.jsp">inicio</a>
</body>
</html>