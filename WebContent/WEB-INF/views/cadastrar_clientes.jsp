<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template/_header_views.jsp" %>

<p style="color: red;">${errorString}</p>

<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading"><label>Novo Cliente</label></div>
		<div class="panel-body">
           
 				<form method="POST"
					action="<%=request.getContextPath()%>/Controller?command=CadastroCliente">
					
		        ID: <input name="id" class="form-control" required placeholder="Preencha este campo." /> <br/>
		        Nome: <input name="nome" class="form-control" required placeholder="Preencha este campo." /> <br/>
	            CPF: <input name="cpf" class="form-control" required placeholder="Preencha este campo." /><br/>
	            RG: <input name="rg" class="form-control" required placeholder="Preencha este campo."/><br/>
	            CEP: <input name="cep" class="form-control" required placeholder="Preencha este campo." /><br/>
	            Endereço: <input name="endereco" class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Municipio: <input name="municipio" class="form-control" required placeholder="Preencha este campo."  /><br/>
	            UF: <input name="uf" class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Valor Renda: <input name="valorRenda" class="form-control" required placeholder="Preencha este campo."  /><br/>
           		<input type="submit" value="Cadastrar" class="btn btn-primary" />
           		
           		
       		</form> 		
		</div>
	</div>
</div>

       
<jsp:include page="../template/_footer.jsp"></jsp:include>
