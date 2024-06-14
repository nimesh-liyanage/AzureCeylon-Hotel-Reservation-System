<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The AZURE Hotels</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/test.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">The Azure Hotels</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Rooms</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Dining</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Events</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </div>
    </nav>

    <header class="jumbotron">
        <div class="container">
            <h1>Welcome The Azure Hotels</h1>
            <p>Your Perfect Destination</p>
            <a href="login.jsp" class="btn btn-primary btn-lg">Book Now</a>
        </div>
    </header>
<section class="photo-collage">
    <div class="photo">
        <img src="./images/image1.jpg" alt="Photo 1">
    </div>
    <div class="photo">
        <img src="./images/image2.jpg" alt="Photo 2">
    </div>
    <div class="photo">
        <img src="./images/image3.jpeg" alt="Photo 3">
    </div>
    <div class="photo">
        <img src="./images/image4.jpg" alt="Photo 4">
    </div>
</section>
   
<section class="facilities">
    <div class="facility-card">
        <div class="facility-icon">
            <i class="fas fa-bed"></i>
        </div>
        <h2>Luxurious Accommodations</h2>
        <p>Enjoy spacious and elegantly designed rooms with modern amenities for your comfort and relaxation.</p>
    </div>

    <div class="facility-card">
        <div class="facility-icon">
            <i class="fas fa-utensils"></i>
        </div>
        <h2>Dining Excellence</h2>
        <p>Savor a culinary journey with a variety of cuisines, from traditional Sri Lankan flavors to international dishes.</p>
    </div>

    <div class="facility-card">
        <div class="facility-icon">
            <i class="fas fa-swimming-pool"></i>
        </div>
        <h2>Relaxation and Recreation</h2>
        <p>Enjoy our swimming pools, fitness centers, and soothing spa treatments for the ultimate relaxation experience.</p>
    </div>

    <div class="facility-card">
        <div class="facility-icon">
            <i class="fas fa-users"></i>
        </div>
        <h2>Event Hosting</h2>
        <p>Host your special events, conferences, and gatherings in our well-equipped event venues with professional event planning services.</p>
    </div>
</section>
    
    <footer class="text-center py-3">
        &copy; 2023 The AZURE Hotels
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
