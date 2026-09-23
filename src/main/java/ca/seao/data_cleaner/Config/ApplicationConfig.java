package ca.seao.data_cleaner.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${data.seao.db}")
    private String dbUrl;

    @Value("${data.seao.user}")
    private String dbUser;

    @Value("${data.seao.pass}")
    private String dbPass;

    @Value("${data.sql.supplier.select.all}")
    private String sqlSupplierSelectAll;

	@Value("${data.sql.supplier.select.similar}")
    private String sqlSupplierSelectSimilar;
	
	@Value("${data.sql.supplier.update.seao.name}")
	private String sqlSupplierUpdateSeaoName;

	public String getDbUrl()
	{
        return dbUrl;
    }

    public String getDbUser()
    {
        return dbUser;
    }

    public String getDbPass()
    {
        return dbPass;
    }
    
    public String getSqlSupplierUpdateSeaoName()
    {
		return sqlSupplierUpdateSeaoName;
	}
    
    public String getSqlSupplierSelectAll()
    {
		return sqlSupplierSelectAll;
	}
    
    public String getSqlSupplierSelectSimilar()
    {
		return sqlSupplierSelectSimilar;
	}

    public void setDbUrl(String dbUrl)
    {
        this.dbUrl = dbUrl;
    }

    public void setDbUser(String dbUser)
    {
        this.dbUser = dbUser;
    }

    public void setDbPass(String dbPass)
    {
        this.dbPass = dbPass;
    }
    
    public void setSqlSupplierSelectAll(String sqlSupplierSelectAll)
    {
		this.sqlSupplierSelectAll = sqlSupplierSelectAll;
	}
    
    public void setSqlSupplierSelectSimilar(String sqlSupplierSelectSimilar)
    {
		this.sqlSupplierSelectSimilar = sqlSupplierSelectSimilar;
	}
    
    public void setSqlSupplierUpdateSeaoName(String sqlSupplierUpdateSeaoName)
    {
		this.sqlSupplierUpdateSeaoName = sqlSupplierUpdateSeaoName;
	}
}
