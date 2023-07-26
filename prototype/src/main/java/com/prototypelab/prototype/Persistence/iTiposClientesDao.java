package com.prototypelab.prototype.Persistence;

import com.prototypelab.prototype.Modelos.Provedores;
import com.prototypelab.prototype.Modelos.TipoClientes;

import java.util.List;
import java.util.Optional;

public interface iTiposClientesDao {

    List<TipoClientes> FindAll();
    Optional<TipoClientes> FindCustomerTypeById(String Id);

    void save(TipoClientes tipoClientes);

    void deleteById(String Id);
}
