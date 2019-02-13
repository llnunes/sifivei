package br.com.sifivei.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Veiculo;
import br.com.sifivei.dao.VeiculoDAO;
import br.com.sifivei.exceptions.DAOException;

public class AdicionarVeiculo implements Command{

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String caminho = "/WEB-INF/views/cadastrar_veiculo.jsp";
		
		String param = request.getParameter("id");
		
		if(param != null) {
			Integer id = Integer.parseInt(param);
	    		
			Veiculo veiculo = null;
			 
	        String errorString = null;
	 
	        try {
	            VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
	            veiculo = veiculoDAO.consultarPorId(id);
	        } catch (DAOException e) {
	        	errorString = e.getMessage();
			}
	 
	        if (errorString != null && veiculo == null) {
	            try {
					response.sendRedirect(request.getServletPath() + "/Controller?command=ListarVeiculos");
				} catch (IOException e) {
					errorString = e.getMessage();
				}
	            return;
	        }
	 
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("veiculo", veiculo);	        		
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
