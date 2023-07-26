package com.prototypelab.prototype.Services;

import com.prototypelab.prototype.Modelos.Clientes;

import java.util.List;
import java.util.Optional;

public interface IClientesServices {

    List<Clientes> FindAll();
    Optional<Clientes> FindClientesByid(String Id);

    void save(Clientes clientes);

    void deleteById(String Id);
}
