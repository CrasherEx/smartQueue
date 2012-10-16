<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputPasswordError");
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
	<label class="control-label" for="inputPassword">
		Senha
	</label>
	<div class="controls">
		<input type="password" id="inputPassword" name="inputPassword" value="" placeholder="**********" />
	</div>
</div>