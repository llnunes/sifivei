<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template/_header_views.jsp"%>

<p style="color: red;">${errorString}</p>

<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<label>Lista de Financiamentos</label>
		</div>
		<div class="panel-body">
			
			<div class="table-responsive">
	    <table border="1" cellpadding="5" cellspacing="1" >
	       <tr>
	          <th>Id</th>
	          <th>Num Financiamento</th>
	          <th>Financiamento</th>
	          <th>Veiculo</th>
	          <th>Valor do Bem (R$)</th>
	          <th>Valor da Entrada (R$)</th>
	          <th>Num Parcelas</th>
	          <th>Data Aprovação</th>
	          <th>Data Quitação</th>
	          <th>Taxa de Juros (%)</th>
	          <th>Editar</th>
	          <th>Remover</th>
	       </tr>
	       <c:forEach items="${listaFinanciamentos}" var="financiamento" >
	          <tr>
	             <td>${financiamento.id}</td>
	             <td>${financiamento.numeroFinanciamento}</td>
	             <td>${financiamento.cliente.id}</td>
	             <td>${financiamento.veiculo.id}</td>
	             <td>${financiamento.valorBem}</td>
	             <td>${financiamento.valorEntrada}</td>
	             <td>${financiamento.numeroParcelas}</td>
	             <td><fmt:formatDate value="${financiamento.dataAprovacao}" pattern="dd/MM/yyyy" /> </td>
	             <td><fmt:formatDate value="${financiamento.dataQuitacao}" pattern="dd/MM/yyyy" /></td>
	             <td>${financiamento.taxaJuros}</td>
	             <td>
					<a href="<%=request.getContextPath()%>/Controller?command=AdicionarFinanciamento&id=${financiamento.id}" >Editar</a>
				 </td>
				 <td>
					<a href="<%=request.getContextPath()%>/Controller?command=ExcluirFinanciamento&id=${financiamento.id}" >Remover</a>
				 </td>	
	          </tr>
	       </c:forEach>
	    </table>
			</div>
		</div>
	</div>
</div>
<a href="<%=request.getContextPath()%>/Controller?command=AdicionarFinanciamento" >Novo Financiamento</a>

<jsp:include page="../template/_footer.jsp"></jsp:include>
