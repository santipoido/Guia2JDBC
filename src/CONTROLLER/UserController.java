package CONTROLLER;

import MODEL.Alumno;
import MODEL.AlumnoDAO;
import MODEL.Direccion;
import MODEL.DireccionDAO;

import java.util.List;

public class UserController {
    private AlumnoDAO dao;
    private DireccionDAO dao2;

    public UserController() {
        dao = new AlumnoDAO();
        dao2 = new DireccionDAO();
    }

    public void agregarAlumno(int id, String nombre, String apellido, int edad, String email) {
        dao.insertar(new Alumno(id, nombre, apellido, edad, email));
    }

    public List<Alumno> listarAlumnos() {
        return dao.obtenerTodos();
    }

    public void actualizarUsuario(int id, String nuevoNombre) {
        dao.actualizar(new Alumno(id, nuevoNombre));
    }

    public void eliminarUsuario(int id) {
        dao.eliminar(id);
    }

    public void agregarDireccion(int id, String nombreCalle, int alturaCalle, int idAlumno){
        dao2.insertar(new Direccion(id, nombreCalle, alturaCalle, idAlumno));
    }

    public List<Direccion> listarDirecciones(){
        return dao2.obtenerTodos();
    }

    public void actualizarDireccion(int id, String nombreCalle){
        dao2.actualizar(new Direccion(id, nombreCalle));
    }

    public void eliminarDireccion(int id){
        dao2.eliminar(id);
    }
}
