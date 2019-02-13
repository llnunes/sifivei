<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template/_header_views.jsp" %>

<p style="color: red;">${errorString}</p>

<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading"><label>Novo Veiculo</label></div>
		<div class="panel-body">
           
			<form method="POST"
				action="<%=request.getContextPath()%>/Controller?command=CadastrarVeiculo">
				<c:if test="${not empty veiculo.id}">
					ID: <input name="id" value="${veiculo.id}" readonly="true"  class="form-control" required placeholder="Preencha este campo." /> <br/>
				</c:if>	
		        Placa Veículo: <input name="placaVeiculo" value="${veiculo.placaVeiculo}"  class="form-control" required placeholder="Preencha este campo." /> <br/>
	            Modelo: <input name="modelo" value="${veiculo.modelo}"  class="form-control" required placeholder="Preencha este campo." /><br/>
	            Marca: <input name="marca" value="${veiculo.marca}"  class="form-control" required placeholder="Preencha este campo."/><br/>
	            Cor: <input name="cor" value="${veiculo.cor}"  class="form-control" required placeholder="Preencha este campo." /><br/>
	            Chassis: <input name="chassis" value="${veiculo.chassis}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Restricoes: <input name="restricoes" value="${veiculo.restricoes}"  class="form-control" required placeholder="Preencha este campo."  /><br/>	           
	          		<input type="submit" value="Cadastrar" class="btn btn-primary" />
           		
           		
       		</form> 		
		</div>
	</div>
</div>
<br/><br/>
       
<jsp:include page="../template/_footer.jsp"></jsp:include>
