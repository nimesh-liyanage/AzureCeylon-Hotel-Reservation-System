<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Reservation" %>
<%@ page import="com.dao.ReservationDAO" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="./css/udstyle.css">
    <link rel="stylesheet" type="text/css" href="./css/styles-navbar.css">
    
</head>
<body>
    <div class="navbar">
    	<div class="navbar-item">
       		<a href="userdash.jsp">
            	<i class="fas fa-home"></i>
        	</a>    	
        </div>
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

	<div class="container">
          
        <div class="room-options"> 
                 		
            <div class="card">
                <img src="./images/room1.jpg" alt="Room Image" class="room-image">
                <div class = "card-details">
                	<h4>AzureCeylon Colombo</h4>
                    <p>Discover the vibrant heart of Sri Lanka's capital Where luxury meets the bustling cityscape.</p>                	
                	<div class="facility-icons">
                	    <i class="fas fa-wifi facility-icon"></i>
                	    <i class="fas fa-bed facility-icon"></i>
                	    <i class="fas fa-tv facility-icon"></i>
                	    <i class="fas fa-coffee facility-icon"></i>
                	</div>
                </div>
                <div>
                	<button class = "roomdetails-btn">More Details</button>
                	<button onclick="openBookWindow( 1,'AzureCeylon Colombo')" class = "booknow-btn" >Book Now</button>
                </div>
            </div>
            
            <div class="card" >
                <img src="./images/room2.jpg" alt="Room Image" class="room-image">
                 <div class = "card-details">
                	<h4>AzureCeylon Galle</h4>
					<p>Escape to the historic coastal charm of Galle, Immerse in the beauty of the fort city.</p>                	
                	<div class="facility-icons">
                	    <i class="fas fa-wifi facility-icon"></i>
                	    <i class="fas fa-bed facility-icon"></i>
                	    <i class="fas fa-tv facility-icon"></i>
                	    <i class="fas fa-coffee facility-icon"></i>
                	</div>
                </div>
                <div>
                	<button class = "roomdetails-btn">More Details</button>
                	<button onclick="openBookWindow(2, 'AzureCeylon Galle')" class = "booknow-btn" >Book Now</button>
                </div>
            </div>
            
            <div class="card" data-hotel="hotel3">
                <img src="./images/room3.jfif" alt="Room Image" class="room-image">
                <div class = "card-details">
                	<h4>AzureCeylon Kandy</h4>
 					<p>Experience the cultural tapestry of Sri Lanka's hill capital Where tradition and tranquility unite.</p>                	
                	<div class="facility-icons">
                	    <i class="fas fa-wifi facility-icon"></i>
                	    <i class="fas fa-bed facility-icon"></i>
                	    <i class="fas fa-tv facility-icon"></i>
                	    <i class="fas fa-coffee facility-icon"></i>
                	</div>
                </div>
                <div>
                	<button class = "roomdetails-btn">More Details</button>
                	<button onclick="openBookWindow(3, 'AzureCeylon Kandy')" class = "booknow-btn"  >Book Now</button>
                </div>
            </div> 
            
        </div>
    

    
     <div class="ongoing-reservations">
     	<h2>Ongoing Reservations</h2>
     	<h4>The reservations that are currently ongoing</h4>
            
			<div class = "reservation-cards">
          	  <%
          	    ReservationDAO reservationDAO = new ReservationDAO();
          	    List<Reservation> reservations = reservationDAO.getOgReservations();

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
            	        <p><strong>No. of Rooms:</strong> <%= reservation.getNumberOfRooms() %></p>
                    	<p><strong>No. of Guests:</strong> <%= reservation.getNumberOfGuests()  %></p>
            			<p><strong>Date Count:</strong> <%= reservation.getDateCount() %></p>
            			<p><strong>Total Cost:</strong> <%= reservation.getTotalCost() %></p>
            		</div>
            		<div class = "button-container">
            			<form action="DeleteReservationServlet" method="post">
            		  		<input type="hidden" name="reservationId" value="<%=reservation.getResId()%>">
            		  		<button type="submit" class="cancel-button">Cancel</button>
            		    </form>
            		      <button class="edit-button" onclick = "openPopup('edit-window-<%=reservation.getResId()%>')">Edit</button>
            		</div>
            	</div>
            	
                <div id="edit-window-<%=reservation.getResId()%>" class = "edit-window">
                    <form action="UpdateReservationServlet" method="post">
                        <fieldset>
                            <legend>Change Reservation Details</legend>
                            <input type="hidden" name="resId" value="<%=reservation.getResId()%>">
                            <input type="text" name="fullName" value="<%= reservation.getFullName() %>"><br><br>
                            <input type="text" name="email" value="<%= reservation.getEmail() %>"><br><br>
                            <input type="text" name="phone" value="<%= reservation.getPhone() %>"><br><br>
                            
                            <button type="button" onclick="closePopup('edit-window-<%=reservation.getResId()%>')">Close</button>
                            <button type="submit">Save Details</button><br>
                        </fieldset>
                     </form>
                </div>
            	  <%
              }
             %>        
			</div>          
     	</div>
	</div>
    
       <div id= "book-window" class = "book-window">
    	<form action="CheckOutServlet" method="post">
        	<fieldset>
            	<legend id="selectedHotel"></legend>
            	
            	    <input type="hidden" name="hotelId" id="hotelId" value=""><br>
            	    
            	    <label for="roomSelection">Select Room Option:</label>
            	    <select id="roomSelection"  name="roomSelection" class = "roomSelection">
            	       	<option value="single">Single</option>
            	       	<option value="double">Double</option>
            	       	<option value="suite">Suite</option>
            	    </select><br><br>
            	    
            	    <label for="numberOfRooms">Number of Rooms:</label>
					<input type="number" id="numberOfRooms" name="numberOfRooms"> <br><br>
					
					<label for="numberOfGuests">Number of Guests:</label>
					<input type="number" id="numberOfGuests" name="numberOfGuests"><br><br>
					          	    
            	    <label for="fullName">Full Name:</label>
                    <input type="text" id="fullName" name="fullName" required><br><br>

                    <label for="email">Email Address:</label>
                    <input type="email" id="email" name="email" required><br><br>

                    <label for="phone">Contact Number:</label>
                    <input type="tel" id="phone" name="phone" required><br><br>
                    
                    <label for="checkInDate">Check-In Date:</label>
                    <input type="date" id="checkInDate" name="checkInDate" required><br><br>

                    <label for="checkOutDate">Check-Out Date:</label>
                    <input type="date" id="checkOutDate" name="checkOutDate" required><br><br>
       
                	<button type ="button" onclick = "closePopup('book-window')" >close</button>
                	<button type ="submit" >confirm</button><br> 
            </fieldset>
         </form>  
     </div>
    
    <script src="./js/ud-script.js"></script>
</body>
</html>

	