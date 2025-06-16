package Models;

import java.util.HashSet;
import java.util.Objects;

public class Equipo {
    private String nombre;
    private HashSet <Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(HashSet<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", jugadores=" + jugadores +
                '}';
    }
    public void addJugador(Jugador jugador){
        jugadores.add(jugador);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        Equipo other = (Equipo) o;
        return this.nombre.equals(other.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

}
