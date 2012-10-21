<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.omega.smartqueue.model.Customer" %>
<%@ page import="com.omega.smartqueue.model.Restaurant" %>
<%@ page import="com.omega.smartqueue.model.CustomerInQueue" %>
<%@ page import="com.omega.smartqueue.enums.UserType" %>
<%@ page import="com.omega.smartqueue.daos.CustomerDAO" %>
<%@ page import="com.omega.smartqueue.daos.RestaurantDAO" %>
<%@ page import="com.omega.smartqueue.daos.QueuesDAO" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="/WEB-INF/views/includes/css.jsp" />
		<jsp:include page="/WEB-INF/views/includes/icon.jsp" />
		<title>Confirm Join Queue</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/bars/top/main.jsp" />
		<div class="container">
			<jsp:include page="/WEB-INF/views/rows/queue.jsp" />
			
			<%
				Restaurant restaurant = (Restaurant) request.getAttribute("restaurant");
				
				ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
				QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
				ArrayList<CustomerInQueue> queue = (ArrayList<CustomerInQueue>) queuesDAO.selectCustomersInQueue(restaurant.getRestaurant_id());
			%>
			<div class="row">
				<div class="span10 offset1 well">
					<legend>
						<h3>
							Geral:
						</h3>
					</legend>
					<h4>
						<%=restaurant.getName()%>
					</h4>
					<table class="table table-striped well">
						<thead>
							<tr>
								<th>
									Nome do Restaurante
								</th>
								<th>
									Total de Grupos na Fila
								</th>
								<th>
									Total de Pessoas na Fila
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><%=restaurant.getName()%></td>
								<td><%=queue.size()%></td>
								<%
									int numberOfcustomersInQueue = 0;
									for(CustomerInQueue customerInQueue:queue)
									{
										numberOfcustomersInQueue += customerInQueue.getParty();
									}
								%>
								<td><%=numberOfcustomersInQueue%></td>
							</tr>
						</tbody>
					</table>
				</div>	
			</div>
			<div class="row">
				<div class="span10 offset1 well">
					<legend>
						<h3>
							Fila do Restaurante:
						</h3>
					</legend>
					<%
						if(queue.size() > 0)
						{
					%>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Posição na Fila</th>
									<th>Nome</th>
									<th>Número de Pessoas</th>
								</tr>
							</thead>
							<tbody>
							<%
						
									for(int customerIndexInQueue = 0;customerIndexInQueue<queue.size();customerIndexInQueue++)
									{
										CustomerInQueue customerInQueue = queue.get(customerIndexInQueue);
										int position = customerIndexInQueue+1;
							%>
										<%
											String rowClass = "";
											if(session.getAttribute("userId") != null)
											{
												if( (Integer) session.getAttribute("userId") == customerInQueue.getCustomer_id())
												{
													rowClass = "success";
												}		
											}
										%>
										<tr class="<%=rowClass%>">
											<td>
												#<%=position%>
												<%
													if(rowClass.equals("success"))
													{
														out.print(" (você)");
													}
												%>
											</td>
											<td>
												<%=customerInQueue.getCustomer_name()%>
											</td>
											<td>
												<%=customerInQueue.getParty()%> pessoa(s)
											</td>
										</tr>
								<%
										}
								%>
							</tbody>
						</table>
					<%
						}
						else
						{
					%>
							<div class="alert alert-info">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Aviso!</strong>
								<br/>
								A fila do restaurante encontra-se vazia.
							</div>
							
							<h5>
								Não há nenhum cliente na fila do restaurante selecionado.
							</h5>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/bars/bottom/main.jsp" />
		<jsp:include page="/WEB-INF/views/includes/js.jsp" />
	</body>
</html>