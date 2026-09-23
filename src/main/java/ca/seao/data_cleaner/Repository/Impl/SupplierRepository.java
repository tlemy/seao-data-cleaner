package ca.seao.data_cleaner.Repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ca.seao.data_cleaner.Config.ApplicationConfig;
import ca.seao.data_cleaner.Dao.Supplier;
import ca.seao.data_cleaner.DataSource.DataSource;

@Repository
public class SupplierRepository
{
    private final DataSource dataSource;
    private final ApplicationConfig config;

    public SupplierRepository(DataSource dataSource, ApplicationConfig config)
    {
        this.dataSource = dataSource;
        this.config = config;
    }
    
    public List<Supplier> selectAll() throws SQLException
    {
    	List<Supplier> supps = new LinkedList<>();
    	
    	Connection conn = dataSource.getConnection();
    	try (PreparedStatement stmt = conn.prepareStatement(config.getSqlSupplierSelectAll()))
    	{
    		ResultSet rs = stmt.executeQuery();
    		
    		while (rs.next())
    		{
    			supps.add(new Supplier(rs.getLong("id"), rs.getString("supplier_name")));
    		}
    	}
    	
    	return supps;
    }
    
    public List<Supplier> selectSimilar(String similar) throws SQLException
    {
    	List<Supplier> supps = new LinkedList<>();
    	
    	Connection conn = dataSource.getConnection();
    	try (PreparedStatement stmt = conn.prepareStatement(config.getSqlSupplierSelectSimilar()))
    	{
    		stmt.setString(1, similar);
    		
    		ResultSet rs = stmt.executeQuery();
    		
    		while (rs.next())
    		{
    			supps.add(new Supplier(rs.getLong("id"), rs.getString("supplier_name")));
    		}
    	}
    	return supps;
    }
    
    public boolean updateSupplierSeaoName(long id, String newName) throws SQLException
    {
    	Connection conn = dataSource.getConnection();
    	try (PreparedStatement stmt = conn.prepareStatement(config.getSqlSupplierUpdateSeaoName()))
    	{
    		stmt.setString(1, newName);
    		stmt.setLong(2, id);
    		return stmt.executeUpdate() > 0;
    	}
    }
}
