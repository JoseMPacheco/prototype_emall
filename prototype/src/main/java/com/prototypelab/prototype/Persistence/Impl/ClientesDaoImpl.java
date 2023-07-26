package com.prototypelab.prototype.Persistence.Impl;

import com.prototypelab.prototype.Modelos.Clientes;
import com.prototypelab.prototype.Persistence.iClientesDao;
import com.prototypelab.prototype.Repositories.ClientesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ClientesDaoImpl implements iClientesDao {

    @Autowired
    ClientesRepositories clientesRepositories;
    @Override
    public List<Clientes> FindAll() {
        return (List<Clientes>) clientesRepositories.findAll();
    }

    @Override
    public Optional<Clientes> FindClientesByid(String Id) {
        return clientesRepositories.findById(Id);
    }

    @Override
    public void save(Clientes clientes) {
        clientesRepositories.save(clientes);
    }

    @Override
    public void deleteById(String Id) {
        clientesRepositories.deleteById(Id);

    }
}
