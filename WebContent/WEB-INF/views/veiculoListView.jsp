<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Lista de Veiculos</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Lista de Veiculos</h3>
 
    <p style="color: red;">${errorString}</p>
 	<div class="table-responsive">
	    <table border="1" cellpadding="5" cellspacing="1" >
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
	                <a href="editarVeiculo?id=${veiculo.id}">Editar</a>
	             </td>
	             <td>
	                <a href="removerVeiculo?id=${veiculo.id}">Remover</a>
	             </td>
	          </tr>
	       </c:forEach>
	    </table>
 	</div>
 	
    <a href="novoVeiculo" >Novo Veiculo</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>