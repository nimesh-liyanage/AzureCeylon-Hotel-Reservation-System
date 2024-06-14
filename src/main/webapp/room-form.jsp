<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rooms - Admin Dashboard</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="./css/room-form.css">

</head>
<body>
    <!-- Left Sidebar -->
    <div class="sidebar">
        <a href="<%=request.getContextPath()%>/admin-dash.jsp"><i class="fas fa-user"></i> Admin Profile</a>
        <a href="/HotelRes/list-room" class="active"><i class="fas fa-bed"></i> Rooms</a>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h2>Admin Dashboard</h2>
        
	<div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${room != null}">
                        <form action="update-room" method="post" onsubmit="return validateForm();">
                    </c:if>
                    <c:if test="${room == null}">
                        <form action="insert-room" method="post" onsubmit="return validateForm();">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${room != null}">
                                Edit Room
                            </c:if>
                            <c:if test="${room == null}">
                                Add New Room
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${room != null}">
                        <input type="hidden" name="RoomID" value="<c:out value='${room.getRoomID()}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>HotelID</label>
                        <input type="number" value="<c:out value='${room.getHotelID()}' />" class="form-control" name="HotelID" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>RoomNumber</label>
                        <input type="text" value="<c:out value='${room.getRoomNumber()}' />" class="form-control" name="RoomNumber" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>RoomType</label>
                        <input type="text" value="<c:out value='${room.getRoomType()}' />" class="form-control" name="RoomType" required>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>PricePerNight</label>
                        <input type="number" value="<c:out value='${room.getPricePerNight()}' />" class="form-control" name="PricePerNight" required>
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
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
        });
        
        function validateForm() {
            // Basic validation, you can add more specific validation as needed
            var hotelID = document.forms[0]["HotelID"].value;
            var roomNumber = document.forms[0]["RoomNumber"].value;
            var roomType = document.forms[0]["RoomType"].value;
            var pricePerNight = document.forms[0]["PricePerNight"].value;

            if (hotelID === "" || roomNumber === "" || roomType === "" || pricePerNight === "") {
                alert("All fields are required");
                return false;
            }

            return true;
        }
    </script>
</body>
</html>