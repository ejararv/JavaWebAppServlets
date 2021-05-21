<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGISTICS REGISTRATION</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
              integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">

        <script>
            var openFile = function openFile(file) {
                var input = file.target;
                var reader = new FileReader();
                reader.onload = function () {
                    var dataURL = reader.result;
                    var output = document.getElementById('img1');
                    output.src = dataURL;
                    document.getElementById("profile").value = dataURL;
                };
                reader.readAsDataURL(input.files[0]);
            };
        </script>
    </head>

    <body>
        <header class="login">
		<div class="reg">
			<div class="container">
            <div class="masthead-heading text-uppercase">
                <label htmlFor="link">LOGISTICS REGISTRATION</label>
            </div>

            <form action="register" method="post">
                <!--------Login Details------>
                <div class="row">
                    <div class="col-md-4">
                        <div class="team-member">
                            <img src="img/foto.jpg" class="mx-auto rounded-circle" id="img1" width="200"
                                 height="200" />
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-group mb-2">
                            <label for="email" class="mb-0">Email</label>
                            <input type="email" id="email" name="email" class="form-control"
                                   placeholder="przykład@mail.com" required>
                        </div>
                        <div class="form-group mb-2">
                            <label for="password" class="mb-0">Hasło</label>
                            <input type="password" id="code" name="password" class="form-control"
                                   placeholder="Hasło" required>
                        </div>
                        <label for="img " class="mb-0">Zdjęcie profilowe</label>
                        <input type="file" enctype="multipart/form-data" name="pimg2" class="inputBox mb-1" id="img"
                               onchange="openFile(event)" />
                        <input type="hidden" class="btn btn-primary" name="image" id="image">
                    </div>

                    <div class="col-md-4">
                        <div class="form-group mb-2">
                            <label for="contact" class="mb-0">Numer kontaktowy </label>
                            <input type="tel" id="contact" name="contact" class="form-control"
                                   placeholder="+48*********" required>
                        </div>

                        <div class="form-group mb-2">
                            <label for="confirm" class="mb-0">Potwierdź hasło </label>
                            <input type="password" id="confirm" name="confirm" class="form-control"
                                   placeholder="Wprowadź ponownie hasło" required>
                        </div>
                    </div>
                </div>
                <hr />
                <!--------Personal Details---------->
                <div class="container">
                    <h5>DANE OSOBOWE</h5>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group mb-2">
                                <label for="name" class="mb-0">Imię i nazwisko </label>
                                <input type="text" id="name" name="name" class="form-control"
                                       placeholder="Imię i nazwisko" required>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="form-group mb-2">
                                <label for="age" class="mb-0">Wiek</label>
                                <input type="number" id="age" name="age" class="form-control" placeholder="Wiek"
                                       min="18" required>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group mb-2">
                                <label for="gender " class="mb-0">Gender</label>
                                <select class="form-control mb-2" id="gender" name="gender" required>
                                    <option value="">Wybierz...</option>
                                    <option value="MALE">PAN</option>
                                    <option value="FEMALE">PANI</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <hr />
                <div class="container">
                        <input type="Submit" class="btn btn-primary btn-block"  value="Zarejestruj sie">

                        <a class="btn btn-secondary btn-block" href=' <c:url value="/login" />'>Zaloguj sie</a>
                </div>
            </form>


        </header>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
    </body>

</html>