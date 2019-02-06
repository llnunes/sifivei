package br.com.sifivei.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sifivei.beans.ContratoFinanciamento;
import br.com.sifivei.beans.Usuario;
import br.com.sifivei.utils.MyUtils;

@WebServlet(urlPatterns = { "/listaFinanciamentos" })
public class FinanciamentoListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FinanciamentoListServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Check User has logged on
		Usuario loginedUser = MyUtils.getLoginedUser(session);

		// Not logged in
		if (loginedUser == null) {
			// Redirect to login page.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		Connection conn = MyUtils.getStoredConnection(request);

		String errorString = null;
		List<ContratoFinanciamento> list = null;
		try {
			list = DBUtils.queryFinanciamento(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("listaFinanciamentos", list);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/financiamentoListView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
