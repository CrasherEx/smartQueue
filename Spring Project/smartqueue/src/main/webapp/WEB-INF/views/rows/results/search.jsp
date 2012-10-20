<%@ page import="java.util.ArrayList" %>
<%@ page import="com.omega.smartqueue.enums.UserType" %>
<%@ page import="com.omega.smartqueue.daos.CustomerDAO" %>
<%@ page import="com.omega.smartqueue.daos.RestaurantDAO" %>
<%@ page import="com.omega.smartqueue.daos.QueuesDAO" %>
<%@ page import="com.omega.smartqueue.model.Customer" %>
<%@ page import="com.omega.smartqueue.model.Restaurant" %>
<%@ page import="com.omega.smartqueue.model.CustomerInQueue" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.springframework.dao.EmptyResultDataAccessException" %>

<div class="span10 offset1 well">
	<legend>
		<h2>
			Resultados:
		</h2>
	</legend>
	<%
		ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) request.getAttribute("restaurants");
		if (restaurants == null)
		{
	%>
			<img class="span5 offset2" src="${pageContext.request.contextPath}/resources/images/search/empty.png" />
	<%
		}
		else if (restaurants.isEmpty())
		{
	%>
		<img class="span5 offset2" src="${pageContext.request.contextPath}/resources/images/search/notFound.png" />
		<%
		}
		else
		{
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
			QueuesDAO queuesDAO = (QueuesDAO) context.getBean("QueuesDAO");
			
	%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Restaurante</th>
					<th>Cidade</th>
					<th>Estado</th>
					<th>Tamanho da Fila</th>
					<th>Ações</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
	<%
	
			for(Restaurant restaurant:restaurants)
			{
				ArrayList<CustomerInQueue> customerList = (ArrayList<CustomerInQueue>) queuesDAO.selectCustomersInQueue(restaurant.getRestaurant_id());
	%>
			<%
				String rowClass = "";
			 	if(session.getAttribute("userType") != null)
			 	{
			 		if(session.getAttribute("userType") == UserType.CUSTOMER)
			 		{
				 		try
				 		{
				 			CustomerInQueue customerInQueue = (CustomerInQueue) queuesDAO.selectByCustomerId((Integer)session.getAttribute("userId"));
				 			if (customerInQueue.getRestaurant_id() == restaurant.getRestaurant_id())
				 			{
				 				rowClass = "success";
				 			}
				 		}
				 		catch(EmptyResultDataAccessException emptyResultDataAccessException)
				 		{
				 		}
			 		}
			 	}
			%>
			<tr class="<%=rowClass%>">
				<td><%=restaurant.getName()%></td>
				<td><%=restaurant.getCity()%></td>
				<td><%=restaurant.getState()%></td>
				
				<%
					int numberOfCustomersInQueue = 0;
					for(int i=0;i<customerList.size();i++)
					{
						numberOfCustomersInQueue += customerList.get(i).getParty();
					}
				%>
				<td><%=customerList.size()%> grupo(s) / <%=numberOfCustomersInQueue%> pessoa(s) no total </td>
				
				 <%
				 	if(session.getAttribute("userType") == null)
				 	{
				 %>
				 	<td>
						<form action="viewQueue" method="GET">
		     				<input type="hidden" name="restaurantId" value="<%=restaurant.getRestaurant_id()%>" /> 
		     				<input type="submit" class="btn" value="Visualizar Fila"/>
		   				</form>
	   				</td>
				 	<td>
						<a href="login" class="btn btn-primary"><i class="icon-off icon-white"></i> Login </a>
	   				</td>
					<td></td>
				 <%
					 }
				 	else if(session.getAttribute("userType") == UserType.RESTAURANT)
				 	{
				 %>
				 	<td>
						<form action="viewQueue" method="GET">
		     				<input type="hidden" name="restaurantId" value="<%=restaurant.getRestaurant_id()%>" /> 
		     				<input type="submit" class="btn" value="Visualizar Fila"/>
		   				</form>
		   			</td>
					<td></td>
					<td></td>
				 <%
				 	}
				 	else if(session.getAttribute("userType") == UserType.CUSTOMER)
				 	{
				 		try
				 		{
				 			CustomerInQueue customerInQueue = (CustomerInQueue) queuesDAO.selectByCustomerId((Integer)session.getAttribute("userId"));
				 			%>
				 				<td>
					 				<div>
										<form action="viewQueue" method="GET">
						     				<input type="hidden" name="restaurantId" value="<%=restaurant.getRestaurant_id()%>" /> 
						     				<input type="submit" class="btn" value="Visualizar Fila"/>
						   				</form>
					   				</div>
				   				</td>
				   			<%
				   				if(customerInQueue.getRestaurant_id() == restaurant.getRestaurant_id())
				   				{
				   			%>
				   				<td>
									<a href="leaveQueue" class="btn btn-danger">Sair da Fila</a>
				   				</td>
				   				<td>
				   					<b>
				   						( Você está nessa Fila )
				   					</b>
				   				</td>
				   			<%
				   				}
				   				else
				   				{
				   					%>
				   						<td></td>
				   						<td></td>
				   					<%
				   				}
				 		}
				 		catch(EmptyResultDataAccessException emptyResultDataAccessException)
				 		{
				 			%>
				 				<td>
									<form action="viewQueue" method="GET">
					     				<input type="hidden" name="restaurantId" value="<%=restaurant.getRestaurant_id()%>" /> 
					     				<input type="submit" class="btn" value="Visualizar Fila"/>
					   				</form>
				   				</td>
				 				<td>
									<form action="confirmjoinqueue" method="GET">
					     				<input type="hidden" name="restaurant" value="<%=restaurant.getRestaurant_id()%>" /> 
					     				<input type="submit" class="btn btn-primary" value="Entrar na Fila"/>
					   				</form>
				   				</td>
				   				<td></td>
				 			<%
				 		}
				 %>
				 
				 <%
				 	}
				 %>

			</tr>
	<%
			} 
	%>
			</tbody>
		</table>
	<%
		}
	%>			
</div>