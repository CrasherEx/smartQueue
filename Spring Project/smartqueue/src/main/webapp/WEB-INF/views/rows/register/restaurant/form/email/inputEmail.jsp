<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputEmailError");
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
	<label class="control-label" for="inputEmail">
		E-mail
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("inputEmail");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<input type="text" id="inputEmail" name="inputEmail" value="<%=inputFieldValue%>" placeholder="usuario@exemplo.com" />
	</div>
</div>