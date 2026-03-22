import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReservaService {

    private ReservaDAO dao;
    private TicketService ticketService;

    public ReservaService(ReservaDAO dao, TicketService ticketService) {
        this.dao = dao;
        this.ticketService = ticketService;
    }

    // ✅ 1. Crear reserva
    public void crearReserva(Reserva r) {

        // regla: no más de capacidad
        long ocupados = dao.listar().stream()
                .filter(res -> res.getVehiculo().equals(r.getVehiculo()))
                .filter(res -> res.getEstado() == EstadoReserva.ACTIVA)
                .count();

        if (ocupados >= r.getVehiculo().getCapacidadMaxima()) {
            System.out.println("No hay cupos disponibles");
            return;
        }

        // regla: no repetir reserva mismo pasajero
        boolean existe = dao.listar().stream()
                .anyMatch(res ->
                        res.getPasajero().equals(r.getPasajero()) &&
                        res.getVehiculo().equals(r.getVehiculo()) &&
                        res.getFechaViaje().equals(r.getFechaViaje()) &&
                        res.getEstado() == EstadoReserva.ACTIVA
                );

        if (existe) {
            System.out.println("Ya tiene una reserva activa");
            return;
        }

        dao.guardar(r);
    }

    // ✅ 2. Cancelar
    public void cancelarReserva(String codigo) {
        dao.listar().forEach(r -> {
            if (r.getCodigo().equals(codigo)) {
                r.cancelar();
            }
        });
    }

    // ✅ 3. Convertir a ticket
    public void convertirReserva(String codigo) {
        for (Reserva r : dao.listar()) {
            if (r.getCodigo().equals(codigo) && r.getEstado() == EstadoReserva.ACTIVA) {

                ticketService.venderTicket(r.getPasajero(), r.getVehiculo());

                r.convertir();
            }
        }
    }

    // ✅ 4. Verificar vencidas
    public void verificarVencidas() {
        int contador = 0;

        for (Reserva r : dao.listar()) {
            if (r.getEstado() == EstadoReserva.ACTIVA && r.estaVencida()) {
                r.cancelar();
                contador++;
            }
        }

        System.out.println("Reservas canceladas: " + contador);
    }

    // ✅ 5. Listar activas
    public List<Reserva> listarActivas() {
        return dao.listar().stream()
                .filter(r -> r.getEstado() == EstadoReserva.ACTIVA)
                .collect(Collectors.toList());
    }
}