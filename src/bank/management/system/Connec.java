package bank.management.system;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;

public class Connec {
    
    Connection c;
    Statement s;
    
    public Connec(){
        
        try{
            // Load properties from .env file
            Properties props = new Properties();
            FileInputStream in = new FileInputStream(".env"); // Ensure the .env file is in the root of your project
            props.load(in);
            in.close();
            
            String url = props.getProperty("DB_URL");
            String user = props.getProperty("DB_USER");
            String pass = props.getProperty("DB_PASS");

            // Establish the connection
            c = DriverManager.getConnection(url, user, pass);
            s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        catch(Exception e){
             System.out.println(e);   
        }    
    }
}
