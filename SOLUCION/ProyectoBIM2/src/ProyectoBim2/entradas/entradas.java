package ProyectoBim2.entradas;

import java.util.Scanner;

public class entradas {
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
}
