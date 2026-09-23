package ca.seao.data_cleaner;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ca.seao.data_cleaner.Processor.SupplierProcessor;

@SpringBootApplication
public class DataCleanerApplication implements CommandLineRunner
{
	private final SupplierProcessor supProcessor;
	
	public DataCleanerApplication(SupplierProcessor supProcessor)
	{
		this.supProcessor = supProcessor;
	}
	
	public static void main(String[] args)
	{
		SpringApplication.run(DataCleanerApplication.class, args);
	}

	@Override
	public void run(String... args)
	{
		Map<String, String> mappedArgs = mapParams(args);

		if (mappedArgs.containsKey("--supplier") || mappedArgs.containsKey("-s"))
		{
			try
			{
				supProcessor.normalizeSeaoNames();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	private Map<String, String> mapParams(String[] args)
	{
		List<String> filteredArgs = List.of(args).stream().filter(a -> a.startsWith("-")).toList();
		Map<String, String> result = new HashMap<>();

		for (String arg : filteredArgs)
		{
			result.put(arg, arg);
		}
		return result;
	}
}
