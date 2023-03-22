package es.ieslavereda.myrecicleviewexample;

public class Usuario {

    private String nombre;
    private String apellidos;
    private String oficio;
    private int imagen;

    public Usuario(String nombre, String apellidos, String oficio, int imagen) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.oficio = oficio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
