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
                case 3 ->
                    mostrarEstadisticas(totalEntradasNormales, totalEntradasEspeciales, totalGanancias, asistenciaPorDia);
                case 4 ->
                    registrarAsistencia(tcl, asistenciaPorDia);
                case 5 -> {
                    System.out.println("\n👋 Gracias por usar el sistema. ¡Hasta la próxima!");
                    break OUTER;
                }
                default ->
                    System.out.println("⚠ Opción no válida, intente nuevamente.");
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

/***
 *
 *run:

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 1
¿Cuántas entradas desea comprar?🤔: 3
✅ Entradas normales compradas por $15

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 2
¿Cuántas entradas desea comprar?🤔: 3
Ingrese el día de la semana (jueves, viernes, sábado): jueves
🎟 Entradas especiales compradas por $24

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 4

========================================
 📝 Registro de Asistencia 
========================================
Ingrese el número de día de la feria (1-10): 1
👥 Ingrese la cantidad de asistentes generales: 2
🎭 Ingrese la asistencia a la función especial (2pm - 5pm): 3
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
👥 Total de visitantes: 6
🎟️ Entradas normales vendidas: 3
🎭 Entradas especiales vendidas: 3
💰 Ganancias totales: $39
📅 Asistencia por día:
Día | Asistencia General | Función Especial
-------------------------------------------
  1 |                  2 |                3 
  2 |                  0 |                0 
  3 |                  0 |                0 
  4 |                  0 |                0 
  5 |                  0 |                0 
  6 |                  0 |                0 
  7 |                  0 |                0 
  8 |                  0 |                0 
  9 |                  0 |                0 
 10 |                  0 |                0 

📊 Resumen de Asistencia por Semana:
Semana | Asistencia General | Asistencia Especial | Total
--------------------------------------------------------
   1   |                  2 |                   3 |     5
   2   |                  0 |                   0 |     0

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 1
¿Cuántas entradas desea comprar?🤔: 20
✅ Entradas normales compradas por $100

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 2
¿Cuántas entradas desea comprar?🤔: 10
Ingrese el día de la semana (jueves, viernes, sábado): jueves
🎟 Entradas especiales compradas por $80

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 4

========================================
 📝 Registro de Asistencia 
========================================
Ingrese el número de día de la feria (1-10): 2
👥 Ingrese la cantidad de asistentes generales: 20
🎭 Ingrese la asistencia a la función especial (2pm - 5pm): 10
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
👥 Total de visitantes: 36
🎟️ Entradas normales vendidas: 23
🎭 Entradas especiales vendidas: 13
💰 Ganancias totales: $219
📅 Asistencia por día:
Día | Asistencia General | Función Especial
-------------------------------------------
  1 |                  2 |                3 
  2 |                 20 |               10 
  3 |                  0 |                0 
  4 |                  0 |                0 
  5 |                  0 |                0 
  6 |                  0 |                0 
  7 |                  0 |                0 
  8 |                  0 |                0 
  9 |                  0 |                0 
 10 |                  0 |                0 

📊 Resumen de Asistencia por Semana:
Semana | Asistencia General | Asistencia Especial | Total
--------------------------------------------------------
   1   |                 22 |                  13 |    35
   2   |                  0 |                   0 |     0

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 1
¿Cuántas entradas desea comprar?🤔: 10
✅ Entradas normales compradas por $50

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 2
¿Cuántas entradas desea comprar?🤔: 5
Ingrese el día de la semana (jueves, viernes, sábado): viernes
🎟 Entradas especiales compradas por $60

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 4

========================================
 📝 Registro de Asistencia 
========================================
Ingrese el número de día de la feria (1-10): 3
👥 Ingrese la cantidad de asistentes generales: 5
🎭 Ingrese la asistencia a la función especial (2pm - 5pm): 2
✅ Asistencia registrada correctamente.

========================================
   🎡 Sistema de Gestión de Entradas 🎟 
========================================
1. Comprar entrada normal 🎟
2. Comprar entrada especial 🎫
3. Ver estadísticas 📊
4. Registrar asistencias 📝
5. Salir 🚪
Seleccione una opción: 4

========================================
 📝 Registro de Asistencia 
========================================
Ingrese el número de día de la feria (1-10): 4
👥 Ingrese la cantidad de asistentes generales: 5
🎭 Ingrese la asistencia a la función especial (2pm - 5pm): 3
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
👥 Total de visitantes: 51
🎟️ Entradas normales vendidas: 33
🎭 Entradas especiales vendidas: 18
💰 Ganancias totales: $329
📅 Asistencia por día:
Día | Asistencia General | Función Especial
-------------------------------------------
  1 |                  2 |                3 
  2 |                 20 |               10 
  3 |                  5 |                2 
  4 |                  5 |                3 
  5 |                  0 |                0 
  6 |                  0 |                0 
  7 |                  0 |                0 
  8 |                  0 |                0 
  9 |                  0 |                0 
 10 |                  0 |                0 

📊 Resumen de Asistencia por Semana:
Semana | Asistencia General | Asistencia Especial | Total
--------------------------------------------------------
   1   |                 32 |                  18 |    50
   2   |                  0 |                   0 |     0

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