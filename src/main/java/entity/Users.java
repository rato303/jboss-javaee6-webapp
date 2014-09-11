package entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class Users {

	@Column(name = "NUM")
	public Integer num;

	@Column(name ="NAME")
	public String name;

}
