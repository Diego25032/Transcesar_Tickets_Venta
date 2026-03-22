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
            System.out.println("5. Reportes");

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
                case 4:
                    System.out.println("1. Tickets por fecha");
                    System.out.println("2. Tickets por vehículo");
                    System.out.println("3. Tickets por pasajero");
                    System.out.println("4. Resumen del día");    
            }
        } while (opcion != 5);

        sc.close();
    }
}