<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("confirmInputEmailError");
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
	<label class="control-label" for="confirmInputEmail">
		Confirmar E-mail
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("confirmInputEmail");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<input type="text" id="confirmInputEmail" name="confirmInputEmail" value="<%=inputFieldValue%>" placeholder="" />
	</div>
</div>