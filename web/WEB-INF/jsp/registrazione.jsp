<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<?php
	session_start();
	$user=$_POST["username"];
	$pass=$_POST["password"];
	$cpass=$_POST["confirm-password"];
	if($pass==$cpass) {
		$db=mysql_connect("10.0.1.252","5ib27","5ib27");
  		if($db==FALSE) die ("Errore nella connessione.");
  		mysql_select_db("5ib27",$db) or die("Errore nella selezione del database.");

  		$query="select utente from Utenti where utente='$user'";
  		$result=mysql_query($query);
  		$nRow=mysql_num_rows($result);
  		if($nRow==0){
  			$query="insert into Utenti (utente,password) values ('$user','$pass')";
  			$result=mysql_query($query);
  			header ("Location: ./login.php");
  		}
  		else header("Location: login.php?dupplicate=true");
	}
	else header("Location: login.php?errorPass=true");
?>
<%
    String utente = request.getParameter("username");
    String pass = request.getParameter("password");
    String conf_pass = request.getParameter("confirm-password");
    String location ="";
    boolean presente = false;
    if(pass.equals(conf_pass)){
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.252/5ib27","5ib27","5ib27");
        PreparedStatement st = con.prepareStatement("select utente from Utenti where utente=?");
        st.setString(1, utente);
        ResultSet ris = st.executeQuery();
        while(ris.next()){
            //utente già presente
            System.out.println("utente gia presente");
            location = "./login.jsp?dupplicate=true";
            //response.sendRedirect(location);
            presente =true;
        }//while
        if(!presente){
            //aggiungo utente
            st = con.prepareStatement("insert into Utenti (utente,password) values (?,?)");
            st.setString(1,utente);
            st.setString(2,pass);
            st.executeUpdate();
            location = "./login.jsp";
        }
        
    }
    else {
        location="./login.jsp?errorPass=true";
    }
    response.sendRedirect(location);
%>