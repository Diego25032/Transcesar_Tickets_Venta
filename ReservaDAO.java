import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    private List<Reserva> reservas = new ArrayList<>();

    public void guardar(Reserva r) {
        reservas.add(r);
        System.out.println("Reserva guardada");
    }

    public List<Reserva> listar() {
        return reservas;
    }
}