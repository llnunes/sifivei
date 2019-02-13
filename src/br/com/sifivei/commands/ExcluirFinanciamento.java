package br.com.sifivei.commands;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.dao.ContratoFinanciamentoDAO;
import br.com.sifivei.exceptions.DAOException;

public class ExcluirFinanciamento implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
				
		String param = request.getParameter("id");
		String errorString = null;
		
		if(param != null) {
			Integer id = Integer.parseInt(param);
	    		 
	        try {
	            ContratoFinanciamentoDAO financiamentoDAO = ContratoFinanciamentoDAO.getInstance();	           
	            financiamentoDAO.excluir(id);
	        } catch (DAOException e) {
	        	errorString = e.getMessage();
			}
	 
	        request.setAttribute("errorString", errorString);        		
		}
		
		try {
			response.sendRedirect(request.getContextPath() + "/Controller?command=ListarFinanciamentos");
		} catch (IOException e) {
			errorString = e.getMessage();
		}		
	}
}
