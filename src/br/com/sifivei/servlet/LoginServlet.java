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
import javax.servlet.http.HttpSession;

import br.com.sifivei.beans.Usuario;
import br.com.sifivei.utils.MyUtils;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	// Show Login page.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Forward to /WEB-INF/views/loginView.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

		dispatcher.forward(request, response);

	}

	// When the usuario enters usuarioName & password, and click Submit.
	// This method will be executed.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);

		Usuario usuario = null;
		boolean hasError = false;
		String errorString = null;

		if (login == null || senha == null || login.length() == 0 || senha.length() == 0) {
			hasError = true;
			errorString = "Required usuarioname and password!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				// Find the usuario in the DB.
				usuario = DBUtils.findUser(conn, login, senha);

				if (usuario == null) {
					hasError = true;
					errorString = "User Name or password invalid";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		// If error, forward to /WEB-INF/views/login.jsp
		if (hasError) {
			usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("usuario", usuario);

			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher //
					= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

			dispatcher.forward(request, response);
		}
		// If no error
		// Store usuario information in Session
		// And redirect to usuarioInfo page.
		else {
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, usuario);

			// If usuario checked "Remember me".
			if (remember) {
				MyUtils.storeUserCookie(response, usuario);
			}
			// Else delete cookie.
			else {
				MyUtils.deleteUserCookie(response);
			}

			// Redirect to usuarioInfo page.
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
	}

}