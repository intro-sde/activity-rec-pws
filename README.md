# activity-rec-pws
RESTful process centric service for recommending activities.

The following operations for the https://sde-activity-rec-pws.herokuapp.com/process endpoint are available in this service:

- /quotes @GET | [] | Returns a list of sport related random quotes from external API.
- /user/registration @POST | [firstname, lastname, email, birthyear] | Saves input data if new user.
- /user/id @GET | [firstname, lastname, email, birthyear] | Returns id of given user.
- /recommendation @GET | [userId, type, city] | Get 5 recommended items.
- /feedback @POST | [itemId, userId, rating] | Saves item as user preference and adds rating.