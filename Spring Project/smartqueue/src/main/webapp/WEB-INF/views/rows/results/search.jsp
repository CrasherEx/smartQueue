<%@ page import="java.util.ArrayList" %>
<%@ page import="com.omega.smartqueue.model.Restaurant" %>
<div class="span8 well">
	<legend>
		<h2>
			Busca de Restaurantes:
		</h2>
	</legend>
	<%
		ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) request.getAttribute("restaurants");
		if (restaurants == null)
		{
	%>
			Insira um nome de restaurante no campo de busca e clique em "Buscar".
	<%
		}
		else if (restaurants.isEmpty())
		{
	%>
			Não encontramos um nome de restaurante compatível com o digitado.
		<%
		}
		else
		{
			for(Restaurant restaurant:restaurants)
			{
	%>
			<div class="well">
				<legend>
					<h4>
						<b>Restaurante: </b> <%=restaurant.getName()%>
					</h4>
				</legend>
				
				<p>
					<b>Telefone: </b> <%=restaurant.getTelephone()%>
					<br/>
					<b>Estado: </b> <%=restaurant.getState()%>
					<br/>
					<b>Cidade: </b> <%=restaurant.getCity()%>
					<br/>
					<b>Endereço: </b> <%=restaurant.getAddress()%>
					<br/>
				</p>
				
				<button class="btn btn-primary">Entrar na Fila</button>
			</div>
	<%
			} 
		}
	%>			
</div>