<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" class="museo.db.Utente" scope="session" />
<!DOCTYPE html>
<html lang="en">
    <!-- Navigation -->
    <head>
        <jsp:include page="head.jsp"/>
        <title>Servizi</title>
        <link href="./resources/css/visita.css" rel="stylesheet">
        <script src="./resources/js/jquery.js"></script>
        <script src="./resources/js/biglietto.js"></script>
    </head>
    <body>     
        <jsp:include page="menu.jsp"/>
        <%@ page import="museo.db.Visita" %>
        <%@ page import="java.sql.Date" %>

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
                      if (v.getTipo() == 'E') {
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
                    <%
                      String nome = user.getNomeUtente();
                      if (nome == null) {
                    %>
                    <a  href="./login"><button title="Esegui il login per acquistare i biblietti" class="btn btn-primary">Acquista Biglietti</button></a>

                    <%
                      } else {
                        out.print("<button id='add-biglietti' class='btn btn-primary'>Acquista Biglietti</button>");
                      }
                    %>
                    <h3>Info Visita:</h3>
                    <p>Numero di biglietti prenotati per questa esposizione: ${num_biglietti}</p>
                    <p>Ricavo vendita biglietti : ${soldi_biglietti} &euro;</p>
                </div>

            </div>
            <!-- /.row -->
            <c:if test="${user.getNomeUtente() != null}" >
                <div id="prenota-biblietto" class="row invis">
                    <form action="./addBiglietto" id="inputBiglietto" method="get">
                        <div class="col-lg-12">
                            <h2>Prenota i tuoi biglietti</h2>
                        </div><br/><br/><br/>
                        <table id="biglietti" class="table">
                            <tr>
                                <th>Categoria</th>
                                <th>Prezzo</th>
                                <th>Validit&agrave;</th>
                                <th>Servizi</th>
                            </tr>
                            <tr id="b1">
                                <td id="categoria">
                                    <select class="categorie">
                                        <c:forEach items="${categorie}" var="categoria">
                                            <option class="categoria" title="${categoria.descrizione}" data-codice="${categoria.codiceCategoria}" value="${categoria.sconto}">${categoria.titolo}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td id="price">${visita.tariffa}</td>
                                <td id="validita"><%if (v.getTipo() == 'E') {
                                    out.print(v.getDataFine());
                                  }
                                else{
                                    out.print((Date) request.getAttribute("dataFine"));
                                }%></td>
                                <td id="servizi">
                                    <c:forEach items="${servizi}" var="servizio">
                                        <label title="${servizio.descrizione}"><input class="servizi" data-codice="${servizio.codiceServizio}" type="checkbox" name="${servizio.titolo}" value="${servizio.prezzo}" /> ${servizio.titolo}</label>
                                        <br /> 
                                    </c:forEach>
                                </td>
                            </tr>
                        </table>
                        
                        <input name="dataValidita" class="invis" type="date" value="<%if (v.getTipo() == 'E') {
                                    out.print(v.getDataFine());
                                  }
                               else {
                                   out.print((Date) request.getAttribute("dataFine"));
                               }
                               %>" />
                        <input name="codiceVisita" value="${visita.codiceVisita}" type="hidden" />
                        <input name="nomeUtente" type="hidden" value="${user.getNomeUtente()}" />
                        <input id="i-categoria" name="categoria" type="hidden" value="1" />
                        <button type="submit" class="btn btn-info">Invia</button>

                    </form>
                </div>
        </c:if>
        <!-- /.row -->

        <hr>

        <!-- /.container -->

        <jsp:include page="footer.jsp"/>
    </body>

</html>
