package Models;
import java.util.Set;
import java.util.TreeSet;

public class TablaDePosiciones{
    private TreeSet<DetalleEquipo> tabla;

    public TablaDePosiciones(TreeSet<DetalleEquipo> tabla) {
        this.tabla = tabla;
    }

    public void agregarDetalleEquipo(DetalleEquipo detalle){
        tabla.add(detalle);
    }

    public void actualizarDetalleEquipo(DetalleEquipo nuevoDetalle) {
        DetalleEquipo detalleExistente = null;
        tabla.removeIf(d -> d.getEquipo().getNombre().equals(nuevoDetalle.getEquipo().getNombre()));
        tabla.add(nuevoDetalle);
    }


    public DetalleEquipo getDetalleEquipo (Equipo e) {
        DetalleEquipo exists = null;
        for (DetalleEquipo de : this.tabla) {
            if (de.getEquipo() == e) {
                exists = de;
            }
        }
        return exists;
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
        return tabla;
    }
}