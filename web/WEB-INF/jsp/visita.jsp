<!DOCTYPE html>
<html lang="en">
    <!-- Navigation -->
    <head>
        <jsp:include page="head.jsp"/>
        <title>Servizi</title>
    </head>
    <body>     
        <jsp:include page="menu.jsp"/>
        <%@ page import="museo.db.Visita" %>

        <!-- Page Content -->
        <div class="container">

            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">${visita.titolo}</h1>
                </div>
            </div>
            <!-- /.row -->

            <!-- Portfolio Item Row -->
            <div class="row">

                <div class="col-md-8" >
                    <a href="#">
                        <img style="height: 400px; width: 800px;" class="img-responsive img-hover img-related" src="${visita.getImmagineCopertina()}" alt="${visita.getTitolo()}">
                    </a>
                </div>

                <div class="col-md-4">
                    <h3>Descrizione</h3>
                    <p>${visita.getDescrizione()}</p>
                    <% 
                    Visita v = (Visita) request.getAttribute("visita");
                    if(v.getTipo() == 'E'){
                    %>
                        <h3>Date</h3>
                        <ul>
                            <li>Inizio evento: ${visita.getDataInizio()}</li>
                            <li>Fine evento: ${visita.getDataFine()}</li>
                        </ul>
                    <%
                    }
                    %>
                    <h3>Prezzo</h3>
                    <p>${visita.tariffa} &euro;</p>
                    <button class="btn btn-primary">Acquista Biglietti</button>
                </div>

            </div>
            <!-- /.row -->

            <!-- Related Projects Row -->
            <!--<div class="row">

                <div class="col-lg-12">
                    <h3 class="page-header">Related Projects</h3>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive img-hover img-related" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive img-hover img-related" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive img-hover img-related" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

                <div class="col-sm-3 col-xs-6">
                    <a href="#">
                        <img class="img-responsive img-hover img-related" src="http://placehold.it/500x300" alt="">
                    </a>
                </div>

            </div>-->
            <!-- /.row -->

            <hr>

        <!-- /.container -->

        <jsp:include page="footer.jsp"/>
    </body>

</html>
