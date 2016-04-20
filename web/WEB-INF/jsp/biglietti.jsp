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
            <c:forEach items="${tikets}" var="biglietto">
                <div class="col-md-3 col-sm-6" style="height: 550px;">
                        <div class="panel-body">
                            <h3>Biglietto n° ${biglietto.getTitolo()}</h3>
                            <p>Data di validit&agrave;: ${biglietto.getDataValidita()}</p>
                            <p>Data prenotazione: ${biglietto.getDataPrenotazione()}</p>
                            <p>Prenotato da: ${biglietto.getNomeUtente()}</p>
                            <p>Categoria biglietto: ${biglietto.getCategoria()}</p>
                            <p>Servizi: ${biglietto.getServiziCollection()}</p>
                            <p>Prenotato da: ${biglietto.getNomeUtente()}</p>
                        </div>
                    </div>
                </div>
             </c:forEach>
                 
    <jsp:include page="footer.jsp"/>

    </body>

</html>
