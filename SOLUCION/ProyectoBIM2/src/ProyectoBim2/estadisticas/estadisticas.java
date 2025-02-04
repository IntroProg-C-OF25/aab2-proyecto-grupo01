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
}
