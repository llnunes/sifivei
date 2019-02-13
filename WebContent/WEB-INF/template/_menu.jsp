<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
    
<div style="padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/">Home</a>
   |
   <a href="<%=request.getContextPath()%>/Controller?command=Logout">Logoff</a>
   |
   <a href="<%=request.getContextPath()%>/Controller?command=UsuarioCommand">Informações do Usuário</a>
   |
   <a href="<%=request.getContextPath()%>/Controller?command=ListarClientes">Lista de Clientes</a>
   |
   <a href="<%=request.getContextPath()%>/Controller?command=ListarVeiculos">Lista de Veiculos</a>
   |
   <a href="<%=request.getContextPath()%>/Controller?command=ListarFinanciamentos">Lista de Financiamentos</a>
   | 
    
</div>  