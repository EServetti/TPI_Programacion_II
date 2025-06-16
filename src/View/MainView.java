package View;

import java.util.Scanner;

public class MainView {
    Scanner sc = new Scanner(System.in);

    public void mostrarMenu () {
        System.out.println("Bienvenido al sistema del campeonato de basquet");
        System.out.println("Para ver la tabla ingrese 1");
        System.out.println("Para actualizar los detalles de un equipo ingrese 2");
        System.out.println("Para agregar un jugador a un equipo ingrese 3");
        System.out.println("Para ver los jugadores de un equipo ingrese 4");
        System.out.println("Para ver los partidos ingrese 5");
        System.out.println("Para agregar un partido ingrese 6");
        System.out.println("Para salir ingrese 7");
    }

    public String pedirString(String dato) {
        System.out.println(dato);
        return sc.next();
    }

    public int pedirInt(String dato) {
        System.out.println(dato);
        return sc.nextInt();
    }
}
