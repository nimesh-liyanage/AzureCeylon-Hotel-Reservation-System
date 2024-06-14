<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile - Admin Dashboard</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Add Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="./css/admin-dash.css">
</head>
<body>
    <!-- Left Sidebar -->
    <div class="sidebar">
        <a href="#" class="active"><i class="fas fa-user"></i> Admin Profile</a>
        <a href="/HotelRes/hotel-list"><i class="fas fa-hotel"></i> Hotels</a>
        <a href="/HotelRes/list-room"><i class="fas fa-bed"></i> Rooms</a>
        <a href="#" id="logoutButton"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </div>

    <!-- Main Content -->
    <div class="main-content">
    <h2>Admin Dashboard</h2>
    <div class="container">
        <h4>Admin Information</h4>
        <p><strong>Username:</strong> JohnDoe123</p>
        <p><strong>Email:</strong> john.doe@example.com</p>
        <p><strong>First Name:</strong> John</p>
        <p><strong>Last Name:</strong> Doe</p>

    </div>
	</div>
	
	<!-- Logout Confirmation Modal -->
    <div class="modal" tabindex="-1" role="dialog" id="logoutModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Logout Confirmation</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to logout?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <a href="LogoutServlet" class="btn btn-primary">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Add Bootstrap and jQuery for interactivity -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Add "active" class to the current tab based on the URL
        $(document).ready(function() {
            var currentUrl = window.location.href;
            $('.sidebar a').each(function() {
                if (currentUrl.includes($(this).attr('href'))) {
                    $(this).addClass('active');
                }
            });

            // Open the logout confirmation modal
            $('#logoutButton').click(function() {
                $('#logoutModal').modal('show');
            });
        });
    </script>
</body>
</html>
