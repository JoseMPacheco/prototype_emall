package com.prototypelab.prototype.Services;

import com.prototypelab.prototype.Modelos.Clientes;
import com.prototypelab.prototype.Modelos.Provedores;
import org.hibernate.annotations.HQLSelect;

import java.util.List;
import java.util.Optional;

public interface iProvedoresServices {
    List<Provedores> FindAll();

    Optional<Provedores> FindClientesByid(String Id);

    void save(Provedores provedores);

    void deleteById(String Id);
}
