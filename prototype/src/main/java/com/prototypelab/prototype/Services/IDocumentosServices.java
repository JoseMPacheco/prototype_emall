package com.prototypelab.prototype.Services;

import com.prototypelab.prototype.Modelos.Documentos;

import java.util.List;
import java.util.Optional;

public interface IDocumentosServices {
    List<Documentos> FindAll();
    Optional<Documentos> FindDocumentById(String Id);

    void save(Documentos documentos);

    void deleteById(String Id);
}
