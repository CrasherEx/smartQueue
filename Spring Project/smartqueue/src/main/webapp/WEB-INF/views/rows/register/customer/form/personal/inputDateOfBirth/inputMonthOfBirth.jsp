<select class="span2" id="inputMonthOfBirth">
	<option value="none" selected>- Selecione um M�s -</option>
	<%
		String[] months ={"Janeiro","Fevereiro","Mar�o","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		for(int i=1;i<=12;i++)
		{
	%>
		<option value="<%=i%>"><%=months[i-1]%></option>	
	<%
		}
	%>
</select>