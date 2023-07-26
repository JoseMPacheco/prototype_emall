package com.prototypelab.prototype.Services.Impl;

import com.prototypelab.prototype.Modelos.Documentos;
import com.prototypelab.prototype.Persistence.iDocumentosDao;
import com.prototypelab.prototype.Services.IDocumentosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentosServices implements IDocumentosServices {

    @Autowired
    iDocumentosDao documentosDao;
    @Override
    public List<Documentos> FindAll() {
        return documentosDao.FindAll();
    }

    @Override
    public Optional<Documentos> FindDocumentById(String Id) {
        return documentosDao.FindDocumentById(Id);
    }

    @Override
    public void save(Documentos documentos) {

        documentosDao.save(documentos);
    }

    @Override
    public void deleteById(String Id) {
        documentosDao.deleteById(Id);
    }
}
