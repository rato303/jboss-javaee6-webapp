package servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UserSession;
import dao.UsersDao;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	@Inject
	private UserSession userSession;

	@Inject
	private UsersDao usersDao;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.userSession.start();

		response.getWriter().println("logined[" + this.usersDao.findByNum(1).name + "]");
	}

}
