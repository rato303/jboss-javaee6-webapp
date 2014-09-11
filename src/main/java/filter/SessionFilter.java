package filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.UserSession;

@WebFilter("/rest/*")
public class SessionFilter implements Filter {

	@Inject
	private UserSession userSession;

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if (this.needsSessionCheck(request) && ! this.userSession.isLogged()) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		} else {
			chain.doFilter(request, response);
		}

	}

	private boolean needsSessionCheck(HttpServletRequest request) {
		return !request.getRequestURI().endsWith("/session");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// no use
	}

	@Override
	public void destroy() {
		// no use
	}

}
