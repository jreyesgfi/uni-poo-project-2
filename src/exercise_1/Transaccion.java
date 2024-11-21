package exercise_1;

import java.time.LocalDate;

public class Transaccion implements OperacionBancaria{
    protected double monto;
    protected LocalDate fecha;
    protected String motivo;
    protected String tipo = "exercise_1.Transaccion";
    public Transaccion(double monto, LocalDate fecha, String motivo) {
        checkMonto(monto);
        this.monto = monto;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    protected void checkMonto(double monto_to_check) throws ArithmeticException{
        if (monto_to_check < 0){
            throw new ArithmeticException("Monto negativo");
        }
    }

    public double aplicarOperacionBancaria(){
        return monto;
    }

    public void mostrarResumenOperacion(){
        System.out.println("\nRESUMEN OPERACION");
        System.out.println("Tipo de transacción: "+ this.tipo);
        System.out.println("Fecha: "+this.fecha);
        System.out.println("Monto: "+this.monto);
        System.out.println("Motivo: "+motivo);
    }


}
