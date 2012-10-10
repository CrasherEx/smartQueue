<% 
	String lastInputValue = request.getParameter("inputDayOfBirth");
	String inputFieldValue = "";
	if(lastInputValue != null)
	{
		inputFieldValue = lastInputValue;
	}
%>
<select class="span1" id="inputDayOfBirth" name="inputDayOfBirth">
	<option value="none" <%if(inputFieldValue.equals("") || inputFieldValue.equals("none"))out.print("selected"); %>>----</option>
	<%
		for(Integer i=1;i<=31;i++)
		{
	%>
		<option value="<%=i%>" <%if(inputFieldValue.equals(i.toString()))out.print("selected");%>><%=i%></option>	
	<%
		}
	%>
</select>