<%-- 
    Document   : visualizzaOrdini
    Created on : 28-apr-2016, 11.41.11
    Author     : FSEVERI\reginato2906
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
                <c:forEach items="${visualizzaOrdini}" var="visualizzaOrdini">
                    <div>
                        <p>${visualizzaOrdini.getDataPrenotazione()}</p>
                    </div>
                 </c:forEach>
            
            </div>
                   
            <jsp:include page="footer.jsp"/>
    </body>
</html>
