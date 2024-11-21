import exercise_1.CuentaCorriente;
import exercise_1.Ingreso;
import exercise_1.Retirada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CuentaCorrienteTest {
    CuentaCorriente cuentaCorriente;

    @BeforeEach
    void setUp(){
        this.cuentaCorriente = new CuentaCorriente("asdf-1234-1234-1234-1234");
    }
    @Test
    void crearMostrarTransacciones(){
        Ingreso transaccion1 = new Ingreso(300, LocalDate.of(2024, 11, 21), "Por que sí", "otra_cuenta");
        Retirada transaccion2 = new Retirada(170.60, LocalDate.of(2023, 5, 1), "Por que sí");
        Retirada transaccion3 = new Retirada(30.33, LocalDate.of(2022, 11, 30), "Por que sí");
        Ingreso transaccion4 = new Ingreso(220.4, LocalDate.of(2021, 11, 21), "Por que sí", "otra_cuenta");
        Retirada transaccion5 = new Retirada(790, LocalDate.of(2023, 10, 6), "Por que sí");

        this.cuentaCorriente.mostrarHistorialTransacciones();
        this.cuentaCorriente.nuevo_moviento(transaccion1);
        this.cuentaCorriente.nuevo_moviento(transaccion2);
        this.cuentaCorriente.nuevo_moviento(transaccion3);

        this.cuentaCorriente.mostrarHistorialTransacciones();
        this.cuentaCorriente.nuevo_moviento(transaccion4);
        this.cuentaCorriente.nuevo_moviento(transaccion5);

        this.cuentaCorriente.mostrarHistorialTransacciones();

        this.cuentaCorriente.mostrarHistorialTransacciones(LocalDate.of(2023,5,1), LocalDate.of(2024,11,21));

    }
}