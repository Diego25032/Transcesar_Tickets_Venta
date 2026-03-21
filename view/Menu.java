import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== SISTEMA TRANSCESAR ===");
            System.out.println("1. Registrar Vehiculo");
            System.out.println("2. Registrar Pasajero");
            System.out.println("3. Vender Ticket");
            System.out.println("4. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Registrando vehiculo...");
                    break;
                case 2:
                    System.out.println("Registrando pasajero...");
                    break;
                case 3:
                    System.out.println("Vendiendo ticket...");
                    break;
            }
        } while (opcion != 4);
    }
}