<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
	
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
<body>

	<jsp:include page="WEB-INF/template/_header.jsp"></jsp:include>

	<div class="container">
		<div class="row animated fadeInUp">

			<div class="col-md-4 col-md-offset-4">
				<section class="login-content">
					<div class="text-center">
						<h1 class="h4"></h1>
					</div>
					<form method="POST"
						action="<%=request.getContextPath()%>/Controller?command=Login">
						<section class="panel panel-default">
							<header class="panel-heading text-center">
								<h2 class="panel-title h5">Controle de Acesso</h2>
							</header>
							<article class="panel-body">
								<div class="form-group">
									<label for="login">Login</label> <input type="text"
										class="form-control" value="${usuario.login}" name="login"
										id="login" placeholder="Digite seu login" required>
								</div>
								<div class="form-group">
									<label for="senha">Senha</label> <input type="password"
										class="form-control" id="senha" name="senha"
										value="${usuario.senha}" placeholder="Digite sua senha"
										required>
								</div>
							</article>
							<ul class="list-group">
								<li class="list-group-item"><label> <input
										class="form-check-input" type="checkbox" name="rememberMe"
										value="Y"> Lembre-me
								</label></li>
							</ul>
							<footer class="panel-footer">
								<button type="submit"
									class="btn btn-primary btn-darken btn-block">
									<i class="fa fa-sign-in"></i> Acessar
								</button>
							</footer>
						</section>
					</form>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="WEB-INF/template/_footer.jsp"></jsp:include>

</body>
</html>