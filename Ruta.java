public class Ruta {
    private String codigo;
    private String origen;
    private String destino;
    private double distanciaKm;
    private int tiempoMin;

    public Ruta(String codigo, String origen, String destino, double distanciaKm, int tiempoMin) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.tiempoMin = tiempoMin;
    }
}