package View;

import java.util.Scanner;

public class DetalleEquipoView {
    Scanner sc = new Scanner(System.in);
    public void mostrarMensaje (String message) {
        System.out.println(message);
    }

    public void menuActualizacion () {
        System.out.println("Que quieres actualizar de detalle equipo?");
        System.out.println("Actualizar puntos ingrese 1");
        System.out.println("Actualizar anotaciones a favor ingrese 2");
        System.out.println("Actualizar anotaciones en contra ingrese 3");
        System.out.println("Actualizar victorias ingrese 4");
        System.out.println("Actualizar derrotas ingrese 5");
        System.out.println("Cancelar ingrese 6");
    }

    public int pedirInt (String message) {
        System.out.println(message);
        return sc.nextInt();
    }

    public String pedirString (String message) {
        System.out.println(message);
        return sc.nextLine();
    }
}
