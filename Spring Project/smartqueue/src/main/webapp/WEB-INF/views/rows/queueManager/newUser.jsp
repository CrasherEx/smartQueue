<%@ page import="com.omega.smartqueue.enums.UserType" %>
<%@ page import="com.omega.smartqueue.daos.CustomerDAO" %>
<%@ page import="com.omega.smartqueue.daos.RestaurantDAO" %>
<%@ page import="com.omega.smartqueue.model.Customer" %>
<%@ page import="com.omega.smartqueue.model.Restaurant" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.ArrayList" %>

<div class="span5 well">
	<form action="addUserToQueue" method="post" class="form-horizontal">
		<%
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
			RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
			ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) restaurantDAO.selectById((Integer)session.getAttribute("userId"));
			Restaurant restaurant = restaurantList.get(0);
		%>
		<legend>
			<h3>
				Adicionar um Cliente à Fila:
			</h3>
		</legend>
	   			
	   	<input type="hidden" name="restaurant" value="<%=restaurant.getRestaurant_id()%>" />
	  			
		<div class="control-group">
			<label class="control-label" for="inputEmail">
				Nome:
			</label>
			<div class="controls">
				<input type="text" name="name" />
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputEmail">
				Telefone:
			</label>
			<div class="controls">
				<input type="text" name="telephone" />
			</div>
		</div>
			
		<div class="control-group">
			<label class="control-label" for="inputEmail">
				Número de Pessoas:
			</label>
			<div class="controls">
				<input type="number" min="1" name="party" />
			</div>
		</div>
		
		<div class="control-group">
			<div class="controls">
				<input type="submit" class="btn btn-primary" value="Adicionar Cliente"/>
				<a class="btn" href="home">Cancelar</a>
			</div>
		</div>
	</form>
</div>