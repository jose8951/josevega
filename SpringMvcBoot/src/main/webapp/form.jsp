<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name" /></title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	width: 220px;
}
</style>
</head>
<body>
	
	<form:form modelAttribute="alumno" method="POST" action="guardar">
		
		<table>
		
		<tr>
		<td  colspan="2"><h3><spring:message code="form.titulo" /></h3></td>
		</tr>
			<tr>
				<td><spring:message code="form.nombre" /></td>
				<td><form:input path="nombre" /></td>
				

			</tr>
			<tr>
				<td><spring:message code="form.apellido" /></td>
				<td><form:input path="apellido" /></td>

			</tr>
			<tr>
				<td><spring:message code="form.edad" /></td>
				<td><form:input path="edad" /></td>

			</tr>
			<tr>
				<td><form:radiobutton path="sexo" value="niño" /> <spring:message code="form.genero.niño" /></td>
				<td><form:radiobutton path="sexo" value="niña" /> <spring:message code="form.genero.niña" /></td>
			</tr>

			<tr>
				<td><spring:message code="form.fecha" /></td>
				<td><fmt:formatDate value="${alumno.fecha}" pattern="dd/MM/yyyy" var="fecha" />
				<form:input path="fecha" value="${fecha}" type="date" /></td>
				
			</tr>
			<tr>
				<td><spring:message code="form.padres" /></td>
				<td><form:select path="codigoPadre.id" items="${listaPadre}"
						itemLabel="nombre" itemValue="id" /></td>
			</tr>
			<tr>
			<td><spring:message code="form.curso" /></td>
			<td><form:select path="codigoProfesor.id"
					items="${listaProfesor}" itemLabel="id" itemValue="id" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="<spring:message code="accion.guardar" />"></td>
				<td></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br> ${msg}
	<br>

	<a href="formDentro.jsp"><spring:message code="accion.inicio" /></a>
	
	
</body>
</html>