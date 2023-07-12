package com.chatApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chatApp.dto.userdto;
import com.chatApp.utils.Encryption;
public class userdao {
	         public boolean isLogin(userdto userdto1) throws ClassNotFoundException, SQLException,Exception
	         {
	        	 Connection con=null;
	        	 PreparedStatement pstmt=null;   //like statement in add
	        	 ResultSet rs=null;
	        	 final String SQL="Select userid from users where userid=? and password=?";
	        	 try
	        	 {
	        		 con=commondao.createConnection();
	        		 pstmt=con.prepareStatement(SQL); //pstmt is placeholder in which ? is given userid and password is stored
	        	     pstmt.setString(1, userdto.getUserid());
	        	     String encryptedPwd=Encryption.passwordEncrypt(new String(userdto1.getPassword()));
	        	     pstmt.setString(2, encryptedPwd);
	        	     rs=pstmt.executeQuery();
	        	     return rs.next();
	        	 }
	        	 finally
	        	 {
	        		 if(rs!=null)
	        		 {
	        			 rs.close();
	        		 }
	        		 if(pstmt!=null)
	        		 {
	        			 pstmt.close();
	        		 }
	        		 if(con!=null)
	        		 {
	        			 con.close();
	        		 }
	        	 }
	         }
	
	
	
	

           public int add(userdto userdto1)throws ClassNotFoundException, SQLException,Exception
           {
        	   System.out.println("Rec " +userdto1.getUserid() + " " +userdto1.getPassword());
        	   Connection connection=null;
        	   Statement stmt=null; //for query
        	   try {   //guarded region
        	       //step-1 connection create
        	       connection=commondao.createConnection(); 
        	   
        	       //step-2 we do a query
        	        stmt=connection.createStatement();
        	   
        	        //insert into users(userid,password) values('ram','fd234');
        	        int record=stmt.executeUpdate("insert into users (userid,password) values('"+userdto1.getUserid() + "','"+ Encryption.passwordEncrypt(new String(userdto1.getPassword())) +"')");
        	     return record;
        	   }
        	   finally   //always execute(Resource clean to stop the program )
        	   {
        		   if(stmt!=null)
        		   {
        	            stmt.close();
        		   }
        		   if(connection!=null)
        		   {
        			   connection.close(); 
        		   }
        	   }
  
           }
}
