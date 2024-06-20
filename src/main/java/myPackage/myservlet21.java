package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class myservlet21
 */
public class myservlet21 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myservlet21() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // API key and movie parameter from request
	        String apiKey = "74ce71fd";
	        String movie = request.getParameter("movie");

	        // Construct the API URL
	        String apiUrl = "https://www.omdbapi.com/?t=" + movie + "&apikey=" + apiKey;

	        // Create URL object and open connection
	   try {
	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");

	        // Handle the response
	        InputStream inputStream;
	        int status = connection.getResponseCode();
	        if (status == HttpURLConnection.HTTP_OK) {
	            inputStream = connection.getInputStream();
	        } else {
	            inputStream = connection.getErrorStream();
	        }

	        // Read the response
	        InputStreamReader reader = new InputStreamReader(inputStream);
	        Scanner scanner = new Scanner(reader);
	        StringBuilder responseContent = new StringBuilder();
	        while (scanner.hasNext()) {
	            responseContent.append(scanner.nextLine());
	        }
	        scanner.close();

	        // Log the response (optional)
	        System.out.println(responseContent);
	        
	        //type casting 
            
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);
            
            // Check if the movie was found
            if (jsonObject.has("Response") && jsonObject.get("Response").getAsString().equals("False")) {
                // Redirect to the error page
                request.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }
	          
            String title = jsonObject.get("Title").getAsString();
            String year = jsonObject.get("Year").getAsString();
            String rated = jsonObject.get("Rated").getAsString();
            String released = jsonObject.get("Released").getAsString();
            String runtime = jsonObject.get("Runtime").getAsString();
            String genre = jsonObject.get("Genre").getAsString();
            String actors = jsonObject.get("Actors").getAsString();
            String plot = jsonObject.get("Plot").getAsString();
            String language = jsonObject.get("Language").getAsString();
            String country = jsonObject.get("Country").getAsString();
            String awards = jsonObject.get("Awards").getAsString();
            String poster = jsonObject.get("Poster").getAsString();
            String imdbRating = jsonObject.get("imdbRating").getAsString();
            String imdbVotes = jsonObject.get("imdbVotes").getAsString();
            
            request.setAttribute("title", title);
            request.setAttribute("year", year);
            request.setAttribute("rated", rated);
            request.setAttribute("released", released);
            request.setAttribute("runtime", runtime);
            request.setAttribute("genre", genre);
            request.setAttribute("actors", actors);
            request.setAttribute("plot", plot);
            request.setAttribute("language", language);
            request.setAttribute("country", country);
            request.setAttribute("awards", awards);
            request.setAttribute("poster", poster);
            request.setAttribute("imdbRating", imdbRating);
            request.setAttribute("imdbVotes", imdbVotes);
	        

	        // Set the response content as an attribute for the JSP
	        request.setAttribute("apiResponse", responseContent.toString());

	        // Clean up
	        connection.disconnect();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	        // Forward the request to the JSP page
	        request.getRequestDispatcher("Result.jsp").forward(request, response);
	    }

}