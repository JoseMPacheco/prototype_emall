package com.prototypelab.prototype.Repositories;

import com.prototypelab.prototype.Modelos.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepositories extends CrudRepository<Clientes, String> {
}
