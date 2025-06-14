package Controller;
import Models.*;

public class ControllerPartido {

    public ControllerPartido() {
    }
    public void crearPartido(Equipo local, Equipo visitante, int puntosLocal, int puntosVisitante, int fecha) {
        Partido partido = new Partido(local, visitante, puntosLocal, puntosVisitante, fecha);
    }
}
