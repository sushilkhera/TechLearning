package com.sushil.springboot.repo;

import java.sql.SQLException;

import javax.sql.DataSource;

public interface DBConfiguration {
	
	public DataSource getDataSource() throws SQLException;
}
