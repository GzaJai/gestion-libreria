package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:gestion_libreria.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error al conectar Database" + e.getMessage());
        }
        return conn;
    }
}
