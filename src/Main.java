import Controller.JugadorController;
import Controller.MainController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpi_prog_ii","tu_usuario","tu_contraseña");
            MainController mainController = new MainController(conn);
            mainController.iniciar();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
