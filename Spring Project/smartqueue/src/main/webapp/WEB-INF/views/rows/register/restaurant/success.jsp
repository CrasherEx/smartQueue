<%@ page import="java.util.ArrayList" %>
<div class="row">
	<div class="span8 well offset2">
		<legend>
			<h2>
				Registro
			</h2>
		</legend>
		<% 
			String restaurantName = request.getParameter("inputName");
			if(restaurantName != null)
			{
		%>
			<div class="alert alert-success">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Sucesso!</strong>
				<br/>
				Parabéns! O registro do restaurante <b><%=restaurantName%></b> foi realizado com sucesso!
			</div>
		<%
			}
			else
			{
		%>
			<div class="alert alert-success">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Sucesso!</strong>
				<br/>
				Parabéns! O registro foi realizado com sucesso!
			</div>
		<%
			}
		%>
		
		<p>
			O registro do restaurante no site www.smartqueue.com.br foi realizado com sucesso!
			<br/>
			Para acessar sua conta, basta acessar nossa página de <a href="login">login</a>.
			<br/>
		</p>
		
		<a href="login" class="btn btn-primary">Login</a>
		<a href="home" class="btn">Voltar</a>
		
	</div>
</div>