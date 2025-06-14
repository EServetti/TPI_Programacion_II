package Controlador;

import Models.Jugador;
import Vista.VistaJ;

import java.util.ArrayList;

public class JugadorControlador {
    ArrayList <Jugador> jugadores = new ArrayList<>();
    VistaJ vista = new VistaJ();
    PosicionVista vistaPosicion = new PosicionVista();



    private void registrarJugador(){
        String nombre = vista.pedirString("Ingrese el nombre del jugador ");
        String apellido = vista.pedirString("Ingrese el apellido del jugador");
        int dni = vista.pedirInt("Ingrese el Dni del jugador");
        String fechaNacimiento = vista.pedirFecha("Ingrese la fecha de nacimiento");
        Posicion posicion = vistaPosicion.pedirPosicion();
        Jugador jugador = new Jugador(nombre, apellido, dni, fechaNacimiento, posicion);
        jugadores.add(jugador);
    }
    public void mostrarJugador() {
        int dni = vista.pedirInt("Ingrese dni del jugador");
        Jugador exist = null;
        for (Jugador j : jugadores) {
            if (j.getDni()==dni) {
                exist=j;
            }


        }
        if (exist!=null) {
            vista.mostrarJugador(exist);

        }
        else{vista.mostrarLineas("No existe un jugador con ese dni");}

    }
    private void cambiarDniJugador(){
        int dniActual = vista.pedirInt("Ingrese el dni Actual del jugador");

        Jugador jugadorEncontrado = null;
        for (Jugador j:jugadores){
            if(j.getDni()==dniActual){
                jugadorEncontrado = j;
                break;

            }
            if (jugadorEncontrado == null) {
                System.out.println("No se encontró un jugador con ese DNI.");
                return;
            }
            int nuevoDni = vista.pedirInt("Ingrese el nuevo DNI:");

            jugadorEncontrado.setDni(nuevoDni);

            System.out.println("El DNI fue actualizado correctamente.");
        }
        }

    }



    }



