<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputCityError");
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
	<label class="control-label" for="inputCity">
		Cidade
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("inputCity");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<input type="text" id="inputCity" name="inputCity" value="<%=inputFieldValue%>" placeholder="" />
	</div>
</div>