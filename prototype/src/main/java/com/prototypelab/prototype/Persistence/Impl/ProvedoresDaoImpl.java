package com.prototypelab.prototype.Persistence.Impl;

import com.prototypelab.prototype.Modelos.Clientes;
import com.prototypelab.prototype.Modelos.Provedores;
import com.prototypelab.prototype.Persistence.iProvedoresDao;
import com.prototypelab.prototype.Repositories.ProvedoresRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProvedoresDaoImpl implements iProvedoresDao {

    @Autowired
    ProvedoresRepositories provedoresRepositories;
    @Override
    public List<Provedores> FindAll() {
        return (List<Provedores>) provedoresRepositories.findAll();
    }

    @Override
    public Optional<Provedores> FindProvidersById(String Id) {
        return provedoresRepositories.findById(Id);
    }

    @Override
    public void save(Provedores provedores) {
        provedoresRepositories.save(provedores);
    }

    @Override
    public void deleteById(String Id) {
        provedoresRepositories.deleteById(Id);

    }
}
