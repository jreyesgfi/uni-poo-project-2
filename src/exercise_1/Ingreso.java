package exercise_1;

import java.time.LocalDate;

public class Ingreso extends Transaccion implements OperacionBancaria{
    String cuenta_origen;
    public Ingreso(double monto, LocalDate fecha, String motivo, String cuenta_origen) {
        super(monto, fecha, motivo);
        this.cuenta_origen = cuenta_origen;
        this.tipo = "exercise_1.Ingreso";
    }

    @Override
    public double aplicarOperacionBancaria() {
        return monto;
    }

    @Override
    public void mostrarResumenOperacion() {
        super.mostrarResumenOperacion();
        System.out.println("Cuenta origen: " + cuenta_origen);
    }
}
