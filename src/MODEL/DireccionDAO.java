package MODEL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO {
    private Connection conn;

    public DireccionDAO() {
        try {
            conn = ConexionMySql.getInstancia().getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Inserta una nueva direccion
    public void insertar(Direccion direccion) {
        String sql = "INSERT INTO direcciones(id, calle, altura, alumno_id) VALUES(?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, direccion.getId());
            pstmt.setString(2, direccion.getCalle());
            pstmt.setInt(3, direccion.getAltura());
            pstmt.setInt(4, direccion.getAlumno_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insertando direccion: " + e.getMessage());
        }
    }

    // Devuelve la lista de direcciones
    public List<Direccion> obtenerTodos() {
        List<Direccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM direcciones";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Direccion d = new Direccion(rs.getInt("id"), rs.getString("calle"), rs.getInt("altura"), rs.getInt("alumno_id"));
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Error leyendo direcciones: " + e.getMessage());
        }
        return lista;
    }

    // Actualiza un usuario existente
    public void actualizar(Direccion direccion) {
        String sql = "UPDATE direcciones SET calle = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, direccion.getCalle());
            pstmt.setInt(2, direccion.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando direccion: " + e.getMessage());
        }
    }

    // Elimina una dirección por su ID
    public void eliminar(int id) {
        String sql = "DELETE FROM direcciones WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando direccion: " + e.getMessage());
        }
    }
}
