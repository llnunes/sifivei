<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template/_header_views.jsp" %>

<p style="color: red;">${errorString}</p>

<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading"><label>Novo Cliente</label></div>
		<div class="panel-body">
           
 				<form method="POST"
					action="<%=request.getContextPath()%>/Controller?command=CadastrarCliente">
				<c:if test="${not empty cliente.id}">
					ID: <input name="id" value="${cliente.id}" readonly="true"  class="form-control" required placeholder="Preencha este campo." /> <br/>
				</c:if>	
		        Nome: <input name="nome" value="${cliente.nome}"  class="form-control" required placeholder="Preencha este campo." /> <br/>
	            CPF: <input name="cpf" value="${cliente.cpf}"  class="form-control" required placeholder="Preencha este campo." /><br/>
	            RG: <input name="rg" value="${cliente.rg}"  class="form-control" required placeholder="Preencha este campo."/><br/>
	            CEP: <input name="cep" value="${cliente.cep}"  class="form-control" required placeholder="Preencha este campo." /><br/>
	            Endereço: <input name="endereco" value="${cliente.endereco}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Municipio: <input name="municipio" value="${cliente.municipio}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
	            UF: <input name="uf" value="${cliente.uf}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Valor Renda: <input name="valorRenda" value="${cliente.valorRenda}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
           		<input type="submit" value="Cadastrar" class="btn btn-primary" />
           		
           		
       		</form> 		
		</div>
	</div>
</div>
<br/><br/>
       
<jsp:include page="../template/_footer.jsp"></jsp:include>
