package View;

import Models.Jugador;

import java.sql.Date;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadorView {
    Scanner sc = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String pedirString(String dato) {
        System.out.println(dato);
        return sc.nextLine();
    }

    public int pedirInt(String dato) {
        System.out.println(dato);
        int integrer = sc.nextInt();
        sc.nextLine();
        return integrer;
    }

    public Date pedirFecha() {
        System.out.println("Ingrese la fecha de nacimiento (formato: yyyy-MM-dd):");
        try {
            String input = sc.nextLine();
            LocalDate localDate = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
            return Date.valueOf(localDate);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Intente nuevamente.");
            return pedirFecha();
        }
    }



    public void mostrarJugadores(ArrayList<Jugador> jugadores) {
        for (Jugador j:jugadores){
            System.out.println(j);
        }

    }
    public void mostrarJugador(Jugador jugador){
        System.out.println(jugador.toString());

    }
    public void mostrarLineas(String mensaje){
        System.out.println(mensaje);

    }


}
