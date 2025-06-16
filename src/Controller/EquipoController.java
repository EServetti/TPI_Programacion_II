package Controller;

import Models.Equipo;
import Models.Jugador;
import View.EquipoView;
import View.JugadorView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class EquipoController {

    JugadorView jugadorView;
    EquipoView equipoView;
    Connection conn;

    public EquipoController (Connection conn) {
        equipoView = new EquipoView();
        jugadorView = new JugadorView();
        this.conn = conn;
    }

    public Equipo getEquipo () {
        int id = equipoView.pedirInt("Ingrese el id del equipo");
        return getEquipoPorId(id);
    }

    public void verJugadores() {
        int idEquipo = equipoView.pedirInt("Ingrese el id del equipo para ver sus jugadores");
        Equipo equipo = this.getEquipoPorId(idEquipo);

        if (equipo != null) {
            try {
                String sql = "SELECT * FROM jugadores WHERE id_equipo = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idEquipo);
                ResultSet rs = ps.executeQuery();

                boolean hayJugadores = false;
                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    int dni = rs.getInt("dni");
                    int posicion = rs.getInt("posicion");
                    Date fechaNacimiento = rs.getDate("fecha_nacimiento");

                    Jugador jugador = new Jugador(nombre, apellido, dni, fechaNacimiento, posicion);
                    jugadorView.mostrarJugador(jugador);
                    hayJugadores = true;
                }

                if (!hayJugadores) {
                    System.out.println("Este equipo no tiene jugadores registrados.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No existe un equipo con ese id");
        }
    }

    public Equipo getEquipoPorId(int id) {
        Equipo equipo = null;
        try {
            String sql = "SELECT * FROM equipos WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                equipo = new Equipo(nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipo;
    }

}
