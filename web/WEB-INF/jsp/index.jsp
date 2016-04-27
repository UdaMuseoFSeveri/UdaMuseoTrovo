<!DOCTYPE html>
<jsp:useBean id="user" class="museo.db.Utente" scope="session" />
<html lang="en">
    <!-- Navigation -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Servizi</title>
    </head>
    <body>     
        <jsp:include page="menu.jsp"/>

        <!-- Header Carousel -->
        <header id="myCarousel" class="carousel slide">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <c:set var="c" value="0"></c:set>
                <c:forEach items="${visite}" var="visita">
                    <c:if test="${c==0}">
                        <li data-target="#myCarousel" data-slide-to="${c}" class="active"></li>
                    </c:if>
                    <c:if test="${c>0}">
                        <li data-target="#myCarousel" data-slide-to="${c}"></li>
                    </c:if>
                    <c:set var="c" value="${c+1}"></c:set>
                </c:forEach>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <c:set var="i" value="0"></c:set>
                <c:forEach items="${visite}" var="visita">
                    <c:if test="${i == 0}">
                        
                            <div class="item active">
                                <a href="./visita?codice=${visita.getCodiceVisita()}">
                                <div class="fill" style="background-image:url('${visita.getImmagineCopertina()}');"></div>
                                <div class="carousel-caption">
                                    <h2>${visita.getTitolo()}</h2>
                                </div>
                                </a>
                            </div>
                        
                    </c:if>
                    <c:if test="${i > 0}">
                        
                            <div class="item">
                                <a href="./visita?codice=${visita.getCodiceVisita()}">
                                <div class="fill" style="background-image:url('${visita.getImmagineCopertina()}');"></div>
                                <div class="carousel-caption">
                                    <h2>${visita.getTitolo()}</h2>
                                </div>
                                </a>
                            </div>
                    </c:if>
                   
                    <c:set var="i" value="${i+1}"></c:set>
                </c:forEach>
                 <!-- Controls -->
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                        <span class="icon-prev"></span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">
                        <span class="icon-next"></span>
                    </a>
            </div>
        </header>

        <!-- Page Content -->
        <div class="container">

            <!-- Selezione delle visite base -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        Visite del museo
                    </h1>
                </div>
                <c:forEach items="${visiteBase}" var="visita">
                    <div class="col-md-4">
                        <div class="panel panel-default" style="height: 200px;">
                            <div class="panel-heading">
                                <h4><i></i> ${visita.getTitolo()}</h4>
                            </div>
                            <div class="panel-body">
                                <p>${visita.getDescrizione()}</p>  
                            </div>
                            <a href="./visita?codice=${visita.getCodiceVisita()}" class="btn btn-default" style=" margin-left: 10px;"> Scopri</a>  
                        </div>
                    </div>             
                </c:forEach>
            </div>
            <br>
            <%
                String nome =user.getNomeUtente();
                if (nome != null) {
            %>
            <div class="well">
                <div class="row">
                    <div class="col-md-8">                    
                        <p>Visualizza i tuoi ordini</p>
                    </div>
                    <div class="col-md-4">
                        <a class="btn btn-lg btn-default btn-block" href="#">Call to Action</a>
                    </div>
                </div>
            </div>
            <%}%>

            <jsp:include page="footer.jsp"/>
            <!-- Script to Activate the Carousel -->

            <script>
                $('.carousel').carousel({
                    interval: 5000 //changes the speed
                })
            </script>



    </body>

</html>
