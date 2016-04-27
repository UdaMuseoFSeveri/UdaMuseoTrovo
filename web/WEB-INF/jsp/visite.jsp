<!DOCTYPE html>
<html lang="en">
   <!-- Navigation -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
            <jsp:include page="head.jsp"/>
            <title>Visite</title>
    </head>
    <body>     
    <jsp:include page="menu.jsp"/>

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Elenco visite</h2>
            </div>
        </div>
        <c:forEach items="${visiteBase}" var="visiteBase">
            <div class="row">
           
                <div class="col-md-7">
                         <img style="height: 400px; width: 700px;" class="img-responsive img-related" src="${visiteBase.getImmagineCopertina()}">
                </div>
                <div class="col-md-5">
                    <h3>Titolo:</h3>
                    <p> ${visiteBase.getTitolo()} </p>
                    <h3>Descrizione:</h3>
                    <p>${visiteBase.getDescrizione()}</p>
                    <h3>Prezzo:</h3>
                    <p>${visiteBase.tariffa} &euro;</p>
                    <a class="btn btn-primary" href="./visita?codice=${visiteBase.getCodiceVisita()}">Scopri di pi&ugrave;</i></a>
                </div>    
            </div>        
            <hr>
        </c:forEach>
          
        <br>    
        <a name="ancora"></a>
        <h2 class="page-header">Elenco esposizioni</h2>
        <c:forEach items="${visite}" var="visite">
            <div class="row">
                <div class="col-md-7">
                    <img style="height: 400px; width: 700px;" class="img-responsive img-related" src="${visite.getImmagineCopertina()}">
                </div>
                <div class="col-md-5">
                    <h3>Titolo:</h3>
                    <p> ${visite.getTitolo()} </p>
                    <h3>Descrizione:</h3>
                    <p>${visite.getDescrizione()}</p>
                    <h3>Date:</h3>
                        <ul>
                            <li>Data Inizio: ${visite.getDataInizio()} </li>
                            <li>Data Fine: ${visite.getDataFine()}</li>
                        </ul>
                    <h3>Prezzo:</h3>
                    <p>${visite.tariffa} &euro;</p>
                    <a class="btn btn-primary" href="./visita?codice=${visite.getCodiceVisita()}">Scopri di pi&ugrave;</i></a>
                </div>    
            </div>        
            <hr>
        </c:forEach>

    <jsp:include page="footer.jsp"/>
</body>

</html>
