<% 
	String lastInputValue = request.getParameter("inputMonthOfBirth");
	String inputFieldValue = "";
	if(lastInputValue != null)
	{
		inputFieldValue = lastInputValue;
	}
%>
<select class="span2" id="inputMonthOfBirth" name="inputMonthOfBirth">
	<option value="none" <%if(inputFieldValue.equals("") || inputFieldValue.equals("none"))out.print("selected"); %>>- Selecione um Mês -</option>
	<%
		String[] months ={"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		for(Integer i=1;i<=12;i++)
		{
	%>
		<option value="<%=i%>" <%if(inputFieldValue.equals(i.toString()))out.print("selected");%>><%=months[i-1]%></option>	
	<%
		}
	%>
</select>