
package Models;

import java.util.Date;

public class Jugador implements Comparable<Jugador> {

    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int dni;
    private Posicion posicion;


    public Jugador() {
    }
    public Jugador(String nombre, String apellido, int dni, String fechaNacimiento) {
        this.nombre = nombre;

        this.dni = dni;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Jugador(String nombre, String posicion) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
<<<<<<< HEAD
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", dni=" + dni +
                '}';
    }
=======
    public int compareTo(Jugador o) {
        return this.apellido.compareTo(o.getApellido());
    }

>>>>>>> 3347a0f3e7087321f080608708f2ac1596aed700
}

