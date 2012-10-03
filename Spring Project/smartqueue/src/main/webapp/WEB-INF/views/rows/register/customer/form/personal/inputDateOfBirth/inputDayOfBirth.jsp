<select class="span1" id="inputDayOfBirth">
	<option value="none" selected>----</option>
	<%
		for(int i=1;i<=31;i++)
		{
	%>
		<option value="<%=i%>"><%=i%></option>	
	<%
		}
	%>
</select>