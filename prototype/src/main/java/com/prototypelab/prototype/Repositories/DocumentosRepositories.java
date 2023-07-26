package com.prototypelab.prototype.Repositories;

import com.prototypelab.prototype.Modelos.Documentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentosRepositories extends CrudRepository<Documentos, String> {
}
