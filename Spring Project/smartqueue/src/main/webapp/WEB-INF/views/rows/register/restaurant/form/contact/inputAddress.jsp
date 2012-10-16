<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputAddressError");
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
	<label class="control-label" for="inputAddress">
		Endereço
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("inputAddress");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<input type="text" id="inputAddress" name="inputAddress" value="<%=inputFieldValue%>" class="span5" placeholder="" />
	</div>
</div>