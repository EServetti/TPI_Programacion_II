package View;
import Models.*;
public class PartidoView {

    public PartidoView() {
    }

    public void mostrarPartido(Partido partido) {
        System.out.println("Fecha del partido: " + partido.getFecha());
        System.out.println("Equipo Local: " + partido.getEquipoLocal().getNombre());
        System.out.println("Equipo Visitante: " + partido.getEquipoVistante().getNombre());
        int puntosLocal = partido.getPuntosLocal();
        int puntosVisitante = partido.getPuntosVisitante();
        System.out.println("Resultado: " + partido.getResultado(puntosVisitante, puntosLocal));
        System.out.println("Ganador: " + partido.getGanador(puntosVisitante, puntosLocal));
        System.out.println("Diferencia de puntos: " + partido.getDiferenciaPuntos(puntosLocal, puntosVisitante));
    }
}
