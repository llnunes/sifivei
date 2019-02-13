package br.com.sifivei.commands;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.beans.ContratoFinanciamento;
import br.com.sifivei.beans.Veiculo;
import br.com.sifivei.dao.ContratoFinanciamentoDAO;
import br.com.sifivei.exceptions.DAOException;

public class CadastrarFinanciamento implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String id = (String) request.getParameter("id");
        Integer numeroFinanciamento = new Integer(request.getParameter("numeroFinanciamento"));
        Integer clienteId = new Integer(request.getParameter("cliente"));
        Integer veiculoId = new Integer(request.getParameter("veiculo"));
        BigDecimal valorBem = new BigDecimal(request.getParameter("valorBem"));
        BigDecimal valorEntrada = new BigDecimal(request.getParameter("valorEntrada"));
        Integer numParcelas = new Integer(request.getParameter("numeroParcelas"));
        Date dtAprovacao = null; 
        Date dtQuitacao = null;
		try {
			dtQuitacao = sdf.parse(request.getParameter("dataQuitacao"));
		} catch (ParseException e1) {			
			dtQuitacao = null;
		}
		try {
			dtAprovacao = sdf.parse(request.getParameter("dataAprovacao"));
		} catch (ParseException e1) {
			dtAprovacao = null;
		}
        Double txJuros = new Double(request.getParameter("taxaJuros"));
        
        ContratoFinanciamento financiamento = new ContratoFinanciamento();
        if(id != null) {
        	financiamento.setId(Integer.parseInt(id));
        }
        financiamento.setNumeroFinanciamento(numeroFinanciamento);
        Cliente cliente = new Cliente();
        cliente.setId(clienteId);
        financiamento.setCliente(cliente);
        Veiculo veiculo = new Veiculo();
        veiculo.setId(veiculoId);
        financiamento.setVeiculo(veiculo);
        financiamento.setValorBem(valorBem);        
        financiamento.setValorEntrada(valorEntrada);
        financiamento.setNumeroParcelas(numParcelas);
        financiamento.setDataAprovacao(dtAprovacao);
        financiamento.setDataQuitacao(dtQuitacao);
        financiamento.setTaxaJuros(txJuros);
        
        String errorString = null;
        
        try {
            ContratoFinanciamentoDAO financiamentoDAO = ContratoFinanciamentoDAO.getInstance();
            financiamentoDAO.salvar(financiamento);            
        } catch (DAOException e) {
        	errorString = e.getMessage();
		}
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("financiamento", financiamento);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/cadastrar_financiamento.jsp");
            try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				errorString = e.getMessage();
			}
        } else {
            try {
				response.sendRedirect(request.getContextPath() + "/Controller?command=ListarFinanciamentos");
			} catch (IOException e) {
				errorString = e.getMessage();
			}
        }
	}

}
