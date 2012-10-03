<select class="span1" id="inputYearOfBirth">
	<option value="none" selected>----</option>
	<%
		for(int i=2012;i>=1900;i--)
		{
	%>
		<option value="<%=i%>"><%=i%></option>	
	<%
		}
	%>
</select>