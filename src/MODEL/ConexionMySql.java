package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionMySql {
    private static ConexionMySql instancia;
    private Connection conexion;
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "Guia2";

    private ConexionMySql() throws SQLException {
        try {
            conexion = DriverManager.getConnection(URL + DB_NAME, USER, PASS);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos" + e.getMessage());
        }
    }

    public static ConexionMySql getInstancia() throws SQLException {
        if (instancia == null || instancia.getConexion().isClosed()) {
            instancia = new ConexionMySql();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
