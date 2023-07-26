package com.prototypelab.prototype.Repositories;

import com.prototypelab.prototype.Modelos.TipoClientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoClientesRepositories extends CrudRepository<TipoClientes,String> {

}
