<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.omega.smartqueue.model.CustomerInQueue" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="/WEB-INF/views/includes/css.jsp" />
		<jsp:include page="/WEB-INF/views/includes/icon.jsp" />
		<title>Filas</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/bars/top/main.jsp" />
		<div class="container">
			<div class="row">
				<div class="span8 well offset2">
						<legend>
							<h2>
								Filas
							</h2>
						</legend>
						<%
							ArrayList<ArrayList<CustomerInQueue>> queues = (ArrayList<ArrayList<CustomerInQueue>>) request.getAttribute("queues");
							ArrayList<String> restaurantNames = (ArrayList<String>) request.getAttribute("restaurantNames");
							if(queues != null)
							{
								for(int i=0;i<queues.size();i++)
								{
									ArrayList<CustomerInQueue> queue = queues.get(i);
									%>
										<div class="span6 well">
											<h3><%=restaurantNames.get(i)%></h3>
											
											<%
											for(CustomerInQueue customerInQueue:queue)
											{
											%>
												<div class="well">
													<h5>
														<b>Posição: </b>#<%=customerInQueue.getPosition()%>
													</h5>
													<hr/>
													<br/>										
													<b>Nome: </b><%=customerInQueue.getCustomer_name()%>
													<br/>		
													<b>Telefone: </b><%=customerInQueue.getTelephone()%>
													<br/>	
													<b>Grupo de: </b><%=customerInQueue.getParty()%>
													<br/>
													<b>Id do Usuário Registrado: </b><%=customerInQueue.getCustomer_id()%>
													<br/>
													
													<form action="removeCustomerFromQueue" method="post">
     													<input type="hidden" name="id" value="<%=customerInQueue.getCustomer_in_queue_id()%>" />
														<input type="submit" class="btn btn-danger" value="Remover da Fila"/>
													</form>
										
												</div>
											<%
												}
											%>
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
