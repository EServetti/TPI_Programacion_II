package Models;
import java.util.Set;
import java.util.TreeSet;

public class TablaDePosiciones{
    private Set<DetalleEquipo> tabla;
    public TablaDePosiciones(){
        tabla = new TreeSet<>();
    }
    public void agregarDetalleEquipo(DetalleEquipo detalle){
        tabla.add(detalle);
    }
    public void actualizarTabla(){
    }
    public void mostrarTabla(){
        System.out.println("---- Tabla de Posiciones ----");
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
    public Set<DetalleEquipo> getTablaOrdenada(){
        return new TreeSet<>(tabla);
    }
}