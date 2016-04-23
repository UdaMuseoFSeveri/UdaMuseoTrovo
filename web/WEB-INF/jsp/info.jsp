<%-- 
    Document   : info
    Created on : 23-apr-2016, 10.31.35
    Author     : FSEVERI\reginato2906
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Info</title>
    </head>
    
    <body>
    <jsp:include page="menu.jsp"/>
    
    <div class="container">
         
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Informazioni</h2>
            </div>

        <div class="row">
            <!-- Map Column -->
            <div class="col-md-8">
                <!-- Embedded Google Map -->
                <iframe width="100%" height="400px" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22399.431842386908!2d11.886081394364234!3d45.430932955664666!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x477eda8380402c27%3A0xa791341b6d94fac3!2sVia+Luigi+Pettinati%2C+46%2C+35129+Padova+PD!5e0!3m2!1sit!2sit!4v1461403884650"></iframe>
            </div>
            <!-- Contact Details Column -->
            <div class="col-md-4">
                <h3>Contatti</h3>
                <p>
                    Via Pettinati 46 <br>Padova, IT 35129 <br>
                </p>
                <p><i class="fa fa-phone"></i> (049) 8658111</p>
                <p><i class="fa fa-envelope-o"></i> info@gmail.com
                </p>
                <p><i class="fa fa-clock-o"></i> Luned&igrave; - Venerd&igrave;: 9:00 AM to 5:00 PM </p>
            </div>
        </div>
    </div>

     <jsp:include page="footer.jsp"/>

</body>

</html>
