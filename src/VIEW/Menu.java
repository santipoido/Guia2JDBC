package VIEW;

import CONTROLLER.UserController;
import MODEL.Alumno;
import MODEL.Direccion;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final UserController controller;
    private final Scanner scanner;

    public Menu() {
        controller = new UserController();
        scanner = new Scanner(System.in);
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ USUARIOS ---");
            System.out.println("1. Agregar alumno");
            System.out.println("2. Listar alumnos");
            System.out.println("3. Actualizar alumno");
            System.out.println("4. Eliminar alumno");
            System.out.println("5. Agregar dirección");
            System.out.println("6. Listar direcciones");
            System.out.println("7. Actualizar direccion");
            System.out.println("8. Eliminar direccion");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer del scanner

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> actualizar();
                case 4 -> eliminar();
                case 5 -> agregarDireccion();
                case 6 -> listarDirecciones();
                case 7 -> actualizarDireccion();
                case 8 -> eliminarDireccion();
                case 0 -> System.out.println("¡Chau!");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void agregar() {
        System.out.println("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();
        controller.agregarAlumno(id, nombre, apellido, edad, email);
    }

    private void listar() {
        List<Alumno> alumnos = controller.listarAlumnos();
        alumnos.forEach(System.out::println);
    }

    private void actualizar() {
        System.out.print("ID a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        controller.actualizarUsuario(id, nombre);
    }

    private void eliminar() {
        System.out.print("ID a eliminar: ");
        int id = scanner.nextInt();
        controller.eliminarUsuario(id);
    }

    private void agregarDireccion() {
        System.out.println("Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre calle: ");
        String nombreCalle = scanner.nextLine();

        System.out.print("Altura calle: ");
        int altura = scanner.nextInt();

        System.out.println("Id alumno a cargar la calle: ");
        int idAlumno = scanner.nextInt();
        scanner.nextLine();

        controller.agregarDireccion(id, nombreCalle, altura, idAlumno);
    }

    public void listarDirecciones(){
        List<Direccion> direcciones = controller.listarDirecciones();
        direcciones.forEach(System.out::println);
    }

    private void actualizarDireccion() {
        System.out.print("ID a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo nombre de calle: ");
        String nombre = scanner.nextLine();
        controller.actualizarDireccion(id, nombre);
    }

    private void eliminarDireccion() {
        System.out.print("ID a eliminar: ");
        int id = scanner.nextInt();
        controller.eliminarDireccion(id);
    }
}
