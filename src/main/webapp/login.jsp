<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    .card {
        margin-top: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .card-header {
        font-size: 24px;
        background-color: rgb(128, 128, 255);
    }

    .form-group {
        margin-bottom: 20px;
    }

    .btn-primary {
        background-color: rgb(128, 128, 255);
        border: none;
    }

    .btn-primary:hover {
        background-color: rgb(96, 96, 192); /* A slightly darker shade for hover effect */
    }
</style>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header text-white text-center">
                        <h4>Login</h4>
                    </div>
                    <div class="card-body">
                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <label for="username">User Name</label>
                                <input type="text" class="form-control" name="username" id="username">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password">
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Login</button>
                            <!-- Add a Register button -->
                            <button type="button" class="btn btn-primary btn-block" id="registerBtn">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript to handle the register button click event -->
    <script>
        document.getElementById("registerBtn").addEventListener("click", function() {
            // Redirect to the registration page or perform any desired action
            window.location.href = "register.jsp"; // Change the URL to your registration page
        });
    </script>
</body>
</html>
