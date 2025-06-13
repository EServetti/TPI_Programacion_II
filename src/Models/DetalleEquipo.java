package Models;

import java.util.HashSet;

public class DetalleEquipo implements Comparable<DetalleEquipo>{
    private Equipo equipo;
    private HashSet<Partido> partidos;
    private int puntos;
    private int victorias;
    private int derrotas;
    private int puntosAfavor;
    private int puntosEnContra;

    public DetalleEquipo() {
    }

    public DetalleEquipo(Equipo equipo, int puntosEnContra, int puntosAfavor, int derrotas, int victorias, int puntos, HashSet<Partido> partidos) {
        this.equipo = equipo;
        this.puntosEnContra = puntosEnContra;
        this.puntosAfavor = puntosAfavor;
        this.derrotas = derrotas;
        this.victorias = victorias;
        this.puntos = puntos;
        this.partidos = partidos;
    }

    public int getPuntosEnContra() {
        return puntosEnContra;
    }

    public void setPuntosEnContra(int puntosEnContra) {
        this.puntosEnContra = puntosEnContra;
    }

    public int getPuntosAfavor() {
        return puntosAfavor;
    }

    public void setPuntosAfavor(int puntosAfavor) {
        this.puntosAfavor = puntosAfavor;
    }

    public int getDerrotas(){
        return derrotas;
    }

    public void setDerrotas(int derrotas){
        this.derrotas = derrotas;
    }

    public int getVictorias(){
        return victorias;
    }

    public void setVictorias(int victorias){
        this.victorias = victorias;
    }

    public int getPuntos(){
        return puntos;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }

    public HashSet<Partido> getPartidos(){
        return partidos;
    }

    public void setPartidos(HashSet<Partido> partidos){
        this.partidos = partidos;
    }

    public Equipo getEquipo(){
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getDiferenciaPuntos() {
        return this.puntosAfavor - this.puntosEnContra;
    }

    @Override
    public int compareTo(DetalleEquipo o) {
        return 0;
    }
}
