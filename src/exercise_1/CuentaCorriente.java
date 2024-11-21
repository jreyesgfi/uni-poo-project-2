package exercise_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CuentaCorriente {
    private double saldo;
    private String titular;
    private String numero_cuenta;
    private ArrayList<Transaccion> transacciones;
    public CuentaCorriente(String new_numero_cuenta) {
        this.saldo = 0;
        this.titular = "";
        this.numero_cuenta = new_numero_cuenta;
        this.transacciones = new ArrayList<>();
    }
    private void informar_saldo() {
        System.out.println("\nINFORMACIÓN SALDO");
        String mensaje = String.format(
                "Titular: %s, Número de cuenta: %s, Saldo actual: %.2f€",
                this.titular,
                this.numero_cuenta,
                this.saldo
        );
        System.out.println(mensaje);
    }

    public void nuevo_moviento(Transaccion transaccion){
        this.saldo += transaccion.aplicarOperacionBancaria();
        this.transacciones.add(transaccion);
        transaccion.mostrarResumenOperacion();
        this.informar_saldo();
    }

    public void mostrarHistorialTransacciones(){
        System.out.println("\nHISTORIAL DE TRANSACCIONES");
        for (Transaccion transaccion : this.transacciones) {
            transaccion.mostrarResumenOperacion();
        }
    }

    public void mostrarHistorialTransacciones(LocalDate fecha_inicio, LocalDate fecha_fin){
        System.out.println("\nHISTORIAL DE TRANSACCIONES");
        System.out.println("Fecha inicio: "+fecha_inicio+". Fecha fin: "+fecha_fin+".");
        for (Transaccion transaccion : filtrarTransacciones(fecha_inicio, fecha_fin)) {
            transaccion.mostrarResumenOperacion();
        }
    }

    private List<Transaccion> filtrarTransacciones(LocalDate fecha_inicio, LocalDate fecha_fin){
        List<Transaccion> transaccionesFiltradas = transacciones.parallelStream()
                .filter(transaccion -> {
                    LocalDate fecha = transaccion.fecha;
                    return (fecha.isEqual(fecha_inicio) || fecha.isAfter(fecha_inicio)) &&
                            (fecha.isEqual(fecha_fin) || fecha.isBefore(fecha_fin));
                })
                .collect(Collectors.toList());
        return transaccionesFiltradas;
    }

}
