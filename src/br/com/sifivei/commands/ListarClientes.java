package br.com.sifivei.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.dao.ClienteDAOImpl;

public class ListarClientes implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		List<Cliente> listaClientes = null;
		
		ClienteDAOImpl clienteDAO = ClienteDAOImpl.getInstance();
		try {
			listaClientes = clienteDAO.pesquisarClientes();
		} catch (Exception e) {
			errorString = e.getMessage();
		}		
	
		request.setAttribute("errorString", errorString);
		request.setAttribute("listaClientes", listaClientes);
	
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/listar_clientes.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {			
			e.printStackTrace();
		}		
	}
}
