<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <link rel="stylesheet" 
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/fontawesome.min.css"/>
        <link rel="stylesheet" href="stylee.css">
        <title>${title} (${year}) - MovieFinder</title>
    </head>
    <body>
  
        <div class="search-container">
        
        <form action="myservlet21" method="post" class="searchInput">
             <input type="text" id="search-box" class="search-box" name="movie" placeholder="Search for movies" required>
    <button id="search-button" class="search-button">Search</button>
        </form>
        </div>
        <div class="text-color">
     
        <h1 style="margin-left: 20px;"><img alt="MovieFinder Logo" src="images/logoo.png" style="width: 190px;"></h1>
        <h2 style="margin-left: 20px;">${title} (${year}) | <img alt="IMDb Logo" src="images/IMDb2.png" style="width: 60px; vertical-align: middle; margin-bottom: 4px;"> ${imdbRating} </h2>
    
        <div class="poster">   
	    <img src="${poster}" alt="Poster">
	    </div>
	    
	    <div class="movie-info" >
	   
	    <div>
	    <p><strong>Rated:</strong> ${rated}</p>
	    </div>
	    
	    <div>
	    <p><strong>Released:</strong> ${released}</p>
	    </div>
	    
	    <div>
	    <p><strong>Runtime:</strong> ${runtime}</p>
	    </div>
	    
	    <div>
	    <p><strong>Genre:</strong> ${genre}</p>
	    </div>
	    
	    <div>
	    <p><strong>Actors:</strong> ${actors}</p>
	    </div>
	    
	    <div>
	    <p><strong>Plot:</strong> ${plot}</p>
	    </div>
	    
	    <div>
	    <p><strong>Language:</strong> ${language}</p>
	    </div>
	    
	    <div>
	    <p><strong>Country:</strong> ${country}</p>
	    </div>
	    
	    <div>
	    <p><strong>Awards:</strong> ${awards}</p>
	    </div>
	    
	    <div>
	    <p><strong>IMDB Votes:</strong> ${imdbVotes}</p>
	    </div>
        </div>
        </div>
    </body>
</html>