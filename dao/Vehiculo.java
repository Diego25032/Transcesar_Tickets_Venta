public abstract class Vehiculo implements Imprimible {
    protected String placa;
    protected String ruta;
    protected int capacidadMaxima;
    protected int pasajerosActuales = 0;

    public Vehiculo(String placa, String ruta, int capacidadMaxima) {
        this.placa = placa;
        this.ruta = ruta;
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean hayCupo() {
        return pasajerosActuales < capacidadMaxima;
    }

    public void subirPasajero() {
        pasajerosActuales++;
    }
}