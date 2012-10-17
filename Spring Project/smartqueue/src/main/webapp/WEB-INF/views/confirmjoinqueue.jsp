<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="/WEB-INF/views/includes/css.jsp" />
		<jsp:include page="/WEB-INF/views/includes/icon.jsp" />
		<title>Confirm Join Queue</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/bars/top/main.jsp" />
		<form action="joinqueue" method="post">
			Nome: <input type="text" name="name" value=<%=request.getAttribute("customerName")%>/>
			Telefone: <input type="text" name="telephone" value=<%=request.getAttribute("customerTel") %>/>
			Número de pessoas: <input type="text" name="party">
			<input type="submit" class="btn btn-primary" value="Confirmar"/>
			<a class="btn" href="home">Cancelar</a>
			
		</form>
	</body>
</html>