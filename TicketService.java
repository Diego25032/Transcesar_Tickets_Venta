import java.time.LocalDate;
import java.util.List;

public class TicketService {
    public boolean puedeComprar(Pasajero p, List<Ticket> tickets) {
    long count = tickets.stream()
        .filter(t -> t.getPasajero().equals(p))
        .filter(t -> t.getFecha().equals(LocalDate.now()))
        .count();

    return count < 3;
}
    public void venderTicket(Pasajero p, Vehiculo v) {
        if (!v.hayCupo()) {
            System.out.println("Vehículo lleno");
            return;
        }
        v.subirPasajero();
        System.out.println("Ticket vendido");
    }

    List<LocalDate> festivos = List.of(
    LocalDate.of(2026,1,1),
    LocalDate.of(2026,12,25)
);

public boolean esFestivo(LocalDate fecha) {
    return festivos.contains(fecha);
}
}