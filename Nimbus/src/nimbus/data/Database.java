package nimbus.data;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    
    private static final String USERNAME = "root";
    //private static final String PASSWORD = "password";
    private static final String PASSWORD = "@Tiagob12";
    private static final String URL = "localhost";
    //private static final String SCHEMA = "NimbusSQL";
    private static final String SCHEMA = "mydb";
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
        
        }
    }
    
    public static java.sql.Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://"+URL+"/"+SCHEMA+"?autoReconnect=true&useSSL=false",USERNAME,PASSWORD);
    }
    
    public static void close(java.sql.Connection c) {
        try {
            if(c!=null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException e) {
        
        }
    }
}
