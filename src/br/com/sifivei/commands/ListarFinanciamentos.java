package br.com.sifivei.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.ContratoFinanciamento;
import br.com.sifivei.dao.ContratoFinanciamentoDAO;

public class ListarFinanciamentos implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		List<ContratoFinanciamento> listaFinanciamentos = null;
		
		ContratoFinanciamentoDAO financiamentoDAO = ContratoFinanciamentoDAO.getInstance();
		try {
			listaFinanciamentos = financiamentoDAO.pesquisarContratoFinanciamentos();
		} catch (Exception e) {
			errorString = e.getMessage();
		}		
	
		request.setAttribute("errorString", errorString);
		request.setAttribute("listaFinanciamentos", listaFinanciamentos);
	
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/listar_financiamentos.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {			
			e.printStackTrace();
		}		
	}
}
