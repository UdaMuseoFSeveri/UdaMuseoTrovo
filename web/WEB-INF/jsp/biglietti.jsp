<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Biglietti</title>
    </head>
    <body>     
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
                                
                                <p>Data di validit&agrave;: ${biglietto.getDataValidita()}</p>
                                <p>Prenotato da: ${biglietto.getNomeUtente().nomeUtente}</p>
                                <p>Categoria biglietto: ${biglietto.codiceCategoria.titolo}</p>
                                Servizi: <ul>
                                    <c:forEach items="${biglietto.getServiziCollection()}" var="servizio">
                                        <li>${servizio.titolo}: ${servizio.prezzo}</li>

                                    </c:forEach>
                                </ul>

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
