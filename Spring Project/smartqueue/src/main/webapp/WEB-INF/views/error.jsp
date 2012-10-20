<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/views/includes/css.jsp" />
		<jsp:include page="/WEB-INF/views/includes/icon.jsp" />
		<title>Login</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/bars/top/main.jsp" />
		<div class="container">
			<jsp:include page="/WEB-INF/views/rows/queue.jsp" />
			<div class="row">
				<div class="span10 well offset1">
					<legend>
						<h2>
							Erro!
						</h2>
					</legend>
					<%
						ArrayList<String> errorMessages = (ArrayList<String>) request.getAttribute("errorMessages");
						if(errorMessages != null)
						{
					%>
						<div class="alert alert-error">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Erro!</strong>
							<br/>
							<%
								for(String errorMessage:errorMessages)
								{
									out.print("- " + errorMessage + "<br/>");
								}	
							%>
						</div>
					<%
						}
					%>
					<p>
						Um erro foi encontrado.
						<br/>
						Caso necessite de ajuda, entre em contato com o SAC.
					</p>
					<a class="btn btn-primary" href="home">Voltar à Página Inicial</a>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/bars/bottom/main.jsp" />
		<jsp:include page="/WEB-INF/views/includes/js.jsp" />
	</body>
</html>