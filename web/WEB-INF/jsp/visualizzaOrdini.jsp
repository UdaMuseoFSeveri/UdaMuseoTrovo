<jsp:useBean id="user" class="museo.db.Utente" scope="session" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="museo.db.Biglietto" %>
<%@ page import="museo.db.Servizio" %>
<!DOCTYPE html>
<html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Visualizza Ordini</title>
    </head>
    <body>     
        <jsp:include page="menu.jsp"/>

        <!-- Page Content -->
        <div class="container">

            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Visualizza Ordini</h2>
                </div>
            </div>
            <!-- /.row -->

            <!-- Portfolio Item Row -->
            <div class="row">

                <c:forEach items="${ordini}" var="ordine">
                    <div class="panel panel-default">
                        <div class="panel-heading"><h3 class="panel-title">${ordine.codiceVisita.titolo}</h3></div>
                        <div class="panel-body">
                            <div class="col-lg-9">
                                <h3 style="margin-top: 0px;">Codice Biglietto: ${ordine.getCodiceBiglietto()}</h3>
                                <p><b>Data di validit&agrave;:</b> ${ordine.getDataValidita()}</p>
                                <p><b>Prenotato da:</b> ${ordine.getNomeUtente().nomeUtente}</p>
                                <p><b>Categoria biglietto:</b> ${ordine.codiceCategoria.titolo} <b>Sconto: </b>${ordine.codiceCategoria.sconto}%</p>
                                <p><b>Prezzo biglietto:</b> ${ordine.codiceVisita.tariffa} &euro;</p>
                                <c:if test="${!ordine.getServiziCollection().isEmpty()}">
                                    <b>Servizi:</b> <ul>
                                    </c:if>
                                    <c:forEach items="${ordine.getServiziCollection()}" var="servizio">
                                        <li>${servizio.titolo}: ${servizio.prezzo} &euro;</li>

                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="col-lg-3">
                                <p class="price">
                                    <%
                                      Biglietto b = (Biglietto) pageContext.getAttribute("ordine");
                                      float prezzoVisita = b.getCodiceVisita().getTariffa();
                                      int percSconto = b.getCodiceCategoria().getSconto();
                                      float pServizi = 0;
                                      for (Servizio s : b.getServiziCollection()) {
                                        pServizi += s.getPrezzo();
                                      }
                                      float prezzoFinale = prezzoVisita - (prezzoVisita * percSconto / 100) + pServizi;
                                      out.print(prezzoFinale);
                                    %>
                                    &euro;
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <jsp:include page="footer.jsp"/>
    </body>
</html>
