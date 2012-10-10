<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.omega.smartqueue.model.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="/WEB-INF/views/includes/css.jsp" />
		<jsp:include page="/WEB-INF/views/includes/icon.jsp" />
		<title>Usuários Registrados</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/bars/top/main.jsp" />
		<div class="container">
			<div class="row">
				<div class="span8 well offset2">
						<legend>
							<h2>
								Usuários Registrados
							</h2>
						</legend>
						<%
							ArrayList<Customer> customers = (ArrayList<Customer>) request.getAttribute("customers");
							if(customers != null)
							{
								for(Customer customer:customers)
								{
									%>
										<div class="span6 well">
											<b>E-mail: </b> <%=customer.getEmail()%>
											<br/>
											<b>Senha: </b> <%=customer.getPassword()%>
											<br/>
											<b>Nome: </b> <%=customer.getName()%>
											<br/>
											<b>Sobrenome: </b> <%=customer.getLastName()%>
											<br/>
											<b>Sexo: </b> <%=customer.getGender().toString()%>
											<br/>
											<b>Data de Nascimento: </b> <%=customer.getDateOfBirth().toString()%>
											<br/>
											<b>Telefone: </b> <%=customer.getTelephone()%>
											<br/>
											<b>Endereço: </b> <%=customer.getAddress()%>
											<br/>
											<b>Estado: </b> <%=customer.getState()%>
											<br/>
											<b>Cidade: </b> <%=customer.getCity()%>
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
