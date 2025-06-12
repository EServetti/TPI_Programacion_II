package Models;

import java.util.HashSet;
import java.util.Objects;

public class Equipo {
    private String nombre;
    private HashSet <Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(String nombre, HashSet<Jugador> jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
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
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre); // usar solo campos fijos
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

}
