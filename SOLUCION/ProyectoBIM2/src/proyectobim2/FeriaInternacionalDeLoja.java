package proyectobim2;

import java.util.Scanner;
import java.io.*;

public class FeriaInternacionalDeLoja {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[][] boletos = new String[100][5]; 
        int contadorBoletos = 0;
        
        while (true) {
            System.out.println("\n=== Sistema de Gestión de Entradas - Feria Internacional de Loja ===");
            System.out.println("1. Comprar boleto");
            System.out.println("2. Ver facturación total");
            System.out.println("3. Registrar asistencia");
            System.out.println("4. Generar estadísticas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                contadorBoletos = comprarBoleto(scanner, boletos, contadorBoletos);
            } else if (opcion == 2) {
                verFacturacionTotal(boletos, contadorBoletos);
            } else if (opcion == 3) {
                registrarAsistencia(scanner, boletos, contadorBoletos);
            } else if (opcion == 4) {
                generarEstadisticas(boletos, contadorBoletos);
            } else if (opcion == 5) {
                guardarBoletosEnArchivo(boletos, contadorBoletos);
                System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static int comprarBoleto(Scanner scanner, String[][] boletos, int contadorBoletos) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        System.out.println("Tipo de entrada: ");
        System.out.println("1. Normal ($5)");
        System.out.println("2. Función especial ($10)");
        System.out.print("Seleccione el tipo de entrada: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        String tipoEntrada;
        String precio;
        if (tipo == 1) {
            tipoEntrada = "Normal";
            precio = "5";
        } else if (tipo == 2) {
            tipoEntrada = "Especial";
            precio = "10";
        } else {
            System.out.println("Tipo de entrada no válido. Compra cancelada.");
            return contadorBoletos;
        }

        System.out.print("Ingrese la fecha (dd-mm-aaaa): ");
        String fecha = scanner.nextLine();

        boletos[contadorBoletos][0] = String.valueOf(contadorBoletos + 1);
        boletos[contadorBoletos][1] = tipoEntrada;
        boletos[contadorBoletos][2] = fecha;
        boletos[contadorBoletos][3] = precio;
        boletos[contadorBoletos][4] = nombreCliente;
        contadorBoletos++;

        System.out.println("Boleto comprado exitosamente. ID: " + contadorBoletos);
        return contadorBoletos;
    }

    public static void verFacturacionTotal(String[][] boletos, int contadorBoletos) {
        int totalFacturado = 0;
        for (int i = 0; i < contadorBoletos; i++) {
            totalFacturado += Integer.parseInt(boletos[i][3]);
        }
        System.out.println("Facturación total: $" + totalFacturado);
    }

    public static void registrarAsistencia(Scanner scanner, String[][] boletos, int contadorBoletos) {
        System.out.print("Ingrese la fecha de la función especial (dd-mm-aaaa): ");
        String fecha = scanner.nextLine();

        int asistentes = 0;
        for (int i = 0; i < contadorBoletos; i++) {
            if (boletos[i][1].equals("Especial") && boletos[i][2].equals(fecha)) {
                asistentes++;
            }
        }

        System.out.println("Asistencia registrada para la función del " + fecha + ": " + asistentes + " personas.");
    }

    public static void generarEstadisticas(String[][] boletos, int contadorBoletos) {
        int totalNormal = 0, totalEspecial = 0;
        int ingresosNormal = 0, ingresosEspecial = 0;

        for (int i = 0; i < contadorBoletos; i++) {
            if (boletos[i][1].equals("Normal")) {
                totalNormal++;
                ingresosNormal += Integer.parseInt(boletos[i][3]);
            } else if (boletos[i][1].equals("Especial")) {
                totalEspecial++;
                ingresosEspecial += Integer.parseInt(boletos[i][3]);
            }
        }

        System.out.println("\n=== Estadísticas finales ===");
        System.out.println("Entradas normales vendidas: " + totalNormal);
        System.out.println("Entradas especiales vendidas: " + totalEspecial);
        System.out.println("Ingresos por entradas normales: $" + ingresosNormal);
        System.out.println("Ingresos por entradas especiales: $" + ingresosEspecial);
        System.out.println("Total ingresado: $" + (ingresosNormal + ingresosEspecial));
    }

    public static void guardarBoletosEnArchivo(String[][] boletos, int contadorBoletos) throws IOException {
        FileWriter writer = new FileWriter("boletos.csv");
        writer.write("ID,Tipo,Fecha,Precio,Cliente\n");
        for (int i = 0; i < contadorBoletos; i++) {
            writer.write(String.join(",", boletos[i]) + "\n");
        }
        System.out.println("Boletos guardados en 'boletos.csv'.");
    }
}
