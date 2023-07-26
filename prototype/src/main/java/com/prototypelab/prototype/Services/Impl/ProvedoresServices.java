package com.prototypelab.prototype.Services.Impl;

import com.prototypelab.prototype.Modelos.Provedores;
import com.prototypelab.prototype.Persistence.iProvedoresDao;
import com.prototypelab.prototype.Services.iProvedoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvedoresServices implements iProvedoresServices {

    @Autowired
    iProvedoresDao provedoresDao;
    @Override
    public List<Provedores> FindAll() {
        return provedoresDao.FindAll();
    }


    @Override
    public Optional<Provedores> FindClientesByid(String Id) {
        return provedoresDao.FindProvidersById(Id);
    }

    @Override
    public void save(Provedores provedores) {

        provedoresDao.save(provedores);
    }

    @Override
    public void deleteById(String Id) {
        provedoresDao.deleteById(Id);
    }
}
