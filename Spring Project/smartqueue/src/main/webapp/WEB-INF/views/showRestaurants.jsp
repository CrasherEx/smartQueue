<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.omega.smartqueue.model.Restaurant" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="/WEB-INF/views/includes/css.jsp" />
		<jsp:include page="/WEB-INF/views/includes/icon.jsp" />
		<title>Restaurantes Registrados</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/bars/top/main.jsp" />
		<div class="container">
			<div class="row">
				<div class="span8 well offset2">
						<legend>
							<h2>
								Restaurantes Registrados
							</h2>
						</legend>
						<%
							ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) request.getAttribute("restaurants");
							if(restaurants != null)
							{
								for(Restaurant restaurant:restaurants)
								{
									%>
										<div class="span6 well">
											<b>Nome: </b> <%=restaurant.getName()%>
											<br/>
											<b>E-mail: </b> <%=restaurant.getEmail()%>
											<br/>
											<b>Senha: </b> <%=restaurant.getPassword()%>
											<br/>
											<b>Telefone: </b> <%=restaurant.getTelephone()%>
											<br/>
											<b>Endereço: </b> <%=restaurant.getAddress()%>
											<br/>
											<b>Estado: </b> <%=restaurant.getState()%>
											<br/>
											<b>Cidade: </b> <%=restaurant.getCity()%>
										</div>
									<%
								}
							}
						%>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/js.jsp" />
	</body>
</html>
