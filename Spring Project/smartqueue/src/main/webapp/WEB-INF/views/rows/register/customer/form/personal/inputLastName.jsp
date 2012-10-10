<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputLastNameError");
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
	<label class="control-label" for="inputLastName">
		Sobrenome
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("inputLastName");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<input type="text" id="inputLastName" name="inputLastName" value="<%=inputFieldValue%>" placeholder="" />
	</div>
</div>