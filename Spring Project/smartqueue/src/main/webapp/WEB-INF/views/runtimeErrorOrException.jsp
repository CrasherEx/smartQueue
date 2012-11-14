<%@ page import="java.util.ArrayList" %>
<%@page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/views/includes/css.jsp" />
		<jsp:include page="/WEB-INF/views/includes/icon.jsp" />
		<title>Erro</title>
	</head>
	<body>
	
			
		<div class="navbar navbar-top">
			<div class="navbar-inner">
				<div class="container">
					<div class="logo brand">
						<a href="home">
							<img src="${pageContext.request.contextPath}/resources/images/logo/smartqueue.png" />
						</a>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<jsp:include page="/WEB-INF/views/rows/queue.jsp" />
			<div class="row">
				<div class="span10 well offset1">
					<h3>
						Erro
					</h3>
					<p>
						Um erro inesperado ocorreu.
						<br/>
						Por favor, acesse esse serviço novamente mais tarde.
						<br/>
						Contacte nosso SAC se esse problema persistir.
						
					</p>
					<a class="btn btn-primary" href="home">Voltar à Página Inicial</a>
				</div>
			</div>
		</div>
	</body>
</html>