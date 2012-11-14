 <%@ page import="java.util.ArrayList" %>
 <%@ page import="com.omega.smartqueue.model.CustomerInQueue" %>

<div class="span6 well">
	<legend>
		<h2>
			Gerenciador de Filas
		</h2>
	</legend>
	<%
		ArrayList<CustomerInQueue> queue = (ArrayList<CustomerInQueue>) request.getAttribute("queue");
	
		if(queue.size() > 0)
		{
	%>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>Número de Pessoas</th>
				<th>Ações</th>
				<th>Notificações</th>
			</tr>
		</thead>
		<tbody>
		<%
	
				for(int customerIndexInQueue = 0;customerIndexInQueue<queue.size();customerIndexInQueue++)
				{
					CustomerInQueue customerInQueue = queue.get(customerIndexInQueue);
					int position = customerIndexInQueue+1;
		%>
					<tr>
						<td>
							<%=position%>
						</td>
						<td>
							<%=customerInQueue.getCustomer_name()%>
						</td>
						<td>
							<%=customerInQueue.getTelephone()%>
						</td>
						<td>
							<%=customerInQueue.getParty()%>
						</td>
						<td>
							<form action="callCustomerFromQueue" method="post">
								<input type="hidden" name="id" value="<%=customerInQueue.getCustomer_in_queue_id()%>" />
								<input type="submit" class="btn btn-primary btn-small" value="Chamar Cliente"/>
							</form>
							<form action="removeCustomerFromQueue" method="post">
								<input type="hidden" name="id" value="<%=customerInQueue.getCustomer_in_queue_id()%>" />
								<input type="submit" class="btn btn-danger btn-small" value="Remover da Fila"/>
							</form>
						</td>
						<td>
							<%
							Integer indexOfTheUserCalled = (Integer) request.getAttribute("indexOfTheUserCalled");
							if(indexOfTheUserCalled != null)
							{
								if(indexOfTheUserCalled == customerInQueue.getCustomer_in_queue_id())
								{
								%>
									<div class="alert alert-info">
										<strong>Sucesso! </strong>
										Mensagem enviada.
									</div>
								<%
								}
							}
							%>
						</td>
						
					</tr>
			<%
					}
			%>
		</tbody>
	</table>
	<%
		}
		else
		{
	%>
			<div class="alert alert-info">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Atenção!</strong>
				<br/>
				A fila do restaurante encontra-se vazia. Em caso de dúvidas ou problemas, contate o SAC.
			</div>
			
			<h5>
				A fila do restaurante econtra-se vazia.
			</h5>
	<%
		}
	%>
</div>