<%-- 
    Document   : visualizzaOrdini
    Created on : 28-apr-2016, 11.41.11
    Author     : FSEVERI\reginato2906
--%>
<jsp:useBean id="user" class="museo.db.Utente" scope="session" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <c:forEach items="${visualizzaOrdini}" var="ordini">
                    <div>
                        <p>${ordini.getNomeUtente().getNomeUtente()}</p>
                        <p>${ordini.getCodiceBiglietto()}</p>
                        <p>${ordini.getDataPrenotazione()}</p>
                        <p>${ordini.getDataPrenotazione()}</p>
                    </div>
                    <hr>
                </c:forEach>

            </div>

            <jsp:include page="footer.jsp"/>
    </body>
</html>
