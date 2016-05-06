<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Biglietti</title>
    </head>
    <body>     
        <%@ page import="museo.db.Biglietto" %>
        <%@ page import="museo.db.Servizio" %>
        <jsp:include page="menu.jsp"/>

        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Biglietti</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <c:forEach items="${tikets}" var="biglietto">
                        <div class="panel panel-default">
                            <div class="panel-heading"><h3 class="panel-title">${biglietto.codiceVisita.titolo}</h3></div>
                            <div class="panel-body">
                                <div class="col-lg-9">
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
                                        float pServizi =0;
                                        for(Servizio s: b.getServiziCollection()){
                                          pServizi+= s.getPrezzo();
                                        }
                                        float prezzoFinale = prezzoVisita - (prezzoVisita*percSconto/100) +pServizi ;
                                        out.print(prezzoFinale);
                                        %>
                                       &euro;
                                    </p>
                                </div>


                            </div>
                        </div>

                    </c:forEach>

                    <a href='./visite' ><button class="btn btn-primary">Continua ad acquistare</button></a>
                    <a href='./acquista' ><button class="btn btn-success">Completa l'acquisto</button></a>
                    <a href='./svuotaCarrello' ><button class="btn btn-danger">Svuota il carrello</button></a>
                </div>
            </div>

            <jsp:include page="footer.jsp"/>

    </body>

</html>
