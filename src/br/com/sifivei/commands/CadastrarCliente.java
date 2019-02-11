package br.com.sifivei.commands;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.dao.ClienteDAOImpl;
import br.com.sifivei.exceptions.DAOException;

public class CadastrarCliente implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//String id = (String) request.getParameter("id");
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
        //cliente.setId(Integer.parseInt(id));
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
            ClienteDAOImpl clienteDAO = ClienteDAOImpl.getInstance();
            clienteDAO.salvar(cliente);            
        } catch (DAOException e) {
        	errorString = e.getMessage();
		}
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("cliente", cliente);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/cadastrar_cliente.jsp");
            try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				errorString = e.getMessage();
			}
        } else {
            try {
				response.sendRedirect(request.getContextPath() + "/Controller?command=ListarClientes");
			} catch (IOException e) {
				errorString = e.getMessage();
			}
        }
	}

}
