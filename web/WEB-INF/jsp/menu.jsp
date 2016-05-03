<jsp:useBean id="user" class="museo.db.Utente" scope="session" />
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="./">Home</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="./categorie">Categorie</a>
                </li>
                <li>
                    <a href="./servizi">Servizi</a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown"href="#">Visita <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="./visite">Visite</a>
                        </li>
                        <li>
                            <a href="./visite#ancora">Esposizioni tematiche</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="./info">Info</a> 
                </li>
                <li>
                    <%
                        String nome = user.getNomeUtente();
                        if (nome == null) {
                    %>
                    <a href="./login">Login</a> 
                </li>
                    <%
                    } else {
                    %>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown"href="#">${user.nomeUtente}<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="./visualizzaOrdini">Visualizza Ordini</a>
                        </li>
                        <li>
                            <a href="./logout">Logout</a>
                        </li>
                    </ul>
                </li>
                <%}%>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>


