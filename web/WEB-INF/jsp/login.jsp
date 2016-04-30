<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="museo.db.Utente" scope="session" />
<html>
    <head>

        <title>Login</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            $(function () {

                $('#login-form-link').click(function (e) {
                    $("#login-form").delay(100).fadeIn(100);
                    $("#register-form").fadeOut(100);
                    $('#register-form-link').removeClass('active');
                    $(this).addClass('active');
                    e.preventDefault();
                });
                $('#register-form-link').click(function (e) {
                    $("#register-form").delay(100).fadeIn(100);
                    $("#login-form").fadeOut(100);
                    $('#login-form-link').removeClass('active');
                    $(this).addClass('active');
                    e.preventDefault();
                });

            });
        </script>
        <jsp:include page="head.jsp"/>
        <link href="./resources/css/login.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="login-form-link">Login</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" id="register-form-link">Register</a>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <c:if test="${risposta!=null}">
                                        <div style="color:red;text-align:center"><b>${risposta}</b></div> </br>
                                            </c:if>
                                            <c:if test="${username!=null}">
                                                <jsp:setProperty name="user" property="nomeUtente" value="${username}"></jsp:setProperty>
                                                <c:redirect url="./homepage"/>
                                            </c:if>
                                    <form id="login-form" action="./verificaLogin" method="post" role="form" style="display: block;">
                                        <div class="form-group">
                                            <input name="utente" id="username" tabindex="1" class="form-control" placeholder="Username" value="" type="text">
                                        </div>
                                        <div class="form-group">
                                            <input name="password" id="password" tabindex="2" class="form-control" placeholder="Password" type="password">
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login"  type="submit">
                                                </div>
                                            </div>
                                        </div>

                                    </form>


                                    <form id="register-form" action="./registra" method="post" role="form" style="display: none;">

                                        <div class="form-group">
                                            <input name="utente" id="username" tabindex="1" class="form-control" placeholder="Username" value="" type="text">
                                        </div>
                                        <div class="form-group">
                                            <input name="password" id="password" tabindex="2" class="form-control" placeholder="Password" type="password">
                                        </div>
                                        <div class="form-group">
                                            <input name="verificaPassword" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password" type="password">
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register"  type="submit">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"/>
            <!-- Script to Activate the Carousel -->

            <script>
                $('.carousel').carousel({
                    interval: 5000 //changes the speed
                });
            </script>
    </body></html>
