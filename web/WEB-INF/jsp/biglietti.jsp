<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Carrello</title>
    </head>
    <body>     
        <%@ page import="museo.db.Biglietto" %>
        <%@ page import="museo.db.Servizio" %>
        <jsp:include page="menu.jsp"/>
        <%
          float prezzoT = 0;
        %>
        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Carrello</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <c:set var="id" value="0" ></c:set>
                    <c:forEach items="${tikets}" var="biglietto">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <!--<div class="col-lg-11">-->
                                <h3 class="panel-title">${biglietto.codiceVisita.titolo}</h3>
                                <!--</div>
                                <div clas="col-lg-1">
                                    <a style="text-align:left;" href="./removeBiglietto?id=${id}"><button class="btn-danger">Rimuovi</button></a>
                                </div>-->

                            </div>
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
                                <div  class="col-lg-3">
                                    <p class="price">
                                        <%
                                          Biglietto b = (Biglietto) pageContext.getAttribute("biglietto");
                                          float prezzoVisita = b.getCodiceVisita().getTariffa();
                                          int percSconto = b.getCodiceCategoria().getSconto();
                                          float pServizi = 0;
                                          if (b.getServiziCollection() != null) {
                                            for (Servizio s : b.getServiziCollection()) {
                                              pServizi += s.getPrezzo();
                                            }
                                          }
                                          float prezzoFinale = prezzoVisita - (prezzoVisita * percSconto / 100) + pServizi;
                                          prezzoT += prezzoFinale;
                                          out.print(prezzoFinale);
                                        %>
                                        &euro;
                                    </p>
                                    <a href="./removeBiglietto?id=${id}"><button style="margin-left:70px;" class="btn btn-danger">Rimuovi</button></a>
                                </div>


                            </div>
                        </div>
                        <c:set var="id" value="${id+1}" ></c:set>
                    </c:forEach>

                    <c:if test="${tikets.isEmpty()}">
                        <h2>Carrello vuoto!</h2>
                        <br/><br/>
                        <a href='./visite' ><button class="btn btn-primary">Vedi il catalogo</button></a>
                    </c:if>
                    <c:if test="${!tikets.isEmpty()}">
                        <div style="text-align: right">
                            <h3>Totale da pagare: <% out.print(prezzoT);%> &euro;</h3>
                        </div>
                        <a href='./visite' ><button class="btn btn-primary">Continua ad acquistare</button></a>
                        <a href='./acquista' ><button class="btn btn-success">Completa l'acquisto</button></a>
                        <a href='./svuotaCarrello' ><button class="btn btn-danger">Svuota il carrello</button></a>
                    </c:if>

                </div>
            </div>

            <jsp:include page="footer.jsp"/>

    </body>

</html>
