package commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();

			if (!session.isNew()) {

				session.invalidate();
				response.sendRedirect("/WEB-INF/views/login.jsp");

			}
		} catch (IOException ex) {
			Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}