package Controller;

import Models.Equipo;
import Models.Jugador;
import Models.Posicion;
import View.JugadorView;
import View.PosicionView;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class JugadorController {
    JugadorView vista;
    PosicionView vistaPosicion;
    EquipoController equipoController;
    Connection conn;

    public JugadorController(Connection conn, EquipoController equipoController) {
        vista = new JugadorView();
        vistaPosicion = new PosicionView();
        this.equipoController = equipoController;
        this.conn = conn;
    }


    public void registrarJugador() {
        String nombre = vista.pedirString("Ingrese el nombre del jugador ");
        String apellido = vista.pedirString("Ingrese el apellido del jugador");
        int dni = vista.pedirInt("Ingrese el Dni del jugador");
        Date fechaNacimiento = vista.pedirFecha();
        int posicion = vista.pedirInt("Ingrese el número que usa el jugador");
        int idEquipo = vista.pedirInt("Ingrese el id del equipo en que juega");

        Equipo exists = equipoController.getEquipoPorId(idEquipo);

        if (exists != null) {
            try {
                String sql = "INSERT INTO jugadores (nombre, apellido, dni, fecha_nacimiento, posicion, id_equipo) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, nombre);
                    ps.setString(2, apellido);
                    ps.setInt(3, dni);
                    ps.setDate(4, fechaNacimiento);
                    ps.setInt(5, posicion);
                    ps.setInt(6, idEquipo);
                    ps.executeUpdate();
                }
                vista.mostrarLineas("El jugador fue agregado al equipo");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            vista.mostrarLineas("No existe un equipo con ese id");
        }
    }
}




