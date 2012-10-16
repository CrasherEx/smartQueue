<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/views/includes/css.jsp" />
		<jsp:include page="/WEB-INF/views/includes/icon.jsp" />
		<title>Registro de Restaurante</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/bars/top/main.jsp" />
		<div class="container">
			<jsp:include page="/WEB-INF/views/rows/register/restaurant/form.jsp" />
		</div>
		<jsp:include page="/WEB-INF/views/includes/js.jsp" />
	</body>
</html>