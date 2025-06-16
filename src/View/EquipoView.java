package View;

import Models.Jugador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class EquipoView {
    Scanner sc = new Scanner(System.in);

    public void jugadorAgregado (){
        System.out.println("El jugador fue agregado correctamente.");
    }

    public void errorAlAgregarJugador(){
        System.out.println("Hubo un error al agregar el jugador.");
    }

    public void verJugadores(HashSet<Jugador> jugador){
        for (Jugador j : jugador){
            System.out.println(j.toString());
        }
    }

    public String pedirString (String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public int pedirInt (String message) {
        System.out.println(message);
        return sc.nextInt();
    }

    public void equipoCreado() {
        System.out.println("El equipo fue agregado al sistema");
    }

    public void equipoNoEncontrado () {
        System.out.println("No se encontro un equipo con ese nombre");
    }
}
