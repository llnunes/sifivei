<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Editar Veiculo</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Editar Veiculo</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty veiculo}">
         <form method="POST" action="${pageContext.request.contextPath}/editarVeiculo">
            <input type="hidden" name="id" value="${veiculo.id}" />
            <table border="0">
               	<tr>
	               <td>ID</td>
	               <td><input type="text" name="id" value="${veiculo.id}" /></td>
	            </tr>            
	            <tr>
	               <td>Placa Veículo</td>
	               <td><input type="text" name="placaVeiculo" value="${veiculo.placaVeiculo}" /></td>
	            </tr>
	            <tr>
	               <td>Modelo</td>
	               <td><input type="text" name="modelo" value="${veiculo.modelo}" /></td>
	            </tr>
	            <tr>
	               <td>Marca</td>
	               <td><input type="text" name="marca" value="${veiculo.marca}" /></td>
	            </tr>
	            <tr>
	               <td>Cor</td>
	               <td><input type="text" name="cor" value="${veiculo.cor}" /></td>
	            </tr>
	            <tr>
	               <td>Chassis</td>
	               <td><input type="text" name="chassis" value="${veiculo.chassis}" /></td>
	            </tr>
	            <tr>
	               <td>Restricoes</td>
	               <td><input type="text" name="restricoes" value="${veiculo.restricoes}" /></td>
	            </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/listaVeiculos">Cancelar</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>