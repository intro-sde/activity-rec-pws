package rest.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class ActivityRecommendation {
	public static WebTarget config() {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget service = client.target(getBaseURI());
		System.out.println("Calling " + getBaseURI() ); 
		return service;
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"https://sde-recommendation-ws.herokuapp.com").build();
	}
	public static String recommendActivities(String userId,String city) {
		String result="Items in list items";
		String type = "activity";
		
		WebTarget service = config();
		Response resp = service.path("/recommend").queryParam("userId", userId).queryParam("type", type).queryParam("city", city).request().accept(MediaType.APPLICATION_JSON).get();
		String response = resp.readEntity(String.class);
		
		
		return response;
}

	
	
	

}


