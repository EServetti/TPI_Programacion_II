package View;

import Models.DetalleEquipo;
import java.util.Set;

public class TablaDePosicionesView {

    public void mostrarTabla(Set<DetalleEquipo> tabla) {
        System.out.println("---TABLA DE POSICIONES---");
        System.out.println("Pos | Equipo           | Pts | PG | PP | Dif");
        System.out.println("---------------------------------------------");
        int pos = 1;
        for (DetalleEquipo d : tabla) {
            System.out.printf("%-3d | %-16s | %-3d | %-2d | %-2d | %-4d\n",
                    pos++,
                    d.getEquipo().getNombre(),
                    d.getPuntos(),
                    d.getVictorias(),
                    d.getDerrotas(),
                    d.getDiferenciaPuntos());
        }
    }

    public void detalleNoEncontrado () {
        System.out.println("El detalle de equipo con ese equipo no fue encontrado");
    }
}
