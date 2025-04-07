package MODEL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    private Connection conn;

    public AlumnoDAO() {
        try {
            conn = ConexionMySql.getInstancia().getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Inserta un nuevo alumno
    public void insertar(Alumno alumno) {
        String sql = "INSERT INTO alumnos(id, nombre, apellido, edad, email) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, alumno.getId());
            pstmt.setString(2, alumno.getNombre());
            pstmt.setString(3, alumno.getApellido());
            pstmt.setInt(4, alumno.getEdad());
            pstmt.setString(5, alumno.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error insertando usuario: " + e.getMessage());
        }
    }

    // Devuelve la lista de usuarios existentes
    public List<Alumno> obtenerTodos() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Alumno a = new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"), rs.getString("email"));
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error leyendo alumnos: " + e.getMessage());
        }
        return lista;
    }

    // Actualiza un usuario existente
    public void actualizar(Alumno alumno) {
        String sql = "UPDATE alumnos SET nombre = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, alumno.getNombre());
            pstmt.setInt(2, alumno.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error actualizando usuario: " + e.getMessage());
        }
    }

    // Elimina un usuario por su ID
    public void eliminar(int id) {
        String sql = "DELETE FROM alumnos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando usuario: " + e.getMessage());
        }
    }
}
