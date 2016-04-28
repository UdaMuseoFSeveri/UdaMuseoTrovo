<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <!-- Navigation -->
    <head>
        <jsp:include page="head.jsp"/>
        <title>Servizi</title>
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
                    <p>${visita.tariffa} &euro;</p>
                    <button class="btn btn-primary">Acquista Biglietti</button>
                </div>

            </div>
            <!-- /.row -->
            <div class="row" id="prenota-biblietto">
                <div class="col-lg-12">
                    <h2>Prenota i tuoi biglietti</h2>
                </div><br/><br/><br/>
                <table>
                    <tr>
                        <th>Biglietto numero</th>
                        <th>Visita</th>
                        <th>Categoria</th>
                        <th>Prezzo</th>
                        <th>Validit&agrave;</th>
                    </tr>
                    <tr>
                        <td><script type="text/javascript">getNumBiglietto()</script></td>
                        <td>${visita.titolo}</td>
                        <td>
                            <select id="categorie">
                                <c:forEach items="${categorie}" var="categoria">
                                    <option value="${categoria.sconto}">${categoria.titolo}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <%
                                //prezzo
                                long prezzo = v.getTariffa();
                                out.print("<script type='text/javascript'>getTariffa("+prezzo+",categorie)</script>");
                            %>
                        </td>
                        <td>
                            12/12/2016
                        </td>
                    
                    </tr>
                </table>
            </div>
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
