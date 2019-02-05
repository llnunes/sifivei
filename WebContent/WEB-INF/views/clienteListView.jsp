<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Lista de Clientes</h3>
 
    <p style="color: red;">${errorString}</p>
 	<div class="table-responsive">
	    <table border="1" cellpadding="5" cellspacing="1" >
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
	       <c:forEach items="${listaClientes}" var="cliente" >
	          <tr>
	             <td>${cliente.id}</td>
	             <td>${cliente.cpf}</td>
	             <td>${cliente.nome}</td>
	             <td>${cliente.rg}</td>
	             <td>${cliente.municipio}</td>
	             <td>${cliente.uf}</td>
	             <td>${cliente.valorRenda}</td>
	             <td>
	                <a href="editarCliente?id=${cliente.id}">Editar</a>
	             </td>
	             <td>
	                <a href="removerCliente?id=${cliente.id}">Remover</a>
	             </td>
	          </tr>
	       </c:forEach>
	    </table>
 	</div>
 	
    <a href="novoCliente" >Novo Cliente</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>