<jsp:useBean id="user" class="museo.db.Utente" scope="session" />


<html>
    <head>
        <title>Login</title>
        <jsp:include page="head.jsp"/>
        <jsp:include page="menu.jsp"/>
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
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

            });</script>
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
                                    <%
                                        out.print("<a href='#' ");
                                        if (request.getParameter("indb") != null || request.getParameter("dupplicate") != null) {
                                            out.print("id='login-form-link'>Login</a>");
                                        } else {
                                            out.print(" class='active' id='login-form-link'>Login</a>");
                                        }
                                    %>

                                </div>
                                <div class="col-xs-6">
                                    <%
                                        out.print("<a href='#' id='register-form-link' ");
                                        if (request.getParameter("indb") != null || request.getParameter("dupplicate") != null || request.getParameter("errorPass") != null) {
                                            out.print(" class='active' ");
                                        } else {
                                            out.print(">Register</a>");
                                        }
                                    %>
                                </div>
                            </div>
                            <hr>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <%
                                        String risp = request.getParameter("risposta");
                                        if (risp != null) {

                                            if (risp.equals("-1")) {
                                                out.print("<p style='color: red; text-align: center;'><b>Password errata!!!</b></p>");
                                            } else if (risp.equals("1")) {
                                                out.print("<p style='color: red; text-align: center;'><b>Utente non trovato, registrati!</b></p>");
                                            } else {
                                                user.setNomeUtente(request.getParameter("utente"));
                                                response.sendRedirect("./homepage");
                                            }
                                        }

                                        /**
                                         * String risp =
                                         * request.getParameter("risposta"); if
                                         * (risp.equals("pswdErr=true")) {
                                         * out.print("<p style='color: red; text-align: center;'><b>Password
                                         * errata!!!</b></p>"); } if
                                         * (risp.equals("pswdErr=false")) {
                                         * String resp =
                                         * request.getParameter("indb"); if
                                         * (resp.equals("true")) {
                                         * out.print("<p style='color: red; text-align: center;'><b>Utente
                                         * non trovato, registrati!</b></p>"); }
                                         * } if
                                         * (request.getParameter("risposta") !=
                                         * null) { String resp =
                                         * request.getParameter("dupplicate");
                                         * if (resp.equals("true")) {
                                         * out.print("<p style='color: red; text-align: center;'><b>Utente
                                         * gia' presente, scegli un altro
                                         * nome!</b></p>"); } } if
                                         * (request.getParameter("risposta") !=
                                         * null) { String resp =
                                         * request.getParameter("errorPass"); if
                                         * (resp.equals("true")) {
                                         * out.print("<p style='color: red; text-align: center;'><b>Password
                                         * non corrispondenti, scrivi
                                         * correttamente le password!</b></p>");
                                         * } }
                                         *
                                         */
                                        //inizio form                                           
                                        out.print("<form id='login-form' action='./verificaLogin' method='post' role='form'");
                                        if (request.getParameter("indb") != null || request.getParameter("dupplicate") != null || request.getParameter("errorPass") != null) {
                                            out.print(" style='display: none;'>");
                                        } else {
                                            out.print(" style='display:block;'>"); }

                                    %>
                                    <div class="form-group">
                                        <input name="utente" id="utente" tabindex="1" class="form-control" placeholder="Username" value="" type="text" required/>
                                    </div>
                                    <div class="form-group">
                                        <input name="password" id="password" tabindex="2" class="form-control" placeholder="Password" type="password" required/>
                                    </div>
                                    <div class="form-group text-center">
                                        <input tabindex="3" class="" name="remember" id="remember" type="checkbox">
                                        <label for="remember"> Remember Me</label>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-6 col-sm-offset-3">
                                                <input name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In" type="submit">
                                            </div>
                                        </div>
                                    </div>
                                    </form>
                                    <%out.print("<form id='register-form' action='./registra' method='post' role='form'");
                                        if (request.getParameter("indb") != null || request.getParameter("dupplicate") != null || request.getParameter("errorPass") != null) {
                                            out.print(" style='display: block;'>");
                                        } else {
                                            out.print(" style='display: none;'>");
                                        }
                                    %>
                                    <div class="form-group">
                                        <input name="utente" id="username" tabindex="1" class="form-control" placeholder="Username" value="" type="text" required/>
                                    </div>
                                    <div class="form-group">
                                        <input name="password" id="password" tabindex="2" class="form-control" placeholder="Password" type="password" required/>
                                    </div>
                                    <div class="form-group">
                                        <input name="verificaPassword" id="verificaPassword" tabindex="2" class="form-control" placeholder="Confirm Password" type="password" required/>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-6 col-sm-offset-3">
                                                <input name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now" type="submit">
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
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
