<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Lista de Financiamentos</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Lista de Financiamentos</h3>
 
    <p style="color: red;">${errorString}</p>
 	<div class="table-responsive">
	    <table border="1" cellpadding="5" cellspacing="1" >
	       <tr>
	          <th>Id</th>
	          <th>Num Financiamento</th>
	          <th>Cliente</th>
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
	             <td>${financiamento.dataAprovacao}</td>
	             <td>${financiamento.dataQuitacao}</td>
	             <td>${financiamento.taxaJuros}</td>
	             <td>
	                <a href="editarFinanciamento?id=${financiamento.id}">Editar</a>
	             </td>
	             <td>
	                <a href="removerFinanciamento?id=${financiamento.id}">Remover</a>
	             </td>
	          </tr>
	       </c:forEach>
	    </table>
 	</div>
 	
    <a href="novoFinanciamento" >Novo Financiamento</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>