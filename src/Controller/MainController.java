package Controller;

import Models.DetalleEquipo;
import Models.Equipo;
import Models.TablaDePosiciones;
import View.MainView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

public class MainController {
    EquipoController equipoController;
    MainView mainView;
    TablaDePosicionesController tablaDePosicionesController;
    DetallesEquipoController detallesEquipoController;
    TablaDePosiciones tablaDePosiciones;
    PartidoController partidoController;
    JugadorController jugadorController;
    Connection conn;

    public MainController (Connection conn) {
        tablaDePosiciones = new TablaDePosiciones(new TreeSet<>());
        equipoController = new EquipoController(conn);
        mainView = new MainView();
        tablaDePosicionesController = new TablaDePosicionesController(conn, equipoController);
        detallesEquipoController = new DetallesEquipoController(equipoController, tablaDePosicionesController, conn);
        partidoController = new PartidoController(equipoController, conn);
        this.conn = conn;
        jugadorController = new JugadorController(conn, equipoController);
    }

    public void iniciar () {
        crearEquipos();
        mainView.mostrarMenu();
        int opcion = 0;
        while (opcion != 7) {
            opcion = mainView.pedirInt("Ingrese una opcion");
            switch (opcion) {
                case 1:
                    tablaDePosicionesController.mostrarTabla();
                    break;
                case 2:
                    detallesEquipoController.actualizarDetalleEquipo();
                    break;
                case 3:
                    jugadorController.registrarJugador();
                    break;
                case 4:
                    equipoController.verJugadores();
                    break;
                case 5:
                    partidoController.verPartidos();
                    break;
                case 6:
                    partidoController.crearPartido();
                    break;
                case 7:
                    System.out.println("Gracias por utilizar nuestro sistema, adios.");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        };

    }

    // Agregamos los equipos "default" del torneo
    public void crearEquipos() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS equipos (nombre VARCHAR(30), id INT PRIMARY KEY)");
            stmt.execute("CREATE TABLE IF NOT EXISTS detalles_equipos (" +
                    "id_equipo INT NOT NULL," +
                    "puntos INT DEFAULT 0," +
                    "victorias INT DEFAULT 0," +
                    "derrotas INT DEFAULT 0," +
                    "puntos_favor INT DEFAULT 0," +
                    "puntos_contra INT DEFAULT 0," +
                    "FOREIGN KEY (id_equipo) REFERENCES equipos (id))");
            stmt.execute("CREATE TABLE IF NOT EXISTS jugadores (" +
                    "nombre VARCHAR(30) NOT NULL, " +
                    "apellido VARCHAR(30) NOT NULL, " +
                    "fecha_nacimiento DATE NOT NULL, " +
                    "dni BIGINT PRIMARY KEY, " +
                    "posicion INT NOT NULL, " +
                    "id_equipo INT NOT NULL, " +
                    "FOREIGN KEY(id_equipo) REFERENCES equipos(id))");
            stmt.execute("CREATE TABLE IF NOT EXISTS partidos (id_local int not null," +
                    "id_visitante int not null," +
                    "puntos_local int default 0," +
                    "puntos_visitante int default 0," +
                    "fecha_torneo int default 1," +
                    "FOREIGN KEY(id_local) REFERENCES equipos(id)," +
                    "FOREIGN KEY(id_visitante) REFERENCES equipos(id))");

            for (int i = 1; i < 11; i++) {
                try (PreparedStatement psEquipo = conn.prepareStatement("INSERT INTO equipos (id, nombre) VALUES (?, ?)")) {
                    psEquipo.setInt(1, i);
                    psEquipo.setString(2, "Equipo_" + i);
                    psEquipo.executeUpdate();
                }

                try (PreparedStatement psDetalle = conn.prepareStatement("INSERT INTO detalles_equipos (id_equipo) VALUES (?)")) {
                    psDetalle.setInt(1, i);
                    psDetalle.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
