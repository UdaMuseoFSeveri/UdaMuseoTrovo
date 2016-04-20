
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
        <title>Categorie</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <!-- Service Tabs -->
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Categorie</h2>
                </div>
                <div class="col-lg-12">

                    <ul id="myTab" class="nav nav-tabs nav-justified">

                        <c:forEach items="${categorie}" var="categoria">  
                            <c:if test="${cat.getCodiceCategoria() < 2}">
                                <li class="active"><a href="#cat-${categoria.getCodiceCategoria()}" data-toggle="tab"><i class="fa fa-tree"></i>${categoria.getTitolo()}</a>
                                </li>
                            </c:if>
                            <li><a href="#cat-${categoria.getCodiceCategoria()}" data-toggle="tab"> ${categoria.getTitolo()}</a>
                            </li>
                        </c:forEach>
                    </ul>

                    <div id="myTabContent" class="tab-content">
                        <c:forEach items="${categorie}" var="cat"> 
                            <c:if test="${cat.getCodiceCategoria() < 2}">
                                <div class="tab-pane fade active in" id="cat-${cat.getCodiceCategoria()}">
                                    <h4>${cat.getTitolo()}</h4>
                                    <ul> ${cat.getDescrizione()}</ul>                                 
                                </div>
                            </c:if>
                            <c:if test="${cat.getCodiceCategoria() >1}">
                            <div class="tab-pane fade in" id="cat-${cat.getCodiceCategoria()}">
                                <h4>${cat.getTitolo()}</h4>
                                <ul>
                                    ${cat.getDescrizione()}
                                </ul>                                  
                                <p>Per poter accedere a questa categoria e agli sconti che ne derivano il cliente dovrà mostrare questi tipi di documenti:</p>
                                <ul>
                                    ${cat.getTipoDocumento()}
                                </ul>
                                <p>Lo sconto per questa categoria sarà del ${cat.getSconto()} %</p>
                            </div>
                            </c:if>
                        </c:forEach>

                    </div>

                </div>
            </div>  
            <hr>

            <jsp:include page="footer.jsp"/>








            </body>
            </html>
