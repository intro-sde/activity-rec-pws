package rest.activity;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.json.JSONArray;
import org.json.JSONObject;

public class Quotes {
	public static WebTarget config() {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget service = client.target(getBaseURI());
		System.out.println("Calling " + getBaseURI() ); 
		return service;
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"https://quotes.rest").build();
	}
	public static String getRandomQuotes() throws Exception {
		String category = "sports";
		String result="Sports do not build character. They reveal it. (Heywood Broun)";
		WebTarget service = config();
		Response resp = service.path("/qod").queryParam("category", category).request().accept(MediaType.APPLICATION_JSON).get();
		String response = resp.readEntity(String.class);
		//System.out.println(response);
		JSONObject obj = new JSONObject(response);
		JSONObject contents = (JSONObject) obj.get("contents");
		JSONArray quotes = contents.getJSONArray("quotes");
		String quote = quotes.getJSONObject(0).getString("quote");
		String author = quotes.getJSONObject(0).getString("author");
		System.out.println(quote);
	
		if (quote!=null) {
			result = quote + " (" + author + ")";
		}

		return result;
	}
}
