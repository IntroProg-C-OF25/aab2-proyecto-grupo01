package ProyectoBim2.entradas;

import java.util.Scanner;

public class entradas {
   
    public static int comprarEntradaNormal(Scanner tcl) {
        int precio = 5;
        int precioT = 0;
        int entradas;
        System.out.print("¿Cuantas entradas desea comprar?🤔: ");
        entradas = tcl.nextInt();
        for (int i = 0; i < entradas; i++) {
            precioT += precio;
        }
        System.out.println("✅ Entradas normales comprada por $" + precioT);
        return precioT;
    }

    public static int comprarEntradaEspecial(Scanner tcl) {
        int precioBase = 10;
        int precioT = 0;
        int entradas;
        String dia;
        System.out.print("¿Cuantas entradas desea comprar?🤔");
        entradas=tcl.nextInt();
        do{
            System.out.print("Ingrese el día de la semana (jueves, viernes, sábado): ");
            dia = tcl.next().toLowerCase();
            
     
            if (dia.equals("jueves")) {
                precioBase = 8;
            } else if (dia.equals("viernes") || dia.equals("sábado")) {
                precioBase = 12;
            }
   
            if (dia.equals("lunes") || dia.equals("martes") || dia.equals("miercoles") || dia.equals("domingo")){
                System.err.println("Error! solo puede ingresar el dia: jueves, viernes y sabado");
            }
        }while (dia.equals("lunes") || dia.equals("martes") || dia.equals("miercoles") || dia.equals("domingo") );
        for (int i = 0; i < entradas; i++) {
                precioT += precioBase;
        }

        System.out.println("🎟️ Entradas especiales compradas por $" + precioT);
        return precioT;
    }
}
