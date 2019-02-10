package commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.sifivei.beans.Usuario;
import br.com.sifivei.dao.UsuarioDAOImpl;
import br.com.sifivei.exceptions.DAOException;

public class Login implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            Usuario usuario = UsuarioDAOImpl.getInstance().login(login, senha);
            
            if (usuario != null) {
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("loginedUser", usuario);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");

        		dispatcher.forward(request, response);

            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException e) {			
        	Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
		} catch (DAOException ed) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ed);
		}

    }
}