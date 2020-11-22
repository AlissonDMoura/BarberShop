/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barber_shop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author aliss
 */
public class dbConector {
            
            //Private strings that cannot changed (final), to be accessed by our connector. protects information.
            
            private static final String URL = "jdbc:mysql://52.50.23.197:3306/Alisson_2019142?useSSL=false";
            private static final String USER = "Alisson_2019142";
            private static final String PASS = "2019142";
                        
            
            public static Connection insertSt(String name, String surname, String email, String Phone, String Location, String Password, Boolean type){
               
                try {
                    Statement stmt = getConnection().createStatement();                   
                    stmt.execute("INSERT INTO users(name, surname, email, phone, address, password, usertype) " + "VALUES (" + name +", " + surname +", "+ email +", "
                                + Phone +", " + Location +", "+ Password +", " + type);
                    
                }
                catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                

                se = se.getNextException();
            }   }
                return null;
                
                
                           
                
                                
            }
            
            public static Connection getConnection(){
                            
                
                try {                           
                    //connects to the database, return a message confirming it was successful, and return the connection
                    
                    Connection conn = DriverManager.getConnection(URL, USER, PASS);
                    System.out.println("Connected");
                    return conn;
                    
                                        
                                        
                    //catch error and report the connection wasn't stabilished.
                } catch (SQLException ex) {
                    throw new RuntimeException("Error Connecting", ex);
                }
                
            }
           
            //close connection in three steps. the third constructior initialize the second that initialize the first. (less code this way)
            public static void closeConnection(Connection conn) {
                
                if (conn != null){
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        System.err.println("Error: CloseConnection on conn" + ex);// Red console error
                    }
                    }
                    }   
            public static void closeConnection(Connection conn, PreparedStatement st) {
                
                if (st != null){
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        System.err.println("Error: CloserConnection on st  " + ex);// Red console error
                    }
                    }
                closeConnection(conn);
                    }   
            public static void closeConnection(Connection conn, PreparedStatement st, ResultSet rs) {
                
                if (rs != null){
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        System.err.println("Error: on rs" + ex);// Red console error
                    }
                    }
                closeConnection(conn, st);
                
                    }   
}

 
