package Controller;

import Models.Equipo;
import Models.TablaDePosiciones;
import Models.DetalleEquipo;
import View.TablaDePosicionesView;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

public class TablaDePosicionesController {
        private TablaDePosiciones modelo = new TablaDePosiciones(new TreeSet<>());
        private TablaDePosicionesView vista;
        private EquipoController equipoController;
        Connection conn;


    public TablaDePosicionesController(Connection conn, EquipoController equipoController) {
        this.conn = conn;
        this.vista = new TablaDePosicionesView();
        this.equipoController = equipoController;
    }

    public void agregarEquipo(DetalleEquipo detalle) {modelo.agregarDetalleEquipo(detalle);}

    public void actualizarEquipo(DetalleEquipo detalle) {modelo.actualizarDetalleEquipo(detalle);}

    public void mostrarTabla() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM detalles_equipos");

            TreeSet<DetalleEquipo> detalles = new TreeSet<>();

            while (rs.next()) {
                int idEquipo = rs.getInt("id_equipo");
                int puntos = rs.getInt("puntos");
                int victorias = rs.getInt("victorias");
                int derrotas = rs.getInt("derrotas");
                int puntosFavor = rs.getInt("puntos_favor");
                int puntosContra = rs.getInt("puntos_contra");

                Equipo equipo = equipoController.getEquipoPorId(idEquipo);
                if (equipo == null) {
                    equipo = new Equipo("Equipo_" + idEquipo);
                }

                DetalleEquipo detalle = new DetalleEquipo(equipo);
                detalle.setPuntos(puntos);
                detalle.setVictorias(victorias);
                detalle.setDerrotas(derrotas);
                detalle.setPuntosAfavor(puntosFavor);
                detalle.setPuntosEnContra(puntosContra);

                detalles.add(detalle);
            }

            modelo = new TablaDePosiciones(detalles);
            vista.mostrarTabla(modelo.getTablaOrdenada());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}