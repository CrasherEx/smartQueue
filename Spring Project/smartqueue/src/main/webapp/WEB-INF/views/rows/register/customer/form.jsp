<div class="row">
	<div class="span8 well offset2">
		<form class="form-horizontal" action="submitRegister" method="post">
			<legend>
				<h2>
					Registro
				</h2>
			</legend>
			<jsp:include page="form/personal.jsp" />
			<jsp:include page="form/email.jsp" />
			<jsp:include page="form/password.jsp" />
			<jsp:include page="form/contact.jsp" />
			<jsp:include page="form/send.jsp" />
		</form>
	</div>
</div>