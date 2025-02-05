package ProyectoBim2.entradas;

import java.util.Scanner;

public class entradas {
   
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
}
