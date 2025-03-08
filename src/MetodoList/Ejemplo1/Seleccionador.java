package MetodoList.Ejemplo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seleccionador<T> implements FiltradorGen<T>{

    @Override
    public List<T> recolector(Scanner input, Class<T> tipo) {
        List<T> seleccionados = new ArrayList<>();
        System.out.println("Ingrese la lista que debe ser filtrada (Ingrese fin o 0 para finalizar)");
        while(true){
            if(tipo == String.class){
                String elemento = input.nextLine();
                if(elemento.equalsIgnoreCase("fin")){
                    break;
                }
                seleccionados.add((T) elemento);
            }
            else if(tipo == Integer.class){
                Integer elemento = input.nextInt();
                if(elemento == 0){
                    break;
                }
                seleccionados.add((T) elemento);
            }
            else if(tipo == Boolean.class){
                Boolean elemento = input.nextBoolean();
                if(elemento != (true | false)){
                    break;
                }
                seleccionados.add((T) elemento);
            }
            else{
                System.out.println("Tipo no soportado");
            }

        }

        return seleccionados;
    }

    @Override
    public void filtrador(List<T> listado, T criterio) {
        List<T> filtrados = new ArrayList<>();
        for(T elemento : listado){
            if(elemento.toString().contains(criterio.toString())){ //try to use contains using toString()
                filtrados.add((T) elemento);
            }
        }
        System.out.println("Elementos filtrados: "+ filtrados);
    }

}
