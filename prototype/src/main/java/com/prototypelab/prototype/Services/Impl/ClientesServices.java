package com.prototypelab.prototype.Services.Impl;

import com.prototypelab.prototype.Modelos.Clientes;
import com.prototypelab.prototype.Persistence.iClientesDao;
import com.prototypelab.prototype.Services.IClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServices implements IClientesServices {

    @Autowired
    iClientesDao clientesDao;

    @Override
    public List<Clientes> FindAll() {
        return clientesDao.FindAll();
    }

    @Override
    public Optional<Clientes> FindClientesByid(String Id) {
        return clientesDao.FindClientesByid(Id);
    }

    @Override
    public void save(Clientes clientes) {
        clientesDao.save(clientes);

    }

    @Override
    public void deleteById(String Id) {
        clientesDao.deleteById(Id);
    }
}
