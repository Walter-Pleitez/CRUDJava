package MetodoList.Ejemplo1;

import java.util.List;
import java.util.Scanner;

public interface FiltradorGen <T>{

    List<T> recolector(Scanner input, Class<T> tipo);

    void filtrador(List<T> listado, T criterio);
}
