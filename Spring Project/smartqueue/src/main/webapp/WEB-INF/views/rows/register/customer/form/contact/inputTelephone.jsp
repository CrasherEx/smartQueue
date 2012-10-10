<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputTelephoneError");
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
	<label class="control-label" for="inputTelephone">
		Telefone
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("inputTelephonePrefix");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<input type="text" id="inputTelephonePrefix" name="inputTelephonePrefix" value="<%=inputFieldValue%>" class="span1" placeholder="" />
		<% 
			lastInputValue = request.getParameter("inputTelephone");
			inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<input type="text" id="inputTelephone" name="inputTelephone" value="<%=inputFieldValue%>"  class="span2" placeholder="" />
	</div>
</div>