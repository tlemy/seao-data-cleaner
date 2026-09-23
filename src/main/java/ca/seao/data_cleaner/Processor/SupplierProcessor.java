package ca.seao.data_cleaner.Processor;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import ca.seao.data_cleaner.Config.ApplicationConfig;
import ca.seao.data_cleaner.Dao.Supplier;
import ca.seao.data_cleaner.Repository.Impl.SupplierRepository;

@Component
public class SupplierProcessor 
{
	private final ApplicationConfig config;
	
	private final SupplierRepository repo;
	
	private final Scanner scanner;
	
	public SupplierProcessor(ApplicationConfig config, SupplierRepository repo)
	{
		this.config = config;
		this.repo = repo;
		this.scanner = new Scanner(System.in);
	}
	
	public void normalizeSeaoNames() throws SQLException
	{
		List<Supplier> supps = repo.selectAll();
		String prev = "";
		
		for (Supplier sup : supps)
		{
			if (sup.equals(prev))
			{
				continue;
			}
			
			List<Supplier> similars = repo.selectSimilar(sup.getSeaoName());
			
			for (Supplier sim : similars)
			{
				prev = sup.getSeaoName();
				
				if (!sim.getSeaoName().equals(sup.getSeaoName()))
				{
					String msg = String.format("'%s' => '%s' [y/N]", sim.getSeaoName(), sup.getSeaoName());
					
					System.out.println(msg);
					
					String c = this.scanner.next();
					
					if (c.equalsIgnoreCase("y"))
					{
						if (repo.updateSupplierSeaoName(sim.getId(), sup.getSeaoName()))
						{
							System.out.println("Updated");
						}
					}
				}
			}
		}
	}
}
