package tugas.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/covid";
        return DriverManager.getConnection(url,"root","");
    }
}
