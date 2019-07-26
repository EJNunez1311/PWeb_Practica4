package Practica2;

public class Estudiante {

    private int matricula;
    private  String nombre;
    private  String apellido;
    private  String carrera;
    private  String telefono;

    public Estudiante() {

    }

    @Override
    public String toString() {
        return String.format("matricula: %d, Nombre: %s, Apellido: %s, Carrera: %s, Telefono: %s", matricula, nombre, apellido, carrera, telefono);
    }

    public Estudiante(int matricula, String nombre, String apellido, String carrera, String telefono) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getMatricula() {
        return matricula;

    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;

    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
