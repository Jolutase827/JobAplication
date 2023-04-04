package es.ieslavereda.myrecicleviewexample;

import java.io.Serializable;
import java.util.Comparator;

public class Usuario implements Serializable {

    public static final Comparator<Usuario> SORT_BY_NAME = new Comparator<Usuario>() {
        @Override
        public int compare(Usuario u, Usuario u1) {
            return (u.getNombre().compareToIgnoreCase(u1.getNombre())+(u.getApellidos().compareToIgnoreCase(u1.getApellidos())));
        }
    };
    public static final Comparator<Usuario> SORT_BY_PROFESION =  new Comparator<Usuario>() {
        @Override
        public int compare(Usuario u, Usuario u1) {
            return (u.getIdprofesion()- u1.getIdprofesion())+(u.getNombre().compareToIgnoreCase(u1.getNombre())+(u.getApellidos().compareToIgnoreCase(u1.getApellidos())));
        }
    };
    private String nombre;
    private String apellidos;
    private int idprofesion;

    public Usuario(String nombre, String apellidos, int idprofesion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.idprofesion = idprofesion;
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

    public int getIdprofesion() {
        return idprofesion;
    }

    public void setIdprofesion(int idprofesion) {
        this.idprofesion = idprofesion;
    }
}
