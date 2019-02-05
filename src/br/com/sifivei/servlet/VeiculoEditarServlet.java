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

@WebServlet(urlPatterns = { "/editarVeiculo" })
public class VeiculoEditarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public VeiculoEditarServlet() {
        super();
    }
 
    // Show veiculo edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        Integer id = Integer.parseInt((String) request.getParameter("id"));
        
        Veiculo veiculo = null;
 
        String errorString = null;
 
        try {
            veiculo = DBUtils.findVeiculo(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The veiculo does not exist to edit.
        // Redirect to listaVeiculos page.
        if (errorString != null && veiculo == null) {
            response.sendRedirect(request.getServletPath() + "/listaVeiculos");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("veiculo", veiculo);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/veiculoEditarView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the veiculo information, and click Submit.
    // This method will be executed.
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
            DBUtils.updateVeiculo(conn, veiculo);
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
                    .getRequestDispatcher("/WEB-INF/views/veiculoEditarView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the veiculo listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/listaVeiculos");
        }
    }
 
}