package Models;

public class DetalleEquipo implements Comparable<DetalleEquipo> {
    private Equipo equipo;
    private int puntos;
    private int victorias;
    private int derrotas;
    private int puntosAfavor;
    private int puntosEnContra;

    public DetalleEquipo() {
    }

    public DetalleEquipo(Equipo equipo) {
        this.equipo = equipo;
        this.puntosEnContra = 0;
        this.puntosAfavor = 0;
        this.derrotas = 0;
        this.victorias = 0;
        this.puntos = 0;
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

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getDiferenciaPuntos() {
        return this.puntosAfavor - this.puntosEnContra;
    }

    // Orden por puntos DESC, y si empatan, por nombre ASC
    @Override
    public int compareTo(DetalleEquipo o) {
        int cmp = Integer.compare(o.puntos, this.puntos);
        if (cmp == 0) {
            return this.equipo.getNombre().compareTo(o.equipo.getNombre());
        }
        return cmp;
    }

    // Dos DetalleEquipo son iguales si el equipo es el mismo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleEquipo)) return false;
        DetalleEquipo other = (DetalleEquipo) o;
        return this.equipo.getNombre().equals(other.equipo.getNombre());
    }

    @Override
    public int hashCode() {
        return equipo.getNombre().hashCode();
    }
}
