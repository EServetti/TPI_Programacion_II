package Controller;

import Models.TablaDePosiciones;
import Models.DetalleEquipo;
import View.TablaDePosicionesView;

public class TablaDePosicionesController {

    public class TablaPosicionesController {

        private TablaDePosiciones modelo;
        private TablaDePosicionesView vista;

        public TablaPosicionesController(TablaDePosiciones modelo, TablaDePosicionesView vista) {
            this.modelo = modelo;
            this.vista = vista;
        }

        public void agregarEquipo(DetalleEquipo detalle) {
            modelo.agregarDetalleEquipo(detalle);
        }

        public void mostrarTabla() {
            vista.mostrarTabla(modelo.getTablaOrdenada());
        }
    }
}