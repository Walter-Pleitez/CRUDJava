package interfazrepo.repositorio;

import interfazrepo.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements FullRepo{

    List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for(Cliente cli : dataSource){
            if(cli.getId() != null && cli.getId().equals(id)){
                resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente c = this.porId(id);
        this.dataSource.remove(c);  // this.dataSource.remove(this.porId(id));
    }

    //ORDENAR
    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);  //OPTIMIZANDO
        listaOrdenada.sort(new Comparator<Cliente>() {  //OPTIMIZANDO
            @Override
            public int compare(Cliente o1, Cliente o2) {
                int resultado = 0;

                if(dir == Direccion.ASC){
                    resultado = this.ordenar(o1,o2);  //OPTIMIZANDO
                }else if(dir == Direccion.DESC){
                    resultado = this.ordenar(o2,o1);  //OPTIMIZANDO
                }

                return resultado;
            }
            //OPTIMIZANDO
            private int ordenar(Cliente o1, Cliente o2){
                int resultado = 0;
                switch (campo){
                    case "id" -> resultado = o1.getId().compareTo(o2.getId());
                    case "nombre" -> resultado = o1.getNombre().compareTo(o2.getNombre());
                    case "apellido" -> resultado = o1.getApellido().compareTo(o2.getApellido());
                }
                return resultado;
            }

        });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    //OPTMIZANDO
    @Override
    public int total() {
        return this.dataSource.size();
    }
}
