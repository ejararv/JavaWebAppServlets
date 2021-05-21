<%-- 
    Document   : login
    Created on :
    Author     : 123
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>LOGISTICS LOGIN</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>

<body>

    <header class="login">
        <div class="row">
            <div class="col-6 hide">
            </div>
            <div class="col-6 full">
                <div class="fon">
                    <div class="container">
                        <div class="masthead-heading text-uppercase">
                            <label>LOGISTICS</label>
                        </div>

                        <form method="post" action="login">
                            <div class="form-group">
                                <h5 class="card-title">Zaloguj sie</h5>
                                <div class="form-group">

                                    <input type="email" id="email" name="email" class="form-control"
                                        placeholder="Wpisz email" />
                                </div>
                                <div class="form-group">
                                    <input type="password" id="password" name="password" class="form-control"
                                        placeholder="Wpisz haslo" />
                                </div>
                            </div>
                            <div>
                                <input type="submit" value="Zaloguj sie" class="btn btn-primary" />
                            </div>

                        </form>
                        <p><a href="/mavenproject2/register" />Rejestracja</a></p>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</body>

</html>