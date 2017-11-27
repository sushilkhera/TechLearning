package com.sushil.springboot.dao.impl;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sushil.springboot.repo.DBConfiguration;

import oracle.jdbc.pool.OracleDataSource;
/**
 * This class provides custom DataSource object using few external properties 
 * @author sushilkhera
 *
 */
@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class DBConfigurationImpl implements DBConfiguration {

	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String url;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	@Bean public DataSource getDataSource() throws SQLException {
		System.out.println(toString());
		OracleDataSource datasource = new OracleDataSource();
		datasource.setUser(getUsername());
		datasource.setPassword(getPassword());
		datasource.setURL(getUrl());
		datasource.setImplicitCachingEnabled(true);
		datasource.setFastConnectionFailoverEnabled(true);
		return datasource;
	}

	@Override
	public String toString() {
		return "DBConfigurationImpl [username=" + username + ", password=" + password + ", url=" + url + "]";
	}
}
