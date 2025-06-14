package Vista;

import Models.Jugador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class VistaJ {
    Scanner sc = new Scanner(System.in);
    public String pedirString(String dato) {
        System.out.println(dato);
        return sc.next();
    }

    public int pedirInt(String dato) {
        System.out.println(dato);
        return sc.nextInt();
    }

    public String pedirFecha(String dato) {
        System.out.println();
        return sc.nextLine();
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
