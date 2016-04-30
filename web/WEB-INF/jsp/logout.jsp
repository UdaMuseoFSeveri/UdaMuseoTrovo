<%
    session.invalidate();
    String location = "./homepage";
    response.sendRedirect(location);
%>