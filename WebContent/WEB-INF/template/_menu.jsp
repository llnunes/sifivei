<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
    
<div style="padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/">Home</a>
   |
   <a href="${pageContext.request.contextPath}/login">Login</a>
   |
   <a href="${pageContext.request.contextPath}/logoff">Logoff</a>
   |
   <a href="<%=request.getContextPath()%>/Controller?command=UsuarioCommand">Informações do Usuário</a>
   |
   <a href="<%=request.getContextPath()%>/Controller?command=ListarClientes">Lista de Clientes</a>
   |
   <a href="${pageContext.request.contextPath}/listaVeiculos">Lista de Veiculos</a>
   |
   <a href="${pageContext.request.contextPath}/listaFinanciamentos">Lista de Financiamentos</a>
   | 
    
</div>  