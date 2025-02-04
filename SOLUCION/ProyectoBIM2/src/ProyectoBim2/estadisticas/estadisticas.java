package ProyectoBim2.estadisticas;

public class estadisticas {
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

        int[][] resumenSemanal = new int[2][2]; // [Semana][General, Especial]

        for (int i = 0; i < 5; i++) { // Días 1-5
            resumenSemanal[0][0] += asistenciaPorDia[i][0]; // General
            resumenSemanal[0][1] += asistenciaPorDia[i][1]; // Especial
        }
        for (int i = 5; i < 10; i++) { // Días 6-10
            resumenSemanal[1][0] += asistenciaPorDia[i][0]; // General
            resumenSemanal[1][1] += asistenciaPorDia[i][1]; // Especial
        }

        System.out.println("\n📊 Resumen de Asistencia por Semana:");
        System.out.println("Semana | Asistencia General | Asistencia Especial | Total");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < 2; i++) {
            int totalSemana = resumenSemanal[i][0] + resumenSemanal[i][1];
            System.out.printf("   %d   | %18d | %19d | %5d\n", (i + 1), resumenSemanal[i][0], resumenSemanal[i][1], totalSemana);
        }
    }
}
