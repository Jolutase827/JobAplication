package es.ieslavereda.myrecicleviewexample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Profesion implements Serializable {
    private String nombre;
    private int imagen;

    public Profesion(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }



    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
