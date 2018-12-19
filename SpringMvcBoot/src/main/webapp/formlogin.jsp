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
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="login">
			<div class="container">
				<div id="login-row"
					class="row justify-content-center align-items-center">
					<div id="login-column" class="col-md-6">
						<div class="login-box col-md-12">
							<form:form id="login-form" class="form" modelAttribute="usuario"
								method="POST" action="login">
								<h3 class="text-center text-info">Login</h3>
								<div class="form-group">
									<label for="username" class="text-info"><spring:message
											code="usuario.login" var="labUsuario" /></label>
									<form:input path="username" id="username" class="form-control"
										placeholder="${labUsuario}" />
									<form:errors path="username" cssClass="error" />
								</div>
								<div class="form-group">
									<label for="password" class="text-info"><spring:message
											code="usuario.password" var="labClave" /></label>
									<form:password path="password" id="password"
										class="form-control" placeholder="${labClave}" />
									<form:errors path="password" cssClass="error" />
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-info btn-md"
										value="<spring:message code="usuario.enviar" />" />
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>


