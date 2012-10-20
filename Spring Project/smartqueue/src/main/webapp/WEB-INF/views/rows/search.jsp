<div class="row">
	<div class="span10 offset1">
		<form class="form-search" method="get" action="results">
			<h3>
				Busca de Restaurantes:
			</h3>
			<div class="input-append">
				<% 
					String lastInputValue = request.getParameter("restaurantName");
					String inputFieldValue = "";
					if(lastInputValue != null)
					{
						inputFieldValue = lastInputValue;
					}
				%>
				<input type="text" class="span9 search-query" name="restaurantName" value="<%=inputFieldValue%>">
				<button type="submit" class="btn">Buscar</button>
			</div>
		</form>
	</div>
</div>