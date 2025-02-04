package ProyectoBim2;
import ProyectoBim2.entradas.entradas;
import ProyectoBim2.estadisticas.estadisticas;
import ProyectoBim2.asistencias.asistencias;

import java.util.Scanner;

public class FeriaInternacionalDeLoja {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        int totalEntradasNormales = 0;
        int totalEntradasEspeciales = 0;
        int totalGanancias = 0;
        int[][] asistenciaPorDia = new int[10][2];

        OUTER:
        while (true) {
            System.out.println("\n========================================");
            System.out.println("   🎡 Sistema de Gestión de Entradas 🎟️ ");
            System.out.println("========================================");
            System.out.println("1. Comprar entrada normal 🎟️");
            System.out.println("2. Comprar entrada especial 🎫");
            System.out.println("3. Ver estadísticas 📊");
            System.out.println("4. Registrar asistencias 📝");
            System.out.println("5. Salir 🚪");
            System.out.print("Seleccione una opción: ");
            int opcion = tcl.nextInt();
            switch (opcion) {
                case 1 -> {
                    totalGanancias += comprarEntradaNormal();
                    totalEntradasNormales++;
                }
                case 2 -> {
                    totalGanancias += comprarEntradaEspecial(tcl);
                    totalEntradasEspeciales++;
                }
                case 3 -> mostrarEstadisticas(totalEntradasNormales, totalEntradasEspeciales, totalGanancias, asistenciaPorDia);
                case 4 -> registrarAsistencia(tcl, asistenciaPorDia);
                case 5 -> {
                    System.out.println("\n👋 Gracias por usar el sistema. ¡Hasta la próxima!");
                    break OUTER;
                }
                default -> System.out.println("⚠️ Opción no válida, intente nuevamente.");
            }
        }
    }

    public static int comprarEntradaNormal() {
        int precio = 5;
        System.out.println("✅ Entrada normal comprada por $" + precio);
        return precio;
    }

    public static int comprarEntradaEspecial(Scanner tcl) {
        int precioBase = 10;
        System.out.print("Ingrese el día de la semana (jueves, viernes, sábado): ");
        String dia = tcl.next().toLowerCase();

        if (dia.equals("jueves")) {
            precioBase = 8;
        } else if (dia.equals("viernes") || dia.equals("sábado")) {
            precioBase = 12;
        }

        System.out.println("🎟️ Entrada especial comprada por $" + precioBase);
        return precioBase;
    }

    public static void mostrarEstadisticas(int normales, int especiales, int ganancias, int[][] asistenciaPorDia) {
        int totalVisitantes = normales + especiales;
        System.out.println("\n========================================");
        System.out.println(" 📊 Estadísticas de la Feria 🎡 ");
        System.out.println("========================================");
        System.out.println("👥 Total de visitantes: " + totalVisitantes);
        System.out.println("🎟️ Entradas normales vendidas: " + normales);
        System.out.println("🎭 Entradas especiales vendidas: " + especiales);
        System.out.println("💰 Ganancias totales: $" + ganancias);

        System.out.println("📅 Asistencia por día:");
        System.out.println("Día | Asistencia General | Función Especial");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < asistenciaPorDia.length; i++) {
            System.out.printf(" %2d | %18d | %16d \n", (i + 1), asistenciaPorDia[i][0], asistenciaPorDia[i][1]);
        }

        int totalSemana1General = 0, totalSemana1Especial = 0;
        int totalSemana2General = 0, totalSemana2Especial = 0;

        for (int i = 0; i < 5; i++) { // Días 1-5
            totalSemana1General += asistenciaPorDia[i][0];
            totalSemana1Especial += asistenciaPorDia[i][1];
        }
        for (int i = 5; i < 10; i++) { // Días 6-10
            totalSemana2General += asistenciaPorDia[i][0];
            totalSemana2Especial += asistenciaPorDia[i][1];
        }

        int totalSemana1 = totalSemana1General + totalSemana1Especial;
        int totalSemana2 = totalSemana2General + totalSemana2Especial;

        System.out.println("📌 Asistencia primera semana: " + totalSemana1 + " (General: " + totalSemana1General + ", Especial: " + totalSemana1Especial + ")");
        System.out.println("📌 Asistencia segunda semana: " + totalSemana2 + " (General: " + totalSemana2General + ", Especial: " + totalSemana2Especial + ")");
    }

    public static void registrarAsistencia(Scanner tcl, int[][] asistenciaPorDia) {
        System.out.println("\n========================================");
        System.out.println(" 📝 Registro de Asistencia ");
        System.out.println("========================================");
        System.out.print("Ingrese el número de día de la feria (1-10): ");
        int dia = tcl.nextInt();
        if (dia < 1 || dia > 10) {
            System.out.println("⚠️ Día inválido, intente nuevamente.");
            return;
        }

        System.out.print("👥 Ingrese la cantidad de asistentes generales: ");
        int cantidad = tcl.nextInt();
        
        System.out.print("🎭 Ingrese la asistencia a la función especial (2pm - 5pm): ");
        int funcionAsistencia = tcl.nextInt();

        asistenciaPorDia[dia - 1][0] += cantidad;
        asistenciaPorDia[dia - 1][1] += funcionAsistencia;

        System.out.println("✅ Asistencia registrada correctamente.");
    }
}