package com.prototypelab.prototype.Persistence;

import com.prototypelab.prototype.Modelos.Clientes;
import com.prototypelab.prototype.Modelos.Provedores;

import java.util.List;
import java.util.Optional;

public interface iProvedoresDao {
    List<Provedores> FindAll();
    Optional<Provedores> FindProvidersById(String Id);



    void save(Provedores provedores);

    void deleteById(String Id);
}
