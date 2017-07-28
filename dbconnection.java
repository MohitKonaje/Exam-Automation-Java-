/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examautomation;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mk3s
 */
public class dbconnection {
    private Connection dbconnection;
    public Connection connect() {
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Connection Success");
   
    }
    catch(ClassNotFoundException cnfe){
    System.out.println("Connection Failed");
    }
    String url="jdbc:mysql://localhost:3306/regusers?zeroDateTimeBehavior=convertToNull";
    try{
    dbconnection=(Connection) DriverManager.getConnection(url, "root", "");
    System.out.println("Database Connected");
    }
    catch(SQLException se)
    {
    System.out.println("no Database" +se);
    }
    return dbconnection;

}
}
