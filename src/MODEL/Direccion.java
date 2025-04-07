package MODEL;

public class Direccion {
    private int id;
    private String calle;
    private int altura;
    private int alumno_id;

    public Direccion(int id, String calle, int altura, int alumno_id) {
        this.id = id;
        this.calle = calle;
        this.altura = altura;
        this.alumno_id = alumno_id;
    }

    public Direccion() {}

    public Direccion(int id, String nombreCalle) {
        this.id = id;
        this.calle = nombreCalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", altura=" + altura +
                ", alumno_id=" + alumno_id +
                '}';
    }
}
