package Models;

import java.util.Date;

public class Jugador implements Comparable<Jugador> {

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int dni;
    private Posicion posicion;

    public Jugador() {
    }

    public Jugador(String nombre, Posicion posicion, int dni, String apellido, Date fechaNacimiento) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.dni = dni;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int compareTo(Jugador o) {
        return this.nombre.compareTo(o.getNombre());
    }

}
