<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.model.Review" %>
<%@ page import="com.dao.ReviewDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Review Information</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="./css/review-style.css">
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
	
    <h1 class = "review-heading">REVIEW INFORMATION</h1>
     <div class="review-container">
        <table border="1">
            <tr>
                <th>Review ID</th>
                <th>Hotel ID</th>
                <th>Room Type</th>
                <th>Rating</th>
                <th>Review Text</th>
                <th>Review Date</th>
                <th>Actions</th>
            </tr>

            <%
            ReviewDAO reviewDAO = new ReviewDAO();
            HttpSession ses = request.getSession();
            String username = (String) ses.getAttribute("username");
            List<Review> reviews = reviewDAO.getReviews(username);

            for (Review review : reviews) {
            %>
                <tr>
                    <td><%= review.getReviewID() %></td>
                    <td><%= review.getHotelID() %></td>
                    <td><%= review.getRoomType() %></td>
                    <td><%= review.getRating() %></td>
                    <td><%= review.getReviewText() %></td>
                    <td><%= review.getReviewDate() %></td>
                    <td>
                    	<div class = "button-container">
							<button class="btn-edit" onclick="openPopup('up-review-window-<%= review.getReviewID() %>')">Edit</button>
                    		<form action="DeleteReviewServlet" method="post">
            					<input type="hidden" name="reviewId" value="<%= review.getReviewID()%>">
            					<button type="submit" class="btn-delete">Delete</button>
            				</form>  
            			</div> 
            			
						<div id="up-review-window-<%= review.getReviewID() %>" class="up-review-window">
                        	<form action="UpdateReviewServlet" method="post">
                         		<div class="popup-content">
                         			<fieldset>
                         			    <legend>Change Review</legend>
                         			    <input type="hidden" name="reviewId" value="<%= review.getReviewID() %>"> 
                         			    <label for="rating">Rating:</label>
                         			    <input type="text" name="rating" value="<%= review.getRating() %>"><br><br>
                         			    <label for="review-text">Review Text:</label>
                         		        <textarea name="review-text"><%= review.getReviewText() %></textarea><br><br>                        			    
					 	 			    <button type="button" onclick="closePopup('up-review-window-<%= review.getReviewID() %>')">Close</button>
                         			    <button type="submit">Save Details</button><br>
                         			</fieldset>
                         		</div>
                        	</form>
                        </div>                   
                    </td>
                    
                </tr>
            <%
            }
            %>
        </table>
    </div>
          
     <script src="./js/ud-script.js"></script>          
</body>
</html>
