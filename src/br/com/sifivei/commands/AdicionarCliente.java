package br.com.sifivei.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.dao.ClienteDAOImpl;
import br.com.sifivei.exceptions.DAOException;

public class AdicionarCliente implements Command{

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String caminho = "/WEB-INF/views/cadastrar_cliente.jsp";
		
		Object param = request.getAttribute("cliente");
		
		if(param != null) {
			//Integer id = Integer.parseInt(param);
	    
			caminho = "/WEB-INF/views/atualizar_cliente.jsp"; 
			
			Cliente cliente = null;
			 
	        String errorString = null;
	 
	        try {
	            ClienteDAOImpl clienteDAO = ClienteDAOImpl.getInstance();
	            cliente = clienteDAO.consultarPorPk(1);
	        } catch (DAOException e) {
	        	errorString = e.getMessage();
			}
	 
	        if (errorString != null && cliente == null) {
	            try {
					response.sendRedirect(request.getServletPath() + "/Controller?command=ListarClientes");
				} catch (IOException e) {
					errorString = e.getMessage();
				}
	            return;
	        }
	 
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("cliente", cliente);	        		
		}
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher(caminho);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {			
			e.printStackTrace();
		}
		
	}

}
