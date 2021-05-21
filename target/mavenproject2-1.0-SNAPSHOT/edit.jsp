<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Edytowac</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-shrink" id="mainNav">
        <div class="container">
            <a class="navbar-brand">Logistics</a>
            <button class="navbar-toggler navbar-toggler-right collapsed" type="button" data-toggle="collapse"
                data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                Menu
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav text-uppercase ml-auto">
                    <li class="nav-item"><a class="nav-link" href=' <c:url value="/" />'>Lista towarów</a></li>
                      <li class="nav-item"><a class="nav-link" href=' <c:url value="/create" />'>Nowy towar</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href=' <c:url value="/history" />'>Historia</a></li>
                      <li class="nav-item"><a class="nav-link" href=' <c:url value="/login" />'>Wyloguj sie</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <header class="edit">
        <div class="fon">
            <div class="container">
                <div class="text-center">
                    <h3 class="section-heading text-uppercase">Edytowac dane towaru #${product.id}</h3>
                </div>
                <form method="post">
                    <input type="hidden" value="${product.id}" name="id" />
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" value="${product.name}" class="form-control"
                                    placeholder="Wpisz nazwe towaru *" required="required" />
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" value="${product.price}" class="form-control" type="number"
                                    min="1" placeholder="Wpisz cene towaru *" required="required" />
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Producent</label>
                                <input name="proizwoditel" value="${product.proizwoditel}" class="form-control"
                                    placeholder="Wpisz producenta *" required="required" />
                            </div>
                            <div class="form-group">
                                <label>Ilosc</label>
                                <input name="koliczestwo" value="${product.koliczestwo}" class="form-control"
                                    type="number" placeholder="Wpisz ilosc *" min="1" required="required" />
                            </div>
                        </div>
                    </div>
                    <div class="text-center">
                        <input class="btn btn-primary btn-block text-uppercase" type="submit" value="Send" />
                    </div>
            </div>
            </form>
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