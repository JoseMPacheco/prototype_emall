package com.prototypelab.prototype.Persistence;

import com.prototypelab.prototype.Modelos.Documentos;


import java.util.List;
import java.util.Optional;

public interface iDocumentosDao {

    List<Documentos> FindAll();
    Optional<Documentos> FindDocumentById(String Id);

    void save(Documentos documentos);

    void deleteById(String Id);
}
