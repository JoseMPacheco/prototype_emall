package com.prototypelab.prototype.Persistence.Impl;

import com.prototypelab.prototype.Modelos.Provedores;
import com.prototypelab.prototype.Modelos.TipoClientes;
import com.prototypelab.prototype.Persistence.iTiposClientesDao;
import com.prototypelab.prototype.Repositories.TipoClientesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TipoClientesDaoImpl implements iTiposClientesDao {

    @Autowired
    TipoClientesRepositories clientesRepositories;

    @Override
    public List<TipoClientes> FindAll() {
       return  (List<TipoClientes>) clientesRepositories.findAll();
    }

    @Override
    public Optional<TipoClientes> FindCustomerTypeById(String Id) {
        return clientesRepositories.findById(Id);
    }

    @Override
    public void save(TipoClientes tipoClientes) {
        clientesRepositories.save(tipoClientes);
    }

    @Override
    public void deleteById(String Id) {
        clientesRepositories.deleteById(Id);
    }
}
