<div class="row">
	<div class="span6">
		<form class="form-search" method="get" action="results">
			<div class="input-append">
				<% 
					String lastInputValue = request.getParameter("restaurantName");
					String inputFieldValue = "";
					if(lastInputValue != null)
					{
						inputFieldValue = lastInputValue;
					}
				%>
				<input type="text" class="span6 search-query" name="restaurantName" value="<%=inputFieldValue%>">
				<button type="submit" class="btn">Buscar</button>
			</div>
		</form>
	</div>
	<div class="span5 offset1"></div>
</div>