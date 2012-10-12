<%@ page import="java.util.ArrayList" %>
<div class="row">
	<div class="span8 well offset2">
		<legend>
			<h2>
				Registro
			</h2>
		</legend>
		<% 
			String userName = request.getParameter("inputName");
			if(userName != null)
			{
		%>
			<div class="alert alert-success">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Sucesso!</strong>
				<br/>
				Parabéns <b><%=userName%></b>, seu registro foi realizado com sucesso!
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
				Parabéns, seu registro foi realizado com sucesso!
			</div>
		<%
			}
		%>
		
		<p>
			O seu registro no site www.smartqueue.com.br foi realizado com sucesso!
			<br/>
			Para acessar sua conta, basta acessar nossa página <a href="login">login</a>.
			<br/>
		</p>
		
		<a href="login" class="btn btn-primary">Login</a>
		<a href="home" class="btn">Voltar</a>
		
	</div>
</div>