<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="Util.User" scope="session" />    

<%
  String redirectURL;
  String utente = request.getParameter("username");
  String pswd = request.getParameter("password");
  Class.forName("com.mysql.jdbc.Driver");
  Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.252/5ib27","5ib27","5ib27");
  PreparedStatement st = con.prepareStatement("select * from Utenti where utente=?");
  st.setString(1, utente);
  ResultSet ris = st.executeQuery();
  while (ris.next()){
    String utent = ris.getString(1);
    out.print("utente_db: "+utent+"\n");
    String pass = ris.getString(2);
    out.print("pass_db: "+pass+"\n");
    out.print("utente: "+utente+"\n");
    out.print("pass: "+pswd+"\n");
    if(pass.equals(pswd)){
        user.setNome(utente);
        redirectURL = "../menu.jsp";
        response.sendRedirect(redirectURL);
    }
    else{
        out.print("pass sbagliata");
        //redirectURL = "./login.php?pswdErr=true";
        //response.sendRedirect(redirectURL);
    }
    
  }
  out.print("non presente");
  //redirectURL = "./login.php?indb=false";
  //response.sendRedirect(redirectURL);
%>