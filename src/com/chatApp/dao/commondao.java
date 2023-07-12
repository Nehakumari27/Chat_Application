package com.chatApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.chatApp.utils.Configreader.getValue;


//throw early and catch later
public interface commondao {
      public static Connection createConnection() throws ClassNotFoundException, SQLException
      {
    	  //step-1 load a Driver (which is a type of class)
    	  Class.forName(getValue("DRIVER"));     //(it show red when we donot throw exception)
    	  
    	  //step-2 Making a connection (it is run in local host so,we connect like that. if it run in another computer we should give ip address of that computer
    	  final String CONNECTION_STRING=getValue("CONNECTION_URL"); //protocol//machine//portno of mysql(optional)//database name(in mysql)
    	  final String USER_ID=getValue("USERID");
    	  final String PASSWORD=getValue("PASS");
    	  Connection con=DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
    	  if(con!=null)
    	  {
    		  System.out.println("Connection Created...");
    		  //con.close();
    	  }
    	  return con;
      }
}
