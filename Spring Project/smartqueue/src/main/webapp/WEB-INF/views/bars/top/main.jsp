<%@ page import="com.omega.smartqueue.enums.UserType" %>
<%@ page import="com.omega.smartqueue.daos.CustomerDAO" %>
<%@ page import="com.omega.smartqueue.daos.RestaurantDAO" %>
<%@ page import="com.omega.smartqueue.model.Customer" %>
<%@ page import="com.omega.smartqueue.model.Restaurant" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.ArrayList" %>


<div class="navbar navbar-top">
	<div class="navbar-inner">
		<div class="container">
			<div class="logo brand">
				<a href="home">
					<img src="${pageContext.request.contextPath}/resources/images/logo/smartqueue.png" />
				</a>
			</div>
			
			<%
				session = request.getSession();
				if(session.getAttribute("userId") == null)
				{
			%>
				
				<div class="btn-group pull-right">
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<i class="icon-th-large"></i> Mais Opções <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="restaurantRegister">Registro de Restaurantes</a></li>
					</ul>
				</div>
				
				<div class="btn-group pull-right">
					<a class="btn" href="register">
						<i class="icon-pencil "></i> Registrar
					</a>
				</div>
				
				<div class="btn-group pull-right">	
					<a class="btn btn-primary" href="login">
						<i class="icon-off icon-white"></i> Login
					</a>
				</div>
			<%
				}
				else
				{
					if(session.getAttribute("userType").equals(UserType.CUSTOMER))
					{
						ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
						CustomerDAO customerDAO = (CustomerDAO) context.getBean("CustomerDAO");
						ArrayList<Customer> customerList = (ArrayList<Customer>) customerDAO.selectById((Integer)session.getAttribute("userId"));
						Customer customer = customerList.get(0);
						%>
							<div class="btn-group pull-right">
								<button class="btn dropdown-toggle" data-toggle="dropdown">
									<i class="icon-user"></i> <%=customer.getName()%> <%=customer.getLastName()%> <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li>
										<a href="logout">
											<i class="icon-off"></i> Logout
										</a>
									</li>
								</ul>
							</div>
						<%
					}
					else if(session.getAttribute("userType").equals(UserType.RESTAURANT))
					{
						ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
						RestaurantDAO restaurantDAO = (RestaurantDAO) context.getBean("RestaurantDAO");
						ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) restaurantDAO.selectById((Integer)session.getAttribute("userId"));
						Restaurant restaurant = restaurantList.get(0);
						%>
							
							<div class="btn-group pull-right">
								<a class="btn" href="queueManager">
									<i class="icon-th-large"></i> Minha Fila
								</a>
							</div>
							
							<div class="btn-group pull-right">
								<button class="btn dropdown-toggle" data-toggle="dropdown">
									<i class="icon-user"></i> <%=restaurant.getName()%> <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li>
										<a href="logout">
											<i class="icon-off"></i> Logout
										</a>
									</li>
								</ul>
							</div>
						<%
					}
				}
			%>
		</div>
	</div>
</div>
