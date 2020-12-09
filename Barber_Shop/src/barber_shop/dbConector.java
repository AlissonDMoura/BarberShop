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
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author alisson Moura
 */
public class dbConector {
            
            //Private strings that cannot changed (final), to be accessed by our connector. protects information.
            
            private static final String URL = "jdbc:mysql://52.50.23.197:3306/Alisson_2019142?useSSL=false";
            private static final String USER = "Alisson_2019142";
            private static final String PASS = "2019142";
                        
            
            public static Connection insertSt(String name, String surname, String email,
            String Phone, String Location, String Password, String type){
               int id = 0;
               
                try {
                    
                    Statement idCheck = getConnection().createStatement();
                    ResultSet r1 = idCheck.executeQuery("SELECT MAX(Id) FROM users");
                    
                    while(r1.next()){
                        id = r1.getInt(1);
                        id++;
                    }
                    System.out.println("This is my Next ID:");
                    System.out.println(id);
                    
                                        
                    
                    Statement stmt = getConnection().createStatement();                   
                    stmt.execute("INSERT INTO users (Id, name, surname, email, phone, address, password, userType)\n" +
                                "VALUES ( "+ id +", '"+ name +"', '" + surname +"', '"+ email +"', '"+ Phone +"', '" + Location +
                                "', '"+ Password +"', " + type +")");
                                        
                    idCheck.close();
                    r1.close();                }
                
                catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                

                se = se.getNextException();
            }   }
                
                return null;}
            //register new user.
            
            public static Connection getConnection(){
                            
                
                try {                           
                    //connects to the database, return a message confirming it was successful, and return the connection
                    
                    Connection conn = DriverManager.getConnection(URL, USER, PASS);
                    System.out.println("Retrieving data");
                    return conn;
                    
                                        
                                        
                    //catch error and report the connection wasn't stabilished.
                } catch (SQLException ex) {
                    throw new RuntimeException("Error Connecting", ex);
                }
                
            }
            //connect into the database for further queries.
           
            public static int userLogin(String email, String password) throws SQLException{
                                         
                String Email = "";
                String Pass = "";
                int id = 0;
                String User = "";
              
                    Statement credCheck;              
                    credCheck = getConnection().createStatement();
                
                    //Check credentials and write the information into the string.
                    ResultSet ecred;               
                    ecred = credCheck.executeQuery("Select email from users where password = '" + password +"' and email = '"+email+"'");
                    while(ecred.next()){
                        Email = ecred.getString(1);                    }
                    System.out.println("ecred = " + Email);
               
                    ResultSet pcred;
                    pcred = credCheck.executeQuery("Select password from users where password = '" + password +"' and email = '"+email+"'");
                    while(pcred.next()){
                        Pass = pcred.getString(1);                    }                    
                    System.out.println("pcred = " + Pass);
                    
                    ResultSet idcred;
                    idcred = credCheck.executeQuery("Select Id from users where password = '" + password +"' and email = '"+email+"'");
                    while(idcred.next()){
                        id = idcred.getInt(1);                    }                    
                    System.out.println("idcred = " + id);
                                        
                    ResultSet userType;
                    userType = credCheck.executeQuery("Select userType from users where Id = " + id);
                    while(userType.next()){
                    User = userType.getString(1);                    }
                    System.out.println("User type is " +User);
                                        
                    if(Pass.equals(password) && !Email.equals(email)){
                        System.out.println("credentials checked");}
                    
                    else {System.out.println("Access Denied - Credentials don't Match");}            
                return id;  } 
            //confirm credentials and return the ID for login.

            public static Connection insertApp(String date, String hour, String hdresser, String location){
                    
                try {                    
                    int id =0;
                    
                    Statement idCheck = getConnection().createStatement();
                    ResultSet r1 = idCheck.executeQuery("SELECT MAX(id) FROM appointments");
                    
                    while(r1.next()){
                        id = r1.getInt(1);
                        id++;
                    }
                    System.out.println("This is my Next ID:");
                    System.out.println(id);
                    
                    
                    Statement stmt = getConnection().createStatement();                   
                    stmt.execute("INSERT INTO appointments (id, date, hour, hair_dresser, location, customer, confirm, status)\n" +
                                "VALUES ( "+ id +", '"+ date +"', '" + hour +"', '"+ hdresser +"', '"+ location +"', 'vacant','','vacant')");
                                        
                    idCheck.close();
                    r1.close();                }
                
                catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                

                se = se.getNextException();                
            }   }
                
                return null;            }
            //insert new appointment into the database.
            
            public static int[] viewAppH(String name, String d1, String d2, String d3, String d4, String d5) throws SQLException{
                
                //This code will query the next 5 appointments, sorted by date and save it's ID's in Ascendent order into a array.
                                
                    Statement tContent;              
                    tContent = getConnection().createStatement();
                    
                    int[] ids = new int[6];
                    
                    
                    ResultSet idValue;               
                    idValue = tContent.executeQuery("Select id from appointments where date ='"+ d1 +"' or date ='"+d2+"' or date ='"+d3
                                                    +"' or date ='"+d4+"' or date ='"+d5+"' ORDER by date ASC, hour asc;");
                    
                    int i = 0;
                    while(idValue.next()){
                        ids[i] = idValue.getInt(1);
                        i++;

            }
                    System.out.println("id1 = " + ids[0]);
                    System.out.println("id2 = " + ids[1]);
                    System.out.println("id3 = " + ids[2]);
                    System.out.println("id4 = " + ids[3]);
                    System.out.println("id5 = " + ids[4]);
            return ids;
            
            
            
}
            //Show appointments.

            public static String[] lineCatch(int AppointmentId) throws SQLException{
                
                    String [] Appointment = new String[7];
                
                    Statement lineCheck;              
                    lineCheck = getConnection().createStatement();
                
                    ResultSet line;               
                    line = lineCheck.executeQuery("Select * from appointments where id = " + AppointmentId + ";");
                    while(line.next()){
                        Appointment[0] = line.getString(2); //date
                        Appointment[1] = line.getString(3); // hour
                        Appointment[2] = line.getString(4); // hair_dresser
                        Appointment[3] = line.getString(5); // location
                        Appointment[4] = line.getString(6); // customer
                        Appointment[5] = line.getString(7); // confirm
                        Appointment[6] = line.getString(8); // status
                        
                    }
                                       
                    return Appointment;
                    
            }
            //retrieve all information for a singular appointment and store it into a string.
            
}
 
