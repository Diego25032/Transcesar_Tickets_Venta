public class TicketService {
    public void venderTicket(Pasajero p, Vehiculo v) {
        if (!v.hayCupo()) {
            System.out.println("Vehículo lleno");
            return;
        }
        v.subirPasajero();
        System.out.println("Ticket vendido");
    }
}