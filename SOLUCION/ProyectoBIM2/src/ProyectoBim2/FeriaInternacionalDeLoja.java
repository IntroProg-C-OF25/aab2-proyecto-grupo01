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
            System.out.println("   🎡 Sistema de Gestión de Entradas 🎟 ");
            System.out.println("========================================");
            System.out.println("1. Comprar entrada normal 🎟");
            System.out.println("2. Comprar entrada especial 🎫");
            System.out.println("3. Ver estadísticas 📊");
            System.out.println("4. Registrar asistencias 📝");
            System.out.println("5. Salir 🚪");
            System.out.print("Seleccione una opción: ");
            int opcion = tcl.nextInt();
            switch (opcion) {
                case 1 -> {
                    int[] resultado = comprarEntradaNormal(tcl);
                    totalGanancias += resultado[0];
                    totalEntradasNormales += resultado[1];
                }
                case 2 -> {
                    int[] resultado = comprarEntradaEspecial(tcl);
                    totalGanancias += resultado[0];
                    totalEntradasEspeciales += resultado[1];
                }
                case 3 -> mostrarEstadisticas(totalEntradasNormales, totalEntradasEspeciales, totalGanancias, asistenciaPorDia);
                case 4 -> registrarAsistencia(tcl, asistenciaPorDia);
                case 5 -> {
                    System.out.println("\n👋 Gracias por usar el sistema. ¡Hasta la próxima!");
                    break OUTER;
                }
                default -> System.out.println("⚠ Opción no válida, intente nuevamente.");
            }
        }
    }

    public static int[] comprarEntradaNormal(Scanner tcl) {
        int precio = 5;
        System.out.print("¿Cuántas entradas desea comprar?🤔: ");
        int entradas = tcl.nextInt();
        int precioT = entradas * precio;
        System.out.println("✅ Entradas normales compradas por $" + precioT);
        return new int[]{precioT, entradas};
    }

    public static int[] comprarEntradaEspecial(Scanner tcl) {
        int precioBase = 10;
        System.out.print("¿Cuántas entradas desea comprar?🤔: ");
        int entradas = tcl.nextInt();
        String dia;
        do {
            System.out.print("Ingrese el día de la semana (jueves, viernes, sábado): ");
            dia = tcl.next().toLowerCase();
            if (dia.equals("jueves")) {
                precioBase = 8;
            } else if (dia.equals("viernes") || dia.equals("sábado")) {
                precioBase = 12;
            } else {
                System.err.println("Error! solo puede ingresar el día: jueves, viernes y sábado");
            }
        } while (!dia.equals("jueves") && !dia.equals("viernes") && !dia.equals("sábado"));
        int precioT = entradas * precioBase;
        System.out.println("🎟 Entradas especiales compradas por $" + precioT);
        return new int[]{precioT, entradas};
    }

    public static void mostrarEstadisticas(int normales, int especiales, int ganancias, int[][] asistenciaPorDia) {
        int totalVisitantes = normales + especiales;
        System.out.println("\n========================================");
        System.out.println(" 📊 Estadísticas de la Feria 🎡 ");
        System.out.println("========================================");
        System.out.println("👥 Total de visitantes: " + totalVisitantes);
        System.out.println("🎟 Entradas normales vendidas: " + normales);
        System.out.println("🎭 Entradas especiales vendidas: " + especiales);
        System.out.println("💰 Ganancias totales: $" + ganancias);

        System.out.println("\n📅 Asistencia por día:");
        System.out.println("Día |	Generales |	Especiales");
        System.out.println("-----------------------------");
        for (int i = 0; i < asistenciaPorDia.length; i++) {
            System.out.println((i + 1) + "\t" + asistenciaPorDia[i][0] + "\t\t" + asistenciaPorDia[i][1]);
        }

        int totalGeneralesSemana1 = 0;
        int totalEspecialesSemana1 = 0;
        int totalGeneralesSemana2 = 0;
        int totalEspecialesSemana2 = 0;

        for (int i = 0; i < 5; i++) {
            totalGeneralesSemana1 += asistenciaPorDia[i][0];
            totalEspecialesSemana1 += asistenciaPorDia[i][1];
        }

        for (int i = 5; i < 10; i++) {
            totalGeneralesSemana2 += asistenciaPorDia[i][0];
            totalEspecialesSemana2 += asistenciaPorDia[i][1];
        }

        System.out.println("\n🗓 Asistencia semanal:");
        System.out.println("Semana 1:");
        System.out.println("Generales | Especiales");
        System.out.println(totalGeneralesSemana1 + "\t\t" + totalEspecialesSemana1);

        System.out.println("Semana 2:");
        System.out.println("Generales | Especiales");
        System.out.println(totalGeneralesSemana2 + "\t\t" + totalEspecialesSemana2);
    }

    public static void registrarAsistencia(Scanner tcl, int[][] asistenciaPorDia) {
        System.out.print("Ingrese el número de día de la feria (1-10): ");
        int dia = tcl.nextInt();
        if (dia < 1 || dia > 10) {
            System.out.println("⚠ Día inválido, intente nuevamente.");
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

/***
 *
========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 1
¿Cuántas entradas desea comprar?🤔: 1
✅ Entradas normales compradas por $5

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 2
¿Cuántas entradas desea comprar?🤔: 1
Ingrese el día de la semana (jueves, viernes, sábado): jueves
🎟 Entradas especiales compradas por $8

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 4
Ingrese el número de día de la feria (1-10): 1
👥 Ingrese la cantidad de asistentes generales: 11
🎭 Ingrese la asistencia a la función especial (2pm - 5pm): 1
✅ Asistencia registrada correctamente.

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 3

========================================
 📊 Estadísticas de la Feria 🎡 
========================================
👥 Total de visitantes: 2
🎟 Entradas normales vendidas: 1
🎭 Entradas especiales vendidas: 1
💰 Ganancias totales: $13

📅 Asistencia por día:
Día |	Generales |	Especiales
-----------------------------
1	11		1
2	0		0
3	0		0
4	0		0
5	0		0
6	0		0
7	0		0
8	0		0
9	0		0
10	0		0

🗓 Asistencia semanal:
Semana 1:
Generales | Especiales
11		1
Semana 2:
Generales | Especiales
0		0

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 5

👋 Gracias por usar el sistema. ¡Hasta la próxima!
 */