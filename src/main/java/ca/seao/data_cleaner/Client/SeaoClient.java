package ca.seao.data_cleaner.Client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class SeaoClient
{
    private HttpClient client;

    public SeaoClient()
    {
        this.client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();
    }

    public HttpResponse<byte[]> makeHttpRequest(String url)
    {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.ofMinutes(2))
            .GET()
            .build();

        try
        {
        	return client.send(request, HttpResponse.BodyHandlers.ofByteArray());
		} 
        catch (Exception e)
        {
        	System.out.println();
		}
        
        return null;
    }    
}
