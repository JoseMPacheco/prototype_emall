package com.prototypelab.prototype.Persistence.Impl;

import com.prototypelab.prototype.Modelos.Documentos;
import com.prototypelab.prototype.Persistence.iDocumentosDao;
import com.prototypelab.prototype.Repositories.DocumentosRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DocumentosDaoImpl implements iDocumentosDao {

    @Autowired
    DocumentosRepositories documentosRepositories;
    @Override
    public List<Documentos> FindAll() {
        return (List<Documentos>) documentosRepositories.findAll();
    }

    @Override
    public Optional<Documentos> FindDocumentById(String Id) {
        return documentosRepositories.findById(Id);
    }


    @Override
    public void save(Documentos documentos) {
        documentosRepositories.save(documentos);
    }

    @Override
    public void deleteById(String Id) {
        documentosRepositories.deleteById(Id);
    }
}
