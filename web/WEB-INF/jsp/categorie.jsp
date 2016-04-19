<%-- 
    Document   : categorie
    Created on : 15-apr-2016, 18.31.31
    Author     : Giacomo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <c:forEach items="${categorie}" var="categoria">
        <p>${categoria.getTitolo()} </p>
    </c:forEach>
    <jsp:include page="footer.jsp"/>
    </body>
</html>
