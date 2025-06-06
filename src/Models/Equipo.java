package Models;

import java.util.HashSet;

public class Equipo {
    private String nombre;
    private HashSet <Jugador> jugadores;
    private HashSet <Partido> partidos;
    private int puntos;
    private int anotacionesAFavor;
    private int anotacionesEnContra;
    private int diferenciaDeGoles;
    private int victorias;
    private int empates;
    private int derrotas;

    public Equipo() {
    }

    public Equipo(String nombre, HashSet<Jugador> jugadores,
                  HashSet<Partido> partidos, int puntos,
                  int anotacionesAFavor, int anotacionesEnContra,
                  int diferenciaDeGoles, int victorias, int empates,
                  int derrotas) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.partidos = partidos;
        this.puntos = puntos;
        this.anotacionesAFavor = anotacionesAFavor;
        this.anotacionesEnContra = anotacionesEnContra;
        this.diferenciaDeGoles = diferenciaDeGoles;
        this.victorias = victorias;
        this.empates = empates;
        this.derrotas = derrotas;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getAnotacionesAFavor() {
        return anotacionesAFavor;
    }

    public void setAnotacionesAFavor(int anotacionesAFavor) {
        this.anotacionesAFavor = anotacionesAFavor;
    }

    public int getAnotacionesEnContra() {
        return anotacionesEnContra;
    }

    public void setAnotacionesEnContra(int anotacionesEnContra) {
        this.anotacionesEnContra = anotacionesEnContra;
    }

    public int getDiferenciaDeGoles() {
        return diferenciaDeGoles;
    }

    public void setDiferenciaDeGoles(int diferenciaDeGoles) {
        this.diferenciaDeGoles = diferenciaDeGoles;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
}
