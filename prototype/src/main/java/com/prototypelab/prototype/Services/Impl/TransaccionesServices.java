package com.prototypelab.prototype.Services.Impl;

import com.prototypelab.prototype.Modelos.Transacciones;
import com.prototypelab.prototype.Persistence.iTransaccionesDao;
import com.prototypelab.prototype.Services.iTransaccionesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionesServices implements iTransaccionesServices {

    @Autowired
    iTransaccionesDao transaccionesDao;
    @Override
    public List<Transacciones> FindAll() {
        return transaccionesDao.FindAll();
    }

    @Override
    public Optional<Transacciones> FindById(Long Id) {
        return transaccionesDao.FindById(Id);
    }

    @Override
    public void save(Transacciones transacciones) {
        transaccionesDao.save(transacciones);
    }

    @Override
    public void deleteById(Long Id) {
        transaccionesDao.deleteById(Id);
    }
}
