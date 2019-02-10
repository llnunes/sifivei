<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template/_header_views.jsp" %>
	
<c:if test="${!empty sessionScope.usuario}" > 

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading"><label>Informações Usuário Logado</label></div>
			<div class="panel-body">

				<h3><label>Ola:</label> ${usuario.login}</h3>
				
				<label>Nome:</label> ${usuario.nome} <br /> 
				<label>Sexo:</label> ${usuario.sexo eq 'M'? 'Masculino' : 'Feminino' } <br />
			</div>
		</div>
	</div>
</c:if>
	
<jsp:include page="../template/_footer.jsp"></jsp:include>
	
