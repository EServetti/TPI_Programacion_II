package Models;

import java.util.HashSet;

public class Equipo {
    private String nombre;
    private HashSet <Jugador> jugadores;
    private HashSet <Partido> partidos;

    public Equipo() {
    }

    public Equipo(String nombre, HashSet<Jugador> jugadores, HashSet<Partido> partidos) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.partidos = partidos;
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

    public HashSet<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(HashSet<Partido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", jugadores=" + jugadores +
                ", partidos=" + partidos +
                '}';
    }
}
