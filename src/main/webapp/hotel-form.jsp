<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotels - Admin Dashboard</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="./css/hotel-form.css">
</head>
<body>
    <!-- Left Sidebar -->
    <div class="sidebar">
        <a href="<%=request.getContextPath()%>/admin-dash.jsp"><i class="fas fa-user"></i> Admin Profile</a>
        <a href="/HotelRes/hotel-list" class="active"><i class="fas fa-hotel"></i> Hotels</a>
    </div>

    <!-- Main Content -->
    <div class="main-content">
        <h2>Admin Dashboard</h2>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${hotel != null}">
                        <form id="hotelForm" action="hotel-update" method="post">
                    </c:if>
                    <c:if test="${hotel == null}">
                        <form id="hotelForm" action="hotel-insert" method="post">
                    </c:if>
    
                    <caption>
                        <h2>
                            <c:if test="${hotel != null}">
                            Edit Hotel
                        </c:if>
                            <c:if test="${hotel == null}">
                            Add New Hotel
                        </c:if>
                        </h2>
                    </caption>
    
                    <c:if test="${hotel != null}">
                        <input type="hidden" name="HotelID" value="<c:out value='${hotel.getHotelID()}' />" />
                    </c:if>
    
                    <fieldset class="form-group">
                        <label>HotelName</label> <input type="text"
                            value="<c:out value='${hotel.getHotelName()}' />" class="form-control"
                            name="HotelName" required>
                    </fieldset>
    
                    <fieldset class="form-group">
                        <label>Address</label> <input type="text"
                            value="<c:out value='${hotel.getAddress()}' />" class="form-control"
                            name="Address" required>
                    </fieldset>
    
                    <fieldset class="form-group">
                        <label>ContactNumber</label> <input type="number"
                            value="<c:out value='${hotel.getContactNumber()}' />" class="form-control"
                            name="ContactNumber" required>
                    </fieldset>
                    
                    <fieldset class="form-group">
                        <label>Description</label> <input type="text"
                            value="<c:out value='${hotel.getDescription()}' />" class="form-control"
                            name="Description" required>
                    </fieldset>
    
                    <fieldset class="form-group">
                        <label>Rating</label> <input type="number"
                            value="<c:out value='${hotel.getRating()}' />" class="form-control"
                            name="Rating" required>
                    </fieldset>
    
                    <button type="button" class="btn btn-success" id="saveButton">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap Modal for Confirmation Dialog -->
    <div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="confirmationModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmationModalLabel">Confirm Action</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to save this hotel?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-success" id="confirmSave">Save</button>
                </div>
            </div>
        </div>
    </div>
    
    	<!-- Bootstrap Modal for Empty Fields Alert -->
	<div class="modal fade" id="emptyFieldsModal" tabindex="-1" role="dialog" aria-labelledby="emptyFieldsModalLabel" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="emptyFieldsModalLabel">Empty Fields Alert</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	            </div>
	            <div class="modal-body">
	                Please fill in all required fields.
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>

    <!-- Add Bootstrap and jQuery for interactivity -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
	    $(document).ready(function() {
	        // Add "active" class to the current tab based on the URL
	        var currentUrl = window.location.href;
	        $('.sidebar a').each(function() {
	            if (currentUrl.includes($(this).attr('href'))) {
	                $(this).addClass('active');
	            }
	        });
	
	        // Save Button Click Handler
	        $('#saveButton').click(function() {
	            var emptyFields = false;
	            $('input[required]').each(function() {
	                if ($(this).val() === '') {
	                    emptyFields = true;
	                }
	            });
	
	            if (emptyFields) {
	                // Show empty fields alert
	                $('#emptyFieldsModal').modal('show');
	            } else {
	                // Show save confirmation dialog
	                $('#confirmationModal').modal('show');
	
	                $('#confirmSave').click(function() {
	                    $('#hotelForm').submit(); // Submit the form when confirmed
	                    $('#confirmationModal').modal('hide'); // Close the modal
	                });
	            }
	        });
	    });
	</script>

</body>
</html>
