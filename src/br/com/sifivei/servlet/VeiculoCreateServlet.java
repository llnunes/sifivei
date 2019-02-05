package br.com.sifivei.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Veiculo;
import br.com.sifivei.utils.MyUtils;

@WebServlet(urlPatterns = { "/novoVeiculo" })
public class VeiculoCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public VeiculoCreateServlet() {
        super();
    }
 
    // Show veiculo creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/veiculoNovoView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the veiculo information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
        String placaVeiculo = (String) request.getParameter("placaVeiculo");
        String modelo = (String) request.getParameter("modelo");
        String marca = (String) request.getParameter("marca");
        String cor = (String) request.getParameter("cor");
        String chassis = (String) request.getParameter("chassis");
        String restricoes = (String) request.getParameter("restricoes");
        
        Veiculo veiculo = new Veiculo();
        veiculo.setId(Integer.parseInt(id));
        veiculo.setPlacaVeiculo(placaVeiculo);
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setCor(cor);
        veiculo.setChassis(chassis);
        veiculo.setRestricoes(restricoes);              
 
        String errorString = null;
        
        try {
            DBUtils.insertVeiculo(conn, veiculo);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
 
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("veiculo", veiculo);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/veiculoNovoView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the veiculo listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/listaVeiculos");
        }
    }
 
}