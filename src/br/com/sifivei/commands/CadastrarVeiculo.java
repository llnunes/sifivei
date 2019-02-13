package br.com.sifivei.commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Veiculo;
import br.com.sifivei.dao.VeiculoDAO;
import br.com.sifivei.exceptions.DAOException;

public class CadastrarVeiculo implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
				
		String id = (String) request.getParameter("id");
        String placaVeiculo = (String) request.getParameter("placaVeiculo");
        String modelo = (String) request.getParameter("modelo");
        String marca = (String) request.getParameter("marca");
        String cor = (String) request.getParameter("cor");
        String chassis = (String) request.getParameter("chassis");
        String restricoes = (String) request.getParameter("restricoes");
        
        Veiculo veiculo = new Veiculo();
        if(id != null) {
        	veiculo.setId(Integer.parseInt(id));
        }
        veiculo.setPlacaVeiculo(placaVeiculo);
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setCor(cor);
        veiculo.setChassis(chassis);
        veiculo.setRestricoes(restricoes);   
        
        String errorString = null;
        
        try {
            VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();
            veiculoDAO.salvar(veiculo);            
        } catch (DAOException e) {
        	errorString = e.getMessage();
		}
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("veiculo", veiculo);
         
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/cadastrar_veiculo.jsp");
            try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				errorString = e.getMessage();
			}
        } else {
            try {
				response.sendRedirect(request.getContextPath() + "/Controller?command=ListarVeiculos");
			} catch (IOException e) {
				errorString = e.getMessage();
			}
        }
	}

}
