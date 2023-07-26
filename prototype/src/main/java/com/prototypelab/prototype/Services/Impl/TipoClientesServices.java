package com.prototypelab.prototype.Services.Impl;

import com.prototypelab.prototype.Modelos.TipoClientes;
import com.prototypelab.prototype.Persistence.iTiposClientesDao;
import com.prototypelab.prototype.Services.ITipoClientesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoClientesServices implements ITipoClientesServices {

    @Autowired
    iTiposClientesDao clientesDao;
    @Override
    public List<TipoClientes> FindAll() {
        return clientesDao.FindAll();
    }

    @Override
    public Optional<TipoClientes> FindCustomerTypeById(String Id) {
        return clientesDao.FindCustomerTypeById(Id);
    }

    @Override
    public void save(TipoClientes tipoClientes) {
        clientesDao.save(tipoClientes);
    }

    @Override
    public void deleteById(String Id) {
        clientesDao.deleteById(Id);
    }
}
