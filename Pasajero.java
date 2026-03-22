    import java.time.LocalDate;
import java.time.Period;
public abstract class Pasajero extends Persona {
    public abstract double calcularDescuento();
    
protected LocalDate fechaNacimiento;

public int calcularEdad() {
    return Period.between(fechaNacimiento, LocalDate.now()).getYears();
}
}
