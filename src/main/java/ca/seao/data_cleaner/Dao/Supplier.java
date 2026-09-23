package ca.seao.data_cleaner.Dao;

public class Supplier
{
	private long id;
	
    private String seaoName;

    public Supplier(long id, String seaoName)
    {
    	this.id = id;
        this.seaoName = seaoName;
    }
    
    public long getId()
    {
    	return this.id;
    }

    public String getSeaoName()
    {
        return seaoName;
    }
}
