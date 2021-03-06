package br.com.sifivei.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.dao.ClienteDAO;
import br.com.sifivei.exceptions.DAOException;

public class AdicionarCliente implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String caminho = "/WEB-INF/views/cadastrar_cliente.jsp";
		
		String param = request.getParameter("id");
		
		if(param != null) {
			Integer id = Integer.parseInt(param);
	    			
			Cliente cliente = null;
			 
	        String errorString = null;
	 
	        try {
	            ClienteDAO clienteDAO = ClienteDAO.getInstance();
	            cliente = clienteDAO.consultarPorId(id);
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
