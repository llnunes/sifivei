package br.com.sifivei.commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sifivei.beans.Usuario;

public class UsuarioCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {

			HttpSession httpSession = request.getSession(true);

			Usuario usuario = (Usuario) httpSession.getAttribute("loginedUser");
			httpSession.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/userInfo.jsp");
			dispatcher.forward(request, response);

		} catch (IOException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ServletException e) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
