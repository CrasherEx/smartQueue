<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputGenderError");
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
	<label class="control-label" for="inputGender">
		Sexo
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("inputGender");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<select class="span2" id="inputGender" name="inputGender">
			<option value="none" <%if(inputFieldValue.equals("") || inputFieldValue.equals("none"))out.print("selected"); %>>- Selecionar -</option>
			<option value="male" <%if(inputFieldValue.equals("male"))out.print("selected"); %>>Masculino</option>
			<option value="female" <%if(inputFieldValue.equals("female"))out.print("selected"); %>>Feminino</option>
		</select>
	</div>
</div>