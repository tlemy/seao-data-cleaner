package ca.seao.data_cleaner.DataSource;

import java.sql.Connection;

public interface DataSource 
{
	public Connection getConnection();
}
