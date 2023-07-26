package com.prototypelab.prototype.Persistence.Impl;


import com.prototypelab.prototype.Modelos.TipoClientes;
import com.prototypelab.prototype.Modelos.Transacciones;
import com.prototypelab.prototype.Persistence.iTransaccionesDao;
import com.prototypelab.prototype.Repositories.TransaccionesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TransaccionesDaoImpl  implements iTransaccionesDao {

    @Autowired
    TransaccionesRepositories transaccionesRepositories;

    @Override
    public List<Transacciones> FindAll() {
        return (List<Transacciones>) transaccionesRepositories.findAll();
    }

    @Override
    public Optional<Transacciones> FindById(Long Id) {
        return transaccionesRepositories.findById(Id);
    }

    @Override
    public void save(Transacciones transacciones) {
        transaccionesRepositories.save(transacciones);
    }

    @Override
    public void deleteById(Long Id) {
        transaccionesRepositories.deleteById(Id);
    }
}
