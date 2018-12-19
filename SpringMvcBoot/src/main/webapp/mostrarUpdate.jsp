<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>mostrar la update</h1>
<form:form modelAttribute="alumno" method="POST" action="guardar">
	<form:hidden path="id"/>
	<table>
		<tr><td>Nombre</td><td><form:input path="nombre"/></td></tr>
		<tr><td>Apellido</td><td><form:input path="apellido"/></td></tr>
		<tr><td>Edad</td><td><form:input path="edad"/></td></tr>
		<tr><td>Genero</td><td><form:input path="sexo"/></td></tr>
		<tr><td>Fecha</td>
		
		<td><fmt:formatDate value="${alumno.fecha}" pattern="dd/MM/yyyy" var="fecha"/>
		<form:input path="fecha" value="${fecha}"/></td></tr>
		
		<tr><td>Codigo padre</td><td><form:select path="codigoPadre.id" items="${listap}" 
		itemLabel="nombre" itemValue="id"/></td></tr>

		<tr><td>Codigo profesor</td><td><form:select path="codigoProfesor.id" items="${listaf}" 
		itemLabel="id" itemValue="id"/></td></tr>
		
		
		<tr><td><input type="submit" value="Guardar"/></td></tr>
    </table>
</form:form>
</body>
</html>