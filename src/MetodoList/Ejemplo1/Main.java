package MetodoList.Ejemplo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Elija la opcion del tipo que quiere filtrar: ");
        System.out.println("1)String  2)Integer  3) Boolean");
        int option = input.nextInt();

        if(option == 1){
            //crear lista para guardar los elementos recibidos por consola
            FiltradorGen elegidos = new Seleccionador();
            List<String> listado =  elegidos.recolector(input, String.class);
            System.out.print("Ingrese criterio para evaluar Strings: ");
            String criterio = input.nextLine();
            //llamar metodo para filtrar los eleemntos e imprimirlos
            elegidos.filtrador(listado, criterio);
        }
        else if(option == 2){
            FiltradorGen elegidos = new Seleccionador();
            List<Integer> listado =  elegidos.recolector(input, Integer.class);
            System.out.print("Ingrese criterio para evaluar Integers: ");
            int criterio = input.nextInt();
            elegidos.filtrador(listado, criterio);
        }
        else if(option == 3){
            FiltradorGen elegidos = new Seleccionador();
            List<Boolean> listado =  elegidos.recolector(input, Boolean.class);
            System.out.print("Ingrese criterio para evaluar Booleans: ");
            boolean criterio = input.nextBoolean();
            elegidos.filtrador(listado, criterio);
        }
        else{
            System.out.println("Tipo de dato no soportado.");
        }


    }


}
