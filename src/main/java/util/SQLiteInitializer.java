package util;

import java.io.*;
import java.sql.*;

public class SQLiteInitializer {

    private static final String DB_URL = "jdbc:sqlite:gestion_libreria.db";
    private static final String SCHEMA_FILE = "schema.sql";

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null && isDatabaseEmpty(conn)) {
                System.out.println("Inicializando base de datos");
                runSchemaScript(conn);
                System.out.println("Base de datos creada correctamente");
            } else {
                System.out.println("Base de datos ya inicializada");
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException("Error al inicializar la base de datos", e);
        }
    }

    private static boolean isDatabaseEmpty (Connection conn) throws SQLException {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%'";
        try  (Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            return !rs.next();
        }
    };

    private static void runSchemaScript (Connection conn) throws IOException, SQLException {
        try (InputStream is = SQLiteInitializer.class.getClassLoader().getResourceAsStream(SCHEMA_FILE)) {
            if (is == null) {
                throw new IOException("No se encontró el archivo " + SCHEMA_FILE + " en resources");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                Statement stmt = conn.createStatement();

                StringBuilder sql = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("--")) continue;

                    sql.append(line);
                    if (line.endsWith(";")) {
                        stmt.execute(sql.toString());
                        sql.setLength(0);
                    }
                }
            }
        }
    }
}
