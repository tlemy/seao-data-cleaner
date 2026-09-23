package ca.seao.data_cleaner.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;

import ca.seao.data_cleaner.Config.ApplicationConfig;

@Configuration
public class DataSourceImpl implements DataSource
{
	private final Connection conn;

	public DataSourceImpl(ApplicationConfig config)
	{
		String url = String.format("%s?user=%s&password=%s&ssl=false", config.getDbUrl(), config.getDbUser(), config.getDbPass());

		try
		{
			this.conn = DriverManager.getConnection(url);
		}
		catch (SQLException e)
		{
			throw new IllegalStateException("Unable to create database connection", e);
		}
	}

	@Override
	public Connection getConnection()
	{
		return this.conn;
	}
}
