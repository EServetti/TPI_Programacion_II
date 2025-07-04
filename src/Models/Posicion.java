package Models;

public class Posicion {
    int numeroPosicion;
    String nombrePosicion;

    public Posicion(String nombrePosicion, int numeroPosicion) {
        this.nombrePosicion = nombrePosicion;
        this.numeroPosicion = numeroPosicion;
    }

    public int getNumeroPosicion() {
        return numeroPosicion;
    }

    @Override
    public String toString() {
        return this.nombrePosicion+" número= "+this.numeroPosicion;
    }

    public void setNumeroPosicion(int numeroPosicion) {
        this.numeroPosicion = numeroPosicion;
    }

    public String getNombrePosicion() {
        return nombrePosicion;
    }

    public void setNombrePosicion(String nombrePosicion) {
        this.nombrePosicion = nombrePosicion;
    }
}
