package interfazrepo.repositorio;

import interfazrepo.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);

}
