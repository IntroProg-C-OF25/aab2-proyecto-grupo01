package ProyectoBim2.asistencias;

import java.util.Scanner;

public class asistencias {
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

