package br.com.sifivei.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.beans.ContratoFinanciamento;
import br.com.sifivei.beans.Veiculo;
import br.com.sifivei.dao.ClienteDAO;
import br.com.sifivei.dao.ContratoFinanciamentoDAO;
import br.com.sifivei.dao.VeiculoDAO;
import br.com.sifivei.exceptions.DAOException;

public class AdicionarFinanciamento implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String caminho = "/WEB-INF/views/cadastrar_financiamento.jsp";
		
		String param = request.getParameter("id");
		List<Cliente> listaClientes = null;
		List<Veiculo> listaVeiculos = null;
		 
        String errorString = null;
 
		if(param != null) {
			Integer id = Integer.parseInt(param);
	    			
			ContratoFinanciamento financiamento = null;
					
	        try {
	            ContratoFinanciamentoDAO financiamentoDAO = ContratoFinanciamentoDAO.getInstance();
	            financiamento = financiamentoDAO.consultarPorId(id); 	            
	        } catch (DAOException e) {
	        	errorString = e.getMessage();
			}
	 
	        if (errorString != null && financiamento == null) {
	            try {
					response.sendRedirect(request.getServletPath() + "/Controller?command=ListarFinanciamentos");
				} catch (IOException e) {
					errorString = e.getMessage();
				}
	            return;
	        }
	        request.setAttribute("financiamento", financiamento);
	    }
		try {
			listaClientes = ClienteDAO.getInstance().pesquisarClientes();
			listaVeiculos = VeiculoDAO.getInstance().pesquisarVeiculos();
			request.setAttribute("veiculos", listaVeiculos);
			request.setAttribute("clientes", listaClientes);
		} catch (DAOException e1) {
			errorString = e1.getMessage();
		}	
		
		request.setAttribute("errorString", errorString);
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher(caminho);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {			
			e.printStackTrace();
		}
		
	}

}
