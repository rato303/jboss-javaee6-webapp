package config;

import javax.enterprise.inject.Produces;

import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;

public class DialectProducer {

	@Produces
	Dialect dialect() {
		return new PostgresDialect();
	}

}
