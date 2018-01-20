# activity-rec-pws
RESTful process centric service for recommending activities. This layer layer serves all requests coming directly from application interface. The process centric services are the gateway to all other modules/services in an application context.

We call one external API to get a motivational quote about sports. This API has a limited access with only 10 request an a hour. If this number is exceeded we provide a static quote instead. 

Retrieving from TheySaidSo API:
- category = <could be one of these: sports,funny,inspire,management,life,love,art,students>

The following operations for the https://sde-activity-rec-pws.herokuapp.com/process endpoint are available in this service:

- /quotes @GET | [] | Returns a sport related random quote from external API.
- /user/registration @POST | [firstname, lastname, email, birthyear] | Saves input data if new user.
- /user/id @GET | [firstname, lastname, email, birthyear] | Returns id of given user.
- /recommendation @GET | [userId, city] | Get 5 recommended activities.
- /feedback @POST | [itemId, userId, rating] | Saves item as user preference and adds rating.

Reference:
- TheySaidSo API, Available at: https://quotes.rest/#!/qod/get_qod