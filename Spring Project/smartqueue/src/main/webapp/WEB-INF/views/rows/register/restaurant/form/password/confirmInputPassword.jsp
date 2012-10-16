<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("confirmInputPasswordError");
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
	<label class="control-label" for="confirmInputPassword">
		Confirmar Senha
	</label>
	<div class="controls">
		<input type="password" id="confirmInputPassword" name="confirmInputPassword" value="" placeholder="" />
	</div>
</div>