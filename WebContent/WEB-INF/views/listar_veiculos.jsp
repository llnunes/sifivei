<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template/_header_views.jsp"%>

<div class="container">

	<p style="color: red;">${errorString}</p>

	<div class="panel panel-default">
		<div class="panel-heading">
			<label>Lista de Veiculos</label>
		</div>
		<div class="panel-body">
			
			<div class="table-responsive">
				<table border="1" cellpadding="5" cellspacing="1">
					<tr>
						<th>Id</th>
				          <th>Placa Veiculo</th>
				          <th>Modelo</th>
				          <th>Marca</th>
				          <th>Cor</th>
				          <th>Chassis</th>
				          <th>Restricoes</th>
				          <th>Editar</th>
				          <th>Remover</th>
					</tr>
					<c:forEach items="${listaVeiculos}" var="veiculo" >
				          <tr>
				             <td>${veiculo.id}</td>
				             <td>${veiculo.placaVeiculo}</td>
				             <td>${veiculo.modelo}</td>
				             <td>${veiculo.marca}</td>
				             <td>${veiculo.cor}</td>
				             <td>${veiculo.chassis}</td>
				             <td>${veiculo.restricoes}</td>
				             <td>
								<a href="<%=request.getContextPath()%>/Controller?command=AdicionarVeiculo&id=${veiculo.id}" >Editar</a>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/Controller?command=ExcluirVeiculo&id=${veiculo.id}" >Remover</a>
							</td>						
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
<a href="<%=request.getContextPath()%>/Controller?command=AdicionarVeiculo" >Novo Veiculo</a>

<jsp:include page="../template/_footer.jsp"></jsp:include>

