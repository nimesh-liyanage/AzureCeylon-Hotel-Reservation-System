<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="./css/checkout-style.css">
</head>
<body>
    <div class="checkout-container">
        <div class="header">
            <h2>Checkout Details</h2>
        </div>

        <div class="info">
            <h3>Name: <%= session.getAttribute("fullName") %></h3>
            <h3>Email: <%= session.getAttribute("email") %></h3>
            <h3>Phone No: <%= session.getAttribute("phone") %></h3>
            <h3>Check-In Date: <%= session.getAttribute("checkInDate") %></h3>
            <h3>Check-Out Date: <%= session.getAttribute("checkOutDate") %></h3>
            <h3>Room Option: <%= session.getAttribute("roomSelection") %></h3>
            <h3>Room Count: <%= session.getAttribute("numberOfRooms") %></h3>
            <h3>Guest Count: <%= session.getAttribute("numberOfGuests") %></h3>
            <h3>Date Count: <%= session.getAttribute("dateCount") %></h3>           
            <h3>Total Cost: $<%= session.getAttribute("totalCost") %></h3>            
        </div>

        <div class="buttons">
            <form action="userdash.jsp">
                <button type="submit" class="cancel-button">Cancel</button>
            </form>

            <form action="ReservationServlet" method="post">
                 <input type="hidden" name="username" value="<%= session.getAttribute("username") %> ">    
                 <input type="hidden" name="fullName" value="<%= session.getAttribute("fullName") %>">
                 <input type="hidden" name="email" value="<%= session.getAttribute("email") %>">
                 <input type="hidden" name="phone" value="<%= session.getAttribute("phone") %>">
                 <input type="hidden" name="checkInDate" value="<%= session.getAttribute("checkInDate") %>">
                 <input type="hidden" name="checkOutDate" value="<%= session.getAttribute("checkOutDate") %>">
                 <input type="hidden" name="hotelId" value="<%= session.getAttribute("hotelId") %> ">    
                 <input type="hidden" name="roomSelection" value="<%= session.getAttribute("roomSelection") %> ">                
                 <input type="hidden" name="numberOfRooms" value="<%= session.getAttribute("numberOfRooms") %> ">                
                 <input type="hidden" name="numberOfGuests" value="<%= session.getAttribute("numberOfGuests") %> "> 
                 <input type="hidden" name="dateCount" value="<%= session.getAttribute("dateCount") %>">
                 <input type="hidden" name="totalCost" value="<%= session.getAttribute("totalCost") %>">
                                
                             
                 <button type="submit" class="confirm-button">Confirm</button>
            </form>
        </div>
    </div>

   
</body>
</html>
