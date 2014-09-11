package config;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

public class DataSourceProducer {

	@Resource(name = "java:jboss/datasources/jboss-javaee6-webappDS")
	@Produces
	DataSource dataSource;

}
