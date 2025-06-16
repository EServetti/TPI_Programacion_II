package View;

import Models.Jugador;
import Models.Posicion;

import java.util.Scanner;

public class PosicionView {
    Scanner sc = new Scanner(System.in);

    public void verPosicion (Jugador jugador) {
        System.out.println(jugador.getPosicion());
    }

    public Posicion pedirPosicion () {
        System.out.println("Ingrese la posicion del jugador");
        String nombrePosicion = sc.nextLine();
        System.out.println("Ingrese el numero del jugador");
        int num = sc.nextInt();
        return new Posicion(nombrePosicion, num);
    }
}
