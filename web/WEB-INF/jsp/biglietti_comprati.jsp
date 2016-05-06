<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="museo.db.Biglietto" %>
<%@ page import="museo.db.Servizio" %>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Biglietti</title>
    </head>
    <body>     
        <jsp:include page="menu.jsp"/>
        <%
          float prezzoT = 0;
        %>
        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Riepilogo Ordine</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <c:forEach items="${biglietti}" var="biglietto">
                        <div class="panel panel-default">
                            <div class="panel-heading"><h3 class="panel-title">${biglietto.codiceVisita.titolo}</h3></div>
                            <div class="panel-body">
                                <div class="col-lg-9">
                                    <h3 style="margin-top: 0px;">Codice biglietto: ${biglietto.codiceBiglietto}</h3>
                                    <p><b>Data di prenotazione:</b> ${biglietto.getDataPrenotazione()}</p>
                                    <p><b>Data di validit&agrave;:</b> ${biglietto.getDataValidita()}</p>
                                    <p><b>Prenotato da:</b> ${biglietto.getNomeUtente().nomeUtente}</p>
                                    <p><b>Categoria biglietto:</b> ${biglietto.codiceCategoria.titolo} <b>Sconto: </b>${biglietto.codiceCategoria.sconto}%</p>
                                    <p><b>Prezzo biglietto:</b> ${biglietto.codiceVisita.tariffa} &euro;</p>
                                    <c:if test="${!biglietto.getServiziCollection().isEmpty()}">
                                        <b>Servizi:</b> <ul>
                                        </c:if>
                                        <c:forEach items="${biglietto.getServiziCollection()}" var="servizio">
                                            <li>${servizio.titolo}: ${servizio.prezzo} &euro;</li>

                                        </c:forEach>
                                    </ul>
                                </div>
                                <div class="col-lg-3">
                                    <p class="price">
                                        <%
                                          Biglietto b = (Biglietto) pageContext.getAttribute("biglietto");
                                          float prezzoVisita = b.getCodiceVisita().getTariffa();
                                          int percSconto = b.getCodiceCategoria().getSconto();
                                          float pServizi = 0;
                                          for (Servizio s : b.getServiziCollection()) {
                                            pServizi += s.getPrezzo();
                                          }
                                          float prezzoFinale = prezzoVisita - (prezzoVisita * percSconto / 100) + pServizi;
                                          prezzoT+=prezzoFinale;
                                          out.print(prezzoFinale);
                                        %>
                                        &euro;
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div>
                        <h3>Prezzo Totale: <% out.print(prezzoT); %> &euro;</h3>
                    </div>
                    <h1>Stampa questa pagina</h1>
                    <h3>Presentala all'entrata del museo e dopo il pagamento potrai entrare</h3>
                </div>
            </div>

            <jsp:include page="footer.jsp"/>

    </body>

</html>
