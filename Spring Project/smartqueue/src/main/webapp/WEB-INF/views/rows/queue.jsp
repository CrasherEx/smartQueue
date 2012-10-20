<%@ page import="com.omega.smartqueue.model.Restaurant" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.omega.smartqueue.model.Customer" %>
<%@ page import="com.omega.smartqueue.model.CustomerInQueue" %>
<%@ page import="com.omega.smartqueue.enums.UserType" %>
<%@ page import="com.omega.smartqueue.daos.CustomerDAO" %>
<%@ page import="com.omega.smartqueue.daos.RestaurantDAO" %>
<%@ page import="com.omega.smartqueue.daos.QueuesDAO" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="org.springframework.dao.EmptyResultDataAccessException" %>

<div class="row">
	<%
		UserType userType = (UserType) session.getAttribute("userType");
		if(userType == null)
		{
	%>
			<!-- 
			<div class="alert">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Minha Fila:</strong>
				<p>
					É necessário estar logado para poder acessar sua fila.
					<br/>
					Para logar-se acesse nossa <a href="login">página de login</a>.
				</p>
			</div>
			-->
	<%	
		}
		else if(userType == UserType.CUSTOMER)
		{
	%>

			<%
				ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
				QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
				RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
				try
				{
					CustomerInQueue customerInQueue = (CustomerInQueue) queuesDAO.selectByCustomerId((Integer)session.getAttribute("userId"));
					%>
						<div class="span10 offset1">
							<table class="table well">
								<thead>
									<tr>
										<th>
											Nome do Restaurante
										</th>
										<th>
											Posição na Fila:
										</th>
										<th>
											Informações
										</th>
										<th>
											Ações:
										</th>
										<th>
										</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											<%=restaurantDAO.selectById(customerInQueue.getRestaurant_id()).get(0).getName()%>
										</td>
										<td>
											#<%=customerInQueue.getPosition()%>
										</td>
										<td>
											<b>Nome:</b> <%=customerInQueue.getCustomer_name()%>
											<br/>
											<b>Telefone:</b> <%=customerInQueue.getTelephone()%>
											<br/>
											<b>Grupo de </b><%=customerInQueue.getParty()%> pessoa(s)
										</td>
										<td>
											<form action="viewQueue" method="GET">
							     				<input type="hidden" name="restaurantId" value="<%=customerInQueue.getRestaurant_id()%>" /> 
							     				<input type="submit" class="btn" value="Visualizar Fila"/>
							   				</form>
										</td>
										<td>
											<a href="leaveQueue" class="btn btn-danger">Sair da Fila</a>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					<%
				}
				catch(EmptyResultDataAccessException emptyResultDataAccessException)
				{
					%>
						<!--
						<div class="alert">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Minha Fila:</strong>
							<p>
								No momento você não está dentro de nenhuma fila.
								<br/>
								Caso deseje entrar em uma fila, utilize nosso sistema de busca.
							</p>
						</div>
						  -->
					<%
				}
		}
		else if(userType == UserType.RESTAURANT)
		{
	%>
		<!--
		<div class="span8 offset2 well">
			<a href="queueManager" class="btn btn-primary span5 offset1">Acessar Gerenciador de Fila</a>
		</div>
		  -->
	<%
		}
	%>
</div>