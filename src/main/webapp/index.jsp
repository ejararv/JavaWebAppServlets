<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Lista towarów</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>

<body class="bg-light">

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


    <div class="container">
        <h3 class=" text-uppercase">Lista towarów</h3>
        <p><a class="btn btn-primary text-uppercase" href='<c:url value="/create" />'>Dodac nowy towar</a></p>
        <table class="table section-heading">
            <thead class=" text-uppercase">
                <tr class="table-active">
                    <th>Towar</th>
                    <th class="hide">Producent</th>
                    <th>Ilosc</th>
                    <th>Cena</th>
                    <th>Opcje</th>
                </tr>
            </thead>
            <tbody class="table-active">
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.name}</td>
                        <td class="hide">${product.proizwoditel}</td>
                        <td>${product.koliczestwo}</td>
                        <td>${product.price}</td>
                        <td>
                            <a class="btn btn-secondary text-uppercase"
                                href='<c:url value="/edit?id=${product.id}" />'>Edytowac</a> |
                            <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                                <input type="hidden" name="id" value="${product.id}">
                                <input class="btn btn-primary text-uppercase" type="submit" value="wyslac">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</body>

</html>