public class Ticket implements Imprimible, Calculable {
    private Pasajero pasajero;
    private Vehiculo vehiculo;
    private String origen;
    private String destino;
    private double valorBase;

    public Ticket(Pasajero pasajero, Vehiculo vehiculo, double valorBase) {
        this.pasajero = pasajero;
        this.vehiculo = vehiculo;
        this.valorBase = valorBase;
    }

    public double calcularTotal() {
        return valorBase * (1 - pasajero.calcularDescuento());
    }

    public void imprimirDetalle() {
        System.out.println("Ticket: " + calcularTotal());
    }
}
