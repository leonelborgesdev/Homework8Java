package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {
    private static final String JDBC_URL = "jdbc:h2:~/employees";
    private static final String JDBC_USER= "sa";
    private static final String JDBC_PASSWORD= "";
    public static Connection getConnection() throws SQLException{
       try{
           Class.forName("org.h2.Driver");
           return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
       }catch (ClassNotFoundException e){
           throw  new RuntimeException(e);
       }
    }
}
