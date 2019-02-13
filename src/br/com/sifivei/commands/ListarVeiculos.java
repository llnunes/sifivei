package br.com.sifivei.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Veiculo;
import br.com.sifivei.dao.VeiculoDAO;

public class ListarVeiculos implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String errorString = null;
		List<Veiculo> listaVeiculos = null;
		
		VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
		try {
			listaVeiculos = veiculoDAO.pesquisarVeiculos();
		} catch (Exception e) {
			errorString = e.getMessage();
		}		
	
		request.setAttribute("errorString", errorString);
		request.setAttribute("listaVeiculos", listaVeiculos);
	
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/listar_veiculos.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {			
			e.printStackTrace();
		}		
	}
}
