<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            margin-top: 20px;
        }

        .card {
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .card-header {
            font-size: 24px;
            background-color: rgb(128, 128, 255);
            color: #fff;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .btn-primary {
            background-color: rgb(128, 128, 255);
            border: none;
        }

        .btn-primary:hover {
            background-color: rgb(96, 96, 192);
        }
    </style>
</head>
<body class="bg-light">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header text-center">
                        <h4>Registration</h4>
                    </div>
                    <div class="card-body">
                        <form action="RegisterServlet" method="post">
                            <div class="form-group">
                                <label for="userName">Username</label>
                                <input type="text" class="form-control" name="userName" id="userName" required>
                            </div>
                            <div class="form-group">
                                <label for="firstName">First Name</label>
                                <input type="text" class="form-control" name="firstName" id="firstName" required>
                            </div>
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" name="lastName" id="lastName" required>
                            </div>
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" name="email" id="email" required>
                            </div>
                            <div class="form-group">
                                <label for="phone">Phone Number</label>
                                <input type="text" class="form-control" name="phone" id="phone" required>
                            </div>
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" name="address" id="address" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password" required>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword">Confirm Password</label>
                                <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
