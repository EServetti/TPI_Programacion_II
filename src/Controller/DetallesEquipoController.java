package Controller;

import Models.DetalleEquipo;
import Models.Equipo;
import Models.Partido;
import Models.TablaDePosiciones;
import View.DetalleEquipoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetallesEquipoController {
    private DetalleEquipoView detalleEquipoView;
    Connection conn;

    public DetallesEquipoController(EquipoController equipoController, TablaDePosicionesController tablaDePosicionesController, Connection conn) {
        this.detalleEquipoView = new DetalleEquipoView();
        this.conn = conn;
    }


    public void actualizarDetalleEquipo() {
        int id = detalleEquipoView.pedirInt("Ingrese el id del equipo");

        detalleEquipoView.menuActualizacion();
        int opcion = 0;

        while (opcion != 6) {
            opcion = detalleEquipoView.pedirInt("Seleccione una opcion");
            String campo = null;
            int nuevoValor = 0;

            switch (opcion) {
                case 1:
                    campo = "puntos";
                    nuevoValor = detalleEquipoView.pedirInt("Ingrese los puntos del equipo");
                    break;
                case 2:
                    campo = "puntos_favor";
                    nuevoValor = detalleEquipoView.pedirInt("Ingrese las anotaciones a favor");
                    break;
                case 3:
                    campo = "puntos_contra";
                    nuevoValor = detalleEquipoView.pedirInt("Ingrese las anotaciones en contra");
                    break;
                case 4:
                    campo = "victorias";
                    nuevoValor = detalleEquipoView.pedirInt("Ingrese las victorias del equipo");
                    break;
                case 5:
                    campo = "derrotas";
                    nuevoValor = detalleEquipoView.pedirInt("Ingrese las derrotas del equipo");
                    break;
                case 6:
                    detalleEquipoView.mostrarMensaje("Saliendo de la edición");
                    return;
                default:
                    detalleEquipoView.mostrarMensaje("Ingrese una opción válida");
                    continue;
            }

            try {
                String sql = "UPDATE detalles_equipos SET " + campo + " = ? WHERE id_equipo = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, nuevoValor);
                ps.setInt(2, id);
                int filas = ps.executeUpdate();

                if (filas > 0) {
                    detalleEquipoView.mostrarMensaje("El campo '" + campo + "' fue actualizado correctamente.");
                } else {
                    detalleEquipoView.mostrarMensaje("No se encontró el equipo con ese ID.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                detalleEquipoView.mostrarMensaje("Ocurrió un error al actualizar la base de datos.");
            }

            opcion = 6;
        }
    }

}
