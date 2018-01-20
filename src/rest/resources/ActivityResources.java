package rest.resources;

import java.io.IOException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.recombee.api_client.exceptions.ApiException;

import rest.activity.ActivityRecommendation;
import rest.activity.Feedback;
import rest.activity.Quotes;
import rest.activity.Users;

@Stateless
@LocalBean
@Path("/process")
public class ActivityResources {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Path("/quotes")
	public List<String> getQuote() throws ApiException, IOException {
		System.out.println("--> ActivityResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		List<String> quotes = Quotes.getRandomQuotes();
		return quotes;
	}
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/user/registration")
	public String register(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname, @QueryParam("email") String email,@QueryParam("birthyear") String birthyear) throws ApiException, IOException {
		System.out.println("--> ActivityResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String result = Users.registerUser(firstname, lastname, email, birthyear);
		return result;
	}
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Path("/user/id")
	public String getUserId(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname, @QueryParam("email") String email,@QueryParam("birthyear") String birthyear) throws ApiException, IOException {
		System.out.println("--> ActivityResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String id = Users.getUserID(firstname, lastname, email, birthyear);
		return id;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Path("/recommendation")
	public List<String> getRecommendation(@QueryParam("userId") String userId, @QueryParam("type") String type, @QueryParam("city") String city) throws ApiException, IOException {
		System.out.println("--> ActivityResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		List<String> recommendations = ActivityRecommendation.recommendActivities(userId, city, type);
		return recommendations;
	}
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	@Path("/feedback")
	public String getFeedback(@QueryParam("itemId") String itemId, @QueryParam("userId") String userId, @QueryParam("rating") String rating) throws ApiException, IOException {
		System.out.println("--> ActivityResource request...");
		System.out.println("--> URI = "+uriInfo);
		System.out.println("--> request = "+request);
		String result = Feedback.getFeedback(itemId, userId, rating);
		return result;
	}

	
}