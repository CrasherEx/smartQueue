<div class="control-group">
	<label class="control-label" for="inputState">
		Estado
	</label>
	<div class="controls">
		<select class="span3" id="inputState">
			<option value="none" selected>- Selecione um Estado -</option>
			<%
				String[][] states = {
					{"Acre","AC"},
					{"Alagoas","AL"},
					{"Amapá","AP"},
					{"Amazonas","AM"},
					{"Bahia","BA"},
					{"Ceará","CE"},
					{"Distrito Federal","DF"},
					{"Espírito Santo","ES"},
					{"Goiás","GO"},
					{"Maranhão","MA"},
					{"Mato Grosso","MT"},
					{"Mato Grosso do Sul","MS"},
					{"Minas Gerais","MG"},
					{"Pará","PA"},
					{"Paraíba","PB"},
					{"Paraná","PR"},
					{"Pernambuco","PE"},
					{"Piauí","PI"},
					{"Rio de Janeiro","RJ"},
					{"Rio Grande do Norte","RN"},
					{"Rio Grande do Sul","RS"},
					{"Rondônia","RO"},
					{"Roraima","RR"},
					{"Santa Catarina","SC"},
					{"São Paulo","SP"},
					{"Sergipe","SE"},
					{"Tocantins","TO"}
				};
				for(int i=1;i<=27;i++)
				{
			%>
				<option value="<%=states[i-1][1]%>"><%=states[i-1][0] + " (" + states[i-1][1] + ")"%></option>	
			<%
				}
			%>
		</select>
	</div>
</div>