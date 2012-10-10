<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputDateError");
	String error = "";
	if(isThereAnError != null)
	{
		if(isThereAnError == true)
		{
			error = "error";
		}
	}
%>
<div class="control-group <%=error%>">
	<label class="control-label">
		Data de Nascimento
	</label>
	<div class="controls">
		<jsp:include page="inputDateOfBirth/inputDayOfBirth.jsp" />
		<jsp:include page="inputDateOfBirth/inputMonthOfBirth.jsp" />
		<jsp:include page="inputDateOfBirth/inputYearOfBirth.jsp" />
	</div>
</div>