package Controller;
import Models.*;
import View.PartidoView;

import java.sql.*;
import java.util.HashSet;

public class PartidoController {
    PartidoView partidoView;
    EquipoController equipoController;
    Connection conn;

    public PartidoController (EquipoController equipoController, Connection conn)
    {
        partidoView = new PartidoView();
        this.equipoController = equipoController;
        this.conn = conn;
    }

    public void crearPartido() {
        int idLocal = partidoView.pedirInt("Ingrese el id del equipo local");
        int idVisitante = partidoView.pedirInt("Ingrese el id del equipo visitante");

        if (idLocal == idVisitante) {
            System.out.println("Un equipo no puede jugar contra sí mismo.");
            return;
        }

        int puntosLocal = partidoView.pedirInt("Ingrese los puntos del local");
        int puntosVisitante = partidoView.pedirInt("Ingrese los puntos del visitante");
        int fechaTorneo = partidoView.pedirInt("Ingrese la fecha del torneo");

        Equipo local = equipoController.getEquipoPorId(idLocal);
        Equipo visitante = equipoController.getEquipoPorId(idVisitante);


        if (local != null && visitante != null) {
            try {
                String sql = "INSERT INTO partidos (id_local, id_visitante, puntos_local, puntos_visitante, fecha_torneo) " +
                        "VALUES (?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idLocal);
                ps.setInt(2, idVisitante);
                ps.setInt(3, puntosLocal);
                ps.setInt(4, puntosVisitante);
                ps.setInt(5, fechaTorneo);
                ps.executeUpdate();
                partidoView.partidoGuardado();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El id del local o del visitante es incorrecto");
        }
    }


    public void verPartidos() {
        try {
            String sql = "SELECT * FROM partidos";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            boolean hayPartidos = false;

            while (rs.next()) {
                Equipo local = equipoController.getEquipoPorId(rs.getInt("id_local"));
                Equipo visitante = equipoController.getEquipoPorId(rs.getInt("id_visitante"));
                int puntosLocal = rs.getInt("puntos_local");
                int puntosVisitante = rs.getInt("puntos_visitante");
                int fechaTorneo = rs.getInt("fecha_torneo");

                Partido partido = new Partido(local, visitante, puntosLocal, puntosVisitante, fechaTorneo);
                partidoView.mostrarPartido(partido);
                hayPartidos = true;
            }

            if(!hayPartidos) {
                System.out.println("No hay partidos guardados");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
