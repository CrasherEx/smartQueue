<%@ page import="java.util.ArrayList" %>
<div class="row">
	<div class="span8 well offset2">
		<form class="form-horizontal" action="submitRegister" method="post">
			<legend>
				<h2>
					Registro
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
							out.print("Um erro foi encontrado no formul�rio:");
						}
						else
						{
							out.print("Alguns erros foram encontrados no formul�rio:");
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
					<div class="alert alert-info">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Aten��o!</strong>
					<br/>
					Ser� necess�rio completar novamente o campo <b>Senha</b> como uma precau��o de seguran�a.
				</div>
			<%
				}
			%>
			<jsp:include page="form/personal.jsp" />
			<jsp:include page="form/email.jsp" />
			<jsp:include page="form/password.jsp" />
			<jsp:include page="form/contact.jsp" />
			<jsp:include page="form/send.jsp" />
		</form>
	</div>
</div>