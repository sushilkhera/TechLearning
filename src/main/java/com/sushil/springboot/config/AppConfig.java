package com.sushil.springboot.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;
/**
 * This class is an example to get Session Factory object through external configuration
 * @author sushilkhera
 *
 */
@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {
	@Autowired
	Environment env;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		Properties props = new Properties();
	      // Setting JDBC properties
	      props.put(DRIVER, env.getProperty("oracle.driver-class-name"));
	      props.put(URL, env.getProperty("oracle.url"));
	      props.put(USER, env.getProperty("oracle.username"));
	      props.put(PASS, env.getProperty("oracle.password"));
	      props.put(AUTOCOMMIT, true);
	      // Setting Hibernate properties
	      props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
	      props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
	      
	      factoryBean.setHibernateProperties(props);
	      factoryBean.setPackagesToScan("com.sushil.springboot","com.sushil.springboot.beans","com.sushil.springboot.repo");
	      
	      return factoryBean;
	}

}
