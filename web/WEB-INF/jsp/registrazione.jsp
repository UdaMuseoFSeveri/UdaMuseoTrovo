<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%
    String utente = request.getParameter("username");
    String pass = request.getParameter("password");
    String conf_pass = request.getParameter("confirm-password");
    String location = "";
    boolean presente = false;
    if (pass.equals(conf_pass)) {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.252/5ib27", "5ib27", "5ib27");
        PreparedStatement st = con.prepareStatement("select utente from Utenti where utente=?");
        st.setString(1, utente);
        ResultSet ris = st.executeQuery();
        while (ris.next()) {
            //utente già presente
            System.out.println("utente gia presente");
            location = "./login.jsp?dupplicate=true";
            //response.sendRedirect(location);
            presente = true;
        }//while
        if (!presente) {
            //aggiungo utente
            st = con.prepareStatement("insert into Utenti (utente,password) values (?,?)");
            st.setString(1, utente);
            st.setString(2, pass);
            st.executeUpdate();
            location = "./login.jsp";
        }

    } else {
        location = "./login.jsp?errorPass=true";
    }
    response.sendRedirect(location);
%>