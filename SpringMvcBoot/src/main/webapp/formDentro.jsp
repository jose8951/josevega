<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

	<span><spring:message code="usuario.registrado" /></span>${usuario.username}<br>
	<br>
	<table>
		<tr>
			<td></td>
			<td><spring:message code="formDentro.titulo" /></td>
			<td></td>
		</tr>
		<tr>
			<td><a href="guardar"><spring:message code="accion.guardar" /></a></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td><a href="listar"><spring:message code="accion.listar" /></a></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<form action="buscar" method="GEST">
			<td><spring:message code="formDentro.buscar" /></td>
			<td><input type="text" name="apellido" ></td>
			<td><input type="submit" value="<spring:message code="usuario.enviar" />"></td>
				</form>
			
		</tr>
		<tr>
			<form action="listaAborrar" method="GEST">
			<td><spring:message code="formDentro.borrar" /></td>
			<td><input type="text" name="apellido"></td>
			<td><input type="submit" value="<spring:message code="usuario.enviar" />"></td>
				</form>
		</tr>
		<tr>
			<form action="listaUpdate" method="GEST">
				<td><spring:message code="formDentro.actualizar" /></td>
				<td><input type="text" name="apellido" ></td>
				<td><input type="submit" value="<spring:message code="usuario.enviar" />"></td>
			</form>
		</tr>
		<tr>
			<td><a href="inicio?lang=es"><spring:message
						code="idioma.es" /></a> <a href="inicio?lang=en"><spring:message
						code="idioma.en" /></a></td>
			<td></td>
			<td></td>

		</tr>
	</table>
	<br>${msg}<br>
	<br>
	<a href="index.jsp"><spring:message code="accion.salir" /></a>
</body>
</html>
