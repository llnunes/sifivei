<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <body>
 
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
    
      <h3>Home Page</h3>
      
      Sistema De Financiamentos de Veiculos.  <br><br>
      <b>As seguintes funções estão disponíveis:</b>
      <ul>
         <li>Login</li>
         <li>Storing user information in cookies</li>
         <li>Lista de Clientes</li>
         <li>Cadastro de Clientes</li>
         <li>Edição de Clientes</li>
         <li>Exclusão de Clientes</li>
      </ul>
 
     <jsp:include page="_footer.jsp"></jsp:include>
 
  </body>
</html>