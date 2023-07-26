package com.prototypelab.prototype.Repositories;

import com.prototypelab.prototype.Modelos.ItemsDocumentos;
import org.springframework.data.repository.CrudRepository;

public interface ItemsRepositories extends CrudRepository<ItemsDocumentos, Long> {
}
