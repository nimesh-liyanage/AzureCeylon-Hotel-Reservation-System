<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
    
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/userprofile-style.css">
</head>
<body>
    <div class="profile-container">
        <h1>User Profile</h1>
        <div class="profile-card">
            <h2>Username: <span id="username"><%= session.getAttribute("username") %> </span></h2>
            <p><strong>Email:</strong> <span id="email">johndoe@example.com</span></p>
            <p><strong>First Name:</strong> <span id="first_name">John</span></p>
            <p><strong>Last Name:</strong> <span id="last_name">Doe</span></p>
            <p><strong>Phone Number:</strong> <span id="phone_number">123-456-7890</span></p>
        </div>
        <button id="update-button" onclick = "openPopup('update-window')">Update Profile</button>
    </div>
    
    <div class="update-window" id="update-window">
        <div class="update-form">
            <h2>Update Profile</h2>
            <form>
                <input type="text" id="update-email" placeholder="Email">
                <input type="text" id="update-first-name" placeholder="First Name">
                <input type="text" id="update-last-name" placeholder="Last Name">
                <input type="text" id="update-phone-number" placeholder="Phone Number">
                <button type = "submit" id="save-button" >Save Details</button>
                <button id="cancel-button" onclick="closePopup('update-window')">Cancel</button>
            </form>
        </div>
    </div>
    <script src="./js/ud-script.js"></script>
</body>
</html>
