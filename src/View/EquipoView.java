package View;

import Models.Jugador;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipoView {
    Scanner sc = new Scanner(System.in);
    public String pedirEquipo(){
        System.out.println("Ingrese el nombre del equipo: ");
        String nombreEquipo = sc.nextLine();
        return nombreEquipo;
    }
    public void jugadorAgregado (){
        System.out.println("El jugador fue agregado correctamente.");
    }
    public void errorAlAgregarJugador(){
        System.out.println("Hubo un error al agregar el jugador.");
    }
    public void verJugadores(ArrayList<Jugador> jugador){
        for (Jugador j : jugador){
            System.out.println(j);
        }
    }
}
