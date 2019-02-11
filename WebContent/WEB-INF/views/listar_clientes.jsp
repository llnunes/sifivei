<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template/_header_views.jsp"%>

<p style="color: red;">${errorString}</p>

<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<label>Lista de Clientes</label>
		</div>
		<div class="panel-body">
			
			<div class="table-responsive">
				<table border="1" cellpadding="5" cellspacing="1">
					<tr>
						<th>Id</th>
						<th>Cpf</th>
						<th>Nome</th>
						<th>RG</th>
						<th>Municipio</th>
						<th>UF</th>
						<th>Valor da Renda</th>
						<th>Editar</th>
						<th>Remover</th>
					</tr>
					<c:forEach items="${listaClientes}" var="cliente">
						<tr>
							<td>${cliente.id}</td>
							<td>${cliente.cpf}</td>
							<td>${cliente.nome}</td>
							<td>${cliente.rg}</td>
							<td>${cliente.municipio}</td>
							<td>${cliente.uf}</td>
							<td>${cliente.valorRenda}</td>
							<td>
								<a href="<%=request.getContextPath()%>/Controller?command=AdicionarCliente" >Editar</a>
							</td>						
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
<a href="<%=request.getContextPath()%>/Controller?command=AdicionarCliente" >Novo Cliente</a>

<jsp:include page="../template/_footer.jsp"></jsp:include>
