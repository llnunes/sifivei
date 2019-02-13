<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../template/_header_views.jsp" %>

<p style="color: red;">${errorString}</p>


<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading"><label>Novo Financiamento</label></div>
		<div class="panel-body">
           
 				<form method="POST"
					action="<%=request.getContextPath()%>/Controller?command=CadastrarFinanciamento">
				<c:if test="${not empty financiamento.id}">
					ID: <input name="id" value="${financiamento.id}" readonly="true"  class="form-control" required placeholder="Preencha este campo." /> <br/>
				</c:if>	
		        Numero Financiamento: <input name="numeroFinanciamento" value="${financiamento.numeroFinanciamento}"  class="form-control" required placeholder="Preencha este campo." /> <br/>
	            Cliente: 
	            <select name="cliente" id="cliente" class="form-control"> 
			  		<option value="0">Selecione...</option>       
			       	<c:forEach var="cli" items="${clientes}" varStatus="id">
			       		<option value="${cli.id}">${cli.nome}</option>
			       	</c:forEach>        
			    </select>
	            <br/>
	           	Veiculo: 
				<select name="veiculo" id="veiculo" class="form-control"> 
			  		<option value="0">Selecione...</option>       
			       	<c:forEach var="vei" items="${veiculos}" varStatus="id">
			       		<option value="${vei.id}">${vei.placaVeiculo}</option>
			       	</c:forEach>        
			    </select>
				<br/>
	            Valor Bem: <input name="valorBem" value="${financiamento.valorBem}"  class="form-control" required placeholder="Preencha este campo." /><br/>
	            Valor Entrada: <input name="valorEntrada" value="${financiamento.valorEntrada}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Numero Parcelas: <input name="numeroParcelas" value="${financiamento.numeroParcelas}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Data Aprovacao: <input name="dataAprovacao" value="${financiamento.dataAprovacao}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Data Quitacao: <input name="dataQuitacao" value="${financiamento.dataQuitacao}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
	            Taxa Juros: <input name="taxaJuros" value="${financiamento.taxaJuros}"  class="form-control" required placeholder="Preencha este campo."  /><br/>
           		<input type="submit" value="Cadastrar" class="btn btn-primary" />
           		
           		
       		</form> 		
		</div>
	</div>
</div>
<br/><br/>
       
<jsp:include page="../template/_footer.jsp"></jsp:include>
