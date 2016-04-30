<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <!-- Navigation -->
    <head>
        <jsp:include page="head.jsp"/>
        <title>Servizi</title>
        <link href="./resources/css/visita.css" rel="stylesheet">
        <script src="./resources/js/jquery.js"></script>
        <script src="./resources/js/prenotazione_biglietto.js"></script>
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
                        <img style="height: 400px; width: 800px;" class="img-responsive img-related" src="${visita.getImmagineCopertina()}" alt="${visita.getTitolo()}">
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
                    <p id="prezzo">${visita.tariffa} &euro;</p>
                    <button id="add-biglietti" class="btn btn-primary">Acquista Biglietti</button>
                </div>

            </div>
            <!-- /.row -->
            <div class="row invis" id="prenota-biblietto">
                <div class="col-lg-12">
                    <h2>Prenota i tuoi biglietti</h2>
                </div><br/><br/><br/>
                <table id="biglietti" class="table">
                    <tr>
                        <th>Biglietto numero</th>
                        <th>Visita</th>
                        <th>Categoria</th>
                        <th>Prezzo</th>
                        <th>Validit&agrave;</th>
                    </tr>
                    <tr id="b1"><td id="b-numB1"></td><td id="b-titolo1">${visita.titolo}</td><td id="b-categoria1">
                            <select class="categorie" onchange="changePrice(event)" name="cat">
                                <c:forEach items="${categorie}" var="categoria">
                                    <option value="${categoria.sconto}">${categoria.titolo}</option>
                                </c:forEach>
                            </select></td><td id="b-price1">
                            ${visita.tariffa}
                        </td><td id="b-validita1">
                            <%
                            if(v.getTipo() == 'E') out.print(v.getDataFine());
                            
                            %>
                        </td></tr>
                    
                </table>
                        <button id="add" class="btn btn-info glyphicon glyphicon-plus"></button>
            </div>
            <!-- /.row -->

            <hr>

        <!-- /.container -->

        <jsp:include page="footer.jsp"/>
    </body>

</html>
