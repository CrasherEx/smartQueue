<%@ page import="java.util.ArrayList" %>
<div class="span6 well offset1">
	<form class="form-horizontal" action="submitLogin" method="post">
		<legend>
			<h2>
				Login
			</h2>
		</legend>
		<%
			ArrayList<String> errorMessages = (ArrayList<String>) request.getAttribute("errorMessages");
			if(errorMessages != null)
			{
		%>
			<div class="alert alert-error">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Erro!</strong>
				<br/>
				<%
					if(errorMessages.size() == 1)
					{
						out.print("Um erro foi encontrado no formulário:");
					}
					else
					{
						out.print("Alguns erros foram encontrados no formulário:");
					}
				%> 
				<br/>
				<%
					for(String errorMessage:errorMessages)
					{
						out.print("- " + errorMessage + "<br/>");
					}	
				%>
			</div>
		<%
			}
		%>
		<jsp:include page="form/inputEmail.jsp" />
		<jsp:include page="form/inputPassword.jsp" />
		<div class="control-group">
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox" name="inputRememberMe" value="true"/> manter-me conectado 
					<i title='Esta opção permite que sua conta continue conctada mesmo após fechar seu navegador.' class="icon-question-sign"></i>
				</label>
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		</div>
	</form>
</div>