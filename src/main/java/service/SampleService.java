package service;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import dao.UsersDao;


@RequestScoped
@Path("sample")
public class SampleService {

	@Inject
	private UsersDao usersDao;

	@GET
	@Path("/uga")
	public String ugaMethod() {
		return "uga !!" + this.usersDao.findByNum(1).name;
//		return "uga !!";
	}

}
