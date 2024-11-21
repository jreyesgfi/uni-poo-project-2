package exercise_1;

import java.time.LocalDate;

public class Retirada extends Transaccion implements OperacionBancaria{
    public Retirada(double monto, LocalDate fecha, String motivo) {
        super(monto, fecha, motivo);
        this.tipo = "exercise_1.Retirada";
    }

    @Override
    public double aplicarOperacionBancaria() {
        // Podríamos añadir la transacción exercise_1.Ingreso a la cuenta destino
        return -monto;
    }
}
