<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Novo Cliente</title>
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Novo Cliente</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/novoCliente">
         <table border="0">
         	<tr>
               <td>ID</td>
               <td><input type="text" name="id" value="${cliente.id}" /></td>
            </tr>            
            <tr>
               <td>CPF</td>
               <td><input type="text" name="cpf" value="${cliente.cpf}" /></td>
            </tr>
            <tr>
               <td>Nome</td>
               <td><input type="text" name="nome" value="${cliente.nome}" /></td>
            </tr>
            <tr>
               <td>RG</td>
               <td><input type="text" name="rg" value="${cliente.rg}" /></td>
            </tr>
            <tr>
               <td>CEP</td>
               <td><input type="text" name="cep" value="${cliente.cep}" /></td>
            </tr>
            <tr>
               <td>Endereco</td>
               <td><input type="text" name="endereco" value="${cliente.endereco}" /></td>
            </tr>
            <tr>
               <td>Municipio</td>
               <td><input type="text" name="municipio" value="${cliente.municipio}" /></td>
            </tr>
            <tr>
               <td>UF</td>
               <td><input type="text" name="uf" value="${cliente.uf}" /></td>
            </tr>
            <tr>
               <td>Valor Renda</td>
               <td><input type="text" name="valorRenda" value="${cliente.valorRenda}" /></td>
            </tr>
            
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="listaClientes">Cancelar</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>