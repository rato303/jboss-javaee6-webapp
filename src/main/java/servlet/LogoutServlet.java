package servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UserSession;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

	@Inject
	private UserSession userSession;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.userSession.end();

		response.getWriter().println("logouted!");

	}

}
