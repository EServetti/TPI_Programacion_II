package Models;

import java.time.LocalDate;
import java.util.Date;

public class Jugador implements Comparable<Jugador> {

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int dni;
    private int posicion;

    public Jugador() {}

    public Jugador(String nombre, String apellido, int dni, Date fechaNacimiento, int posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.posicion = posicion;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public Date getFechaNacimiento() { return fechaNacimiento; }

    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public int getDni() { return dni; }

    public void setDni(int dni) { this.dni = dni; }

    public int getPosicion() { return posicion; }

    public void setPosicion(int posicion) { this.posicion = posicion; }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", dni=" + dni +
                ", posicion=" + posicion +
                '}';
    }

    @Override
    public int compareTo(Jugador o) {
        if (this.apellido == null && o.apellido == null) return 0;
        if (this.apellido == null) return -1;
        if (o.apellido == null) return 1;
        return this.apellido.compareTo(o.apellido);
    }
}
