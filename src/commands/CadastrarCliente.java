package commands;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarCliente implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/cadastrar_clientes.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {			
			e.printStackTrace();
		}
		
	}

}
