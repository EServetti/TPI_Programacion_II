package Controller;

import Models.Equipo;
import Models.Jugador;
import View.EquipoView;

import java.util.HashSet;

public class EquipoController {
    private HashSet<Equipo> equipos = new HashSet<>();
    public void agregarJugadorAEquipo(){
        JugadorView jugadorView = new JugadorView();
        EquipoView equipoView = new EquipoView();
        Jugador jugador = jugadorView.pedirJugador();
        String nombreEquipo = equipoView.pedirEquipo();
        Equipo equipo = null;
        for (Equipo e: equipos){
            if (e.getNombre()==nombreEquipo){
                equipo=e;
            }
        }
        if (equipo != null){
            equipo.addJugador(jugador);
            equipoView.jugadorAgregado();
        }
        else{
            equipoView.errorAlAgregarJugador();
        }
    }
}
