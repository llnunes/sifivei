package br.com.sifivei.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/logoff" })
public class LogoffServlet extends HttpServlet {
		
	private static final long serialVersionUID = 8155648132779396384L;

	public LogoffServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginedUser") != null ) {
			session.removeAttribute("loginedUser");			
			session.invalidate();
		}
	
		response.sendRedirect(request.getContextPath() + "/login");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

}
