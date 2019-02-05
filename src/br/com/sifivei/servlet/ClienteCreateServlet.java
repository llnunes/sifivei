package br.com.sifivei.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.utils.MyUtils;

@WebServlet(urlPatterns = { "/novoCliente" })
public class ClienteCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ClienteCreateServlet() {
        super();
    }
 
    // Show cliente creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/clienteNovoView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the cliente information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
        String cpf = (String) request.getParameter("cpf");
        String nome = (String) request.getParameter("nome");
        String rg = (String) request.getParameter("rg");
        String cep = (String) request.getParameter("cep");
        String endereco = (String) request.getParameter("endereco");
        String municipio = (String) request.getParameter("municipio");
        String uf = (String) request.getParameter("uf");
        String vlr = (String) request.getParameter("valorRenda");
        BigDecimal valorRenda = new BigDecimal(vlr);
       
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(id));
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setRg(rg);
        cliente.setCep(cep);
        cliente.setEndereco(endereco);
        cliente.setMunicipio(municipio);
        cliente.setUf(uf);
        cliente.setValorRenda(valorRenda);        
 
        String errorString = null;
        
        try {
            DBUtils.insertCliente(conn, cliente);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
 
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("cliente", cliente);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/clienteNovoView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the cliente listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/listaClientes");
        }
    }
 
}