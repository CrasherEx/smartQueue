<div class="span6 well offset1">
	<form class="form-horizontal" action="submitLogin" method="post">
		<legend>
			<h2>
				Login
			</h2>
		</legend>
		<div class="alert alert-error">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong>Erro!</strong> Alerta de exemplo para quando a senha estiver errada!
		</div>
		<div class="control-group">
			<label class="control-label" for="inputEmail">
				E-mail
			</label>
			<div class="controls">
				<input type="text" id="inputEmail" placeholder="usuario@exemplo.com" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPassword">
				Senha
			</label>
			<div class="controls">
				<input type="password" id="inputPassword" placeholder="**********" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox" /> manter-me conectado 
					<i title='Esta opção permite que sua conta continue conctada mesmo após fechar seu navegador.' class="icon-question-sign"></i>
				</label>
				<button type="submit" class="btn btn-primary">Login</button>
			</div>
		</div>
	</form>
</div>