package Models;

public class DetalleEquipo implements Comparable<DetalleEquipo>{
    private Equipo equipo;
    private int puntos;
    private int victorias;
    private int derrotas;
    private int puntosAfavor;
    private int puntosEnContra;

    public DetalleEquipo(Equipo equipo, int puntos, int victorias, int derrotas, int puntosAfavor, int puntosEnContra){
        this.equipo = equipo;
        this.puntos = puntos;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntosAfavor = puntosAfavor;
        this.puntosEnContra = puntosEnContra;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getPuntosAfavor() {
        return puntosAfavor;
    }

    public int getPuntosEnContra() {
        return puntosEnContra;
    }

    public int getDiferenciaPuntos() {
        return puntosAfavor - puntosEnContra;
    }

    @Override
    public int compareTo(DetalleEquipo o){
        if (puntos != o.puntos){
            return Integer.compare(o.puntos, puntos);
        }
        return Integer.compare(o.getDiferenciaPuntos(), getDiferenciaPuntos());
    }
}
