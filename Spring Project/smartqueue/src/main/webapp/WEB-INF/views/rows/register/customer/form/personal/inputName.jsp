<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputNameError");
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
	<label class="control-label" for="inputName">
		Nome
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("inputName");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<input type="text" id="inputName" name="inputName" value="<%=inputFieldValue%>" placeholder="" />
	</div>
</div>