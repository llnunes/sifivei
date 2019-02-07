<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<jsp:include page="WEB-INF/template/_header_login.jsp"></jsp:include>

	<div class="container ">
		<div class="form-group">
			<div class="col-md-4 offset-md-4">				
				<p style="color: red;">${errorString}</p>
			</div>
		</div>
		
		<form method="POST" action="${pageContext.request.contextPath}/login">

			<div class="form-group">
				<div class="col-md-4 offset-md-4">
					<label>Login</label> <input type="text" name="login"
						value="${usuario.login}" class="form-control " placeholder="Login"
						required="true">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-4 offset-md-4">
					<label> SENHA </label> <input type="password"
						value="${usuario.senha}" name="senha" class="form-control"
						placeholder="SENHA" required="true">
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-4 offset-md-4">
					<input type="submit" value="Login" class="btn btn-primary" name="">
					<a href="${pageContext.request.contextPath}/">Cancelar</a>

					<div class="form-check">
						<label> <input class="form-check-input" type="checkbox"
							name="rememberMe" value="Y"> Lembre-me
						</label>
					</div>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="WEB-INF/template/_footer.jsp"></jsp:include>
</body>
</html>