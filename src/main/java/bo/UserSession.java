package bo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@SessionScoped
public class UserSession implements Serializable {

	@Inject
	private HttpSession session;

	private boolean isLogged;

	public void start() {
		this.isLogged = true;
	}

	public boolean isLogged() {
		return this.isLogged;
	}

	public void end() {
		this.isLogged = false;
		this.session.invalidate();
	}

}
