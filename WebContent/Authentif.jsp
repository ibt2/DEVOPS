<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="logintemp/fonts/icomoon/style.css">
    <link rel="stylesheet" href="logintemp/css/owl.carousel.min.css">
    <link rel="stylesheet" href="logintemp/css/bootstrap.min.css">
    <link rel="stylesheet" href="logintemp/css/style.css">

    <title>Login</title>
  </head>
  <body>
  
  <div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <img src="logintemp/images/undraw_remotely_2j6y.svg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">
                <h3>Login</h3>
                <p class="mb-4">Veuillez entrer vos informations de connexion ci-dessous.</p>
              </div>
              <form action="Login" method="post">
                <div class="form-group first">
                  <label for="id_patient">ID</label>
                  <input type="text" class="form-control" name="id_patient" id="id_patient" required>
                </div>
                <div class="form-group last mb-4">
                  <label for="password">Password</label>
                  <input type="password" class="form-control" name="password" id="password" required>
                </div>
                
                <input type="submit" value="Login" class="btn btn-block btn-primary">
              </form>

              <c:if test="${bool != null && bool == false}">
                <p class="text-danger mt-3">Vos informations sont erronées. Veuillez les saisir à nouveau correctement.</p>
              </c:if>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="logintemp/js/jquery-3.3.1.min.js"></script>
  <script src="logintemp/js/popper.min.js"></script>
  <script src="logintemp/js/bootstrap.min.js"></script>
  <script src="logintemp/js/main.js"></script>
  </body>
</html>
