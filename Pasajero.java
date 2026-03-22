    import java.time.LocalDate;
import java.time.Period;
public abstract class Pasajero extends Persona {

protected LocalDate fechaNacimiento;

public int calcularEdad() {
    return Period.between(fechaNacimiento, LocalDate.now()).getYears();
}
public double calcularDescuento() {
    if (calcularEdad() >= 60) return 0.30;
    return 0.0;
}


}

