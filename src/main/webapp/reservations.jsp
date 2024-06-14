<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.model.Reservation" %>
<%@ page import="com.dao.ReservationDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Reservation History</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="./css/reservation-style.css">
    <link rel="stylesheet" type="text/css" href="./css/styles-navbar.css">  
</head>
<body>
    <div class="navbar">
    	<div class="navbar-item">
       		<a href="userdash.jsp">
            	<i class="fas fa-home"></i>
        	</a>    	</div>
    	<div class="navbar-item">
       		<a href="reservations.jsp">
            	<i class="fas fa-calendar-alt"></i>
        	</a>
    	</div>
    	<div class="navbar-item">
    	   <a href="reviews.jsp">
        	<i class="fas fa-comment"></i> 
           </a>
    	</div>
    	<div class="navbar-item">
    		<a href="userprofile.jsp">
        		<i class="fa fa-user"></i> 
        	</a>
    	</div>
    	<div class="navbar-item">
    		<a href="LogoutServlet">
        		<i class="fas fa-sign-out-alt"></i> 
        	</a>
    	</div>
	</div>

	<div class="header">
	  	<div class="username">
  	 		 <h3><%= session.getAttribute("username") %> </h3>
    	</div>
    	<div class="navbar-item">
        	<i class="fas fa-bell"></i>
    	</div>
	</div>   
	
   
    <h1 class = "reservation-heading">Reservation Details</h1>
	<div class="reservation-container">
	     
	     
        <div class = "reservation-content">
          <%
          ReservationDAO reservationDAO = new ReservationDAO();
          HttpSession ses = request.getSession();
          String username = (String) ses.getAttribute("username");
          List<Reservation> reservations = reservationDAO.getClosedReservations(username);

          for (Reservation reservation : reservations) {
         %>

         <div class="reservation-card">
            <h2>Reservation <%= reservation.getResId() %></h2>
            <div>
            	<p><strong>Full Name:</strong> <%= reservation.getFullName() %></p>
            	<p><strong>Email:</strong><%= reservation.getEmail() %></p>
            	<p><strong>Phone:</strong><%= reservation.getPhone() %></p>
            	<p><strong>Check-In Date:</strong> <%= reservation.getCheckInDate() %></p>
            	<p><strong>Check-Out Date:</strong> <%= reservation.getCheckOutDate() %></p>
            	<p><strong>Room Option:</strong> <%= reservation.getRoomSelection() %></p>
            	<p><strong>No.of Rooms:</strong> <%= reservation.getNumberOfRooms() %></p>
            	<p><strong>No.of Guests:</strong> <%= reservation.getNumberOfGuests()  %></p>
            	<p><strong>Date Count:</strong><%= reservation.getDateCount() %></p> <br/>
            	<p><strong>Total Cost:</strong> <%= reservation.getTotalCost() %>  </p> <br>
            </div>          
            <div>
                  <button class="add-review-btn" onclick = "openPopup('review-window')">Add Review</button>
            </div>
         </div>
        
        <div id="review-window">
            <form action="ReviewServlet" method="post">
                       <div class="close-icon" id="close-icon">
            	           	 <a href="reservations.jsp" ><i class="fas fa-times"></i></a>
            	       </div>
            	         
            	        <div class="ad-review">            	           
            	          
                 	        <h1>Ad Review</h1>
                 	        
                 	        <input type="hidden" name="username" value="<%= session.getAttribute("username") %>">
                 	        <input type="hidden" name="hotelId" value="<%= reservation.getHotelId() %>">
                 	        <input type="hidden" name="roomType" value="<%= reservation.getRoomSelection() %>">
                                          	        
                 	        <div class="rating">
                 	            <span class="star" data-value="1">&#9733;</span>
                 	            <span class="star" data-value="2">&#9733;</span>
                 	            <span class="star" data-value="3">&#9733;</span>
                 	            <span class="star" data-value="4">&#9733;</span>
                 	            <span class="star" data-value="5">&#9733;</span>
                 	        </div>
                 	        
                 	        <label  class="rate-label">RATE:</label>
                 	        <select class="rate-select" name="Rating">
                 	        	<option>1</option>
                 	        	<option>2</option>
                 	        	<option>3</option>
                 	        	<option>4</option>
                 	        	<option>5</option>
                 	        </select>
                 	        <textarea name = "review-text" id="review-text" placeholder="Write your review here"></textarea><br>
                           
                 	         
                 	        <button id="submit-review">Submit Review</button>
                 	    </div>
            </form>
        </div>

        <%
          }
         %> 
     </div>    
    </div>
        <script src="./js/ud-script.js"></script>
</body>
</html>   