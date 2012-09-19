<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" />
		<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
		<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    	<script src="http://code.jquery.com/jquery-latest.js"></script>
    	
    	<style>
			.loginForm input[type="text"],
			.loginForm input[type="password"]
			{
				float:right;
			}
			
			.loginTitle
			{
				text-align: center;
			}
			
			.smartqueuelogo
			{
				min-height: 20px;
				padding: 19px;
				margin-bottom: 20px;
				-webkit-border-radius: 4px;
				-moz-border-radius: 4px;
				border-radius: 4px;
			}
			
			.loginbox
			{
			background-color: #EEE;
			padding: 19px;
			-webkit-border-radius: 3px;
			-moz-border-radius: 3px;
			border-radius: 3px;
			}
			
    	</style>
		<title>Home</title>
	</head>
	<body>
		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Register</a></li>
					<li><a href="#">Login</a></li>
				</ul>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="span6">
					<a href="home">
						<img src="${pageContext.request.contextPath}/resources/images/logo/smartqueue_logo.png"/>
					</a>
				</div>
				<div class="span5 offset1">
					<div class="row">
						<div class="span2">
							<h1 class="loginTitle">
								Login
							</h1>
							<a href="#">Esqueci minha senha</a>
							<br/>
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
											<input type="checkbox" class="rememberUser" />
											manter-se conectado
										</label>
									</p>
									<p>
										<button type="submit" class="btn btn-primary btn-large btn-block">Login</button>
									</p>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="span8">
						<h3>
							Rio de Janeiro 
							<small><a href="#">Alterar Cidade</a></small>
						</h3>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<form class="form-search">			
						<div class="input-append">
							<input type="text" class="span6 search-query">
							<button type="submit" class="btn">Buscar</button>
						</div>
					</form>
				</div>
				<div class="span5 offset1">
					
				</div>
			</div>
			<div class="row">
				<div class="span8 well">
					<h1>
						Hello world!  
					</h1>
					<p>
						The time on the server is ${serverTime}.
					</p>
					<a href="register">Register</a>
					<br/>
					<a href="login">
						Login
					</a>
					<br/>
				</div>
				<div class="span3 well">
					<h1>
						Favoritos
					</h1>
				</div>
			</div>
		</div>
	</body>
</html>

<!-- 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>
			Hello world!  
		</h1>
		
		<P>  The time on the server is ${serverTime}. </P>
		<a href="register">Register</a>
		<br/>
		<a href="login">Login</a>
		<br/>
	</body>
</html>


							<form>
								<label>
									Usuário
								</label>
								<input type="text" placeholder=""/>
								<label>
									Senha
								</label>
								<input type="password" placeholder="*******"/>
								<br/>
								<button type="submit" class="btn btn-primary">Login</button>
								<button class="btn btn-info">Registrar-se</button>
							</form>
							
							
							
							<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
				</ul>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span5 offset1">
					<a href="home">
						<img src="${pageContext.request.contextPath}/resources/images/logo/smartqueue_logo.png"/>
					</a>
				</div>
				<div class="span4 offset1 well well-small">
					<div class="row-fluid">
						<div class="span5">
							<div class="row-fluid">
								<h2>
									Login
								</h2>
							</div>
							<div class="row-fluid">
								<a href="#">Esqueci minha senha</a>
								<br/>
								<a href="#">Registrar-se</a>
							</div>
						</div>
						<div class="span7">
							<form class="form-horizontal">
								<div class="control-group">
									<label class="control-label" for="inputEmail">Usuário</label>
									<div class="controls">
										<input type="text" id="inputEmail" placeholder="Email" class="input-medium">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="inputPassword">Senha</label>
									<div class="controls">
										<input type="password" id="inputPassword" placeholder="*****" class="input-medium">
									</div>
								</div>
								<div class="control-group">
									<div class="controls">
										<label class="checkbox">
											<input type="checkbox"> manter-se logado
										</label>
										<button type="submit" class="btn btn-primary">Login</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span10 offset1 well">
					<h1>
						Hello world!  
					</h1>
					<p>
						The time on the server is ${serverTime}.
					</p>
					<a href="register">Register</a>
					<br/>
					<a href="login">
						Login
					</a>
					<br/>
				</div>
			</div>
		</div>
 -->