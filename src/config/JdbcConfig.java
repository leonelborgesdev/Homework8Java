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
    public static  void createTable(){
        try(Connection conn = getConnection()) {
            String createTableSQL= "CREATE TABLE IF NOT EXISTS employees" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "salary DECIMAL(10, 2))";
            try (var stmt= conn.createStatement()){
                stmt.executeUpdate(createTableSQL);
                System.out.println("Table Employees created successfully");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
