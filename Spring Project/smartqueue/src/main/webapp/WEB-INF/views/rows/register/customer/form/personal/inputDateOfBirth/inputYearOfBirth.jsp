<% 
	String lastInputValue = request.getParameter("inputYearOfBirth");
	String inputFieldValue = "";
	if(lastInputValue != null)
	{
		inputFieldValue = lastInputValue;
	}
%>
<select class="span1" id="inputYearOfBirth" name="inputYearOfBirth">
	<option value="none" <%if(inputFieldValue.equals("") || inputFieldValue.equals("none"))out.print("selected"); %>>----</option>
	<%
		for(Integer i=2012;i>=1900;i--)
		{
	%>
		<option value="<%=i%>" <%if(inputFieldValue.equals(i.toString()))out.print("selected");%>><%=i%></option>	
	<%
		}
	%>
</select>