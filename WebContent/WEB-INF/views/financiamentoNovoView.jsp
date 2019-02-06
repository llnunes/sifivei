<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Novo Financiamento</title>
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Novo Financiamento</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/novoFinanciamento">
         <table border="0">
         	<tr>
               <td>ID</td>
               <td><input type="text" name="id" value="${financiamento.id}" /></td>
            </tr>            
            <tr>
	             <td>Numero do Financiamento</td>
	             <td><input type="text" name="numeroFinanciamento" value="${financiamento.numeroFinanciamento}" /></td>
	          </tr>
	          <tr>
	             <td>Cliente</td>
	             <td><input type="text" name="cliente_id" value="${financiamento.cliente.id}" /></td>
	          </tr>
	          <tr>
	             <td>Veiculo</td>
	             <td><input type="text" name="veiculo_id" value="${financiamento.veiculo.id}" /></td>
	          </tr>
	          <tr>
	             <td>Valor do Bem (R$)</td>
	             <td><input type="text" name="valorBem" value="${financiamento.valorBem}" /></td>
	          </tr>
	          <tr>
	             <td>Valor da Entrada (R$)</td>
	             <td><input type="text" name="valorEntrada" value="${financiamento.valorEntrada}" /></td>
	          </tr>
	          <tr>
	             <td>Numero de Parcelas</td>
	             <td><input type="text" name="numeroParcelas" value="${financiamento.numeroParcelas}" /></td>
	          </tr>
	          <tr>
	             <td>Data da Aprovacao</td>
	             <td><input type="text" name="dataAprovacao" value="${financiamento.dataAprovacao}" /></td>
	          </tr>
	          <tr>
	             <td>Data da Quitacao</td>
	             <td><input type="text" name="dataQuitacao" value="${financiamento.dataQuitacao}" /></td>
	          </tr>
	          <tr>
	             <td>Taxa de Juros</td>
	             <td><input type="text" name="taxaJuros" value="${financiamento.taxaJuros}" /></td>
	          </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="listaFinanciamentos">Cancelar</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>