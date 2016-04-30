<%
    session.invalidate();
    String location = "./login";
    response.sendRedirect(location);
%>