<%
    session.invalidate();
    String location = "./login.jsp";
    response.sendRedirect(location);
%>