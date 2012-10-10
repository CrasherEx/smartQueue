<% 
	Boolean isThereAnError = (Boolean) request.getAttribute("inputStateError");
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
	<label class="control-label" for="inputState">
		Estado
	</label>
	<div class="controls">
		<% 
			String lastInputValue = request.getParameter("inputState");
			String inputFieldValue = "";
			if(lastInputValue != null)
			{
				inputFieldValue = lastInputValue;
			}
		%>
		<select class="span3" id="inputState" name="inputState">
			<option value="none" <%if(inputFieldValue.equals("") || inputFieldValue.equals("none"))out.print("selected");%> >- Selecione um Estado -</option>
			<%
				String[][] states = {
					{"Acre","AC"},
					{"Alagoas","AL"},
					{"Amap�","AP"},
					{"Amazonas","AM"},
					{"Bahia","BA"},
					{"Cear�","CE"},
					{"Distrito Federal","DF"},
					{"Esp�rito Santo","ES"},
					{"Goi�s","GO"},
					{"Maranh�o","MA"},
					{"Mato Grosso","MT"},
					{"Mato Grosso do Sul","MS"},
					{"Minas Gerais","MG"},
					{"Par�","PA"},
					{"Para�ba","PB"},
					{"Paran�","PR"},
					{"Pernambuco","PE"},
					{"Piau�","PI"},
					{"Rio de Janeiro","RJ"},
					{"Rio Grande do Norte","RN"},
					{"Rio Grande do Sul","RS"},
					{"Rond�nia","RO"},
					{"Roraima","RR"},
					{"Santa Catarina","SC"},
					{"S�o Paulo","SP"},
					{"Sergipe","SE"},
					{"Tocantins","TO"}
				};
				for(int i=1;i<=27;i++)
				{
			%>
				<option value="<%=states[i-1][1]%>" <%if(inputFieldValue.equals(states[i-1][1]))out.print("selected");%>><%=states[i-1][0] + " (" + states[i-1][1] + ")"%></option>	
			<%
				}
			%>
		</select>
	</div>
</div>