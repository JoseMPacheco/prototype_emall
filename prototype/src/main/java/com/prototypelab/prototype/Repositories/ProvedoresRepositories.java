package com.prototypelab.prototype.Repositories;

import com.prototypelab.prototype.Modelos.Provedores;
import org.hibernate.annotations.HQLSelect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ProvedoresRepositories extends CrudRepository<Provedores, String> {



}
