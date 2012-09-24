<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/loginSpan.css" />	
<div class="span5 well">
	<div class="row">
		<div class="span2">
			<h1 class="loginTitle">Login</h1>
			<a href="#">Esqueci minha senha</a>
			<br />
			<a href="#">Registrar-se</a>
		</div>
		<div class="span3">
			<form class="form-inline loginForm">
				<p>
					<label>Usuário</label>
					<input type="text" placeholder="Usuário" class="input-medium" />
				</p>
				<p>
					<label>Senha</label> 
					<input type="password" placeholder="*******" class="input-medium" />
				</p>
				<p>
					<label class="checkbox"> 
						<input type="checkbox" class="rememberUser" /> manter-se conectado
					</label>
				</p>
				<p>
					<button type="submit" class="btn btn-primary btn-large btn-block">Login</button>
				</p>
			</form>
		</div>
	</div>
</div>