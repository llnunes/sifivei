package br.com.sifivei.servlet;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sifivei.beans.Cliente;
import br.com.sifivei.beans.ContratoFinanciamento;
import br.com.sifivei.beans.Veiculo;
import br.com.sifivei.utils.MyUtils;

@WebServlet(urlPatterns = { "/editarFinanciamento" })
public class FinanciamentoEditarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public FinanciamentoEditarServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        Integer id = Integer.parseInt((String) request.getParameter("id"));
        
        ContratoFinanciamento financiamento = null;
 
        String errorString = null;
 
        try {
            financiamento = DBUtils.findFinanciamento(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        if (errorString != null && financiamento == null) {
            response.sendRedirect(request.getServletPath() + "/listaFinanciamentos");
            return;
        }
 
        request.setAttribute("errorString", errorString);
        request.setAttribute("financiamento", financiamento);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/financiamentoEditarView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        String id = (String) request.getParameter("id");
        Integer numeroFinanciamento = new Integer(request.getParameter("numeroFinanciamento"));
        Integer clienteId = new Integer(request.getParameter("cliente_id"));
        Integer veiculoId = new Integer(request.getParameter("veiculo_id"));
        BigDecimal valorBem = new BigDecimal(request.getParameter("valorBem"));
        BigDecimal valorEntrada = new BigDecimal(request.getParameter("valorEntrada"));
        Integer numParcelas = new Integer(request.getParameter("numeroParcelas"));
        Date dtAprovacao;
		try {
			dtAprovacao = sdf.parse(request.getParameter("dataAprovacao"));
		} catch (ParseException e1) {
			dtAprovacao = null;
		}
        Date dtQuitacao;
		try {
			dtQuitacao = sdf.parse(request.getParameter("dataQuitacao"));
		} catch (ParseException e1) {
			dtQuitacao = null;
		}
        Double txJuros = new Double(request.getParameter("taxaJuros"));
        
        ContratoFinanciamento financiamento = new ContratoFinanciamento();
        financiamento.setId(Integer.parseInt(id));
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
            DBUtils.updateFinanciamento(conn, financiamento);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        request.setAttribute("errorString", errorString);
        request.setAttribute("financiamento", financiamento);
 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/financiamentoEditarView.jsp");
            dispatcher.forward(request, response);
        }
        
        else {
            response.sendRedirect(request.getContextPath() + "/listaFinanciamentos");
        }
    }
 
}