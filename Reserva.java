import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {

    private String codigo;
    private Pasajero pasajero;
    private Vehiculo vehiculo;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaViaje;
    private EstadoReserva estado;

    public Reserva(String codigo, Pasajero pasajero, Vehiculo vehiculo, LocalDate fechaViaje) {
        this.codigo = codigo;
        this.pasajero = pasajero;
        this.vehiculo = vehiculo;
        this.fechaViaje = fechaViaje;
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoReserva.ACTIVA;
    }

    public boolean estaVencida() {
        return fechaCreacion.plusHours(24).isBefore(LocalDateTime.now());
    }

    public void cancelar() {
        estado = EstadoReserva.CANCELADA;
    }

    public void convertir() {
        estado = EstadoReserva.CONVERTIDA;
    }

    // getters
}