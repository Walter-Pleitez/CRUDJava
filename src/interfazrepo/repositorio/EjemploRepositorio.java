package interfazrepo.repositorio;

import interfazrepo.modelo.Cliente;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        CrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Elmer", "Calderon"));
        repo.crear(new Cliente("Johana", "Jovel"));
        repo.crear(new Cliente("Walter", "Pleitez"));
        repo.crear(new Cliente("Raquel", "Torres"));

        List<Cliente> cliente = repo.listar();
        cliente.forEach(System.out::println);

        System.out.println("==== paginable =====");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1,4);
        paginable.forEach(System.out::println);

        System.out.println("===== ordenar =====");
        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio)repo)
                .listar("nombre", Direccion.ASC);

        for(Cliente c : clientesOrdenAsc){
            System.out.println(c);
        }

        System.out.println("===== editar =====");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);

        Cliente bea = repo.porId(2);
        System.out.println(bea);
        ((OrdenableRepositorio)repo)
                .listar("apellido", Direccion.ASC).forEach(System.out::println);

        System.out.println("======= Eliminar =======");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
    }
}
