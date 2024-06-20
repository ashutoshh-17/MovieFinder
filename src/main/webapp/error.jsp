<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylee.css">
    <title>Movie Not Found</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('images/backgrnd2.png');
            background-size: cover;
 			background-position: center center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f9fa;
            margin: 0;
        }
        .error-container {
            text-align: center;
            padding: 20px;
            border: 2px solid #dc3545;
            background-color: #FAF9F6;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .error-container h1 {
            color: #dc3545;
        }
        .error-container p {
            color: #333333;
            }  
    </style>
</head>
<body>
 <div class="search-container">
        
        <form action="myservlet21" method="post" class="searchInput">
             <input type="text" id="search-box" class="search-box" name="movie" placeholder="Search for movies" required>
    <button id="search-button" class="search-button">Search</button>
        </form>
        </div>
        <a href="index.html">
     <h1 style="margin-left: 20px;"> <img alt="MovieFinder Logo" src="images/logoo.png" style="width: 190px;"></h1>
    </a>
    <div class="error-container">
        <h1>OOPS! Movie Not Found</h1>
        <p>Please check for misspelling and try again.</p>
    </div>
</body>
</html>
