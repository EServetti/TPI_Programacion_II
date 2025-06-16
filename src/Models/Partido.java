package Models;

public class Partido implements Comparable<Partido> {
    private Equipo equipoLocal;
    private Equipo equipoVistante;
    private int puntosLocal;
    private int puntosVisitante;
    private int fecha;

    public Partido() {
    }

    public Partido(Equipo equipoLocal, Equipo equipoVistante, int puntosLocal, int puntosVisitante, int fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVistante = equipoVistante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.fecha = fecha;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVistante() {
        return equipoVistante;
    }

    public void setEquipoVistante(Equipo equipoVistante) {
        this.equipoVistante = equipoVistante;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public String getGanador(int puntosVisitante,int puntosLocal){
        if (puntosVisitante>puntosLocal){
            return "Gano el equipo visitante";
        } else if (puntosVisitante<puntosLocal) {
            return "Gano el equipo local";
        } else return  "Empate";

    }
    public int getDiferenciaPuntos(int puntosLocal, int puntosVisitante){
        return Math.abs(puntosLocal - puntosVisitante);
    }

    public String getResultado(int puntosVisitante, int puntosLocal){
        String local = "Local:"+puntosLocal;
        String visitante = "Vistante:"+puntosVisitante;
        return local+" - "+visitante;
    }

    @Override
    public int compareTo(Partido o) {
        return Integer.compare(this.fecha, o.fecha);
    }

}
